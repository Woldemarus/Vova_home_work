package ru.otus.homework;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("  [Before] Создание калькулятора...");
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        System.out.println("    [Test] Тест сложения");
        int result = calculator.add(2, 3);
        if (result != 5) {
            throw new RuntimeException("2 + 3 должно быть 5, но получилось " + result);
        }
    }

    @Test
    public void testSubtraction() {
        System.out.println("    [Test] Тест вычитания");
        int result = calculator.subtract(5, 3);
        if (result != 2) {
            throw new RuntimeException("5 - 3 должно быть 2, но получилось " + result);
        }
    }

    @Test
    public void testMultiplication() {
        System.out.println("    [Test] Тест умножения");
        int result = calculator.multiply(4, 3);
        if (result != 12) {
            throw new RuntimeException("4 * 3 должно быть 12, но получилось " + result);
        }
    }

    @Test
    public void testDivision() {
        System.out.println("    [Test] Тест деления");
        int result = calculator.divide(10, 2);
        if (result != 5) {
            throw new RuntimeException("10 / 2 должно быть 5, но получилось " + result);
        }
    }

    @Test
    public void testDivisionByZero() {
        System.out.println("    [Test] Тест деления на ноль");
        try {
            calculator.divide(10, 0);
            throw new RuntimeException("Должно было выбросить исключение при делении на ноль");
        } catch (ArithmeticException e) {
            // Ожидаемое исключение
        }
    }

    @After
    public void tearDown() {
        System.out.println("  [After] Очистка калькулятора...");
        calculator = null;
    }

    // Простой класс калькулятора для тестирования
    private static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }

        public int divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Деление на ноль");
            }
            return a / b;
        }
    }
}
