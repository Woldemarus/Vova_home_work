package ru.otus.l12.homework;

import java.util.*;

/**
 * Жадный алгоритм выдачи денег (выдача максимальными номиналами)
 * Принцип Single Responsibility: отвечает только за алгоритм выдачи денег
 */
public class GreedyWithdrawalStrategy implements WithdrawalStrategy {

    @Override
    public Map<Integer, Integer> calculateWithdrawal(int amount, Map<Integer, Integer> cellStatus)
            throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма для выдачи должна быть положительной");
        }

        if (cellStatus == null || cellStatus.isEmpty()) {
            throw new InsufficientFundsException(amount, 0);
        }

        // Создаем копию статуса ячеек для работы
        Map<Integer, Integer> availableBanknotes = new HashMap<>(cellStatus);

        // Получаем номиналы в убывающем порядке
        List<Integer> denominations = new ArrayList<>(availableBanknotes.keySet());
        denominations.sort(Collections.reverseOrder());

        Map<Integer, Integer> result = new HashMap<>();
        int remainingAmount = amount;

        // Жадный алгоритм: берем максимально возможное количество банкнот наибольшего номинала
        for (int denomination : denominations) {
            int availableCount = availableBanknotes.get(denomination);
            if (availableCount > 0 && denomination <= remainingAmount) {
                int neededCount = remainingAmount / denomination;
                int actualCount = Math.min(neededCount, availableCount);

                if (actualCount > 0) {
                    result.put(denomination, actualCount);
                    remainingAmount -= actualCount * denomination;
                    availableBanknotes.put(denomination, availableCount - actualCount);
                }
            }
        }

        if (remainingAmount > 0) {
            int availableAmount = cellStatus.entrySet().stream()
                    .mapToInt(entry -> entry.getKey() * entry.getValue())
                    .sum();
            throw new InsufficientFundsException(amount, availableAmount);
        }

        return result;
    }
}
