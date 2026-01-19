package ru.otus.hwsm.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hwsm.entity.Question;
import ru.otus.hwsm.entity.QuestionOption;
import ru.otus.hwsm.repository.QuestionRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    /**
     * Получить случайный вопрос для указанного уровня сложности
     */
    @Transactional(readOnly = true)
    public Optional<Question> getRandomQuestionByDifficulty(Integer difficultyLevel) {
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
     * Получить вопрос по ID с загруженными вариантами ответов
     */
    @Transactional(readOnly = true)
    public Optional<Question> getQuestionWithOptions(Long questionId) {
        return questionRepository.findByIdWithOptions(questionId);
    }

    /**
     * Проверить правильность ответа
     */
    @Transactional(readOnly = true)
    public boolean isAnswerCorrect(Long questionId, String optionLetter) {
        Optional<QuestionOption> option =
                questionRepository.findCorrectOptionByQuestionIdAndLetter(questionId, optionLetter);
        return option.isPresent() && option.get().getIsCorrect();
    }

    /**
     * Получить правильный ответ для вопроса
     */
    @Transactional(readOnly = true)
    public Optional<QuestionOption> getCorrectAnswer(Long questionId) {
        return questionRepository.findCorrectOptionByQuestionId(questionId);
    }

    /**
     * Получить варианты ответов для подсказки 50/50
     * Возвращает правильный ответ и один случайный неправильный
     */
    @Transactional(readOnly = true)
    public List<QuestionOption> getFiftyFiftyOptions(Long questionId) {
        List<QuestionOption> allOptions = questionRepository.findOptionsByQuestionId(questionId);

        QuestionOption correctOption = allOptions.stream()
                .filter(QuestionOption::getIsCorrect)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No correct option found for question " + questionId));

        List<QuestionOption> incorrectOptions =
                allOptions.stream().filter(option -> !option.getIsCorrect()).toList();

        if (incorrectOptions.isEmpty()) {
            throw new IllegalStateException("No incorrect options found for question " + questionId);
        }

        QuestionOption randomIncorrectOption = incorrectOptions.get(random.nextInt(incorrectOptions.size()));

        return List.of(correctOption, randomIncorrectOption);
    }

    /**
     * Получить все варианты ответов для вопроса
     */
    @Transactional(readOnly = true)
    public List<QuestionOption> getQuestionOptions(Long questionId) {
        return questionRepository.findOptionsByQuestionId(questionId);
    }
}
