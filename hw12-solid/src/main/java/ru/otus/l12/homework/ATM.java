package ru.otus.l12.homework;

import java.util.Map;

/**
 * Интерфейс банкомата
 * Принцип Single Responsibility: отвечает только за основные операции банкомата
 * Принцип Interface Segregation: содержит только необходимые методы
 */
public interface ATM {
    /**
     * Принять банкноты разных номиналов
     * @param banknotes карта номиналов и количества банкнот
     * @throws IllegalArgumentException если данные некорректны
     */
    void acceptBanknotes(Map<Integer, Integer> banknotes);

    /**
     * Выдать запрошенную сумму минимальным количеством банкнот
     * @param amount сумма для выдачи
     * @return карта номиналов и количества выданных банкнот
     * @throws InsufficientFundsException если сумму нельзя выдать
     * @throws IllegalArgumentException если сумма некорректна
     */
    Map<Integer, Integer> withdrawAmount(int amount) throws InsufficientFundsException;

    /**
     * Получить общую сумму денежных средств в банкомате
     * @return общая сумма
     */
    int getTotalAmount();

    /**
     * Получить информацию о состоянии ячеек
     * @return карта номиналов и количества банкнот в каждой ячейке
     */
    Map<Integer, Integer> getCellStatus();
}
