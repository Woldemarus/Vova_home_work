package ru.otus.hwsm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hwsm.entity.Question;
import ru.otus.hwsm.entity.QuestionOption;
import ru.otus.hwsm.entity.ShuffledQuestionOption;
import ru.otus.hwsm.repository.QuestionRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    // Кэш для хранения перемешанных опций вопросов (gameId_questionId -> перемешанные опции)
    // Используем ConcurrentHashMap для безопасности в многопоточной среде
    private final Map<String, List<ShuffledQuestionOption>> shuffledOptionsCache = new ConcurrentHashMap<>();

    /**
     * Создать ключ для кеша на основе gameId и questionId
     */
    private String createCacheKey(Long gameId, Long questionId) {
        return gameId + "_" + questionId;
    }

    /**
     * Получить случайный вопрос для указанного уровня сложности
     * Очищает кэш перемешанных опций перед получением нового вопроса
     */
    @Transactional(readOnly = true)
    public Optional<Question> getRandomQuestionByDifficulty(Integer difficultyLevel) {
        // Очищаем кэш перемешанных опций для предотвращения путаницы с предыдущими вопросами
        clearAllShuffledOptionsCache();

        List<Question> questions = questionRepository.findByDifficultyLevelWithOptions(difficultyLevel);

        if (questions.isEmpty()) {
            log.warn("No questions found for difficulty level: {}", difficultyLevel);
            return Optional.empty();
        }

        Question randomQuestion = questions.get(random.nextInt(questions.size()));
        log.debug("Selected random question ID {} for difficulty level {}", randomQuestion.getId(), difficultyLevel);

        return Optional.of(randomQuestion);
    }

    /**
     * Получить случайный вопрос для указанного уровня сложности, исключая уже отвеченные в игре
     */
    @Transactional(readOnly = true)
    public Optional<Question> getRandomQuestionByDifficultyExcludingAnswered(Integer difficultyLevel, Long gameId) {
        log.debug(
                "[QUESTION_DEBUG] Getting random question for difficulty {} excluding answered in game {}",
                difficultyLevel,
                gameId);

        // Очищаем кэш перемешанных опций для предотвращения путаницы с предыдущими вопросами
        clearAllShuffledOptionsCache();

        List<Question> questions =
                questionRepository.findByDifficultyLevelWithOptionsExcludingAnswered(difficultyLevel, gameId);
        log.debug(
                "[QUESTION_DEBUG] Found {} available questions for difficulty {} (excluding answered)",
                questions.size(),
                difficultyLevel);

        if (questions.isEmpty()) {
            log.warn("No unanswered questions found for difficulty level: {} in game: {}", difficultyLevel, gameId);
            // Fallback: если нет неотвеченных вопросов, берем любой вопрос этого уровня
            questions = questionRepository.findByDifficultyLevelWithOptions(difficultyLevel);
            log.debug(
                    "[QUESTION_DEBUG] Fallback: found {} total questions for difficulty {}",
                    questions.size(),
                    difficultyLevel);

            if (questions.isEmpty()) {
                return Optional.empty();
            }
        }

        Question randomQuestion = questions.get(random.nextInt(questions.size()));
        log.debug(
                "[QUESTION_DEBUG] Selected random question ID {} for difficulty level {}",
                randomQuestion.getId(),
                difficultyLevel);

        return Optional.of(randomQuestion);
    }

    /**
     * Получить вопрос по ID с загруженными вариантами ответов
     */
    @Transactional(readOnly = true)
    public Optional<Question> getQuestionWithOptions(Long questionId) {
        return questionRepository.findByIdWithOptions(questionId);
    }

    /**
     * Проверить правильность ответа по ID опции
     */
    @Transactional(readOnly = true)
    public boolean isAnswerCorrectByOptionId(Long optionId) {
        return questionRepository
                .findQuestionOptionById(optionId)
                .map(QuestionOption::getIsCorrect)
                .orElse(false);
    }

    /**
     * Получить опцию по ID
     */
    @Transactional(readOnly = true)
    public Optional<QuestionOption> getOptionById(Long optionId) {
        return questionRepository.findQuestionOptionById(optionId);
    }

    /**
     * Получить перемешанную опцию по ID опции
     */
    @Transactional(readOnly = true)
    public Optional<ShuffledQuestionOption> getShuffledOptionById(Long gameId, Long questionId, Long optionId) {
        // Обеспечиваем наличие в кэше
        getShuffledQuestionOptions(gameId, questionId);

        String cacheKey = createCacheKey(gameId, questionId);
        List<ShuffledQuestionOption> cachedOptions = shuffledOptionsCache.get(cacheKey);
        if (cachedOptions == null) {
            return Optional.empty();
        }

        return cachedOptions.stream()
                .filter(option -> option.getId().equals(optionId))
                .findFirst();
    }

    /**
     * Получить правильный ответ для вопроса
     */
    @Transactional(readOnly = true)
    public Optional<QuestionOption> getCorrectAnswer(Long questionId) {
        return questionRepository.findCorrectOptionByQuestionId(questionId);
    }

    /**
     * Получить варианты ответов для подсказки 50/50 с учетом перемешанных позиций
     * Возвращает правильный ответ и один случайный неправильный
     */
    @Transactional(readOnly = true)
    public List<QuestionOption> getFiftyFiftyOptions(Long gameId, Long questionId) {
        // Обеспечиваем наличие в кэше
        getShuffledQuestionOptions(gameId, questionId);

        String cacheKey = createCacheKey(gameId, questionId);
        List<ShuffledQuestionOption> cachedOptions = shuffledOptionsCache.get(cacheKey);

        ShuffledQuestionOption correctOption = cachedOptions.stream()
                .filter(ShuffledQuestionOption::getIsCorrect)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No correct option found for question " + questionId));

        List<ShuffledQuestionOption> incorrectOptions =
                cachedOptions.stream().filter(option -> !option.getIsCorrect()).toList();

        if (incorrectOptions.isEmpty()) {
            throw new IllegalStateException("No incorrect options found for question " + questionId);
        }

        ShuffledQuestionOption randomIncorrectOption = incorrectOptions.get(random.nextInt(incorrectOptions.size()));

        log.debug(
                "Fifty-fifty options for question {}: {} and {}",
                questionId,
                correctOption.getOptionLetter(),
                randomIncorrectOption.getOptionLetter());

        // Конвертируем в QuestionOption для возврата и сортируем по букве ответа
        List<QuestionOption> result =
                List.of(convertToQuestionOption(correctOption), convertToQuestionOption(randomIncorrectOption));

        // Сортируем по optionLetter для сохранения правильного порядка A, B, C, D
        return result.stream()
                .sorted((o1, o2) -> o1.getOptionLetter().compareTo(o2.getOptionLetter()))
                .toList();
    }

    /**
     * Конвертировать ShuffledQuestionOption в QuestionOption
     */
    private QuestionOption convertToQuestionOption(ShuffledQuestionOption option) {
        return QuestionOption.builder()
                .id(option.getId())
                .optionText(option.getOptionText())
                .isCorrect(option.getIsCorrect())
                .optionLetter(option.getOptionLetter())
                .build();
    }

    /**
     * Получить все варианты ответов для вопроса в исходном порядке
     */
    @Transactional(readOnly = true)
    public List<QuestionOption> getQuestionOptions(Long questionId) {
        return questionRepository.findOptionsByQuestionId(questionId);
    }

    /**
     * Очистить кэш перемешанных опций для указанного вопроса
     */
    public void clearShuffledOptionsCache(Long questionId) {
        shuffledOptionsCache.remove(questionId);
        log.debug("Cleared shuffled options cache for question {}", questionId);
    }

    /**
     * Очистить весь кэш перемешанных опций
     */
    public void clearAllShuffledOptionsCache() {
        int cacheSize = shuffledOptionsCache.size();
        shuffledOptionsCache.clear();
        log.debug("[SHUFFLE_DEBUG] Cleared all shuffled options cache. Previous size: {}", cacheSize);
    }

    /**
     * Получить перемешанные варианты ответов для вопроса
     * Правильный ответ будет в случайной позиции A, B, C или D
     * Перемешивание происходит только один раз и кэшируется
     * Метод синхронизирован для безопасности в многопоточной среде
     */
    @Transactional(readOnly = true)
    public synchronized List<QuestionOption> getShuffledQuestionOptions(Long gameId, Long questionId) {
        log.debug("[SHUFFLE_DEBUG] Requesting shuffled options for question ID: {} in game: {}", questionId, gameId);

        String cacheKey = createCacheKey(gameId, questionId);
        // Проверяем кэш
        if (shuffledOptionsCache.containsKey(cacheKey)) {
            List<ShuffledQuestionOption> cachedOptions = shuffledOptionsCache.get(cacheKey);
            log.debug(
                    "[SHUFFLE_DEBUG] Using cached shuffled options for question {}. Cache size: {}",
                    questionId,
                    cachedOptions.size());
            log.debug(
                    "[SHUFFLE_DEBUG] Cached options: {}",
                    cachedOptions.stream()
                            .map(opt -> opt.getOptionLetter() + "="
                                    + opt.getOptionText()
                                            .substring(
                                                    0,
                                                    Math.min(
                                                            20,
                                                            opt.getOptionText().length())))
                            .toList());
            // Конвертируем из кэша обратно в QuestionOption
            return convertShuffledOptionsFromCache(cachedOptions);
        }

        List<QuestionOption> originalOptions = questionRepository.findOptionsByQuestionId(questionId);
        log.debug(
                "[SHUFFLE_DEBUG] Original options for question {}: {}",
                questionId,
                originalOptions.stream()
                        .map(opt -> opt.getOptionLetter() + "="
                                + opt.getOptionText()
                                        .substring(
                                                0,
                                                Math.min(20, opt.getOptionText().length())))
                        .toList());

        if (originalOptions.isEmpty()) {
            log.warn("[SHUFFLE_DEBUG] No options found for question ID: {}", questionId);
            return originalOptions;
        }

        log.debug(
                "Original options for question {}: {}",
                questionId,
                originalOptions.stream()
                        .map(o -> o.getOptionLetter() + ":" + o.getIsCorrect())
                        .toList());

        // Создаем список перемешанных опций для кэширования
        List<ShuffledQuestionOption> shuffledOptionsForCache = new ArrayList<>();

        // Создаем список новых объектов для перемешивания (НЕ мутируем объекты из БД/Hibernate кэша)
        List<QuestionOption> shuffledOptions = new ArrayList<>();
        for (QuestionOption originalOption : originalOptions) {
            shuffledOptions.add(QuestionOption.builder()
                    .id(originalOption.getId())
                    .optionText(originalOption.getOptionText())
                    .isCorrect(originalOption.getIsCorrect())
                    .optionLetter(originalOption.getOptionLetter())
                    .build());
        }

        // Перемешиваем варианты с явным использованием Random
        Collections.shuffle(shuffledOptions, random);
        log.debug(
                "[SHUFFLE_DEBUG] After Collections.shuffle: {}",
                shuffledOptions.stream()
                        .map(opt -> opt.getOptionLetter() + "="
                                + opt.getOptionText()
                                        .substring(
                                                0,
                                                Math.min(10, opt.getOptionText().length())))
                        .toList());

        // Переназначаем буквы в случайном порядке
        String[] letters = {"A", "B", "C", "D"};
        for (int i = 0; i < shuffledOptions.size(); i++) {
            QuestionOption shuffledOption = shuffledOptions.get(i);
            log.debug(
                    "[SHUFFLE_DEBUG] Assigning letter {} to option: {} (correct: {})",
                    letters[i],
                    shuffledOption
                            .getOptionText()
                            .substring(
                                    0,
                                    Math.min(10, shuffledOption.getOptionText().length())),
                    shuffledOption.getIsCorrect());

            // Создаем НОВЫЙ объект для кэша
            ShuffledQuestionOption cachedOption = ShuffledQuestionOption.builder()
                    .id(shuffledOption.getId())
                    .optionText(shuffledOption.getOptionText())
                    .isCorrect(shuffledOption.getIsCorrect())
                    .optionLetter(letters[i])
                    .build();
            shuffledOptionsForCache.add(cachedOption);

            // Обновляем букву в объекте списка для возврата (это НОВЫЙ объект, не из БД)
            shuffledOption.setOptionLetter(letters[i]);
        }

        // Кэшируем результат
        shuffledOptionsCache.put(cacheKey, shuffledOptionsForCache);
        log.debug(
                "[SHUFFLE_DEBUG] Cached {} shuffled options for question {} in game {}",
                shuffledOptionsForCache.size(),
                questionId,
                gameId);

        log.debug(
                "[SHUFFLE_DEBUG] Final shuffled options for question {}: {}",
                questionId,
                shuffledOptions.stream()
                        .map(o -> o.getOptionLetter() + ":" + o.getIsCorrect())
                        .toList());
        log.debug(
                "[SHUFFLE_DEBUG] Final shuffled options text for question {}: {}",
                questionId,
                shuffledOptions.stream()
                        .map(opt -> opt.getOptionLetter() + "="
                                + opt.getOptionText()
                                        .substring(
                                                0,
                                                Math.min(15, opt.getOptionText().length())))
                        .toList());

        return shuffledOptions;
    }

    /**
     * Конвертировать перемешанные опции из кэша в QuestionOption
     */
    private List<QuestionOption> convertShuffledOptionsFromCache(List<ShuffledQuestionOption> shuffledOptions) {
        return shuffledOptions.stream()
                .map(option -> QuestionOption.builder()
                        .id(option.getId())
                        .optionText(option.getOptionText())
                        .isCorrect(option.getIsCorrect())
                        .optionLetter(option.getOptionLetter())
                        .build())
                .toList();
    }
}
