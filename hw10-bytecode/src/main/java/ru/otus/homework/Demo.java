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

            17:41:08.029 [main] INFO ru.otus.homework.Demo -- === Демонстрация автоматического логирования ===
            17:41:08.051 [main] INFO ru.otus.homework.Demo -- 1. Тестируем методы из интерфейса:
            17:41:08.114 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, param: 42
            17:41:08.160 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, params: 10, 20
            17:41:08.173 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, params: 1, 2, hello
            17:41:08.183 [main] INFO ru.otus.homework.Demo --
            2. Тестируем дополнительные перегруженные методы:
            17:41:08.186 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, param: строка
            17:41:08.190 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, params: 3.14, 2.71
            17:41:08.200 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, params: 100, test, true
            17:41:08.211 [main] INFO ru.otus.homework.Ioc -- executed method: calculation, param: [Ljava.lang.Object;@2752f6e2
            17:41:08.211 [main] INFO ru.otus.homework.Demo --
            3. Тестируем метод без аннотации @Log (не логируется):
            Этот метод не будет логироваться: 999
            17:41:08.222 [main] INFO ru.otus.homework.Demo --

         */

    }
}
