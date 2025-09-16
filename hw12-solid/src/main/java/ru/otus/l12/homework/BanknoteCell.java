package ru.otus.l12.homework;

/**
 * Интерфейс ячейки для хранения банкнот определенного номинала
 * Принцип Single Responsibility: отвечает только за хранение банкнот одного номинала
 */
public interface BanknoteCell {
    /**
     * Получить номинал банкнот в ячейке
     * @return номинал банкнот
     */
    int getDenomination();

    /**
     * Получить количество банкнот в ячейке
     * @return количество банкнот
     */
    int getCount();

    /**
     * Добавить банкноты в ячейку
     * @param count количество банкнот для добавления
     * @throws IllegalArgumentException если количество отрицательное
     */
    void addBanknotes(int count);

    /**
     * Извлечь банкноты из ячейки
     * @param count количество банкнот для извлечения
     * @return количество фактически извлеченных банкнот
     * @throws IllegalArgumentException если количество отрицательное
     */
    int withdrawBanknotes(int count);

    /**
     * Проверить, можно ли извлечь указанное количество банкнот
     * @param count количество банкнот
     * @return true, если можно извлечь
     */
    boolean canWithdraw(int count);

    /**
     * Получить общую сумму денег в ячейке
     * @return общая сумма
     */
    int getTotalAmount();
}
