package ru.otus.l12.homework;

/**
 * Исключение, возникающее при недостатке средств в банкомате
 */
public class InsufficientFundsException extends Exception {
    private final int requestedAmount;
    private final int availableAmount;

    public InsufficientFundsException(int requestedAmount, int availableAmount) {
        super(String.format("Недостаточно средств. Запрошено: %d, доступно: %d", requestedAmount, availableAmount));
        this.requestedAmount = requestedAmount;
        this.availableAmount = availableAmount;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }
}
