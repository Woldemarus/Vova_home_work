package ru.otus.hwsm.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.hwsm.entity.Question;
import ru.otus.hwsm.entity.QuestionOption;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    /**
     * Найти все вопросы по уровню сложности
     */
    List<Question> findByDifficultyLevel(Integer difficultyLevel);

    /**
     * Найти все вопросы по уровню сложности Lazy
     */
    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.options WHERE q.difficultyLevel = :difficultyLevel")
    List<Question> findByDifficultyLevelWithOptions(@Param("difficultyLevel") Integer difficultyLevel);

    /**
     * Найти вопрос по ID с загруженными вариантами ответов
     */
    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.options WHERE q.id = :questionId")
    Optional<Question> findByIdWithOptions(@Param("questionId") Long questionId);

    /**
     * Найти все варианты ответов для вопроса
     */
    @Query("SELECT qo FROM QuestionOption qo WHERE qo.question.id = :questionId ORDER BY qo.optionLetter")
    List<QuestionOption> findOptionsByQuestionId(@Param("questionId") Long questionId);

    /**
     * Найти правильный ответ для вопроса
     */
    @Query("SELECT qo FROM QuestionOption qo WHERE qo.question.id = :questionId AND qo.isCorrect = true")
    Optional<QuestionOption> findCorrectOptionByQuestionId(@Param("questionId") Long questionId);

    /**
     * Найти вариант ответа по ID вопроса и букве варианта
     */
    @Query("SELECT qo FROM QuestionOption qo WHERE qo.question.id = :questionId AND qo.optionLetter = :optionLetter")
    Optional<QuestionOption> findCorrectOptionByQuestionIdAndLetter(
            @Param("questionId") Long questionId, @Param("optionLetter") String optionLetter);

    /**
     * Найти вопросы по категории и уровню сложности
     */
    List<Question> findByCategoryAndDifficultyLevel(String category, Integer difficultyLevel);

    /**
     * Подсчитать количество вопросов по уровню сложности
     */
    @Query("SELECT COUNT(q) FROM Question q WHERE q.difficultyLevel = :difficultyLevel")
    Long countByDifficultyLevel(@Param("difficultyLevel") Integer difficultyLevel);

    /**
     * Найти вариант ответа по ID
     */
    @Query("SELECT qo FROM QuestionOption qo WHERE qo.id = :optionId")
    Optional<QuestionOption> findQuestionOptionById(@Param("optionId") Long optionId);

    /**
     * Найти все вопросы по уровню сложности, исключая уже отвеченные в игре
     */
    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.options " + "WHERE q.difficultyLevel = :difficultyLevel "
            + "AND q.id NOT IN (SELECT ga.question.id FROM GameAnswer ga WHERE ga.game.id = :gameId)")
    List<Question> findByDifficultyLevelWithOptionsExcludingAnswered(
            @Param("difficultyLevel") Integer difficultyLevel, @Param("gameId") Long gameId);
}
