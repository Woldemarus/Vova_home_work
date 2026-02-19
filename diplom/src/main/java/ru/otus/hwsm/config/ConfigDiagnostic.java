package ru.otus.hwsm.config;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * Диагностический компонент для отладки загрузки конфигурационных файлов
 */
@Slf4j
@Component
public class ConfigDiagnostic {

    private final ConfigurableEnvironment environment;

    @Value("${telegram.bot.token:NOT_FOUND}")
    private String telegramToken;

    @Value("${telegram.bot.username:NOT_FOUND}")
    private String telegramUsername;

    public ConfigDiagnostic(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void diagnoseConfiguration() {
        log.info("=== ДИАГНОСТИКА КОНФИГУРАЦИИ ===");

        // 1. Проверяем рабочую директорию
        String workingDir = System.getProperty("user.dir");
        log.info("Рабочая директория: {}", workingDir);

        // 2. Проверяем существование файла application-local.properties
        checkConfigFile("application-local.properties");
        checkConfigFile("./application-local.properties");

        // 3. Проверяем переменные окружения
        log.info(
                "TELEGRAM_BOT_TOKEN из env: {}",
                System.getenv("TELEGRAM_BOT_TOKEN") != null ? "[УСТАНОВЛЕН]" : "[НЕ НАЙДЕН]");
        log.info(
                "TELEGRAM_BOT_USERNAME из env: {}",
                System.getenv("TELEGRAM_BOT_USERNAME") != null ? "[УСТАНОВЛЕН]" : "[НЕ НАЙДЕН]");

        // 4. Проверяем загруженные значения
        log.info("telegram.bot.token: {}", "NOT_FOUND".equals(telegramToken) ? "[НЕ ЗАГРУЖЕН]" : "[ЗАГРУЖЕН]");
        log.info("telegram.bot.username: {}", "NOT_FOUND".equals(telegramUsername) ? "[НЕ ЗАГРУЖЕН]" : "[ЗАГРУЖЕН]");

        // 5. Показываем все PropertySource
        log.info("=== АКТИВНЫЕ PROPERTY SOURCES ===");
        environment.getPropertySources().forEach(propertySource -> {
            log.info(
                    "PropertySource: {} (класс: {})",
                    propertySource.getName(),
                    propertySource.getClass().getSimpleName());
        });

        log.info("=== КОНЕЦ ДИАГНОСТИКИ ===");
    }

    private void checkConfigFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            File file = path.toFile();

            log.info("Проверка файла: {}", path.toAbsolutePath());
            log.info("  - Существует: {}", file.exists());
            log.info("  - Читаемый: {}", file.canRead());
            log.info("  - Размер: {} байт", file.exists() ? file.length() : "N/A");

            if (file.exists() && file.canRead()) {
                // Читаем первые несколько строк для проверки содержимого
                try {
                    String content = Files.readString(path);
                    String[] lines = content.split("\n");
                    log.info("  - Первые строки файла:");
                    for (int i = 0; i < Math.min(3, lines.length); i++) {
                        if (lines[i].contains("TOKEN") || lines[i].contains("USERNAME")) {
                            log.info("    {}: [СОДЕРЖИТ СЕКРЕТНЫЕ ДАННЫЕ]", i + 1);
                        } else {
                            log.info("    {}: {}", i + 1, lines[i]);
                        }
                    }
                } catch (Exception e) {
                    log.warn("  - Ошибка чтения содержимого: {}", e.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("Ошибка при проверке файла {}: {}", filePath, e.getMessage());
        }
    }
}
