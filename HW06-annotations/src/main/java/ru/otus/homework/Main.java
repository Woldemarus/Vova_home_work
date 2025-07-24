package ru.otus.homework;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация простого тестового фреймворка ===\n");

        System.out.println("Запускаем тесты для ExampleTest");
        TestRunner.runTests("ru.otus.homework.ExampleTest");


        System.out.println("\n=== Демонстрация завершена ===");
    }
}
