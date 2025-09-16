package ru.otus.l12.homework;

/**
 * Реализация банкноты по умолчанию
 * Принцип Single Responsibility: отвечает только за представление банкноты
 * Принцип Open/Closed: можно расширить новыми типами банкнот без изменения существующего кода
 */
public class DefaultBanknote implements Banknote {
    private final int denomination;

    public DefaultBanknote(int denomination) {
        if (denomination <= 0) {
            throw new IllegalArgumentException("Номинал банкноты должен быть положительным");
        }
        this.denomination = denomination;
    }

    @Override
    public int getDenomination() {
        return denomination;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DefaultBanknote that = (DefaultBanknote) obj;
        return denomination == that.denomination;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(denomination);
    }

    @Override
    public String toString() {
        return String.format("Banknote{denomination=%d}", denomination);
    }
}
