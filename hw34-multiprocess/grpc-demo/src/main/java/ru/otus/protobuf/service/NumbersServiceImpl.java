package ru.otus.protobuf.service;

import io.grpc.stub.StreamObserver;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ru.otus.protobuf.generated.NumberRequest;
import ru.otus.protobuf.generated.NumberResponse;
import ru.otus.protobuf.generated.NumbersServiceGrpc;

public class NumbersServiceImpl extends NumbersServiceGrpc.NumbersServiceImplBase {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void getNumbers(NumberRequest request, StreamObserver<NumberResponse> responseObserver) {
        int firstValue = request.getFirstValue();
        int lastValue = request.getLastValue();
        AtomicInteger currentValue = new AtomicInteger(firstValue);

        executorService.scheduleAtFixedRate(
                () -> {
                    try {
                        int value = currentValue.incrementAndGet();
                        if (value <= lastValue) {
                            NumberResponse response =
                                    NumberResponse.newBuilder().setValue(value).build();
                            responseObserver.onNext(response);
                        } else {
                            executorService.shutdown();
                            responseObserver.onCompleted();
                        }
                    } catch (Exception e) {
                        executorService.shutdown();
                        responseObserver.onError(e);
                    }
                },
                0,
                2,
                TimeUnit.SECONDS);
    }
}
