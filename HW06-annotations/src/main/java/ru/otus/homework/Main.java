package ru.otus.homework;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация простого тестового фреймворка ===\n");

        System.out.println("----------- ");
        // System.out.println("----------- Запускаем тесты для ExampleTest");
        System.out.println("----------- ");
        // TestRunner.runTests("ru.otus.homework.ExampleTest");
        System.out.println("----------- ");
        System.out.println("----------- Запускаем тесты для CalculatorTest");
        System.out.println("----------- ");
        TestRunner.runTests("ru.otus.homework.CalculatorTest");

        System.out.println("\n=== Демонстрация завершена ===");
    }
}
