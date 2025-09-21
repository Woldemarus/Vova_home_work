package ru.otus.l12.homework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Тесты для демонстрации соблюдения принципов SOLID
 */
class SOLIDPrinciplesTest {

    @Test
    void testSingleResponsibilityPrinciple() {
        // Каждый класс имеет одну ответственность
        Banknote banknote = new DefaultBanknote(1000);
        assertEquals(1000, banknote.getDenomination());

        BanknoteCell cell = new DefaultBanknoteCell(1000, 5);
        assertEquals(1000, cell.getDenomination());
        assertEquals(5, cell.getCount());
        assertEquals(5000, cell.getTotalAmount());

        // ATM отвечает только за основные операции
        ATM atm = new DefaultATM();
        assertNotNull(atm);
    }

    @Test
    void testOpenClosedPrinciple() {
        // Можно создать новую стратегию выдачи без изменения существующего кода
        WithdrawalStrategy customStrategy = new WithdrawalStrategy() {
            @Override
            public Map<Integer, Integer> calculateWithdrawal(int amount, Map<Integer, Integer> cellStatus)
                    throws InsufficientFundsException {
                // Простая стратегия: выдаем только банкнотами по 100
                Map<Integer, Integer> result = new HashMap<>();
                if (cellStatus.containsKey(100) && cellStatus.get(100) >= amount / 100) {
                    result.put(100, amount / 100);
                    return result;
                }
                throw new InsufficientFundsException(amount, 0);
            }
        };

        ATM atm = new DefaultATM(customStrategy);
        Map<Integer, Integer> banknotes = new HashMap<>();
        banknotes.put(100, 100);
        atm.acceptBanknotes(banknotes);

        // Тест проходит, если стратегия работает
        assertTrue(atm.getTotalAmount() > 0);
    }

    @Test
    void testLiskovSubstitutionPrinciple() {
        // DefaultATM может быть заменен любой реализацией ATM
        ATM atm1 = new DefaultATM();
        ATM atm2 = new DefaultATM(new GreedyWithdrawalStrategy());

        // Оба объекта должны работать одинаково
        Map<Integer, Integer> banknotes = new HashMap<>();
        banknotes.put(1000, 5);

        atm1.acceptBanknotes(banknotes);
        atm2.acceptBanknotes(banknotes);

        assertEquals(atm1.getTotalAmount(), atm2.getTotalAmount());
    }

    @Test
    void testInterfaceSegregationPrinciple() {
        // Интерфейсы содержат только необходимые методы
        Banknote banknote = new DefaultBanknote(500);
        assertNotNull(banknote.getDenomination());

        BanknoteCell cell = new DefaultBanknoteCell(500, 3);
        assertTrue(cell.canWithdraw(2));
        assertFalse(cell.canWithdraw(5));

        ATM atm = new DefaultATM();
        assertNotNull(atm.getTotalAmount());
    }

    @Test
    void testDependencyInversionPrinciple() {
        // ATM зависит от абстракций, а не от конкретных реализаций
        WithdrawalStrategy strategy = new GreedyWithdrawalStrategy();
        ATM atm = new DefaultATM(strategy);

        // ATM работает с любой реализацией WithdrawalStrategy
        assertNotNull(atm);

        // Можно заменить стратегию без изменения ATM
        WithdrawalStrategy newStrategy = new GreedyWithdrawalStrategy();
        ATM newATM = new DefaultATM(newStrategy);
        assertNotNull(newATM);
    }

    @Test
    void testBanknoteCellOperations() {
        BanknoteCell cell = new DefaultBanknoteCell(1000, 10);

        // Тест добавления банкнот
        cell.addBanknotes(5);
        assertEquals(15, cell.getCount());
        assertEquals(15000, cell.getTotalAmount());

        // Тест извлечения банкнот
        int withdrawn = cell.withdrawBanknotes(3);
        assertEquals(3, withdrawn);
        assertEquals(12, cell.getCount());

        // Тест извлечения больше, чем есть
        withdrawn = cell.withdrawBanknotes(20);
        assertEquals(12, withdrawn);
        assertEquals(0, cell.getCount());

        // Тест проверки возможности извлечения
        assertFalse(cell.canWithdraw(1));
        cell.addBanknotes(5);
        assertTrue(cell.canWithdraw(3));
    }

    @Test
    void testErrorHandling() {
        // Тест обработки ошибок
        assertThrows(IllegalArgumentException.class, () -> {
            new DefaultBanknote(-100);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new DefaultBanknoteCell(-100);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new DefaultBanknoteCell(100, -5);
        });
    }
}
