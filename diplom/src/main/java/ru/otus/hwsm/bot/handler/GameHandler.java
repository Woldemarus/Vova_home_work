package ru.otus.hwsm.bot.handler;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import ru.otus.hwsm.entity.Game;
import ru.otus.hwsm.entity.Question;
import ru.otus.hwsm.entity.User;
import ru.otus.hwsm.service.GameService;
import ru.otus.hwsm.service.QuestionService;
import ru.otus.hwsm.service.UserService;

@Slf4j
@Component
@RequiredArgsConstructor
public class GameHandler {

    private final UserService userService;
    private final GameService gameService;
    private final QuestionService questionService;
    private final MessageSender messageSender;
    private final KeyboardFactory keyboardFactory;

    public void handleQuestionCommandWrapper(Message message) {
        Long chatId = message.getChatId();
        org.telegram.telegrambots.meta.api.objects.User telegramUser = message.getFrom();
        this.handleQuestionCommand(chatId, telegramUser);
    }

    public void handleQuestionCommandWrapper(CallbackQuery callbackQuery) {
        handleQuestionCommand(callbackQuery.getMessage().getChatId(), callbackQuery.getFrom());
    }

    private void handleQuestionCommand(Long chatId, org.telegram.telegrambots.meta.api.objects.User telegramUser) {
        try {
            Optional<Game> activeGameOpt = userService.findActiveGame(telegramUser.getId());
            if (activeGameOpt.isEmpty()) {
                messageSender.sendMessage(chatId, "❌ У вас нет активной игры. Начните новую игру командой /start");
                return;
            }

            Game activeGame = activeGameOpt.get();
            Optional<Question> questionOpt = gameService.getCurrentQuestion(activeGame);

            if (questionOpt.isEmpty()) {
                messageSender.sendMessage(chatId, "❌ Не удалось загрузить вопрос. Попробуйте еще раз.");
                return;
            }

            Question question = questionOpt.get();
            String questionText = buildQuestionMessage(activeGame, question);

            messageSender.sendMessageWithKeyboard(
                    chatId,
                    questionText,
                    keyboardFactory.createQuestionKeyboard(
                            question,
                            activeGame.getGameLifelines().stream()
                                    .map(lifeline -> lifeline.getLifelineType())
                                    .toList()));

        } catch (Exception e) {
            log.error("Error handling /question command for user {}: {}", telegramUser.getId(), e.getMessage(), e);
            messageSender.sendErrorMessage(chatId);
        }
    }

    public void handleContinueCommand(Message message) {
        handleQuestionCommandWrapper(message); // Продолжить = показать текущий вопрос
    }

    public void handleNewGameCommand(Message message) {
        Long chatId = message.getChatId();
        org.telegram.telegrambots.meta.api.objects.User telegramUser = message.getFrom();

        try {
            User user = userService.findOrCreateUser(telegramUser);
            Game newGame = userService.startNewGame(user);

            String messageText = String.format(
                    """
                🎉 Новая игра началась!

                🎯 Вопрос %d из 15
                💰 Текущий выигрыш: %d ₽

                Для получения первого вопроса нажмите далее или введите команду /question
                """,
                    newGame.getCurrentQuestionNumber(), newGame.getCurrentPrizeAmount());

            messageSender.sendMessageWithKeyboard(chatId, messageText, keyboardFactory.createStartGameKeyboard());

        } catch (Exception e) {
            log.error("Error handling /newgame command for user {}: {}", telegramUser.getId(), e.getMessage(), e);
            messageSender.sendErrorMessage(chatId);
        }
    }

    private String buildQuestionMessage(Game game, Question question) {
        return String.format(
                """
            🎯 **Вопрос %d из 15**
            💰 Текущий выигрыш: %d ₽
            🛡️ Несгораемая сумма: %d ₽

            **%s**

            %s

            Выберите ответ или используйте подсказку:
            """,
                game.getCurrentQuestionNumber(),
                game.getCurrentPrizeAmount(),
                game.getGuaranteedPrizeAmount(),
                question.getQuestionText(),
                formatQuestionOptions(question));
    }

    private String formatQuestionOptions(Question question) {
        StringBuilder options = new StringBuilder();
        for (var option : question.getOptions()) {
            options.append(String.format("**%s:** %s\n", option.getOptionLetter(), option.getOptionText()));
        }
        return options.toString();
    }
}
