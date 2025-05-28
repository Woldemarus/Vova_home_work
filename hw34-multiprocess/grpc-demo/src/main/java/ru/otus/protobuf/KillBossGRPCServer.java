package ru.otus.protobuf;

import io.grpc.ServerBuilder;
import java.io.IOException;
import ru.otus.protobuf.service.NumbersServiceImpl;

@SuppressWarnings({"squid:S106"})
public class KillBossGRPCServer {

    public static final int SERVER_PORT = 8190;

    public static void main(String[] args) throws IOException, InterruptedException {
        var numbersService = new NumbersServiceImpl();

        var server =
                ServerBuilder.forPort(SERVER_PORT).addService(numbersService).build();

        server.start();
        System.out.println("Сервер запущен и ожидает подключений на порту " + SERVER_PORT);
        server.awaitTermination();
    }
}
