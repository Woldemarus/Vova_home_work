package ru.otus.l12.homework;

import java.util.Map;

/**
 * Интерфейс стратегии выдачи денег
 * Принцип Open/Closed: позволяет добавлять новые алгоритмы выдачи без изменения существующего кода
 * Принцип Dependency Inversion: ATM зависит от абстракции, а не от конкретной реализации
 */
public interface WithdrawalStrategy {
    /**
     * Рассчитать, как выдать указанную сумму минимальным количеством банкнот
     * @param amount сумма для выдачи
     * @param cellStatus карта номиналов и количества доступных банкнот
     * @return карта номиналов и количества банкнот для выдачи
     * @throws InsufficientFundsException если сумму нельзя выдать
     */
    Map<Integer, Integer> calculateWithdrawal(int amount, Map<Integer, Integer> cellStatus)
            throws InsufficientFundsException;
}
