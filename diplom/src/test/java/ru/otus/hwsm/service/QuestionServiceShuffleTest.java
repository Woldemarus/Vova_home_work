package ru.otus.hwsm.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hwsm.entity.Question;
import ru.otus.hwsm.entity.QuestionOption;
import ru.otus.hwsm.repository.QuestionRepository;

/**
 * Тест для проверки исправления проблемы множественного перемешивания вариантов ответов
 */
@SpringBootTest
public class QuestionServiceShuffleTest {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Тест проверяет, что для одного и того же вопроса всегда возвращается одинаковое перемешивание
     */
    @Test
    @Transactional(readOnly = true)
    public void testShuffledOptionsConsistency() {
        // Получаем любой вопрос с опциями
        List<Question> questions = questionRepository.findAll();
        assertFalse(questions.isEmpty(), "Должен быть хотя бы один вопрос в базе");

        Question testQuestion = questions.get(0);

        // Получаем перемешанные опции несколько раз (используем gameId = 1L для тестов)
        Long gameId = 1L;
        List<QuestionOption> shuffled1 = questionService.getShuffledQuestionOptions(gameId, testQuestion.getId());
        List<QuestionOption> shuffled2 = questionService.getShuffledQuestionOptions(gameId, testQuestion.getId());
        List<QuestionOption> shuffled3 = questionService.getShuffledQuestionOptions(gameId, testQuestion.getId());

        // Проверяем, что результаты одинаковые
        assertEquals(shuffled1.size(), shuffled2.size(), "Количество опций должно совпадать");
        assertEquals(shuffled2.size(), shuffled3.size(), "Количество опций должно совпадать");

        for (int i = 0; i < shuffled1.size(); i++) {
            assertEquals(
                    shuffled1.get(i).getOptionLetter(),
                    shuffled2.get(i).getOptionLetter(),
                    "Буква опции должна совпадать на позиции " + i);
            assertEquals(
                    shuffled1.get(i).getIsCorrect(),
                    shuffled2.get(i).getIsCorrect(),
                    "Правильность ответа должна совпадать на позиции " + i);
            assertEquals(
                    shuffled1.get(i).getOptionLetter(),
                    shuffled3.get(i).getOptionLetter(),
                    "Буква опции должна совпадать на позиции " + i);
        }

        // Проверяем, что есть ровно один правильный ответ
        long correctCount =
                shuffled1.stream().filter(QuestionOption::getIsCorrect).count();
        assertEquals(1, correctCount, "Должен быть ровно один правильный ответ");
    }

    /**
     * Тест проверяет консистентность в многопоточной среде
     */
    @Test
    @Transactional(readOnly = true)
    public void testShuffledOptionsThreadSafety() throws InterruptedException {
        // Получаем любой вопрос с опциями
        List<Question> questions = questionRepository.findAll();
        assertFalse(questions.isEmpty(), "Должен быть хотя бы один вопрос в базе");

        Question testQuestion = questions.get(0);
        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(threadCount);
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // Массив для хранения результатов от разных потоков
        List<QuestionOption>[] results = new List[threadCount];

        // Запускаем несколько потоков одновременно
        for (int i = 0; i < threadCount; i++) {
            final int threadIndex = i;
            executor.submit(() -> {
                try {
                    List<QuestionOption> shuffled =
                            questionService.getShuffledQuestionOptions(1L, testQuestion.getId());
                    results[threadIndex] = shuffled;
                } finally {
                    latch.countDown();
                }
            });
        }

        // Ждем завершения всех потоков
        assertTrue(latch.await(10, TimeUnit.SECONDS), "Потоки должны завершиться за 10 секунд");
        executor.shutdown();

        // Проверяем, что все потоки получили одинаковый результат
        List<QuestionOption> firstResult = results[0];
        for (int i = 1; i < threadCount; i++) {
            List<QuestionOption> currentResult = results[i];
            assertNotNull(currentResult, "Результат потока " + i + " не должен быть null");
            assertEquals(
                    firstResult.size(), currentResult.size(), "Размер результата потока " + i + " должен совпадать");

            for (int j = 0; j < firstResult.size(); j++) {
                assertEquals(
                        firstResult.get(j).getOptionLetter(),
                        currentResult.get(j).getOptionLetter(),
                        "Буква опции в потоке " + i + " на позиции " + j + " должна совпадать");
                assertEquals(
                        firstResult.get(j).getIsCorrect(),
                        currentResult.get(j).getIsCorrect(),
                        "Правильность ответа в потоке " + i + " на позиции " + j + " должна совпадать");
            }
        }
    }

    /**
     * Тест проверяет, что кэш очищается при получении нового вопроса
     */
    @Test
    @Transactional(readOnly = true)
    public void testCacheClearedOnNewQuestion() {
        // Получаем два разных вопроса
        List<Question> questions = questionRepository.findAll();
        assertTrue(questions.size() >= 2, "Должно быть минимум 2 вопроса в базе");

        Question question1 = questions.get(0);
        Question question2 = questions.get(1);

        // Получаем перемешанные опции для первого вопроса
        List<QuestionOption> shuffled1 = questionService.getShuffledQuestionOptions(1L, question1.getId());

        // Очищаем весь кэш (как это делается при получении нового вопроса)
        questionService.clearAllShuffledOptionsCache();

        // Получаем перемешанные опции для второго вопроса
        List<QuestionOption> shuffled2 = questionService.getShuffledQuestionOptions(2L, question2.getId());

        // Проверяем, что кэш действительно был очищен
        assertNotEquals(shuffled1, shuffled2, "Перемешанные опции для разных вопросов должны отличаться");
    }
}
