package ru.otus.homework;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    private final List<String> successfulTests = new ArrayList<>();
    private final List<String> failedTests = new ArrayList<>();
    private final List<Exception> exceptions = new ArrayList<>();

    public void addSuccessfulTest(String testName) {
        successfulTests.add(testName);
    }

    public void addFailedTest(String testName, Exception exception) {
        failedTests.add(testName);
        exceptions.add(exception);
    }

    public int getTotalTests() {
        return successfulTests.size() + failedTests.size();
    }

    public int getSuccessfulTests() {
        return successfulTests.size();
    }

    public int getFailedTests() {
        return failedTests.size();
    }

    public List<String> getSuccessfulTestNames() {
        return new ArrayList<>(successfulTests);
    }

    public List<String> getFailedTestNames() {
        return new ArrayList<>(failedTests);
    }

    public List<Exception> getExceptions() {
        return new ArrayList<>(exceptions);
    }

    public void printStatistics() {
        System.out.println("=== Результаты тестирования ===");
        System.out.println("Всего тестов: " + getTotalTests());
        System.out.println("Успешно: " + getSuccessfulTests());
        System.out.println("Упало: " + getFailedTests());

        if (!failedTests.isEmpty()) {
            System.out.println("\nУпавшие тесты:");
            for (int i = 0; i < failedTests.size(); i++) {
                System.out.println(
                        "- " + failedTests.get(i) + ": " + exceptions.get(i).getMessage());
            }
        }

        if (!successfulTests.isEmpty()) {
            System.out.println("\nУспешные тесты:");
            successfulTests.forEach(test -> System.out.println("+ " + test));
        }
    }
}
