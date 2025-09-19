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


        */

    }
}
