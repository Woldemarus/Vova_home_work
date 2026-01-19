package ru.otus.hwsm.bot.handler;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.otus.hwsm.entity.*;
import ru.otus.hwsm.service.GameService;
import ru.otus.hwsm.service.QuestionService;
import ru.otus.hwsm.service.UserService;

@Slf4j
@Component
@RequiredArgsConstructor
public class CallbackHandler {

    private final UserService userService;
    private final GameService gameService;
    private final QuestionService questionService;
    private final MessageSender messageSender;
    private final KeyboardFactory keyboardFactory;

    public void handleAnswerCallback(CallbackQuery callbackQuery, String callbackData) {
        Long chatId = callbackQuery.getMessage().getChatId();
        Integer messageId = callbackQuery.getMessage().getMessageId();
        String optionLetter = callbackData.replace("answer_", "");

        try {
            Optional<Game> activeGameOpt =
                    userService.findActiveGame(callbackQuery.getFrom().getId());
            if (activeGameOpt.isEmpty()) {
                messageSender.editMessage(chatId, messageId, "❌ Активная игра не найдена.");
                return;
            }

            Game activeGame = activeGameOpt.get();
            Optional<Question> questionOpt = gameService.getCurrentQuestion(activeGame);

            if (questionOpt.isEmpty()) {
                messageSender.editMessage(chatId, messageId, "❌ Вопрос не найден.");
                return;
            }

            Question question = questionOpt.get();
            GameService.GameAnswerResult result = gameService.processAnswer(activeGame, question, optionLetter);

            String resultMessage = buildAnswerResultMessage(result, question, optionLetter);

            if (result.isGameCompleted()) {
                messageSender.editMessageWithKeyboard(
                        chatId, messageId, resultMessage, keyboardFactory.createGameOverKeyboard());
            } else {
                messageSender.editMessage(chatId, messageId, resultMessage);
            }

        } catch (Exception e) {
            log.error("Error handling answer callback: {}", e.getMessage(), e);
            messageSender.editMessage(chatId, messageId, "❌ Ошибка при обработке ответа.");
        }
    }

    public void handleLifelineCallback(CallbackQuery callbackQuery, String callbackData) {
        Long chatId = callbackQuery.getMessage().getChatId();
        Integer messageId = callbackQuery.getMessage().getMessageId();
        String lifelineType = callbackData.replace("lifeline_", "");

        try {
            Optional<Game> activeGameOpt =
                    userService.findActiveGame(callbackQuery.getFrom().getId());
            if (activeGameOpt.isEmpty()) {
                messageSender.editMessage(chatId, messageId, "❌ Активная игра не найдена.");
                return;
            }

            Game activeGame = activeGameOpt.get();
            Optional<Question> questionOpt = gameService.getCurrentQuestion(activeGame);

            if (questionOpt.isEmpty()) {
                messageSender.editMessage(chatId, messageId, "❌ Вопрос не найден.");
                return;
            }

            Question question = questionOpt.get();
            GameLifeline.LifelineType lifeline = parseLifelineType(lifelineType);

            GameService.LifelineResult result = gameService.useLifeline(activeGame, question, lifeline);

            if (!result.isSuccess()) {
                messageSender.editMessage(chatId, messageId, "❌ " + result.getMessage());
                return;
            }

            String lifelineMessage = buildLifelineResultMessage(question, result);

            if (lifeline == GameLifeline.LifelineType.FIFTY_FIFTY) {
                messageSender.editMessageWithKeyboard(
                        chatId,
                        messageId,
                        lifelineMessage,
                        keyboardFactory.createFiftyFiftyKeyboard(result.getRemainingOptions()));
            } else {
                messageSender.editMessage(chatId, messageId, lifelineMessage);
            }

        } catch (Exception e) {
            log.error("Error handling lifeline callback: {}", e.getMessage(), e);
            messageSender.editMessage(chatId, messageId, "❌ Ошибка при использовании подсказки.");
        }
    }

    public void handleStartFirstQuestionCallback(CallbackQuery callbackQuery) {
        Long chatId = callbackQuery.getMessage().getChatId();
        Integer messageId = callbackQuery.getMessage().getMessageId();

        try {
            Optional<Game> activeGameOpt =
                    userService.findActiveGame(callbackQuery.getFrom().getId());
            if (activeGameOpt.isEmpty()) {
                messageSender.editMessage(chatId, messageId, "❌ Активная игра не найдена.");
                return;
            }

            Game activeGame = activeGameOpt.get();
            Optional<Question> questionOpt = gameService.getCurrentQuestion(activeGame);

            if (questionOpt.isEmpty()) {
                messageSender.editMessage(chatId, messageId, "❌ Не удалось загрузить вопрос. Попробуйте еще раз.");
                return;
            }

            Question question = questionOpt.get();
            String questionText = buildQuestionMessage(activeGame, question);

            messageSender.editMessageWithKeyboard(
                    chatId,
                    messageId,
                    questionText,
                    keyboardFactory.createQuestionKeyboard(
                            question,
                            activeGame.getGameLifelines().stream()
                                    .map(lifeline -> lifeline.getLifelineType())
                                    .toList()));

        } catch (Exception e) {
            log.error(
                    "Error handling start first question callback for user {}: {}",
                    callbackQuery.getFrom().getId(),
                    e.getMessage(),
                    e);
            messageSender.editMessage(chatId, messageId, "❌ Произошла ошибка при загрузке вопроса.");
        }
    }

    public void handleTakeMoneyCallback(CallbackQuery callbackQuery) {
        Long chatId = callbackQuery.getMessage().getChatId();
        Integer messageId = callbackQuery.getMessage().getMessageId();

        try {
            Optional<Game> activeGameOpt =
                    userService.findActiveGame(callbackQuery.getFrom().getId());
            if (activeGameOpt.isEmpty()) {
                messageSender.editMessage(chatId, messageId, "❌ Активная игра не найдена.");
                return;
            }

            Game activeGame = activeGameOpt.get();
            int finalPrize = gameService.takeTheMoney(activeGame);

            String message = String.format(
                    """
                💰 **Поздравляем!**

                Вы забрали деньги и завершили игру.

                🏆 **Ваш выигрыш: %d ₽**

                Спасибо за игру! Хотите сыграть еще раз?
                """,
                    finalPrize);

            messageSender.editMessageWithKeyboard(chatId, messageId, message, keyboardFactory.createGameOverKeyboard());

        } catch (Exception e) {
            log.error("Error handling take money callback: {}", e.getMessage(), e);
            messageSender.editMessage(chatId, messageId, "❌ Ошибка при завершении игры.");
        }
    }

    private String buildAnswerResultMessage(
            GameService.GameAnswerResult result, Question question, String selectedLetter) {
        Optional<QuestionOption> correctAnswer = questionService.getCorrectAnswer(question.getId());
        String correctLetter =
                correctAnswer.map(QuestionOption::getOptionLetter).orElse("?");

        if (result.isCorrect()) {
            if (result.isGameCompleted()) {
                return String.format(
                        """
                    ✅ **Правильно!** Ответ: %s

                    🎉 **ПОЗДРАВЛЯЕМ! ВЫ ВЫИГРАЛИ ГЛАВНЫЙ ПРИЗ!**

                    🏆 **Ваш выигрыш: %d ₽**

                    Вы ответили на все 15 вопросов и стали миллионером!
                    Спасибо за игру!
                    """,
                        selectedLetter, result.getFinalPrize());
            } else {
                return String.format(
                        """
                    ✅ **Правильно!** Ответ: %s

                    🎯 Переходим к вопросу %d из 15
                    💰 Ваш выигрыш: %d ₽

                    Нажмите /question для следующего вопроса
                    """,
                        selectedLetter, result.getNextQuestionNumber(), result.getCurrentPrize());
            }
        } else {
            return String.format(
                    """
                ❌ **Неправильно!**

                Ваш ответ: %s
                Правильный ответ: %s

                🎮 **Игра окончена**
                🏆 **Ваш выигрыш: %d ₽**

                Спасибо за игру! Хотите попробовать еще раз?
                """,
                    selectedLetter, correctLetter, result.getFinalPrize());
        }
    }

    private String buildLifelineResultMessage(Question question, GameService.LifelineResult result) {
        String baseMessage = String.format(
                """
            💡 **Подсказка использована: %s**

            %s

            **Вопрос:** %s

            %s
            """,
                getLifelineDisplayName(result.getLifelineType()),
                result.getMessage(),
                question.getQuestionText(),
                result.getLifelineType() == GameLifeline.LifelineType.FIFTY_FIFTY
                        ? "Остались только эти варианты:"
                        : formatQuestionOptions(question));

        return baseMessage;
    }

    private String formatQuestionOptions(Question question) {
        StringBuilder options = new StringBuilder();
        for (var option : question.getOptions()) {
            options.append(String.format("**%s:** %s\n", option.getOptionLetter(), option.getOptionText()));
        }
        return options.toString();
    }

    private String getLifelineDisplayName(GameLifeline.LifelineType type) {
        return switch (type) {
            case FIFTY_FIFTY -> "50/50";
            case PHONE_FRIEND -> "Звонок другу";
            case AUDIENCE_POLL -> "Помощь зала";
        };
    }

    private GameLifeline.LifelineType parseLifelineType(String type) {
        return switch (type) {
            case "fifty_fifty" -> GameLifeline.LifelineType.FIFTY_FIFTY;
            case "phone_friend" -> GameLifeline.LifelineType.PHONE_FRIEND;
            case "audience_poll" -> GameLifeline.LifelineType.AUDIENCE_POLL;
            default -> throw new IllegalArgumentException("Unknown lifeline type: " + type);
        };
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
}
