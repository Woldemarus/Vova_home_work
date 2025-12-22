package ru.otus.hwsm.bot.handler;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import ru.otus.hwsm.entity.Game;
import ru.otus.hwsm.entity.User;
import ru.otus.hwsm.service.UserService;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommandHandler {

    private final UserService userService;
    private final MessageSender messageSender; // ✅ Используем MessageSender
    private final KeyboardFactory keyboardFactory;

    public void handleHelpCommand(Long chatId) {
        String helpText =
                """
            🎮 **Кто хочет стать миллионером** - Команды:

            /start - Начать или продолжить игру
            /question - Получить текущий вопрос
            /stats - Показать статистику
            /help - Показать эту справку

            📋 **Правила игры:**
            • 15 вопросов с возрастающей сложностью
            • 4 варианта ответа (A, B, C, D)
            • 3 подсказки: 50/50, Звонок другу, Помощь зала
            • Несгораемые суммы: 1,000₽ (5-й вопрос) и 32,000₽ (10-й вопрос)
            • Главный приз: 1,000,000₽

            💡 **Подсказки:**
            • 🔄 50/50 - убирает 2 неправильных ответа
            • 📞 Звонок другу - совет от друга
            • 👥 Помощь зала - результаты голосования

            Удачи в игре! 🍀
            """;

        messageSender.sendMessage(chatId, helpText);
    }

    public void handleStatsCommand(Message message) {
        Long chatId = message.getChatId();
        var telegramUser = message.getFrom();

        try {
            Optional<User> userOpt = userService.findByTelegramId(telegramUser.getId());
            if (userOpt.isEmpty()) {
                messageSender.sendMessage(chatId, "❌ Пользователь не найден. Начните игру командой /start");
                return;
            }

            User user = userOpt.get();
            Long completedGames = userService.getCompletedGamesCount(user);
            Optional<Game> activeGame = userService.findActiveGame(telegramUser.getId());

            String statsText = String.format(
                    """
                    📊 **Ваша статистика, %s:**

                    🎯 Завершенных игр: %d
                    🎮 Активная игра: %s
                    %s

                    Продолжайте играть! 🚀
                    """,
                    user.getFirstName() != null ? user.getFirstName() : "Игрок",
                    completedGames,
                    activeGame.isPresent() ? "Да" : "Нет",
                    activeGame.isPresent()
                            ? String.format(
                                    "• Текущий вопрос: %d/15\n• Текущий выигрыш: %d ₽",
                                    activeGame.get().getCurrentQuestionNumber(),
                                    activeGame.get().getCurrentPrizeAmount())
                            : "");

            messageSender.sendMessage(chatId, statsText);
        } catch (Exception e) {
            log.error("Error handling /stats command for user {}: {}", telegramUser.getId(), e.getMessage(), e);
            messageSender.sendErrorMessage(chatId);
        }
    }

    private String buildActiveGameMessage(User user, Game activeGame) {
        Long completedGames = userService.getCompletedGamesCount(user);

        return String.format(
                """
                🎮 Добро пожаловать обратно, %s!

                📊 Ваша статистика:
                • Завершенных игр: %d
                • Текущий вопрос: %d/15
                • Текущий выигрыш: %d ₽

                У вас есть незавершенная игры. Хотите продолжить или начать новую?
                """,
                user.getFirstName() != null ? user.getFirstName() : "Игрок",
                completedGames,
                activeGame.getCurrentQuestionNumber(),
                activeGame.getCurrentPrizeAmount());
    }

    private String buildNewGameMessage(User user, Game newGame) {
        Long completedGames = userService.getCompletedGamesCount(user);

        return String.format(
                """
                🎉 Добро пожаловать в игру "Кто хочет стать миллионером", %s!

                📊 Ваша статистика:
                • Завершенных игр: %d

                🎯 Правила игры:
                • 15 вопросов с возрастающей сложностью
                • 4 варианта ответа на каждый вопрос
                • 3 подсказки: 50/50, Звонок другу, Помощь зала
                • Несгораемые суммы: 1,000₽ и 32,000₽
                • Главный приз: 1,000,000₽

                🚀 Игра началась! Для получения первого вопроса нажмите /question
                """,
                user.getFirstName() != null ? user.getFirstName() : "Игрок", completedGames);
    }
}
