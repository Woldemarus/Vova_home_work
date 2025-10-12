package ru.otus.crm.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.cachehw.MyCache;
import ru.otus.core.repository.DataTemplate;
import ru.otus.core.sessionmanager.TransactionManager;
import ru.otus.crm.model.Client;

public class DbServiceClientImpl implements DBServiceClient {
    private static final Logger log = LoggerFactory.getLogger(DbServiceClientImpl.class);

    private final DataTemplate<Client> clientDataTemplate;
    private final TransactionManager transactionManager;
    private final MyCache<String, Object> clientCache;

    public DbServiceClientImpl(
            TransactionManager transactionManager,
            DataTemplate<Client> clientDataTemplate,
            MyCache<String, Object> clientCache) {
        this.transactionManager = transactionManager;
        this.clientDataTemplate = clientDataTemplate;
        this.clientCache = clientCache;
    }

    @Override
    public Client saveClient(Client client) {
        return transactionManager.doInTransaction(session -> {
            var clientCloned = client.clone();
            Client savedClient;
            if (client.getId() == null) {
                savedClient = clientDataTemplate.insert(session, clientCloned);
                log.info("created client: {}", savedClient);
            } else {
                savedClient = clientDataTemplate.update(session, clientCloned);
                log.info("updated client: {}", savedClient);
            }

            // Обновляем кэш
            if (savedClient.getId() != null) {
                clientCache.put("client-" + savedClient.getId(), savedClient);
            }

            return savedClient;
        });
    }

    @Override
    public Optional<Client> getClient(long id) {
        // Сначала проверяем кэш
        String cacheKey = "client-" + id;
        Object cachedObject = clientCache.get(cacheKey);
        if (cachedObject instanceof Client) {
            Client cachedClient = (Client) cachedObject;
            log.info("✓ Клиент найден в кэше: {}", cachedClient);
            return Optional.of(cachedClient);
        }

        // Если в кэше нет, загружаем из БД
        log.info("✗ Клиент не найден в кэше, загружаем из БД для ID: {}", id);
        return transactionManager.doInReadOnlyTransaction(session -> {
            var clientOptional = clientDataTemplate.findById(session, id);
            log.info("✓ Клиент загружен из БД: {}", clientOptional);

            // Сохраняем в кэш, если клиент найден
            if (clientOptional.isPresent()) {
                log.info("✓ Клиент сохранен в кэш для ID: {}", id);
                clientCache.put(cacheKey, clientOptional.get());
            }

            return clientOptional;
        });
    }

    @Override
    public List<Client> findAll() {
        // Проверяем кэш всех клиентов
        Object cachedObject = clientCache.get("all-clients");
        if (cachedObject instanceof List) {
            @SuppressWarnings("unchecked")
            List<Client> cachedClients = (List<Client>) cachedObject;
            log.info("✓ Список всех клиентов найден в кэше, количество: {}", cachedClients.size());
            return cachedClients;
        }

        // Если в кэше нет, загружаем из БД
        log.info("✗ Список всех клиентов не найден в кэше, загружаем из БД");
        return transactionManager.doInReadOnlyTransaction(session -> {
            var clientList = clientDataTemplate.findAll(session);
            log.info("✓ Список всех клиентов загружен из БД, количество: {}", clientList.size());

            // Сохраняем в кэш
            log.info("✓ Список всех клиентов сохранен в кэш");
            clientCache.put("all-clients", clientList);

            return clientList;
        });
    }

    @Override
    public void deleteAll() {
        transactionManager.doInTransaction(session -> {
            // Получаем количество клиентов перед удалением для логирования
            var clientsCount = clientDataTemplate.findAll(session).size();

            // Удаляем всех клиентов одним запросом
            clientDataTemplate.deleteAll(session);

            // Очищаем кэш
            clientCache.clear();

            log.info("Удалены все клиенты одним запросом, количество: {}", clientsCount);
            return null;
        });
    }

    /**
     * Очищает кэш клиентов для демонстрации
     */
    public void clearClientCache() {
        clientCache.clear();
        log.info("✓ Кэш клиентов очищен");
    }
}
