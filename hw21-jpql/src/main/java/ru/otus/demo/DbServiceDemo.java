package ru.otus.demo;

import java.util.Arrays;
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
import ru.otus.crm.service.DbServiceClientImpl;

public class DbServiceDemo {

    private static final Logger log = LoggerFactory.getLogger(DbServiceDemo.class);

    public static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    public static void main(String[] args) {
        var configuration = new Configuration().configure(HIBERNATE_CFG_FILE);

        var dbUrl = configuration.getProperty("hibernate.connection.url");
        var dbUserName = configuration.getProperty("hibernate.connection.username");
        var dbPassword = configuration.getProperty("hibernate.connection.password");

        new MigrationsExecutorFlyway(dbUrl, dbUserName, dbPassword).executeMigrations();

        var sessionFactory =
                HibernateUtils.buildSessionFactory(configuration, Client.class, Address.class, Phone.class);

        var transactionManager = new TransactionManagerHibernate(sessionFactory);
        ///
        var clientTemplate = new DataTemplateHibernate<>(Client.class);
        ///
        var dbServiceClient = new DbServiceClientImpl(transactionManager, clientTemplate);

        // Создаем клиента с адресом и телефонами
        var address = new Address("ул. Пушкина, д. 1");
        var phones = Arrays.asList(new Phone("+7-123-456-78-90"), new Phone("+7-987-654-32-10"));
        var clientWithDetails = new Client(null, "Клиент с адресом и телефонами", address, phones);

        // Сохраняем клиента (каскадно сохранятся адрес и телефоны)
        var savedClient = dbServiceClient.saveClient(clientWithDetails);
        log.info("Сохранен клиент с деталями: {}", savedClient);

        // Читаем клиента (каскадно загрузятся адрес и телефоны)
        var clientFromDb = dbServiceClient
                .getClient(savedClient.getId())
                .orElseThrow(() -> new RuntimeException("Client not found, id:" + savedClient.getId()));
        log.info("Прочитан клиент из БД: {}", clientFromDb);

        // Обновляем клиента
        clientFromDb.setName("Обновленное имя клиента");
        clientFromDb.getAddress().setStreet("ул. Обновленная, д. 2");
        clientFromDb.getPhones().get(0).setNumber("+7-111-222-33-44");

        var updatedClient = dbServiceClient.saveClient(clientFromDb);
        log.info("Обновлен клиент: {}", updatedClient);

        log.info("Все клиенты:");
        dbServiceClient.findAll().forEach(client -> log.info("client: {}", client));

        // Удаляем всех клиентов
        log.info("Удаляем всех клиентов...");
        dbServiceClient.deleteAll();

        log.info("Клиенты после удаления:");
        dbServiceClient.findAll().forEach(client -> log.info("client: {}", client));
    }
}
