@echo off
setlocal enabledelayedexpansion

echo 🚀 Начинаем сборку и запуск HWSM Telegram Bot...

REM Переходим в корневую директорию проекта
cd /d "%~dp0\.."

REM Проверяем наличие переменных окружения
if "%TELEGRAM_BOT_TOKEN%"=="" (
    echo ❌ Ошибка: Не установлена переменная окружения TELEGRAM_BOT_TOKEN
    echo Установите её командой: set TELEGRAM_BOT_TOKEN=your_bot_token_here
    pause
    exit /b 1
)

if "%TELEGRAM_BOT_USERNAME%"=="" (
    echo ❌ Ошибка: Не установлена переменная окружения TELEGRAM_BOT_USERNAME
    echo Установите её командой: set TELEGRAM_BOT_USERNAME=your_bot_username
    pause
    exit /b 1
)

echo ✅ Переменные окружения проверены

REM Сборка проекта с помощью Gradle
echo 🔨 Сборка проекта...
gradlew.bat clean shadowJar

REM Проверяем, что JAR файл создан
if not exist "build\libs\hwsm-telegram-bot.jar" (
    echo ❌ Ошибка: JAR файл не найден после сборки
    pause
    exit /b 1
)

REM Копируем JAR файл в docker директорию
echo 📦 Копирование JAR файла...
copy "build\libs\hwsm-telegram-bot.jar" "docker\"

REM Создаем директорию для логов
if not exist "docker\logs" mkdir "docker\logs"

REM Останавливаем и удаляем существующие контейнеры
echo 🛑 Остановка существующих контейнеров...
cd docker
docker-compose down --remove-orphans

REM Собираем и запускаем контейнеры
echo 🐳 Сборка и запуск Docker контейнеров...
docker-compose up --build -d

REM Ждем запуска сервисов
echo ⏳ Ожидание запуска сервисов...
timeout /t 10 /nobreak >nul

REM Проверяем статус контейнеров
echo 📊 Статус контейнеров:
docker-compose ps

REM Проверяем логи
echo 📝 Последние логи приложения:
docker-compose logs --tail=20 hwsm-telegram-bot

echo.
echo 🎉 Развертывание завершено!
echo.
echo 📋 Полезные команды:
echo   Просмотр логов:           docker-compose logs -f hwsm-telegram-bot
echo   Остановка:                docker-compose down
echo   Перезапуск:               docker-compose restart hwsm-telegram-bot
echo   Подключение к БД:         docker-compose exec postgres psql -U hwsmdev -d hwsmdev
echo.
echo 🤖 Ваш Telegram-бот готов к работе!
pause