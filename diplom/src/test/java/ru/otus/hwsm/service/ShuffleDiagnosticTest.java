package ru.otus.hwsm.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hwsm.entity.Question;
import ru.otus.hwsm.entity.QuestionOption;
import ru.otus.hwsm.repository.QuestionRepository;

/**
 * Диагностический тест для выявления проблемы с перемешиванием
 */
@SpringBootTest
public class ShuffleDiagnosticTest {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Тест для диагностики: выводит все шаги перемешивания
     */
    @Test
    @Transactional(readOnly = true)
    public void diagnoseShuffleProcess() {
        List<Question> questions = questionRepository.findAll();
        assertFalse(questions.isEmpty(), "Должен быть хотя бы один вопрос");

        Question testQuestion = questions.get(0);
        System.out.println("\n=== DIAGNOSTIC TEST ===");
        System.out.println("Question ID: " + testQuestion.getId());
        System.out.println("Question text: " + testQuestion.getQuestionText());

        // Получаем опции из репозитория напрямую (как в QuestionService)
        List<QuestionOption> originalOptions = questionRepository.findOptionsByQuestionId(testQuestion.getId());

        System.out.println("\n1. Original options from DB (before any processing):");
        for (QuestionOption opt : originalOptions) {
            System.out.println("   " + opt.getOptionLetter() + ": isCorrect=" + opt.getIsCorrect() + ", text="
                    + opt.getOptionText()
                            .substring(0, Math.min(30, opt.getOptionText().length())));
        }

        // Симулируем процесс перемешивания как в QuestionService
        System.out.println("\n2. Creating copy for shuffle...");
        List<QuestionOption> shuffledOptions = new ArrayList<>(originalOptions);

        System.out.println("   Before shuffle - order:");
        for (QuestionOption opt : shuffledOptions) {
            System.out.println("   " + opt.getOptionLetter() + ": isCorrect=" + opt.getIsCorrect());
        }

        System.out.println("\n3. Calling Collections.shuffle()...");
        Collections.shuffle(shuffledOptions);

        System.out.println("   After shuffle - order:");
        for (QuestionOption opt : shuffledOptions) {
            System.out.println("   " + opt.getOptionLetter() + ": isCorrect=" + opt.getIsCorrect());
        }

        // Теперь переназначаем буквы как в QuestionService
        String[] letters = {"A", "B", "C", "D"};
        System.out.println("\n4. Reassigning letters...");
        for (int i = 0; i < shuffledOptions.size(); i++) {
            QuestionOption opt = shuffledOptions.get(i);
            System.out.println("   Position " + i + ": " + opt.getOptionLetter() + " -> " + letters[i] + " (isCorrect="
                    + opt.getIsCorrect() + ")");
            opt.setOptionLetter(letters[i]);
        }

        System.out.println("\n5. Final options with new letters:");
        for (QuestionOption opt : shuffledOptions) {
            System.out.println("   " + opt.getOptionLetter() + ": isCorrect=" + opt.getIsCorrect());
        }

        // Проверяем: изменился ли isCorrect относительно букв A,B,C,D?
        long trueAtA = shuffledOptions.stream()
                .filter(o -> "A".equals(o.getOptionLetter()) && o.getIsCorrect())
                .count();

        System.out.println("\n6. RESULT:");
        System.out.println("   Correct answer at letter A: " + (trueAtA == 1 ? "YES (BUG!)" : "NO (correct behavior)"));

        // Проверяем, что shuffle действительно работает - запускаем много раз
        System.out.println("\n7. Testing shuffle randomness (10 iterations):");
        for (int iter = 0; iter < 10; iter++) {
            List<QuestionOption> testList = new ArrayList<>(originalOptions);
            Collections.shuffle(testList);
            StringBuilder sb = new StringBuilder();
            for (QuestionOption opt : testList) {
                sb.append(opt.getOptionLetter())
                        .append(":")
                        .append(opt.getIsCorrect())
                        .append(" ");
            }
            System.out.println("   Iteration " + iter + ": " + sb);
        }

        // Этот assert всегда проходит - тест диагностический
        assertTrue(true, "Diagnostic test completed - check output above");
    }

    /**
     * Проверка что Hibernate кэш не мутируется после нескольких вызовов
     */
    @Test
    @Transactional(readOnly = true)
    public void testHibernateCacheNotMutated() {
        List<Question> questions = questionRepository.findAll();
        Question testQuestion = questions.get(0);
        Long questionId = testQuestion.getId();

        System.out.println("\n=== HIBERNATE CACHE TEST ===");

        // Вызов 1
        List<QuestionOption> result1 = questionService.getShuffledQuestionOptions(1L, questionId);
        System.out.println("Call 1 result: " + formatOptions(result1));

        // Вызов 2 (должен использовать кэш)
        List<QuestionOption> result2 = questionService.getShuffledQuestionOptions(1L, questionId);
        System.out.println("Call 2 result: " + formatOptions(result2));

        // Получаем исходные данные из БД снова
        List<QuestionOption> originalAfter = questionRepository.findOptionsByQuestionId(questionId);
        System.out.println("DB original after calls: " + formatOptions(originalAfter));

        // Проверяем что исходные данные не изменились
        String originalFirst = originalAfter.get(0).getOptionLetter() + ":"
                + originalAfter.get(0).getIsCorrect();
        assertEquals("A:true", originalFirst, "Original data in DB should NOT be mutated!");

        System.out.println("\n✓ Hibernate cache is NOT mutated - original data preserved!");
    }

    /**
     * Тест через QuestionService.getShuffledQuestionOptions() - проверяем несколько раз
     */
    @Test
    @Transactional(readOnly = true)
    public void testViaQuestionServiceMultipleCalls() {
        List<Question> questions = questionRepository.findAll();
        assertFalse(questions.isEmpty(), "Должен быть хотя бы один вопрос");

        Question testQuestion = questions.getFirst();
        Long questionId = testQuestion.getId();

        System.out.println("\n=== TEST MULTIPLE CALLS ===");
        System.out.println("Question ID: " + questionId);

        // Очищаем кэш вручную перед тестом
        questionService.clearAllShuffledOptionsCache();

        // Первый вызов
        System.out.println("\nCall 1 (after cache clear):");
        List<QuestionOption> result1 = questionService.getShuffledQuestionOptions(1L, questionId);
        System.out.println("Result: " + formatOptions(result1));

        // Второй вызов (должен использовать кэш)
        System.out.println("\nCall 2 (should use cache):");
        List<QuestionOption> result2 = questionService.getShuffledQuestionOptions(1L, questionId);
        System.out.println("Result: " + formatOptions(result2));

        // Сравниваем
        boolean same = compareResults(result1, result2);
        System.out.println("\nResults are identical: " + same);

        // Очищаем и вызываем снова
        questionService.clearAllShuffledOptionsCache();
        System.out.println("\nCall 3 (after cache clear again):");
        List<QuestionOption> result3 = questionService.getShuffledQuestionOptions(1L, questionId);
        System.out.println("Result: " + formatOptions(result3));

        boolean sameAsFirst = compareResults(result1, result3);
        System.out.println("Call 3 same as Call 1: " + sameAsFirst);

        // Проверяем консистентность
        assertEquals(1, result1.stream().filter(QuestionOption::getIsCorrect).count());
        assertEquals(1, result2.stream().filter(QuestionOption::getIsCorrect).count());
        assertEquals(1, result3.stream().filter(QuestionOption::getIsCorrect).count());

        // Проверяем что буквы всегда A,B,C,D
        Set<String> letters1 =
                result1.stream().map(QuestionOption::getOptionLetter).collect(Collectors.toSet());
        Set<String> letters2 =
                result2.stream().map(QuestionOption::getOptionLetter).collect(Collectors.toSet());
        assertEquals(Set.of("A", "B", "C", "D"), letters1, "Letters should be A,B,C,D");
        assertEquals(Set.of("A", "B", "C", "D"), letters2, "Letters should be A,B,C,D");

        System.out.println("\nDiagnostic: Checking if correct answer moves between calls...");
        String correctLetter1 = result1.stream()
                .filter(QuestionOption::getIsCorrect)
                .map(QuestionOption::getOptionLetter)
                .findFirst()
                .orElse("?");
        String correctLetter2 = result2.stream()
                .filter(QuestionOption::getIsCorrect)
                .map(QuestionOption::getOptionLetter)
                .findFirst()
                .orElse("?");
        String correctLetter3 = result3.stream()
                .filter(QuestionOption::getIsCorrect)
                .map(QuestionOption::getOptionLetter)
                .findFirst()
                .orElse("?");

        System.out.println("Correct answer position: Call1=" + correctLetter1 + ", Call2=" + correctLetter2 + ", Call3="
                + correctLetter3);
        System.out.println("Correct answer changed between calls: " + (!correctLetter1.equals(correctLetter3)));
    }

    private String formatOptions(List<QuestionOption> options) {
        return options.stream()
                .map(o -> o.getOptionLetter() + ":" + o.getIsCorrect())
                .toList()
                .toString();
    }

    private boolean compareResults(List<QuestionOption> a, List<QuestionOption> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).getOptionLetter().equals(b.get(i).getOptionLetter())) return false;
            if (!a.get(i).getIsCorrect().equals(b.get(i).getIsCorrect())) return false;
        }
        return true;
    }

    /**
     * Тест через QuestionService.getShuffledQuestionOptions()
     */
    @Test
    @Transactional(readOnly = true)
    public void testViaQuestionService() {
        List<Question> questions = questionRepository.findAll();
        assertFalse(questions.isEmpty(), "Должен быть хотя бы один вопрос");

        Question testQuestion = questions.get(0);
        System.out.println("\n=== TEST VIA QUESTIONSERVICE ===");
        System.out.println("Question ID: " + testQuestion.getId());

        List<QuestionOption> result = questionService.getShuffledQuestionOptions(1L, testQuestion.getId());

        System.out.println("\nResult from getShuffledQuestionOptions():");
        for (QuestionOption opt : result) {
            System.out.println("   " + opt.getOptionLetter() + ": isCorrect=" + opt.getIsCorrect());
        }

        // Проверяем
        long correctCount = result.stream().filter(QuestionOption::getIsCorrect).count();
        assertEquals(1, correctCount, "Должен быть ровно один правильный ответ");

        System.out.println("\nWhere is the correct answer?");
        for (QuestionOption opt : result) {
            if (opt.getIsCorrect()) {
                System.out.println("   Correct answer is at letter: " + opt.getOptionLetter());
            }
        }
    }
}
