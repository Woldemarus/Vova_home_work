package ru.otus.hwsm.bot;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.message.MaybeInaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.otus.hwsm.bot.handler.CallbackHandler;
import ru.otus.hwsm.bot.handler.CommandHandler;
import ru.otus.hwsm.bot.handler.GameHandler;
import ru.otus.hwsm.bot.handler.TelegramClientProvider;
import ru.otus.hwsm.service.UserService;

@Slf4j
@Component
// Ключевое изменение: добавляем LongPollingUpdateConsumer
public class HwsmTelegramBotSimple implements SpringLongPollingBot, LongPollingUpdateConsumer {

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.bot.username}")
    private String botUsername;

    private final CommandHandler commandHandler;
    private final GameHandler gameHandler;
    private final CallbackHandler callbackHandler;
    private final TelegramClientProvider telegramClientProvider;
    private final UserService userService;

    public HwsmTelegramBotSimple(
            CommandHandler commandHandler,
            GameHandler gameHandler,
            CallbackHandler callbackHandler,
            TelegramClientProvider telegramClientProvider,
            UserService userService) {
        this.commandHandler = commandHandler;
        this.gameHandler = gameHandler;
        this.callbackHandler = callbackHandler;
        this.telegramClientProvider = telegramClientProvider;
        this.userService = userService;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return this; // Теперь это работает, потому что класс реализует интерфейс
    }

    // Реализация метода из LongPollingUpdateConsumer
    @Override
    public void consume(List<Update> updates) {
        for (Update update : updates) {
            processUpdate(update);
        }
    }

    // ... остальные методы остаются без изменений
    private void processUpdate(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                handleTextMessage(update.getMessage());
            } else if (update.hasCallbackQuery()) {
                handleCallbackQuery(update.getCallbackQuery());
            }
        } catch (Exception e) {
            log.error("Error processing update: {}", e.getMessage(), e);
        }
    }

    private void handleTextMessage(Message message) {
        String messageText = message.getText();
        Long chatId = message.getChatId();
        User telegramUser = message.getFrom();

        log.debug("Received message: '{}' from user: {}", messageText, telegramUser.getId());

        try {
            // Получаем или создаем пользователя в БД
            ru.otus.hwsm.entity.User user = userService.findOrCreateUser(telegramUser);

            // Проверяем активную игру
            Optional<ru.otus.hwsm.entity.Game> activeGame = userService.findActiveGame(user.getTelegramUserId());

            if (messageText.startsWith("/start")) {
                handleStartCommand(chatId, user, activeGame);
            } else {
                // Остальная логика команд
                switch (messageText) {
                    case "/question" -> gameHandler.handleQuestionCommand(message);
                    case "/continue" -> gameHandler.handleContinueCommand(message);
                    case "/newgame" -> gameHandler.handleNewGameCommand(message);
                    case "/stats" -> commandHandler.handleStatsCommand(message);
                    default -> handleUnknownCommand(chatId);
                }
            }
        } catch (Exception e) {
            log.error("Error handling text message from user {}: {}", telegramUser.getId(), e.getMessage(), e);
            sendErrorMessage(chatId, "❌ Ошибка при обработке команды");
        }
    }

    private void handleStartCommand(
            Long chatId, ru.otus.hwsm.entity.User user, Optional<ru.otus.hwsm.entity.Game> activeGame) {
        StringBuilder messageText = new StringBuilder();

        if (activeGame.isPresent()) {
            // Случай 1: Есть активная игра
            ru.otus.hwsm.entity.Game game = activeGame.get();
            messageText
                    .append("🎮 У вас есть активная игра!\n\n")
                    .append("Текущий вопрос: №")
                    .append(game.getCurrentQuestionNumber())
                    .append("\n")
                    .append("Текущий выигрыш: ")
                    .append(game.getCurrentPrizeAmount())
                    .append(" очков\n")
                    .append("Гарантированный выигрыш: ")
                    .append(game.getGuaranteedPrizeAmount())
                    .append(" очков\n\n")
                    .append("Продолжаем игру?");
        } else {
            // Случай 2: Нет активной игры
            Long completedGamesCount = userService.getCompletedGamesCount(user);

            if (completedGamesCount == 0) {
                // Случай 2.1: Пользователь новый
                messageText
                        .append("👋 Привет, ")
                        .append(user.getFirstName())
                        .append("!\n\n")
                        .append("Добро пожаловать в игру 'Кто хочет стать миллионером?'!\n")
                        .append("Здесь ты можешь проверить свои знания и выиграть призы.\n\n")
                        .append("Начнем первую игру?");
            } else {
                // Случай 2.2: Пользователь уже играл
                messageText
                        .append("С возвращением, ")
                        .append(user.getFirstName())
                        .append("! 👋\n\n")
                        .append("Рады снова видеть тебя!\n")
                        .append("Ты уже завершил ")
                        .append(completedGamesCount)
                        .append(" ")
                        .append(getGameWord(completedGamesCount))
                        .append(".\n\n")
                        .append("Хочешь сыграть еще раз?");
            }
        }

        sendMessage(chatId, messageText.toString());
    }

    private String getGameWord(Long count) {
        if (count % 10 == 1 && count % 100 != 11) {
            return "игру";
        } else if (count % 10 >= 2 && count % 10 <= 4 && (count % 100 < 10 || count % 100 >= 20)) {
            return "игры";
        } else {
            return "игр";
        }
    }

    private void handleCallbackQuery(CallbackQuery callbackQuery) {
        String callbackData = callbackQuery.getData();
        Long userId = callbackQuery.getFrom().getId();
        Long chatId = callbackQuery.getMessage().getChatId();

        log.debug("Received callback: '{}' from user: {}", callbackData, userId);

        try {
            // Отвечаем на callback сразу, чтобы убрать "часики" у пользователя
            answerCallbackQuery(callbackQuery.getId());

            if (callbackData.startsWith("answer_")) {
                callbackHandler.handleAnswerCallback(callbackQuery, callbackData);
            } else if (callbackData.startsWith("lifeline_")) {
                callbackHandler.handleLifelineCallback(callbackQuery, callbackData);
            } else if (callbackData.equals("take_money")) {
                callbackHandler.handleTakeMoneyCallback(callbackQuery);
            } else if (callbackData.equals("continue_game")) {
                handleContinueGameCallback(callbackQuery);
            } else if (callbackData.equals("new_game")) {
                handleNewGameCallback(callbackQuery);
            }
        } catch (Exception e) {
            log.error("Error handling callback from user {}: {}", userId, e.getMessage(), e);
            sendErrorMessage(chatId, "❌ Ошибка при обработке действия");
        }
    }

    private void answerCallbackQuery(String callbackQueryId) {
        try {
            AnswerCallbackQuery answer = AnswerCallbackQuery.builder()
                    .callbackQueryId(callbackQueryId)
                    .build();
            telegramClientProvider.getClient().execute(answer);
        } catch (TelegramApiException e) {
            log.warn("Failed to answer callback query: {}", e.getMessage());
        }
    }

    private void handleContinueGameCallback(CallbackQuery callbackQuery) {
        MaybeInaccessibleMessage maybeMessage = callbackQuery.getMessage();

        // Проверяем, является ли сообщение доступным Message
        if (maybeMessage instanceof org.telegram.telegrambots.meta.api.objects.message.Message) {
            org.telegram.telegrambots.meta.api.objects.message.Message originalMessage =
                    (org.telegram.telegrambots.meta.api.objects.message.Message) maybeMessage;

            // Создаем новое сообщение с теми же данными
            org.telegram.telegrambots.meta.api.objects.message.Message newMessage =
                    new org.telegram.telegrambots.meta.api.objects.message.Message();
            newMessage.setChat(originalMessage.getChat());
            newMessage.setFrom(callbackQuery.getFrom());
            newMessage.setText("/question");
            newMessage.setMessageId(originalMessage.getMessageId());
            newMessage.setDate(originalMessage.getDate());

            gameHandler.handleQuestionCommand(newMessage);
        } else {
            // Обработка случая, когда сообщение недоступно
            log.warn("Message is inaccessible in callback: {}", callbackQuery.getId());
            // Отправляем сообщение в личку пользователю
            sendErrorMessage(
                    callbackQuery.getFrom().getId(),
                    "❌ Не удалось продолжить игру. Сообщение недоступно.\n"
                            + "Попробуйте начать новую игру командой /newgame");
        }
    }

    private void handleNewGameCallback(CallbackQuery callbackQuery) {
        MaybeInaccessibleMessage maybeMessage = callbackQuery.getMessage();

        if (maybeMessage instanceof org.telegram.telegrambots.meta.api.objects.message.Message) {
            org.telegram.telegrambots.meta.api.objects.message.Message originalMessage =
                    (org.telegram.telegrambots.meta.api.objects.message.Message) maybeMessage;

            // Создаем новое сообщение с теми же данными
            org.telegram.telegrambots.meta.api.objects.message.Message newMessage =
                    new org.telegram.telegrambots.meta.api.objects.message.Message();
            newMessage.setChat(originalMessage.getChat());
            newMessage.setFrom(callbackQuery.getFrom());
            newMessage.setText("/newgame");
            newMessage.setMessageId(originalMessage.getMessageId());
            newMessage.setDate(originalMessage.getDate());

            gameHandler.handleNewGameCommand(newMessage);
        } else {
            // Обработка случая, когда сообщение недоступно
            log.warn("Message is inaccessible in callback: {}", callbackQuery.getId());
            // Отправляем в личку, так как inline-сообщение недоступно
            sendErrorMessage(
                    callbackQuery.getFrom().getId(),
                    "❌ Не удалось начать новую игру из этого сообщения.\n"
                            + "Пожалуйста, напишите /newgame напрямую в чат с ботом.");
        }
    }

    private void handleUnknownCommand(Long chatId) {
        sendMessage(
                chatId,
                "❓ Неизвестная команда.\n\n" + "Доступные команды:\n"
                        + "• /start - Начать игру\n"
                        + "• /question - Текущий вопрос\n"
                        + "• /stats - Статистика\n"
                        + "• /help - Помощь");
    }

    private void sendMessage(Long chatId, String text) {
        try {
            SendMessage message = SendMessage.builder()
                    .chatId(chatId.toString())
                    .text(text)
                    .parseMode("Markdown")
                    .build();

            telegramClientProvider.getClient().execute(message);
        } catch (TelegramApiException e) {
            log.error("Failed to send message to chat {}: {}", chatId, e.getMessage());
        }
    }

    private void sendErrorMessage(Long chatId, String text) {
        sendMessage(chatId, text);
    }
}
