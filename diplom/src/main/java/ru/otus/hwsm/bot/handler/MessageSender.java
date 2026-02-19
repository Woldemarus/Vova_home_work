package ru.otus.hwsm.bot.handler;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Slf4j
@Component
public class MessageSender {

    private TelegramClient telegramClient;

    // ✅ Конструктор БЕЗ параметров
    public MessageSender() {
        // TelegramClient будет установлен позже через setter
    }

    // ✅ Setter для TelegramClient с @Lazy
    @org.springframework.beans.factory.annotation.Autowired(required = false)
    @Lazy
    public void setTelegramClient(TelegramClient telegramClient) {
        this.telegramClient = telegramClient;
        if (telegramClient != null) {
            log.info("✅ TelegramClient установлен в MessageSender");
        }
    }

    @PostConstruct
    public void init() {
        log.info("MessageSender инициализирован");
    }

    public void sendMessage(Long chatId, String text) {
        if (telegramClient == null) {
            log.warn(
                    "⚠️ TelegramClient еще не готов. Сообщение не отправлено: {}",
                    text.substring(0, Math.min(text.length(), 50)));
            return;
        }

        try {
            SendMessage message = SendMessage.builder()
                    .chatId(chatId.toString())
                    .text(text)
                    .parseMode("Markdown")
                    .build();

            telegramClient.execute(message);
            log.debug("✅ Сообщение отправлено в чат {}", chatId);
        } catch (TelegramApiException e) {
            log.error("❌ Ошибка отправки в чат {}: {}", chatId, e.getMessage());
        }
    }

    public void sendMessageWithKeyboard(Long chatId, String text, InlineKeyboardMarkup keyboard) {
        SendMessage message = SendMessage.builder()
                .chatId(chatId.toString())
                .text(text)
                .parseMode("Markdown")
                .replyMarkup(keyboard)
                .build();

        try {
            telegramClient.execute(message); // ✅ Исправлено: telegramClient вместо bot
            log.debug("Сообщение с клавиатурой отправлено в чат {}", chatId);
        } catch (TelegramApiException e) {
            log.error("Не удалось отправить сообщение с клавиатурой в чат {}: {}", chatId, e.getMessage(), e);
        }
    }

    public void editMessage(Long chatId, Integer messageId, String text) {
        EditMessageText editMessage = EditMessageText.builder()
                .chatId(chatId.toString())
                .messageId(messageId)
                .text(text)
                .parseMode("Markdown")
                .build();

        try {
            telegramClient.execute(editMessage); // ✅ Исправлено: telegramClient вместо bot
            log.debug("Сообщение отредактировано в чате {}", chatId);
        } catch (TelegramApiException e) {
            log.error("Не удалось отредактировать сообщение в чате {}: {}", chatId, e.getMessage(), e);
        }
    }

    public void editMessageWithKeyboard(Long chatId, Integer messageId, String text, InlineKeyboardMarkup keyboard) {
        EditMessageText editMessage = EditMessageText.builder()
                .chatId(chatId.toString())
                .messageId(messageId)
                .text(text)
                .parseMode("Markdown")
                .replyMarkup(keyboard)
                .build();

        try {
            telegramClient.execute(editMessage); // ✅ Исправлено: telegramClient вместо bot
            log.debug("Сообщение с клавиатурой отредактировано в чате {}", chatId);
        } catch (TelegramApiException e) {
            log.error("Не удалось отредактировать сообщение с клавиатурой в чате {}: {}", chatId, e.getMessage(), e);
        }
    }

    /**
     * Редактирует сообщение и убирает клавиатуру (чтобы кнопки не мигали)
     */
    public void editMessageAndRemoveKeyboard(Long chatId, Integer messageId, String text) {
        EditMessageText editMessage = EditMessageText.builder()
                .chatId(chatId.toString())
                .messageId(messageId)
                .text(text)
                .parseMode("Markdown")
                .replyMarkup(null) // Убираем клавиатуру
                .build();

        try {
            telegramClient.execute(editMessage);
            log.debug("Сообщение отредактировано и клавиатура убрана в чате {}", chatId);
        } catch (TelegramApiException e) {
            log.error(
                    "Не удалось отредактировать сообщение и убрать клавиатуру в чате {}: {}",
                    chatId,
                    e.getMessage(),
                    e);
        }
    }

    /**
     * Отправляет сообщение с клавиатурой и пытается убрать клавиатуру у предыдущего сообщения
     * (если передан messageId предыдущего сообщения)
     */
    public void sendMessageWithKeyboardAndRemovePrevious(
            Long chatId, String text, InlineKeyboardMarkup keyboard, Integer previousMessageId) {
        // Сначала убираем клавиатуру у предыдущего сообщения (если есть)
        if (previousMessageId != null) {
            try {
                EditMessageReplyMarkup editMarkup = EditMessageReplyMarkup.builder()
                        .chatId(chatId.toString())
                        .messageId(previousMessageId)
                        .replyMarkup(null)
                        .build();
                telegramClient.execute(editMarkup);
                log.debug("Клавиатура убрана у сообщения {} в чате {}", previousMessageId, chatId);
            } catch (TelegramApiException e) {
                log.debug("Не удалось убрать клавиатуру у предыдущего сообщения: {}", e.getMessage());
            }
        }

        // Отправляем новое сообщение с клавиатурой
        sendMessageWithKeyboard(chatId, text, keyboard);
    }

    public void sendErrorMessage(Long chatId) {
        sendMessage(
                chatId,
                "❌ Произошла ошибка при обработке вашего запроса.\n"
                        + "Попробуйте еще раз или обратитесь к администратору.");
    }
}
