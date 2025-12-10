package ru.otus.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.cachehw.HwCache;
import ru.otus.cachehw.HwListener;
import ru.otus.cachehw.MyCache;

public class CachePerformanceDemo {
    private static final Logger logger = LoggerFactory.getLogger(CachePerformanceDemo.class);

    public static void main(String[] args) {
        new CachePerformanceDemo().demo();
    }

    private void demo() {
        logger.info("=== Демонстрация производительности кэша ===");

        // Тестируем базовый кэш
        testBasicCache();

        // Тестируем производительность
        testCachePerformance();

        // Тестируем очистку при нехватке памяти
        testMemoryCleanup();
    }

    private void testBasicCache() {
        logger.info("\n--- Тестирование базового функционала кэша ---");

        HwCache<String, String> cache = new MyCache<>();

        // Добавляем слушатель
        HwListener<String, String> listener = (key, value, action) -> {
            logger.info("Событие кэша: {} - ключ: {}, значение: {}", action, key, value);
        };
        cache.addListener(listener);

        // Тестируем операции
        cache.put("key1", "value1");
        cache.put("key2", "value2");

        String value1 = cache.get("key1");
        logger.info("Получено из кэша: {}", value1);

        cache.remove("key2");
        String value2 = cache.get("key2");
        logger.info("Получено после удаления: {}", value2);

        cache.removeListener(listener);
    }

    private void testCachePerformance() {
        logger.info("\n--- Тестирование производительности кэша ---");

        HwCache<Integer, String> cache = new MyCache<>();
        int iterations = 100_000;

        // Заполняем кэш
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            cache.put(i, "value" + i);
        }
        long putTime = System.nanoTime() - startTime;

        // Читаем из кэша
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            cache.get(i);
        }
        long getTime = System.nanoTime() - startTime;

        logger.info("Время записи {} элементов: {} мс", iterations, TimeUnit.NANOSECONDS.toMillis(putTime));
        logger.info("Время чтения {} элементов: {} мс", iterations, TimeUnit.NANOSECONDS.toMillis(getTime));
        logger.info("Среднее время записи: {} нс", putTime / iterations);
        logger.info("Среднее время чтения: {} нс", getTime / iterations);
    }

    private void testMemoryCleanup() {
        logger.info("\n--- Тестирование очистки при нехватке памяти ---");

        MyCache<Object, String> cache = new MyCache<>();

        // Создаем много объектов, которые могут быть собраны сборщиком мусора
        List<Object> keys = new ArrayList<>();

        logger.info("Размер кэша до заполнения: {}", cache.size());

        // Заполняем кэш объектами
        for (int i = 0; i < 1000; i++) {
            Object key = new Object(); // Создаем новый объект
            keys.add(key); // Сохраняем ссылку, чтобы объект не был собран
            cache.put(key, "value" + i);
        }

        logger.info("Размер кэша после заполнения: {}", cache.size());

        // Освобождаем ссылки на ключи (кроме последних 100)
        for (int i = 0; i < keys.size() - 100; i++) {
            keys.set(i, null);
        }

        // Принудительно вызываем сборку мусора
        System.gc();

        try {
            Thread.sleep(1000); // Даем время сборщику мусора
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        logger.info("Размер кэша после сборки мусора: {}", cache.size());
        logger.info("Кэш автоматически очистил слабые ссылки!");

        // Проверяем, что оставшиеся ключи все еще работают
        int workingKeys = 0;
        for (int i = keys.size() - 100; i < keys.size(); i++) {
            if (keys.get(i) != null && cache.get(keys.get(i)) != null) {
                workingKeys++;
            }
        }
        logger.info("Работающих ключей после очистки: {}", workingKeys);
    }
}
