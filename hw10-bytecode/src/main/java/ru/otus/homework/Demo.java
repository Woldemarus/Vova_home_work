package ru.otus.homework;

public class Demo {

    public static void main(String[] args) {
        System.out.println("=== Демонстрация автоматического логирования ===\n");

        // Тестируем TestLogging
        System.out.println("1. Тестируем методы из интерфейса:");
        TestLoggingInterface testLogging = Ioc.createLoggingProxy(TestLogging.class);
        testLogging.calculation(42);
        testLogging.calculation(10, 20);
        testLogging.calculation(1, 2, "hello");

        System.out.println("\n2. Тестируем дополнительные перегруженные методы:");
        testLogging.calculation("строка");
        testLogging.calculation(3.14, 2.71);
        testLogging.calculation(100, "test", true);
        testLogging.calculation(1, 2, 3, 4, 5);

        System.out.println("\n3. Тестируем метод без аннотации @Log (не логируется):");
        testLogging.noLoggingMethod(999);

        System.out.println("\n=== Демонстрация завершена ===");


        /*Результаты прогона
        === Демонстрация автоматического логирования ===

        1. Тестируем методы из интерфейса:
        executed method: calculation, param: 42
        executed method: calculation, params: 10, 20
        executed method: calculation, params: 1, 2, hello

        2. Тестируем дополнительные перегруженные методы:
        executed method: calculation, param: строка
        executed method: calculation, params: 3.14, 2.71
        executed method: calculation, params: 100, test, true
        executed method: calculation, param: [Ljava.lang.Object;@31221be2

        3. Тестируем метод без аннотации @Log (не логируется):
        Этот метод не будет логироваться: 999*/

    }
}
