# HWSM Telegram Bot - "Кто хочет стать миллионером"

Telegram-бот для игры "Кто хочет стать миллионером" на Java с использованием Spring Boot, PostgreSQL и Docker.

## 🎯 Описание проекта

Это полнофункциональный Telegram-бот, реализующий популярную игру "Кто хочет стать миллионером". Игроки отвечают на 15 вопросов возрастающей сложности, стремясь выиграть главный приз в 1,000,000 рублей.

### Основные возможности:
- 15 уровней вопросов с призовым фондом от 100₽ до 1,000,000₽
- Несгораемые суммы: 1,000₽ и 32,000₽
- 3 подсказки: 50/50, Звонок другу, Помощь зала
- Сохранение прогресса игры
- Статистика игрока
- Многопользовательский режим

## 🏗️ Архитектура

### Технологический стек:
- **Java 21** - основной язык программирования
- **Spring Boot 3.x** - фреймворк приложения
- **Spring Data JPA** - работа с базой данных
- **Hibernate** - ORM
- **PostgreSQL 17** - база данных
- **Flyway** - миграции БД
- **TelegramBots API** - интеграция с Telegram
- **Docker & Docker Compose** - контейнеризация
- **Gradle** - система сборки
- **Logback** - логирование

### Структура проекта:
```
diplom/
├── src/main/java/ru/otus/hwsm/
│   ├── entity/          # JPA сущности
│   ├── repository/      # Spring Data репозитории
│   ├── service/         # Бизнес-логика
│   ├── bot/            # Telegram Bot логика
│   └── HwsmTelegramBotApplication.java
├── src/main/resources/
│   ├── db/migration/    # Flyway миграции
│   ├── application.yml  # Конфигурация Spring
│   └── logback.xml     # Конфигурация логирования
├── docker/
│   ├── Dockerfile
│   ├── docker-compose.yml
│   ├── init-db.sql     # Тестовые данные
│   ├── build-and-run.sh
│   └── build-and-run.bat
└── build.gradle.kts    # Gradle конфигурация
```

## 🚀 Быстрый старт

### Предварительные требования:
- Java 21+
- Docker и Docker Compose
- Telegram Bot Token (получить у @BotFather)

### 1. Клонирование и настройка

```bash
# Переход в директорию проекта
cd diplom

# Установка переменных окружения
export TELEGRAM_BOT_TOKEN="your_bot_token_here"
export TELEGRAM_BOT_USERNAME="your_bot_username"
```

### 2. Запуск через Docker (рекомендуется)

**Linux/macOS:**
```bash
chmod +x docker/build-and-run.sh
./docker/build-and-run.sh
```

**Windows:**
```cmd
docker\build-and-run.bat
```

### 3. Ручной запуск

```bash
# Сборка проекта
./gradlew clean shadowJar

# Запуск PostgreSQL
docker run --name hwsm-postgres \
  -e POSTGRES_DB=hwsmdev \
  -e POSTGRES_USER=hwsmdev \
  -e POSTGRES_PASSWORD=HwSm2024!SecureP@ssw0rd#Dev \
  -p 5432:5432 -d postgres:17

# Запуск приложения
java -jar build/libs/hwsm-telegram-bot.jar
```

## 🎮 Игровая механика

### Уровни и призы:
1. 100₽
2. 200₽
3. 300₽
4. 500₽
5. 1,000₽ (несгораемая сумма)
6. 2,000₽
7. 4,000₽
8. 8,000₽
9. 16,000₽
10. 32,000₽ (несгораемая сумма)
11. 64,000₽
12. 125,000₽
13. 250,000₽
14. 500,000₽
15. 1,000,000₽ (главный приз)

### Команды бота:
- `/start` - Начать игру или показать статистику
- `/question` - Получить текущий вопрос
- `/help` - Справка по командам
- `/stats` - Статистика игрока

### Подсказки:
- **50/50** - убирает 2 неправильных ответа
- **Звонок другу** - показывает мнение "друга"
- **Помощь зала** - показывает результаты "голосования"

## 🗄️ База данных

### Основные таблицы:
- `users` - пользователи Telegram
- `games` - игровые сессии
- `questions` - вопросы викторины
- `question_options` - варианты ответов
- `game_answers` - ответы игроков
- `game_lifelines` - использованные подсказки

### Подключение к БД:
```bash
# Через Docker Compose
docker-compose exec postgres psql -U hwsmdev -d hwsmdev

# Прямое подключение
psql -h localhost -p 5432 -U hwsmdev -d hwsmdev
```

## 🔧 Конфигурация

### Основные настройки в `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/hwsmdev
    username: hwsmdev
    password: HwSm2024!SecureP@ssw0rd#Dev

telegram:
  bot:
    token: ${TELEGRAM_BOT_TOKEN}
    username: ${TELEGRAM_BOT_USERNAME}

hwsm:
  game:
    questions-per-game: 15
    time-limit-seconds: 30
```

### Переменные окружения:
- `TELEGRAM_BOT_TOKEN` - токен Telegram бота
- `TELEGRAM_BOT_USERNAME` - имя пользователя бота
- `SPRING_PROFILES_ACTIVE` - профиль Spring (dev/prod/docker)

## 📊 Мониторинг и логи

### Просмотр логов:
```bash
# Docker Compose
docker-compose logs -f hwsm-telegram-bot

# Файлы логов
tail -f docker/logs/hwsm-telegram-bot.log
```

### Health Check:
```bash
curl http://localhost:8080/actuator/health
```

### Метрики:
```bash
curl http://localhost:8080/actuator/metrics
```

## 🛠️ Разработка

### Сборка проекта:
```bash
./gradlew clean build
```

### Запуск тестов:
```bash
./gradlew test
```

### Создание fat JAR:
```bash
./gradlew shadowJar
```

### Добавление новых вопросов:
1. Добавить SQL в `docker/init-db.sql`
2. Или создать новую Flyway миграцию в `src/main/resources/db/migration/`

## 🐳 Docker команды

### Основные команды:
```bash
# Запуск всех сервисов
docker-compose up -d

# Остановка
docker-compose down

# Перезапуск бота
docker-compose restart hwsm-telegram-bot

# Просмотр логов
docker-compose logs -f

# Очистка volumes
docker-compose down -v
```

### Сборка образа:
```bash
docker build -f docker/Dockerfile -t hwsm-telegram-bot .
```

## 🔒 Безопасность

### Рекомендации:
1. Используйте сильные пароли для БД
2. Не храните токены в коде
3. Используйте HTTPS для продакшена
4. Регулярно обновляйте зависимости
5. Настройте файрвол для Docker

### Смена пароля БД:
1. Обновите `application.yml`
2. Обновите `docker-compose.yml`
3. Пересоздайте контейнеры: `docker-compose down -v && docker-compose up -d`

## 📈 Масштабирование

### Для продакшена:
1. Используйте внешнюю БД PostgreSQL
2. Настройте connection pooling
3. Добавьте Redis для кеширования
4. Используйте load balancer
5. Настройте мониторинг (Prometheus + Grafana)

## 🤝 Вклад в проект

1. Fork репозитория
2. Создайте feature branch
3. Внесите изменения
4. Добавьте тесты
5. Создайте Pull Request

## 📝 Лицензия

Этот проект создан в образовательных целях для курса OTUS Java.

## 🆘 Поддержка

При возникновении проблем:
1. Проверьте логи: `docker-compose logs hwsm-telegram-bot`
2. Убедитесь, что все переменные окружения установлены
3. Проверьте доступность БД: `docker-compose ps`
4. Перезапустите сервисы: `docker-compose restart`

---

**Автор:** OTUS Java Student  
**Версия:** 1.0.0  
**Дата:** Декабрь 2025