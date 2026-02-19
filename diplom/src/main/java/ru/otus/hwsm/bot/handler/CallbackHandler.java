package ru.otus.hwsm.bot.handler;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
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
        // Формат: answer_{questionId}_{optionId}
        String[] parts = callbackData.replace("answer_", "").split("_");
        Long questionId = Long.parseLong(parts[0]);
        Long optionId = Long.parseLong(parts[1]);

        log.debug(
                "[CALLBACK_DEBUG] Received answer callback: chatId={}, questionId={}, optionId={}, callbackData={}",
                chatId,
                questionId,
                optionId,
                callbackData);
        log.debug(
                "[CALLBACK_DEBUG] User: {} ({})",
                callbackQuery.getFrom().getFirstName(),
                callbackQuery.getFrom().getId());

        try {
            Optional<Game> activeGameOpt =
                    userService.findActiveGame(callbackQuery.getFrom().getId());
            if (activeGameOpt.isEmpty()) {
                messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Активная игра не найдена.");
                return;
            }

            Game activeGame = activeGameOpt.get();
            // Используем questionId из игры (который был сохранен при показе вопроса)
            Long storedQuestionId = activeGame.getCurrentQuestionId();

            if (storedQuestionId == null) {
                messageSender.editMessageAndRemoveKeyboard(
                        chatId, messageId, "❌ Вопрос не найден. Начните новую игру.");
                return;
            }

            Optional<Question> questionOpt = questionService.getQuestionWithOptions(storedQuestionId);

            if (questionOpt.isEmpty()) {
                messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Вопрос не найден.");
                return;
            }

            Question question = questionOpt.get();
            GameService.GameAnswerResult result = gameService.processAnswer(activeGame, question, optionId);

            String resultMessage =
                    buildAnswerResultMessage(result, question, activeGame.getId(), storedQuestionId, optionId);

            if (result.isGameCompleted()) {
                messageSender.editMessageWithKeyboard(
                        chatId, messageId, resultMessage, keyboardFactory.createGameOverKeyboard());
            } else {
                messageSender.editMessageWithKeyboard(
                        chatId,
                        messageId,
                        resultMessage + "\n\n💡 Нажмите 'Начать' чтобы получить следующий вопрос",
                        keyboardFactory.createStartQuestionKeyboard());
            }

        } catch (Exception e) {
            log.error("Error handling answer callback: {}", e.getMessage(), e);
            messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Ошибка при обработке ответа.");
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
                messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Активная игра не найдена.");
                return;
            }

            Game activeGame = activeGameOpt.get();
            Optional<Question> questionOpt = gameService.getCurrentQuestion(activeGame);

            if (questionOpt.isEmpty()) {
                messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Вопрос не найден.");
                return;
            }

            Question question = questionOpt.get();
            GameLifeline.LifelineType lifeline = parseLifelineType(lifelineType);

            GameService.LifelineResult result = gameService.useLifeline(activeGame, question, lifeline);

            if (!result.isSuccess()) {
                messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ " + result.getMessage());
                return;
            }

            String lifelineMessage = buildLifelineResultMessage(question, result);

            if (lifeline == GameLifeline.LifelineType.FIFTY_FIFTY) {
                // Получаем список использованных подсказок
                List<GameLifeline.LifelineType> usedLifelines = activeGame.getGameLifelines().stream()
                        .map(GameLifeline::getLifelineType)
                        .toList();

                messageSender.editMessageWithKeyboard(
                        chatId,
                        messageId,
                        lifelineMessage,
                        keyboardFactory.createFiftyFiftyKeyboard(
                                result.getRemainingOptions(), question.getId(), usedLifelines));
            } else {
                // Для других подсказок показываем результат подсказки, затем вопрос с учетом 50/50
                // Получаем список использованных подсказок
                List<GameLifeline.LifelineType> usedLifelines = activeGame.getGameLifelines().stream()
                        .map(GameLifeline::getLifelineType)
                        .toList();

                // Проверяем, была ли использована подсказка 50/50
                boolean fiftyFiftyUsed = usedLifelines.contains(GameLifeline.LifelineType.FIFTY_FIFTY);

                String questionText;
                InlineKeyboardMarkup keyboard;

                if (fiftyFiftyUsed) {
                    // Если 50/50 была использована, показываем только 2 варианта
                    List<QuestionOption> remainingOptions =
                            questionService.getFiftyFiftyOptions(activeGame.getId(), question.getId());
                    questionText = buildQuestionMessageWithOptions(activeGame, question, remainingOptions);
                    keyboard =
                            keyboardFactory.createFiftyFiftyKeyboard(remainingOptions, question.getId(), usedLifelines);
                } else {
                    // Иначе показываем все варианты
                    questionText = buildQuestionMessage(activeGame, question);
                    keyboard = keyboardFactory.createQuestionKeyboard(activeGame.getId(), question, usedLifelines);
                }

                String fullMessage = lifelineMessage + "\n\n" + questionText;

                messageSender.editMessageWithKeyboard(chatId, messageId, fullMessage, keyboard);
            }

        } catch (Exception e) {
            log.error("Error handling lifeline callback: {}", e.getMessage(), e);
            messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Ошибка при использовании подсказки.");
        }
    }

    public void handleStartFirstQuestionCallback(CallbackQuery callbackQuery) {
        Long chatId = callbackQuery.getMessage().getChatId();
        Integer messageId = callbackQuery.getMessage().getMessageId();

        try {
            Optional<Game> activeGameOpt =
                    userService.findActiveGame(callbackQuery.getFrom().getId());
            if (activeGameOpt.isEmpty()) {
                messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Активная игра не найдена.");
                return;
            }

            Game activeGame = activeGameOpt.get();
            Optional<Question> questionOpt = gameService.getCurrentQuestion(activeGame);

            if (questionOpt.isEmpty()) {
                messageSender.editMessageAndRemoveKeyboard(
                        chatId, messageId, "❌ Не удалось загрузить вопрос. Попробуйте еще раз.");
                return;
            }

            Question question = questionOpt.get();
            String questionText = buildQuestionMessage(activeGame, question);

            messageSender.editMessageWithKeyboard(
                    chatId,
                    messageId,
                    questionText,
                    keyboardFactory.createQuestionKeyboard(
                            activeGame.getId(),
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
            messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Произошла ошибка при загрузке вопроса.");
        }
    }

    public void handleTakeMoneyCallback(CallbackQuery callbackQuery) {
        Long chatId = callbackQuery.getMessage().getChatId();
        Integer messageId = callbackQuery.getMessage().getMessageId();

        try {
            Optional<Game> activeGameOpt =
                    userService.findActiveGame(callbackQuery.getFrom().getId());
            if (activeGameOpt.isEmpty()) {
                messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Активная игра не найдена.");
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
            messageSender.editMessageAndRemoveKeyboard(chatId, messageId, "❌ Ошибка при завершении игры.");
        }
    }

    private String buildAnswerResultMessage(
            GameService.GameAnswerResult result,
            Question question,
            Long gameId,
            Long questionId,
            Long selectedOptionId) {
        // Получаем выбранную опцию по ID - используем перемешанный вариант
        Optional<ru.otus.hwsm.entity.ShuffledQuestionOption> shuffledSelectedOption =
                questionService.getShuffledOptionById(gameId, questionId, selectedOptionId);
        String selectedLetter = shuffledSelectedOption
                .map(ru.otus.hwsm.entity.ShuffledQuestionOption::getOptionLetter)
                .orElse("?");

        // Получаем правильный ответ из перемешанных вариантов для данной игры
        List<QuestionOption> shuffledOptions = questionService.getShuffledQuestionOptions(gameId, questionId);
        String correctLetter = shuffledOptions.stream()
                .filter(QuestionOption::getIsCorrect)
                .map(QuestionOption::getOptionLetter)
                .findFirst()
                .orElse("?");

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
        // Для подсказки 50/50 показываем полное сообщение с вопросом
        if (result.getLifelineType() == GameLifeline.LifelineType.FIFTY_FIFTY) {
            return String.format(
                    """
                💡 **Подсказка использована: %s**

                %s

                **Вопрос:** %s

                Остались только эти варианты:
                """,
                    getLifelineDisplayName(result.getLifelineType()), result.getMessage(), question.getQuestionText());
        } else {
            // Для других подсказок показываем только результат подсказки
            return String.format(
                    """
                💡 **Подсказка использована: %s**

                %s
                """,
                    getLifelineDisplayName(result.getLifelineType()), result.getMessage());
        }
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
        // Формируем варианты ответов из перемешанных опций
        List<QuestionOption> shuffledOptions =
                questionService.getShuffledQuestionOptions(game.getId(), question.getId());
        return buildQuestionMessageWithOptions(game, question, shuffledOptions);
    }

    private String buildQuestionMessageWithOptions(Game game, Question question, List<QuestionOption> options) {
        StringBuilder optionsText = new StringBuilder();
        for (QuestionOption option : options) {
            optionsText.append(String.format("**%s:** %s\n", option.getOptionLetter(), option.getOptionText()));
        }

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
                optionsText.toString());
    }
}
