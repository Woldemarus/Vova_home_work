package ru.otus.hwsm.service;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hwsm.entity.*;
import ru.otus.hwsm.repository.GameAnswerRepository;
import ru.otus.hwsm.repository.GameRepository;
import ru.otus.hwsm.repository.QuestionRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final GameAnswerRepository gameAnswerRepository;
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    private List<Integer> prizeLevels;

    /**
     * Сохранить ответ игрока в базу данных
     */
    private void saveGameAnswer(GameAnswer gameAnswer) {
        log.debug(
                "[GAME_DEBUG] Saving GameAnswer: gameId={}, questionId={}, selectedOptionId={}, isCorrect={}",
                gameAnswer.getGame().getId(),
                gameAnswer.getQuestion().getId(),
                gameAnswer.getSelectedOption() != null
                        ? gameAnswer.getSelectedOption().getId()
                        : "null",
                gameAnswer.getIsCorrect());

        GameAnswer savedAnswer = gameAnswerRepository.save(gameAnswer);
        log.debug("[GAME_DEBUG] Successfully saved GameAnswer with ID: {}", savedAnswer.getId());
    }

    @PostConstruct
    private void initPrizeLevels() {
        // Используем фиксированные уровни призов из конфигурации
        prizeLevels = List.of(
                100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000);
    }

    /**
     * Получить текущий вопрос для активной игры
     */
    @Transactional
    public Optional<Question> getCurrentQuestion(Game game) {
        if (game.getStatus() != Game.GameStatus.ACTIVE) {
            log.warn("Trying to get question for non-active game: {}", game.getId());
            return Optional.empty();
        }

        // Если у игры уже есть текущий вопрос, используем его
        if (game.getCurrentQuestionId() != null) {
            log.debug(
                    "[GAME_DEBUG] Using existing current question ID {} for game {}",
                    game.getCurrentQuestionId(),
                    game.getId());
            return questionRepository.findByIdWithOptions(game.getCurrentQuestionId());
        }

        // Иначе генерируем новый вопрос
        Optional<Question> questionOpt = questionService.getRandomQuestionByDifficultyExcludingAnswered(
                game.getCurrentQuestionNumber(), game.getId());

        // Сохраняем ID вопроса в игре
        questionOpt.ifPresent(question -> {
            game.setCurrentQuestionId(question.getId());
            gameRepository.save(game);
            log.debug("[GAME_DEBUG] Set current question ID {} for game {}", question.getId(), game.getId());
        });

        return questionOpt;
    }

    /**
     * Обработать ответ игрока
     */
    @Transactional
    public GameAnswerResult processAnswer(Game game, Question question, Long selectedOptionId) {
        log.debug(
                "[GAME_DEBUG] Processing answer: gameId={}, questionId={}, selectedOptionId={}",
                game.getId(),
                question.getId(),
                selectedOptionId);

        boolean isCorrect = questionService.isAnswerCorrectByOptionId(selectedOptionId);
        log.debug("[GAME_DEBUG] Answer is correct: {}", isCorrect);

        // Создаем запись ответа
        GameAnswer gameAnswer = GameAnswer.builder()
                .game(game)
                .question(question)
                .selectedOption(getSelectedOption(selectedOptionId))
                .isCorrect(isCorrect)
                .build();

        log.debug(
                "[GAME_DEBUG] Created GameAnswer: id={}, isCorrect={}", gameAnswer.getId(), gameAnswer.getIsCorrect());

        if (isCorrect) {
            return handleCorrectAnswer(game, gameAnswer);
        } else {
            return handleIncorrectAnswer(game, gameAnswer);
        }
    }

    private GameAnswerResult handleCorrectAnswer(Game game, GameAnswer gameAnswer) {
        int currentLevel = game.getCurrentQuestionNumber();
        int newPrizeAmount = getPrizeForLevel(currentLevel);

        log.debug(
                "[GAME_DEBUG] Handling correct answer: currentLevel={}, newPrizeAmount={}",
                currentLevel,
                newPrizeAmount);

        game.setCurrentPrizeAmount(newPrizeAmount);

        // Проверяем несгораемые суммы
        if (currentLevel == 5) { // 1,000₽
            game.setGuaranteedPrizeAmount(1000);
        } else if (currentLevel == 10) { // 32,000₽
            game.setGuaranteedPrizeAmount(32000);
        }

        // Сохраняем ответ в базу данных
        saveGameAnswer(gameAnswer);
        log.debug(
                "[GAME_DEBUG] Saved GameAnswer to database: gameId={}, questionId={}, isCorrect={}",
                gameAnswer.getGame().getId(),
                gameAnswer.getQuestion().getId(),
                gameAnswer.getIsCorrect());

        // Проверяем, завершена ли игра (15 вопросов)
        if (currentLevel >= 15) {
            game.setStatus(Game.GameStatus.COMPLETED);
            game.setCompletedAt(LocalDateTime.now());
            // Очищаем ID текущего вопроса
            game.setCurrentQuestionId(null);
            log.info("Game {} completed successfully with prize: {}", game.getId(), newPrizeAmount);

            gameRepository.save(game);
            return GameAnswerResult.builder()
                    .correct(true)
                    .gameCompleted(true)
                    .finalPrize(newPrizeAmount)
                    .build();
        } else {
            // Переходим к следующему вопросу
            game.setCurrentQuestionNumber(currentLevel + 1);
            // Очищаем ID текущего вопроса для генерации нового
            game.setCurrentQuestionId(null);
            gameRepository.save(game);

            return GameAnswerResult.builder()
                    .correct(true)
                    .gameCompleted(false)
                    .currentPrize(newPrizeAmount)
                    .nextQuestionNumber(currentLevel + 1)
                    .build();
        }
    }

    private GameAnswerResult handleIncorrectAnswer(Game game, GameAnswer gameAnswer) {
        log.debug(
                "[GAME_DEBUG] Handling incorrect answer: gameId={}, questionNumber={}",
                game.getId(),
                game.getCurrentQuestionNumber());

        game.setStatus(Game.GameStatus.FAILED);
        game.setCompletedAt(LocalDateTime.now());
        // Очищаем ID текущего вопроса
        game.setCurrentQuestionId(null);

        // Игрок получает гарантированную сумму
        int finalPrize = game.getGuaranteedPrizeAmount();
        game.setCurrentPrizeAmount(finalPrize);

        // Сохраняем ответ в базу данных
        saveGameAnswer(gameAnswer);
        log.debug(
                "[GAME_DEBUG] Saved GameAnswer to database: gameId={}, questionId={}, isCorrect={}",
                gameAnswer.getGame().getId(),
                gameAnswer.getQuestion().getId(),
                gameAnswer.getIsCorrect());

        gameRepository.save(game);

        log.info(
                "Game {} failed at question {}. Final prize: {}",
                game.getId(),
                game.getCurrentQuestionNumber(),
                finalPrize);

        return GameAnswerResult.builder()
                .correct(false)
                .gameCompleted(true)
                .finalPrize(finalPrize)
                .build();
    }

    /**
     * Использовать подсказку
     */
    @Transactional
    public LifelineResult useLifeline(Game game, Question question, GameLifeline.LifelineType lifelineType) {
        // Проверяем, не использовалась ли уже эта подсказка
        boolean alreadyUsed =
                game.getGameLifelines().stream().anyMatch(lifeline -> lifeline.getLifelineType() == lifelineType);

        if (alreadyUsed) {
            return LifelineResult.builder()
                    .success(false)
                    .message("Эта подсказка уже была использована!")
                    .build();
        }

        // Создаем запись использования подсказки
        GameLifeline gameLifeline = GameLifeline.builder()
                .game(game)
                .question(question)
                .lifelineType(lifelineType)
                .build();

        game.getGameLifelines().add(gameLifeline);
        gameRepository.save(game);

        return switch (lifelineType) {
            case FIFTY_FIFTY -> processFiftyFifty(game, question);
            case PHONE_FRIEND -> processPhoneFriend(game, question);
            case AUDIENCE_POLL -> processAudiencePoll(game, question);
        };
    }

    private LifelineResult processFiftyFifty(Game game, Question question) {
        List<QuestionOption> remainingOptions = questionService.getFiftyFiftyOptions(game.getId(), question.getId());

        return LifelineResult.builder()
                .success(true)
                .lifelineType(GameLifeline.LifelineType.FIFTY_FIFTY)
                .message("Убираем два неправильных ответа...")
                .remainingOptions(remainingOptions)
                .build();
    }

    private LifelineResult processPhoneFriend(Game game, Question question) {
        Optional<QuestionOption> correctAnswer = questionService.getCorrectAnswer(question.getId());

        if (correctAnswer.isEmpty()) {
            return LifelineResult.builder()
                    .success(false)
                    .message("Ошибка при обработке подсказки")
                    .build();
        }

        // Друг дает правильный ответ с вероятностью 80%
        boolean friendIsRight = Math.random() < 0.8;
        String friendAnswer = friendIsRight
                ? correctAnswer.get().getOptionLetter()
                : getRandomWrongAnswer(game, question, correctAnswer.get().getOptionLetter());

        String confidence = friendIsRight ? "уверен" : "думаю";

        return LifelineResult.builder()
                .success(true)
                .lifelineType(GameLifeline.LifelineType.PHONE_FRIEND)
                .message(String.format("Друг говорит: 'Я %s, что правильный ответ %s'", confidence, friendAnswer))
                .suggestedAnswer(friendAnswer)
                .build();
    }

    private LifelineResult processAudiencePoll(Game game, Question question) {
        Optional<QuestionOption> correctAnswer = questionService.getCorrectAnswer(question.getId());

        if (correctAnswer.isEmpty()) {
            return LifelineResult.builder()
                    .success(false)
                    .message("Ошибка при обработке подсказки")
                    .build();
        }

        // Генерируем результаты голосования зала
        String pollResults = generateAudiencePoll(correctAnswer.get().getOptionLetter());

        return LifelineResult.builder()
                .success(true)
                .lifelineType(GameLifeline.LifelineType.AUDIENCE_POLL)
                .message("Результаты голосования зала:\n" + pollResults)
                .build();
    }

    /**
     * Забрать деньги (остановить игру)
     */
    @Transactional
    public int takeTheMoney(Game game) {
        game.setStatus(Game.GameStatus.COMPLETED);
        game.setCompletedAt(LocalDateTime.now());
        // Очищаем ID текущего вопроса
        game.setCurrentQuestionId(null);

        int finalPrize = game.getCurrentPrizeAmount();
        gameRepository.save(game);

        log.info("Player took the money in game {}. Final prize: {}", game.getId(), finalPrize);
        return finalPrize;
    }

    private QuestionOption getSelectedOption(Long optionId) {
        return questionService.getOptionById(optionId).orElse(null);
    }

    private int getPrizeForLevel(int level) {
        if (level < 1 || level > prizeLevels.size()) {
            return 0;
        }
        return prizeLevels.get(level - 1);
    }

    private String getRandomWrongAnswer(Game game, Question question, String correctLetter) {
        List<QuestionOption> shuffledOptions =
                questionService.getShuffledQuestionOptions(game.getId(), question.getId());
        List<String> wrongLetters = shuffledOptions.stream()
                .filter(option -> !option.getOptionLetter().equals(correctLetter))
                .map(QuestionOption::getOptionLetter)
                .toList();

        if (wrongLetters.isEmpty()) {
            return "A"; // fallback
        }

        return wrongLetters.get((int) (Math.random() * wrongLetters.size()));
    }

    private String generateAudiencePoll(String correctLetter) {
        // Правильный ответ получает 40-70% голосов
        int correctPercentage = 40 + (int) (Math.random() * 31);
        int remaining = 100 - correctPercentage;

        // Распределяем оставшиеся проценты между тремя неправильными ответами
        int wrong1 = (int) (Math.random() * remaining);
        int wrong2 = (int) (Math.random() * (remaining - wrong1));
        int wrong3 = remaining - wrong1 - wrong2;

        String[] letters = {"A", "B", "C", "D"};
        int[] percentages = new int[4];

        // Находим индекс правильного ответа
        int correctIndex = -1;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals(correctLetter)) {
                correctIndex = i;
                break;
            }
        }

        percentages[correctIndex] = correctPercentage;

        // Распределяем неправильные проценты
        int wrongIndex = 0;
        int[] wrongPercentages = {wrong1, wrong2, wrong3};
        for (int i = 0; i < 4; i++) {
            if (i != correctIndex) {
                percentages[i] = wrongPercentages[wrongIndex++];
            }
        }

        return String.format(
                "A: %d%%\nB: %d%%\nC: %d%%\nD: %d%%", percentages[0], percentages[1], percentages[2], percentages[3]);
    }

    // Вспомогательные классы для результатов
    public static class GameAnswerResult {
        private final boolean correct;
        private final boolean gameCompleted;
        private final Integer currentPrize;
        private final Integer finalPrize;
        private final Integer nextQuestionNumber;

        private GameAnswerResult(Builder builder) {
            this.correct = builder.correct;
            this.gameCompleted = builder.gameCompleted;
            this.currentPrize = builder.currentPrize;
            this.finalPrize = builder.finalPrize;
            this.nextQuestionNumber = builder.nextQuestionNumber;
        }

        public static Builder builder() {
            return new Builder();
        }

        // Getters
        public boolean isCorrect() {
            return correct;
        }

        public boolean isGameCompleted() {
            return gameCompleted;
        }

        public Integer getCurrentPrize() {
            return currentPrize;
        }

        public Integer getFinalPrize() {
            return finalPrize;
        }

        public Integer getNextQuestionNumber() {
            return nextQuestionNumber;
        }

        public static class Builder {
            private boolean correct;
            private boolean gameCompleted;
            private Integer currentPrize;
            private Integer finalPrize;
            private Integer nextQuestionNumber;

            public Builder correct(boolean correct) {
                this.correct = correct;
                return this;
            }

            public Builder gameCompleted(boolean gameCompleted) {
                this.gameCompleted = gameCompleted;
                return this;
            }

            public Builder currentPrize(Integer currentPrize) {
                this.currentPrize = currentPrize;
                return this;
            }

            public Builder finalPrize(Integer finalPrize) {
                this.finalPrize = finalPrize;
                return this;
            }

            public Builder nextQuestionNumber(Integer nextQuestionNumber) {
                this.nextQuestionNumber = nextQuestionNumber;
                return this;
            }

            public GameAnswerResult build() {
                return new GameAnswerResult(this);
            }
        }
    }

    public static class LifelineResult {
        private final boolean success;
        private final GameLifeline.LifelineType lifelineType;
        private final String message;
        private final List<QuestionOption> remainingOptions;
        private final String suggestedAnswer;

        private LifelineResult(Builder builder) {
            this.success = builder.success;
            this.lifelineType = builder.lifelineType;
            this.message = builder.message;
            this.remainingOptions = builder.remainingOptions;
            this.suggestedAnswer = builder.suggestedAnswer;
        }

        public static Builder builder() {
            return new Builder();
        }

        // Getters
        public boolean isSuccess() {
            return success;
        }

        public GameLifeline.LifelineType getLifelineType() {
            return lifelineType;
        }

        public String getMessage() {
            return message;
        }

        public List<QuestionOption> getRemainingOptions() {
            return remainingOptions;
        }

        public String getSuggestedAnswer() {
            return suggestedAnswer;
        }

        public static class Builder {
            private boolean success;
            private GameLifeline.LifelineType lifelineType;
            private String message;
            private List<QuestionOption> remainingOptions;
            private String suggestedAnswer;

            public Builder success(boolean success) {
                this.success = success;
                return this;
            }

            public Builder lifelineType(GameLifeline.LifelineType lifelineType) {
                this.lifelineType = lifelineType;
                return this;
            }

            public Builder message(String message) {
                this.message = message;
                return this;
            }

            public Builder remainingOptions(List<QuestionOption> remainingOptions) {
                this.remainingOptions = remainingOptions;
                return this;
            }

            public Builder suggestedAnswer(String suggestedAnswer) {
                this.suggestedAnswer = suggestedAnswer;
                return this;
            }

            public LifelineResult build() {
                return new LifelineResult(this);
            }
        }
    }
}
