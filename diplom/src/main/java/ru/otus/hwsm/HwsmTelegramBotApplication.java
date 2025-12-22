package ru.otus.hwsm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class HwsmTelegramBotApplication {

    public static void main(String[] args) {
        log.info("🚀 Starting Hwsm Telegram Bot Application...");
        SpringApplication.run(HwsmTelegramBotApplication.class, args);
        log.info("✅ Application started successfully!");
        log.info("🤖 Bot is running. Press Ctrl+C to stop.");

        // Spring Boot автоматически управляет жизненным циклом бота
        // Не нужно вручную регистрировать бота или создавать бесконечные циклы
    }
}
