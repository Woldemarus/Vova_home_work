package ru.otus.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.core.repository.DataTemplateHibernate;
import ru.otus.core.repository.HibernateUtils;
import ru.otus.core.sessionmanager.TransactionManagerHibernate;
import ru.otus.crm.dbmigrations.MigrationsExecutorFlyway;
import ru.otus.crm.model.Address;
import ru.otus.crm.model.Client;
import ru.otus.crm.model.Phone;
import ru.otus.crm.service.DBServiceClient;
import ru.otus.crm.service.DbServiceClientImpl;

public class DbServiceCacheDemo {
    private static final Logger logger = LoggerFactory.getLogger(DbServiceCacheDemo.class);

    public static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    public static void main(String[] args) {
        new DbServiceCacheDemo().demo();
    }

    private void demo() {
        logger.info("=== Демонстрация кэширования в DBService ===");

        // Инициализируем DBServiceClient как в DbServiceDemo
        DBServiceClient dbService = createDbService();

        if (dbService == null) {
            logger.warn("DBService не инициализирован");
            return;
        }

        // Демонстрируем работу кэша
        demonstrateCache(dbService);

        // Тестируем производительность с кэшем
        testDbServicePerformance(dbService);
    }

    private DBServiceClient createDbService() {
        try {
            var configuration = new Configuration().configure(HIBERNATE_CFG_FILE);

            var dbUrl = configuration.getProperty("hibernate.connection.url");
            var dbUserName = configuration.getProperty("hibernate.connection.username");
            var dbPassword = configuration.getProperty("hibernate.connection.password");

            new MigrationsExecutorFlyway(dbUrl, dbUserName, dbPassword).executeMigrations();

            var sessionFactory =
                    HibernateUtils.buildSessionFactory(configuration, Client.class, Address.class, Phone.class);
            var transactionManager = new TransactionManagerHibernate(sessionFactory);
            var clientTemplate = new DataTemplateHibernate<>(Client.class);

            return new DbServiceClientImpl(transactionManager, clientTemplate);
        } catch (Exception e) {
            logger.error("Ошибка инициализации DBService: {}", e.getMessage());
            return null;
        }
    }

    private void demonstrateCache(DBServiceClient dbService) {
        logger.info("\n--- Демонстрация работы кэша ---");

        // Очищаем базу данных перед демонстрацией
        dbService.deleteAll();

        // Создаем клиента с адресом и телефоном
        logger.info("1. Создаем клиента с адресом и телефоном...");
        var address = new Address("ул. Кэш-тест, д. 1");
        var phones = Arrays.asList(new Phone("+7-999-888-77-66"));
        var client = new Client(null, "Кэш-тест клиент", address, phones);
        Client savedClient = dbService.saveClient(client);
        logger.info("Создан клиент: {}", savedClient);

        // Очищаем кэш перед первым чтением, чтобы показать чтение из БД
        logger.info("\n2. Очищаем кэш перед первым чтением...");
        ((DbServiceClientImpl) dbService).clearClientCache();

        // Первое чтение - должно быть из БД (кэш очищен)
        logger.info("\n3. Первое чтение клиента (должно быть из БД)...");
        Optional<Client> firstRead = dbService.getClient(savedClient.getId());
        logger.info("Результат первого чтения: {}", firstRead.orElse(null));

        // Второе чтение - должно быть из кэша
        logger.info("\n4. Второе чтение клиента (должно быть из кэша)...");
        Optional<Client> secondRead = dbService.getClient(savedClient.getId());
        logger.info("Результат второго чтения: {}", secondRead.orElse(null));

        // Третье чтение - тоже из кэша
        logger.info("\n5. Третье чтение клиента (тоже из кэша)...");
        Optional<Client> thirdRead = dbService.getClient(savedClient.getId());
        logger.info("Результат третьего чтения: {}", thirdRead.orElse(null));

        // Тестируем кэш для findAll
        logger.info("\n6. Тестируем кэш для findAll...");

        // Очищаем кэш всех клиентов перед первым чтением
        logger.info("Очищаем кэш всех клиентов перед первым чтением...");
        ((DbServiceClientImpl) dbService).clearAllClientsCache();

        // Первое чтение всех клиентов - из БД
        logger.info("Первое чтение всех клиентов (из БД)...");
        List<Client> firstFindAll = dbService.findAll();
        logger.info("Найдено клиентов: {}", firstFindAll.size());

        // Второе чтение всех клиентов - из кэша
        logger.info("Второе чтение всех клиентов (из кэша)...");
        List<Client> secondFindAll = dbService.findAll();
        logger.info("Найдено клиентов: {}", secondFindAll.size());

        // Обновляем клиента - кэш должен обновиться
        logger.info("\n7. Обновляем клиента (кэш должен обновиться)...");
        savedClient.setName("Обновленный кэш-тест клиент");
        savedClient.getAddress().setStreet("ул. Обновленная, д. 2");
        savedClient.getPhones().get(0).setNumber("+7-111-222-33-44");
        Client updatedClient = dbService.saveClient(savedClient);
        logger.info("Обновленный клиент: {}", updatedClient);

        // Читаем обновленного клиента - должен быть из кэша
        logger.info("\n8. Читаем обновленного клиента (из кэша)...");
        Optional<Client> updatedRead = dbService.getClient(savedClient.getId());
        logger.info("Результат чтения обновленного клиента: {}", updatedRead.orElse(null));

        logger.info("\n--- Демонстрация кэша завершена ---");
    }

    private void testDbServicePerformance(DBServiceClient dbService) {
        logger.info("\n--- Тестирование производительности DBService с кэшем ---");

        // Очищаем базу данных перед тестом
        dbService.deleteAll();

        // Создаем тестовых клиентов
        List<Client> testClients = createTestClients(50);
        logger.info("Создано {} тестовых клиентов", testClients.size());

        // Сохраняем клиентов
        logger.info("\n1. Сохраняем клиентов в БД...");
        long startTime = System.nanoTime();
        List<Client> savedClients = new ArrayList<>();
        for (Client client : testClients) {
            Client saved = dbService.saveClient(client);
            savedClients.add(saved);
        }
        long saveTime = System.nanoTime() - startTime;
        logger.info("Время сохранения {} клиентов: {} мс", testClients.size(), TimeUnit.NANOSECONDS.toMillis(saveTime));

        // Тестируем чтение по ID - первый проход (заполнение кэша)
        logger.info("\n2. Первый проход чтения по ID (заполнение кэша)...");
        startTime = System.nanoTime();
        for (Client client : savedClients) {
            Optional<Client> foundClient = dbService.getClient(client.getId());
            if (foundClient.isEmpty()) {
                logger.warn("Клиент с ID {} не найден", client.getId());
            }
        }
        long firstReadByIdTime = System.nanoTime() - startTime;
        logger.info(
                "Время первого чтения {} клиентов по ID: {} мс",
                savedClients.size(),
                TimeUnit.NANOSECONDS.toMillis(firstReadByIdTime));

        // Тестируем чтение по ID - второй проход (из кэша)
        logger.info("\n3. Второй проход чтения по ID (из кэша)...");
        startTime = System.nanoTime();
        for (Client client : savedClients) {
            Optional<Client> foundClient = dbService.getClient(client.getId());
            if (foundClient.isEmpty()) {
                logger.warn("Клиент с ID {} не найден", client.getId());
            }
        }
        long secondReadByIdTime = System.nanoTime() - startTime;
        logger.info(
                "Время второго чтения {} клиентов по ID: {} мс",
                savedClients.size(),
                TimeUnit.NANOSECONDS.toMillis(secondReadByIdTime));

        // Сравниваем производительность
        if (secondReadByIdTime < firstReadByIdTime) {
            long improvement = firstReadByIdTime - secondReadByIdTime;
            double improvementPercent = (double) improvement / firstReadByIdTime * 100;
            logger.info(
                    "Улучшение производительности при чтении из кэша: {} мс ({}%)",
                    TimeUnit.NANOSECONDS.toMillis(improvement), String.format("%.1f", improvementPercent));
        }

        // Тестируем чтение всех клиентов - первый проход (заполнение кэша)
        logger.info("\n4. Первый проход чтения всех клиентов (заполнение кэша)...");
        startTime = System.nanoTime();
        List<Client> firstFindAll = dbService.findAll();
        long firstReadAllTime = System.nanoTime() - startTime;
        logger.info(
                "Время первого чтения всех клиентов: {} мс, найдено: {}",
                TimeUnit.NANOSECONDS.toMillis(firstReadAllTime),
                firstFindAll.size());

        // Тестируем чтение всех клиентов - второй проход (из кэша)
        logger.info("\n5. Второй проход чтения всех клиентов (из кэша)...");
        startTime = System.nanoTime();
        List<Client> secondFindAll = dbService.findAll();
        long secondReadAllTime = System.nanoTime() - startTime;
        logger.info(
                "Время второго чтения всех клиентов: {} мс, найдено: {}",
                TimeUnit.NANOSECONDS.toMillis(secondReadAllTime),
                secondFindAll.size());

        // Сравниваем производительность для findAll
        if (secondReadAllTime < firstReadAllTime) {
            long improvement = firstReadAllTime - secondReadAllTime;
            double improvementPercent = (double) improvement / firstReadAllTime * 100;
            logger.info(
                    "Улучшение производительности при чтении всех клиентов из кэша: {} мс ({}%)",
                    TimeUnit.NANOSECONDS.toMillis(improvement), String.format("%.1f", improvementPercent));
        }

        // Тестируем множественные чтения из кэша
        logger.info("\n6. Тестируем множественные чтения из кэша...");
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            // Читаем случайного клиента
            int randomIndex = (int) (Math.random() * savedClients.size());
            Client randomClient = savedClients.get(randomIndex);
            Optional<Client> foundClient = dbService.getClient(randomClient.getId());
            if (foundClient.isEmpty()) {
                logger.warn("Клиент с ID {} не найден", randomClient.getId());
            }
        }
        long multipleReadTime = System.nanoTime() - startTime;
        logger.info("Время 100 случайных чтений из кэша: {} мс", TimeUnit.NANOSECONDS.toMillis(multipleReadTime));

        // Очищаем данные
        logger.info("\n7. Очищаем тестовые данные...");
        dbService.deleteAll();
        logger.info("Тестовые данные очищены");

        logger.info("\n--- Тестирование производительности завершено ---");
    }

    private List<Client> createTestClients(int count) {
        List<Client> clients = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            // Создаем клиента без ID (null) - Hibernate сам назначит ID
            var address = new Address("City" + i);
            var phones = Arrays.asList(new Phone("+7-123-456-78" + String.format("%02d", i)));
            var client = new Client(null, "Client" + i, address, phones);
            clients.add(client);
        }
        return clients;
    }
}
