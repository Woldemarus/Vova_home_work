package ru.otus.homework;

public class ExampleTest {
    private int counter = 0;
    private String testData = "";

    @Before
    public void setUp() {
        System.out.println("  [Before] Подготовка к тесту...");
        counter = 0;
        testData = "test";
    }

    @Before
    public void setUp2() {
        System.out.println("  [Before] Дополнительная подготовка...");
        counter++;
    }

    @Test
    public void test1() {
        System.out.println("    [Test1] Выполняется первый тест");
        if (counter != 1) {
            throw new RuntimeException("Counter должен быть равен 1, но равен " + counter);
        }
        if (!"test".equals(testData)) {
            throw new RuntimeException("testData должен быть 'test'");
        }
    }

    @Test
    public void test2() {
        System.out.println("    [Test2] Выполняется второй тест");
        // Этот тест должен пройти успешно
        if (counter != 1) {
            throw new RuntimeException("Counter должен быть равен 1");
        }
    }

    @Test
    public void test3() {
        System.out.println("    [Test3] Выполняется третий тест");
        // Этот тест упадет
        throw new RuntimeException("Искусственная ошибка в тесте 3");
    }

    @Test
    public void test4() {
        System.out.println("    [Test4] Выполняется четвертый тест");
        // Этот тест должен пройти успешно
        if (testData.isEmpty()) {
            throw new RuntimeException("testData не должен быть пустым");
        }
    }

    @After
    public void tearDown() {
        System.out.println("  [After] Очистка после теста...");
        testData = "";
    }

    @After
    public void tearDown2() {
        System.out.println("  [After] Дополнительная очистка...");
        counter = 0;
    }
}
