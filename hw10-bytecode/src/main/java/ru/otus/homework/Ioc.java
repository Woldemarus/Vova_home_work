package ru.otus.homework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Ioc {

    private Ioc() {}

    @SuppressWarnings("unchecked")
    public static <T> T createLoggingProxy(Class<T> clazz) {
        try {
            T target = clazz.getDeclaredConstructor().newInstance();
            InvocationHandler handler = new LoggingInvocationHandler(target);

            // Если класс реализует интерфейсы, используем их для создания прокси
            Class<?>[] interfaces = clazz.getInterfaces();
            if (interfaces.length > 0) {
                return (T) Proxy.newProxyInstance(Ioc.class.getClassLoader(), interfaces, handler);
            } else {
                // Если нет интерфейсов, создаем прокси для всех публичных методов
                return createClassProxy(target, clazz);
            }
        } catch (Exception e) {
            throw new RuntimeException("Ошибка создания прокси для класса " + clazz.getName(), e);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T createClassProxy(T target, Class<T> clazz) {
        // Для классов без интерфейсов создаем прокси через наследование
        // Это более сложный подход, но для простоты пока выбросим исключение
        throw new UnsupportedOperationException(
                "Класс " + clazz.getName() + " должен реализовывать интерфейс для создания прокси");
    }

    static class LoggingInvocationHandler implements InvocationHandler {
        private final Object target;

        LoggingInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // Проверяем, есть ли аннотация @Log на методе
            if (method.isAnnotationPresent(Log.class)) {
                logMethodCall(method, args);
            }

            // Вызываем оригинальный метод
            return method.invoke(target, args);
        }

        private void logMethodCall(Method method, Object[] args) {
            StringBuilder logMessage = new StringBuilder();
            logMessage.append("executed method: ").append(method.getName());

            if (args != null && args.length > 0) {
                logMessage.append(", param");
                if (args.length > 1) {
                    logMessage.append("s");
                }
                logMessage.append(": ");

                for (int i = 0; i < args.length; i++) {
                    if (i > 0) {
                        logMessage.append(", ");
                    }
                    logMessage.append(args[i]);
                }
            }

            System.out.println(logMessage.toString());
        }
    }
}
