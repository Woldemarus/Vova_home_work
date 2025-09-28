package ru.otus.crm.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.cachehw.HwListener;
import ru.otus.cachehw.MyCache;
import ru.otus.core.repository.DataTemplate;
import ru.otus.core.sessionmanager.TransactionManager;
import ru.otus.crm.model.Client;

public class DbServiceClientImpl implements DBServiceClient {
    private static final Logger log = LoggerFactory.getLogger(DbServiceClientImpl.class);

    private final DataTemplate<Client> clientDataTemplate;
    private final TransactionManager transactionManager;
    private final MyCache<Long, Client> clientCache;
    private final MyCache<String, List<Client>> allClientsCache;

    public DbServiceClientImpl(TransactionManager transactionManager, DataTemplate<Client> clientDataTemplate) {
        this.transactionManager = transactionManager;
        this.clientDataTemplate = clientDataTemplate;
        this.clientCache = new MyCache<>();
        this.allClientsCache = new MyCache<>();

        // Добавляем слушатель для логирования операций с кэшем
        setupCacheListeners();
    }

    private void setupCacheListeners() {
        HwListener<Long, Client> clientCacheListener = (key, value, action) -> {
            log.info("Кэш клиентов: {} - ключ: {}, клиент: {}", action, key, value != null ? value.getName() : "null");
        };

        HwListener<String, List<Client>> allClientsCacheListener = (key, value, action) -> {
            log.info("Кэш всех клиентов: {} - количество: {}", action, value != null ? value.size() : 0);
        };

        clientCache.addListener(clientCacheListener);
        allClientsCache.addListener(allClientsCacheListener);
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
                clientCache.put(savedClient.getId(), savedClient);
                // Очищаем кэш всех клиентов, так как список изменился
                allClientsCache.clear();
            }

            return savedClient;
        });
    }

    @Override
    public Optional<Client> getClient(long id) {
        // Сначала проверяем кэш
        Client cachedClient = clientCache.get(id);
        if (cachedClient != null) {
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
                clientCache.put(id, clientOptional.get());
            }

            return clientOptional;
        });
    }

    @Override
    public List<Client> findAll() {
        // Проверяем кэш всех клиентов
        List<Client> cachedClients = allClientsCache.get("all");
        if (cachedClients != null) {
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
            allClientsCache.put("all", clientList);

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

            // Очищаем кэши
            clientCache.clear();
            allClientsCache.clear();

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

    /**
     * Очищает кэш всех клиентов для демонстрации
     */
    public void clearAllClientsCache() {
        allClientsCache.clear();
        log.info("✓ Кэш всех клиентов очищен");
    }
}
