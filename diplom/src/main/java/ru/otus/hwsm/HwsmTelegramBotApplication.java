package ru.otus.hwsm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class HwsmTelegramBotApplication {

    public static void main(String[] args) {
        log.info("🚀 Starting Hwsm Telegram Bot Application...");

        // Отладочная информация о конфигурации
        log.info("Working directory: {}", System.getProperty("user.dir"));
        log.info("Java version: {}", System.getProperty("java.version"));
        log.info("Spring profiles: {}", System.getProperty("spring.profiles.active", "default"));

        SpringApplication.run(HwsmTelegramBotApplication.class, args);
        log.info("✅ Application started successfully!");
        log.info("🤖 Bot is running. Press Ctrl+C to stop.");

        // Spring Boot автоматически управляет жизненным циклом бота
        // Не нужно вручную регистрировать бота или создавать бесконечные циклы
    }
}
