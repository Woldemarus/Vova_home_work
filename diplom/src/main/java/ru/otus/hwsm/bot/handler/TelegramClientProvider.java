package ru.otus.hwsm.bot.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
@Slf4j
public class TelegramClientProvider {

    private final TelegramClient telegramClient;

    @Autowired
    public TelegramClientProvider(TelegramClient telegramClient) {
        this.telegramClient = telegramClient;
    }

    public TelegramClient getClient() {
        return telegramClient;
    }
}
