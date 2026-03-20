package ru.otus.hwsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для перемешанных вариантов ответов
 * Не является JPA entity, используется только для отображения
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShuffledQuestionOption {
    private Long id;
    private String optionLetter;
    private String optionText;
    private Boolean isCorrect;
}
