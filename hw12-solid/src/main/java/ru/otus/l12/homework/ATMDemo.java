package ru.otus.l12.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * Демонстрация работы банкомата
 * Показывает все основные возможности эмулятора АТМ
 */
public class ATMDemo {

    public static void main(String[] args) {
        System.out.println("=== Демонстрация эмулятора АТМ ===\n");

        // Создаем банкомат
        ATM atm = new DefaultATM();

        // Загружаем банкноты разных номиналов
        System.out.println("1. Загрузка банкнот в банкомат:");
        Map<Integer, Integer> initialBanknotes = new HashMap<>();
        initialBanknotes.put(5000, 10); // 10 банкнот по 5000
        initialBanknotes.put(2000, 20); // 20 банкнот по 2000
        initialBanknotes.put(1000, 50); // 50 банкнот по 1000
        initialBanknotes.put(500, 100); // 100 банкнот по 500
        initialBanknotes.put(100, 200); // 200 банкнот по 100

        atm.acceptBanknotes(initialBanknotes);
        printATMStatus(atm);

        // Демонстрируем выдачу денег
        System.out.println("\n2. Выдача денег:");
        demonstrateWithdrawal(atm, 1500);
        demonstrateWithdrawal(atm, 7500);
        demonstrateWithdrawal(atm, 12300);
        demonstrateWithdrawal(atm, 100000); // Попытка выдать больше, чем есть

        // Демонстрируем добавление банкнот
        System.out.println("\n3. Добавление новых банкнот:");
        Map<Integer, Integer> additionalBanknotes = new HashMap<>();
        additionalBanknotes.put(5000, 5);
        additionalBanknotes.put(100, 50);
        atm.acceptBanknotes(additionalBanknotes);
        printATMStatus(atm);

        // Демонстрируем выдачу после пополнения
        System.out.println("\n4. Выдача после пополнения:");
        demonstrateWithdrawal(atm, 100000);

        // Демонстрируем проверку возможности выдачи
        System.out.println("\n5. Проверка возможности выдачи:");
        checkWithdrawalPossibility(atm, 50000);
        checkWithdrawalPossibility(atm, 500000);
        checkWithdrawalPossibility(atm, 5000);
        checkWithdrawalPossibility(atm, 500);
        printATMStatus(atm);

        System.out.println("\n=== Демонстрация завершена ===");
    }

    private static void demonstrateWithdrawal(ATM atm, int amount) {
        try {
            System.out.printf("Попытка выдать %d рублей...\n", amount);
            Map<Integer, Integer> withdrawal = atm.withdrawAmount(amount);

            System.out.printf("✓ Успешно выдано %d рублей:\n", amount);
            int totalWithdrawn = 0;
            for (Map.Entry<Integer, Integer> entry : withdrawal.entrySet()) {
                int denomination = entry.getKey();
                int count = entry.getValue();
                int subtotal = denomination * count;
                totalWithdrawn += subtotal;
                System.out.printf("  - %d банкнот по %d рублей = %d рублей\n", count, denomination, subtotal);
            }
            System.out.printf("  Итого: %d рублей\n", totalWithdrawn);

        } catch (InsufficientFundsException e) {
            System.out.printf("✗ Ошибка: %s\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("✗ Неожиданная ошибка: %s\n", e.getMessage());
        }
    }

    private static void checkWithdrawalPossibility(ATM atm, int amount) {
        boolean canWithdraw = ((DefaultATM) atm).canWithdraw(amount);
        System.out.printf("Можно ли выдать %d рублей? %s\n", amount, canWithdraw ? "Да" : "Нет");
    }

    private static void printATMStatus(ATM atm) {
        System.out.printf("Общая сумма в банкомате: %d рублей\n", atm.getTotalAmount());
        System.out.println("Состояние ячеек:");
        Map<Integer, Integer> cellStatus = atm.getCellStatus();
        cellStatus.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
                .forEach(entry -> {
                    int denomination = entry.getKey();
                    int count = entry.getValue();
                    int total = denomination * count;
                    System.out.printf("  - %d банкнот по %d рублей = %d рублей\n", count, denomination, total);
                });
    }
}
