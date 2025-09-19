package ru.otus.homework;

public interface TestLoggingInterface {
    void calculation(int param);

    void calculation(int param1, int param2);

    void calculation(int param1, int param2, String param3);

    // Дополнительные перегруженные методы
    void calculation(String param);

    void calculation(double param1, double param2);

    void calculation(int param1, String param2, boolean param3);

    void calculation(Object... params);

    // Метод без аннотации @Log
    void noLoggingMethod(int param);
}
