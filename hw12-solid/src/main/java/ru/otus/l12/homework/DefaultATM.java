package ru.otus.l12.homework;

import java.util.*;

/**
 * Реализация банкомата
 * Принцип Single Responsibility: отвечает только за основные операции банкомата
 * Принцип Open/Closed: можно расширить новыми стратегиями выдачи без изменения кода
 * Принцип Liskov Substitution: может быть заменен любой реализацией интерфейса ATM
 * Принцип Interface Segregation: реализует только необходимые методы
 * Принцип Dependency Inversion: зависит от абстракций (WithdrawalStrategy, BanknoteCell)
 */
public class DefaultATM implements ATM {
    private final Map<Integer, BanknoteCell> cells;
    private final WithdrawalStrategy withdrawalStrategy;

    public DefaultATM() {
        this(new GreedyWithdrawalStrategy());
    }

    public DefaultATM(WithdrawalStrategy withdrawalStrategy) {
        if (withdrawalStrategy == null) {
            throw new IllegalArgumentException("Стратегия выдачи не может быть null");
        }
        this.cells = new HashMap<>();
        this.withdrawalStrategy = withdrawalStrategy;
    }

    @Override
    public void acceptBanknotes(Map<Integer, Integer> banknotes) {
        if (banknotes == null) {
            throw new IllegalArgumentException("Карта банкнот не может быть null");
        }

        for (Map.Entry<Integer, Integer> entry : banknotes.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();

            if (denomination <= 0) {
                throw new IllegalArgumentException("Номинал банкноты должен быть положительным: " + denomination);
            }
            if (count < 0) {
                throw new IllegalArgumentException("Количество банкнот не может быть отрицательным: " + count);
            }

            // Создаем ячейку для номинала, если её еще нет
            cells.computeIfAbsent(denomination, DefaultBanknoteCell::new).addBanknotes(count);
        }
    }

    @Override
    public Map<Integer, Integer> withdrawAmount(int amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма для выдачи должна быть положительной");
        }

        Map<Integer, Integer> cellStatus = getCellStatus();
        Map<Integer, Integer> withdrawalPlan = withdrawalStrategy.calculateWithdrawal(amount, cellStatus);

        // Выполняем выдачу согласно плану
        Map<Integer, Integer> actualWithdrawal = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : withdrawalPlan.entrySet()) {
            int denomination = entry.getKey();
            int requestedCount = entry.getValue();

            BanknoteCell cell = cells.get(denomination);
            if (cell != null) {
                int actualCount = cell.withdrawBanknotes(requestedCount);
                if (actualCount > 0) {
                    actualWithdrawal.put(denomination, actualCount);
                }
            }
        }

        return actualWithdrawal;
    }

    @Override
    public int getTotalAmount() {
        return cells.values().stream().mapToInt(BanknoteCell::getTotalAmount).sum();
    }

    @Override
    public Map<Integer, Integer> getCellStatus() {
        Map<Integer, Integer> status = new HashMap<>();
        for (Map.Entry<Integer, BanknoteCell> entry : cells.entrySet()) {
            status.put(entry.getKey(), entry.getValue().getCount());
        }
        return status;
    }

    /**
     * Получить детальную информацию о состоянии ячеек
     * @return карта номиналов и детальной информации о ячейках
     */
    public Map<Integer, BanknoteCell> getDetailedCellStatus() {
        return new HashMap<>(cells);
    }

    /**
     * Проверить, можно ли выдать указанную сумму
     * @param amount сумма для проверки
     * @return true, если сумму можно выдать
     */
    public boolean canWithdraw(int amount) {
        try {
            Map<Integer, Integer> cellStatus = getCellStatus();
            withdrawalStrategy.calculateWithdrawal(amount, cellStatus);
            return true;
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            return false;
        }
    }
}
