package ru.otus.homework;

public interface TestLoggingInterface {
    @Log
    void calculation(int param);

    @Log
    void calculation(int param1, int param2);

    @Log
    void calculation(int param1, int param2, String param3);

    // Дополнительные перегруженные методы
    @Log
    void calculation(String param);

    @Log
    void calculation(double param1, double param2);

    @Log
    void calculation(int param1, String param2, boolean param3);

    @Log
    void calculation(Object... params);

    // Метод без аннотации @Log
    void noLoggingMethod(int param);
}
