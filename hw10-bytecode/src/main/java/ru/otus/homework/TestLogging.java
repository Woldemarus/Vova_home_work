package ru.otus.homework;

public class TestLogging implements TestLoggingInterface {

    @Log
    @Override
    public void calculation(int param) {
        // Пустая реализация - логирование будет добавлено через прокси
    }

    @Log
    @Override
    public void calculation(int param1, int param2) {
        // Пустая реализация - логирование будет добавлено через прокси
    }

    @Log
    @Override
    public void calculation(int param1, int param2, String param3) {
        // Пустая реализация - логирование будет добавлено через прокси
    }

    // Дополнительные перегруженные методы для демонстрации гибкости
    @Log
    public void calculation(String param) {
        // Пустая реализация - логирование будет добавлено через прокси
    }

    @Log
    public void calculation(double param1, double param2) {
        // Пустая реализация - логирование будет добавлено через прокси
    }

    @Log
    public void calculation(int param1, String param2, boolean param3) {
        // Пустая реализация - логирование будет добавлено через прокси
    }

    @Log
    public void calculation(Object... params) {
        // Пустая реализация - логирование будет добавлено через прокси
    }

    // Метод без аннотации @Log - не будет логироваться
    public void noLoggingMethod(int param) {
        System.out.println("Этот метод не будет логироваться: " + param);
    }
}
