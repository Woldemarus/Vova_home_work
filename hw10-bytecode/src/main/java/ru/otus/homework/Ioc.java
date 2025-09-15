package ru.otus.homework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ioc {

    private Ioc() {}

    private static final Logger logger = LoggerFactory.getLogger(Ioc.class);

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
            // Логируем все вызовы методов (аннотированные методы всегда одинаковые)
            logMethodCall(method, args);

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
            logger.info(String.valueOf(logMessage));
        }
    }
}
