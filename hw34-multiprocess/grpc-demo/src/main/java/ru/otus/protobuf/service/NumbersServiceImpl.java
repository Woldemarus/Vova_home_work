package ru.otus.protobuf.service;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.protobuf.generated.NumberRequest;
import ru.otus.protobuf.generated.NumberResponse;
import ru.otus.protobuf.generated.NumbersServiceGrpc;

public class NumbersServiceImpl extends NumbersServiceGrpc.NumbersServiceImplBase {
    private static final Logger logger = LoggerFactory.getLogger(NumbersServiceImpl.class);

    @Override
    public void getNumbers(NumberRequest request, StreamObserver<NumberResponse> responseObserver) {
        int firstValue = request.getFirstValue();
        int lastValue = request.getLastValue();

        if (firstValue >= lastValue) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("firstValue должно быть меньше lastValue")
                    .asRuntimeException());
            return;
        }

        AtomicInteger currentValue = new AtomicInteger(firstValue);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> future = null;

        try {
            future = executorService.scheduleAtFixedRate(
                    () -> {
                        try {
                            int value = currentValue.incrementAndGet();
                            if (value <= lastValue) {
                                NumberResponse response = NumberResponse.newBuilder()
                                        .setValue(value)
                                        .build();
                                responseObserver.onNext(response);
                            } else {
                                executorService.shutdown();
                                responseObserver.onCompleted();
                            }
                        } catch (Exception e) {
                            logger.error("Ошибка при отправке значения", e);
                            executorService.shutdown();
                            responseObserver.onError(Status.INTERNAL
                                    .withDescription("Ошибка при отправке значения: " + e.getMessage())
                                    .asRuntimeException());
                        }
                    },
                    0,
                    2,
                    TimeUnit.SECONDS);

        } catch (Exception e) {
            logger.error("Ошибка при создании задачи", e);
            if (future != null) {
                future.cancel(true);
            }
            executorService.shutdown();
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Ошибка при создании задачи: " + e.getMessage())
                    .asRuntimeException());
        }
    }
}
