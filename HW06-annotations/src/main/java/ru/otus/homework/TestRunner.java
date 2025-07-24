package ru.otus.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void runTests(String className) {
        try {
            Class<?> testClass = Class.forName(className);
            TestResult result = new TestResult();

            // Получаем методы с аннотациями
            List<Method> beforeMethods = getMethodsWithAnnotation(testClass, Before.class);
            List<Method> testMethods = getMethodsWithAnnotation(testClass, Test.class);
            List<Method> afterMethods = getMethodsWithAnnotation(testClass, After.class);

            System.out.println("Найдено методов:");
            System.out.println("- @Before: " + beforeMethods.size());
            System.out.println("- @Test: " + testMethods.size());
            System.out.println("- @After: " + afterMethods.size());
            System.out.println();

            // Запускаем каждый тест
            for (Method testMethod : testMethods) {
                runSingleTest(testClass, testMethod, beforeMethods, afterMethods, result);
            }

            // Выводим статистику
            result.printStatistics();

        } catch (ClassNotFoundException e) {
            System.err.println("Класс не найден: " + className);
        } catch (Exception e) {
            System.err.println("Ошибка при запуске тестов: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<Method> getMethodsWithAnnotation(
            Class<?> clazz, Class<? extends java.lang.annotation.Annotation> annotationClass) {
        List<Method> methods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotationClass)) {
                methods.add(method);
            }
        }
        return methods;
    }

    private static void runSingleTest(
            Class<?> testClass,
            Method testMethod,
            List<Method> beforeMethods,
            List<Method> afterMethods,
            TestResult result) {
        Object testInstance = null;
        String testName = testMethod.getName();

        try {
            // Создаем новый экземпляр для каждого теста
            testInstance = createTestInstance(testClass);

            // Выполняем методы @Before
            executeMethods(testInstance, beforeMethods, "Before");

            // Выполняем тестовый метод
            System.out.println("Выполняется тест: " + testName);
            testMethod.invoke(testInstance);
            System.out.println("✓ Тест " + testName + " прошел успешно");
            result.addSuccessfulTest(testName);

        } catch (Exception e) {
            System.err.println("✗ Тест " + testName + " упал: " + e.getCause().getMessage());
            result.addFailedTest(testName, e.getCause() != null ? (Exception) e.getCause() : e);
        } finally {
            // Выполняем методы @After (даже если тест упал)
            try {
                executeMethods(testInstance, afterMethods, "After");
            } catch (Exception e) {
                System.err.println("Ошибка в методах @After для теста " + testName + ": " + e.getMessage());
            }
        }
        System.out.println();
    }

    private static Object createTestInstance(Class<?> testClass) throws Exception {
        Constructor<?> constructor = testClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    private static void executeMethods(Object instance, List<Method> methods, String methodType) throws Exception {
        for (Method method : methods) {
            method.setAccessible(true);
            method.invoke(instance);
        }
    }
}
