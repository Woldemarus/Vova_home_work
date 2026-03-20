# Исправление сортировки вариантов ответов после подсказки 50/50

## Проблема
После использования подсказки "50 на 50" варианты ответов отображались без правильной сортировки по буквам A, B, C, D. Это происходило потому, что метод `getFiftyFiftyOptions` возвращал варианты в порядке: сначала правильный ответ, затем случайный неправильный, независимо от их букв.

## Решение
В методе `QuestionService.getFiftyFiftyOptions()` добавлена сортировка результата по `optionLetter` перед возвратом:

```java
// Конвертируем в QuestionOption для возврата и сортируем по букве ответа
List<QuestionOption> result = List.of(
        convertToQuestionOption(correctOption), 
        convertToQuestionOption(randomIncorrectOption)
);

// Сортируем по optionLetter для сохранения правильного порядка A, B, C, D
return result.stream()
        .sorted((o1, o2) -> o1.getOptionLetter().compareTo(o2.getOptionLetter()))
        .toList();
```

## Измененные файлы
- `src/main/java/ru/otus/hwsm/service/QuestionService.java` - добавлена сортировка в методе `getFiftyFiftyOptions`
- `src/test/java/ru/otus/hwsm/service/QuestionServiceShuffleTest.java` - исправлены вызовы методов для совместимости
- `src/test/java/ru/otus/hwsm/service/ShuffleDiagnosticTest.java` - исправлены вызовы методов для совместимости

## Результат
Теперь после использования подсказки "50 на 50" варианты ответов всегда отображаются в правильном алфавитном порядке (A, B, C, D), что улучшает пользовательский опыт и делает интерфейс более предсказуемым.

## Тестирование
Исправление протестировано:
1. Проект успешно собирается
2. Существующие тесты адаптированы под новую сигнатуру методов
3. Логика сортировки проверена на различных комбинациях букв

Исправление обратно совместимо и не влияет на другую функциональность приложения.