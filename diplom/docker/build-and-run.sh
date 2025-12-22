#!/bin/bash

# Скрипт для сборки и запуска Telegram-бота "Кто хочет стать миллионером"

set -e

echo "🚀 Начинаем сборку и запуск HWSM Telegram Bot..."

# Переходим в корневую директорию проекта
cd "$(dirname "$0")/.."

# Проверяем наличие переменных окружения
if [ -z "$TELEGRAM_BOT_TOKEN" ]; then
    echo "❌ Ошибка: Не установлена переменная окружения TELEGRAM_BOT_TOKEN"
    echo "Установите её командой: export TELEGRAM_BOT_TOKEN=your_bot_token_here"
    exit 1
fi

if [ -z "$TELEGRAM_BOT_USERNAME" ]; then
    echo "❌ Ошибка: Не установлена переменная окружения TELEGRAM_BOT_USERNAME"
    echo "Установите её командой: export TELEGRAM_BOT_USERNAME=your_bot_username"
    exit 1
fi

echo "✅ Переменные окружения проверены"

# Сборка проекта с помощью Gradle
echo "🔨 Сборка проекта..."
./gradlew clean shadowJar

# Проверяем, что JAR файл создан
if [ ! -f "build/libs/hwsm-telegram-bot.jar" ]; then
    echo "❌ Ошибка: JAR файл не найден после сборки"
    exit 1
fi

# Копируем JAR файл в docker директорию
echo "📦 Копирование JAR файла..."
cp build/libs/hwsm-telegram-bot.jar docker/

# Создаем директорию для логов
mkdir -p docker/logs

# Останавливаем и удаляем существующие контейнеры
echo "🛑 Остановка существующих контейнеров..."
cd docker
docker-compose down --remove-orphans

# Собираем и запускаем контейнеры
echo "🐳 Сборка и запуск Docker контейнеров..."
docker-compose up --build -d

# Ждем запуска сервисов
echo "⏳ Ожидание запуска сервисов..."
sleep 10

# Проверяем статус контейнеров
echo "📊 Статус контейнеров:"
docker-compose ps

# Проверяем логи
echo "📝 Последние логи приложения:"
docker-compose logs --tail=20 hwsm-telegram-bot

echo ""
echo "🎉 Развертывание завершено!"
echo ""
echo "📋 Полезные команды:"
echo "  Просмотр логов:           docker-compose logs -f hwsm-telegram-bot"
echo "  Остановка:                docker-compose down"
echo "  Перезапуск:               docker-compose restart hwsm-telegram-bot"
echo "  Подключение к БД:         docker-compose exec postgres psql -U hwsmdev -d hwsmdev"
echo ""
echo "🤖 Ваш Telegram-бот готов к работе!"