FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1

# Создаем пользователя для запуска приложения
RUN addgroup -g 1001 -S appgroup && \
    adduser -u 1001 -S appuser -G appgroup

# Создаем директории для приложения и логов
RUN mkdir -p /app/logs && \
    chown -R appuser:appgroup /app

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR файл
COPY hwsm-telegram-bot.jar app.jar

# Устанавливаем права на файлы
RUN chown appuser:appgroup app.jar

# Переключаемся на непривилегированного пользователя
USER appuser

# Открываем порт для health check
EXPOSE 8080

# Настройки JVM для контейнера
ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:+UseG1GC -XX:+UseContainerSupport"

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
    CMD wget --no-verbose --tries=1 --spider http://localhost:8080/actuator/health || exit 1

# Запуск приложения
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]