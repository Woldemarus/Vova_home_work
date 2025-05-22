package ru.otus.protobuf;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
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
    private final BlockingQueue<Integer> serverValues =
            new ArrayBlockingQueue<>(SERVER_LAST_VALUE - SERVER_FIRST_VALUE);
    private int currentValue = 1;

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
                try {
                    serverValues.put(value.getValue());
                    logger.info("новое значение от сервера: {}", value.getValue());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.error("Ошибка при сохранении значения от сервера", e);
                }
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
            Integer lastServer = serverValues.poll(); // Получаем следующее значение из очереди
            if (lastServer != null) {
                currentValue = currentValue + lastServer + 1;
                logger.info("currentValue: {} (использовано значение от сервера: {})", currentValue, lastServer);
            } else {
                currentValue = currentValue + 1; // Если нет новых значений от сервера, просто увеличиваем на 1
                logger.info("currentValue: {} (нет новых значений от сервера)", currentValue);
            }
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
