package ru.otus.l12.homework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Тесты для эмулятора АТМ
 */
class ATMTest {

    private ATM atm;

    @BeforeEach
    void setUp() {
        atm = new DefaultATM();
    }

    @Test
    void testAcceptBanknotes() {
        Map<Integer, Integer> banknotes = new HashMap<>();
        banknotes.put(1000, 10);
        banknotes.put(500, 5);

        atm.acceptBanknotes(banknotes);

        assertEquals(12500, atm.getTotalAmount());
        Map<Integer, Integer> status = atm.getCellStatus();
        assertEquals(10, status.get(1000));
        assertEquals(5, status.get(500));
    }

    @Test
    void testWithdrawAmount() throws InsufficientFundsException {
        // Загружаем банкноты
        Map<Integer, Integer> banknotes = new HashMap<>();
        banknotes.put(1000, 10);
        banknotes.put(500, 10);
        banknotes.put(100, 20);
        atm.acceptBanknotes(banknotes);

        // Выдаем сумму
        Map<Integer, Integer> withdrawal = atm.withdrawAmount(1500);

        assertEquals(2, withdrawal.size());
        assertEquals(1, withdrawal.get(1000));
        assertEquals(1, withdrawal.get(500));

        // Проверяем, что деньги действительно изъяты
        assertEquals(15500, atm.getTotalAmount()); // 20000 - 1500 = 18500, но у нас 1000+500+100*20 = 17000
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Map<Integer, Integer> banknotes = new HashMap<>();
        banknotes.put(100, 5); // Только 500 рублей
        atm.acceptBanknotes(banknotes);

        assertThrows(InsufficientFundsException.class, () -> {
            atm.withdrawAmount(1000);
        });
    }

    @Test
    void testWithdrawInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            atm.withdrawAmount(-100);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            atm.withdrawAmount(0);
        });
    }

    @Test
    void testAcceptInvalidBanknotes() {
        Map<Integer, Integer> invalidBanknotes = new HashMap<>();
        invalidBanknotes.put(-100, 5);

        assertThrows(IllegalArgumentException.class, () -> {
            atm.acceptBanknotes(invalidBanknotes);
        });

        Map<Integer, Integer> negativeCount = new HashMap<>();
        negativeCount.put(100, -5);

        assertThrows(IllegalArgumentException.class, () -> {
            atm.acceptBanknotes(negativeCount);
        });
    }

    @Test
    void testGetTotalAmount() {
        assertEquals(0, atm.getTotalAmount());

        Map<Integer, Integer> banknotes = new HashMap<>();
        banknotes.put(1000, 3);
        banknotes.put(500, 2);
        atm.acceptBanknotes(banknotes);

        assertEquals(4000, atm.getTotalAmount());
    }

    @Test
    void testGetCellStatus() {
        Map<Integer, Integer> banknotes = new HashMap<>();
        banknotes.put(1000, 5);
        banknotes.put(500, 3);
        atm.acceptBanknotes(banknotes);

        Map<Integer, Integer> status = atm.getCellStatus();
        assertEquals(5, status.get(1000));
        assertEquals(3, status.get(500));
        assertNull(status.get(100));
    }

    @Test
    void testCanWithdraw() {
        Map<Integer, Integer> banknotes = new HashMap<>();
        banknotes.put(1000, 5);
        banknotes.put(500, 3);
        atm.acceptBanknotes(banknotes);

        DefaultATM defaultATM = (DefaultATM) atm;

        assertTrue(defaultATM.canWithdraw(1000));
        assertTrue(defaultATM.canWithdraw(5000));
        assertTrue(defaultATM.canWithdraw(6500));
        assertFalse(defaultATM.canWithdraw(10000));
        assertFalse(defaultATM.canWithdraw(-100));
    }
}
