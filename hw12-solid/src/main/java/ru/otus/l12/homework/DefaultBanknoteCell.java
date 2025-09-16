package ru.otus.l12.homework;

/**
 * Реализация ячейки для хранения банкнот определенного номинала
 * Принцип Single Responsibility: отвечает только за хранение банкнот одного номинала
 * Принцип Open/Closed: можно расширить новыми типами ячеек без изменения существующего кода
 */
public class DefaultBanknoteCell implements BanknoteCell {
    private final int denomination;
    private int count;

    public DefaultBanknoteCell(int denomination) {
        if (denomination <= 0) {
            throw new IllegalArgumentException("Номинал банкноты должен быть положительным");
        }
        this.denomination = denomination;
        this.count = 0;
    }

    public DefaultBanknoteCell(int denomination, int initialCount) {
        this(denomination);
        if (initialCount < 0) {
            throw new IllegalArgumentException("Начальное количество банкнот не может быть отрицательным");
        }
        this.count = initialCount;
    }

    @Override
    public int getDenomination() {
        return denomination;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void addBanknotes(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество банкнот для добавления не может быть отрицательным");
        }
        this.count += count;
    }

    @Override
    public int withdrawBanknotes(int requestedCount) {
        if (requestedCount < 0) {
            throw new IllegalArgumentException("Количество банкнот для извлечения не может быть отрицательным");
        }

        int actualCount = Math.min(requestedCount, this.count);

        this.count -= actualCount;
        return actualCount;
    }

    @Override
    public boolean canWithdraw(int count) {
        return count >= 0 && count <= this.count;
    }

    @Override
    public int getTotalAmount() {
        return denomination * count;
    }

    @Override
    public String toString() {
        return String.format(
                "BanknoteCell{denomination=%d, count=%d, total=%d}", denomination, count, getTotalAmount());
    }
}
