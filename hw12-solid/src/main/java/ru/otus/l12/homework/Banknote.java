package ru.otus.l12.homework;

/**
 * Интерфейс банкноты
 * Принцип Single Responsibility: отвечает только за представление банкноты
 */
public interface Banknote {
    /**
     * Получить номинал банкноты
     * @return номинал банкноты
     */
    int getDenomination();
}
