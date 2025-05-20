package ru.otus.protobuf;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.protobuf.generated.NumberRequest;
import ru.otus.protobuf.generated.NumberResponse;
import ru.otus.protobuf.generated.NumbersServiceGrpc;

public class KillBossGRPCClient {
    private static final Logger logger = LoggerFactory.getLogger(KillBossGRPCClient.class);
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8190;
    private static final int CLIENT_ITERATIONS = 50;
    private static final int SERVER_FIRST_VALUE = 0;
    private static final int SERVER_LAST_VALUE = 30;

    private final ManagedChannel channel;
    private final NumbersServiceGrpc.NumbersServiceStub asyncStub;
    private final AtomicInteger lastServerValue = new AtomicInteger(0);
    private final AtomicInteger currentValue = new AtomicInteger(0);
    private volatile boolean isFirstValue = true;

    public KillBossGRPCClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        asyncStub = NumbersServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void start() throws InterruptedException {
        logger.info("Клиент запускается...");
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<NumberResponse> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(NumberResponse value) {
                int serverValue = value.getValue();
                lastServerValue.set(serverValue);
                logger.info("новое значение от сервера: {}", serverValue);
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Ошибка при получении данных от сервера", t);
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                logger.info("Запрос завершен");
                latch.countDown();
            }
        };

        asyncStub.getNumbers(
                NumberRequest.newBuilder()
                        .setFirstValue(SERVER_FIRST_VALUE)
                        .setLastValue(SERVER_LAST_VALUE)
                        .build(),
                responseObserver);

        // Основной цикл клиента
        for (int i = 0; i < CLIENT_ITERATIONS; i++) {
            int current = currentValue.get();
            int lastServer = lastServerValue.get();

            // Для первого значения просто добавляем 1
            if (isFirstValue) {
                currentValue.set(1);
                isFirstValue = false;
            } else {
                int newValue = current + lastServer + 1;
                currentValue.set(newValue);
            }

            logger.info("currentValue: {}", currentValue.get());
            Thread.sleep(1000);
        }

        latch.await();
    }

    public static void main(String[] args) throws Exception {
        KillBossGRPCClient client = new KillBossGRPCClient(SERVER_HOST, SERVER_PORT);
        try {
            client.start();
        } finally {
            client.shutdown();
        }
    }
}
