package ru.otus.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {
    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

        logger.info("=== Демонстрация автоматического логирования ===\n");

        // Тестируем TestLogging
        logger.info("1. Тестируем методы из интерфейса:");
        TestLoggingInterface testLogging = Ioc.createLoggingProxy(TestLogging.class);
        testLogging.calculation(42);
        testLogging.calculation(10, 20);
        testLogging.calculation(1, 2, "hello");

        logger.info("\n2. Тестируем дополнительные перегруженные методы:");
        testLogging.calculation("строка");
        testLogging.calculation(3.14, 2.71);
        testLogging.calculation(100, "test", true);
        testLogging.calculation(1, 2, 3, 4, 5);

        logger.info("\n3. Тестируем метод без аннотации @Log (не логируется):");
        testLogging.noLoggingMethod(999);

        logger.info("\n=== Демонстрация завершена ===");

        /*Результаты прогона

           22:45:25.841 [main] INFO ru.otus.homework.Demo -- === Демонстрация автоматического логирования ===
            22:45:25.847 [main] INFO ru.otus.homework.Demo -- 1. Тестируем методы из интерфейса:
            22:45:25.882 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, param: 42
            22:45:25.888 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, params: 10, 20
            22:45:25.892 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, params: 1, 2, hello
            22:45:25.895 [main] INFO ru.otus.homework.Demo --
            2. Тестируем дополнительные перегруженные методы:
            22:45:25.896 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, param: строка
            22:45:25.897 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, params: 3.14, 2.71
            22:45:25.902 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, params: 100, test, true
            22:45:25.905 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, param: [Ljava.lang.Object;@47f37ef1
            22:45:25.906 [main] INFO ru.otus.homework.Demo --
            3. Тестируем метод без аннотации @Log (не логируется):
            22:45:25.906 [main] INFO ru.otus.homework.Ioc -- executed method: noLoggingMethod, param: 999
            Этот метод не будет логироваться: 999
            22:45:25.909 [main] INFO ru.otus.homework.Demo --
            === Демонстрация завершена ===

        */

    }
}
