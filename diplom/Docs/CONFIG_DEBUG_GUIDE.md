# Руководство по отладке конфигурационных файлов

## Что мы добавили для отладки

### 1. Расширенное логирование в application.yml
```yaml
logging:
  level:
    org.springframework.boot.context.config: DEBUG  # Отладка загрузки конфигурации
    org.springframework.core.env: DEBUG              # Отладка PropertySource
```

### 2. Диагностический компонент ConfigDiagnostic
Автоматически выводит при запуске:
- Рабочую директорию приложения
- Проверку существования файлов конфигурации
- Статус переменных окружения
- Загруженные значения свойств
- Список всех активных PropertySource

### 3. Отладочная информация в main классе
Выводит базовую информацию о среде выполнения.

## Как использовать

### Шаг 1: Запустите приложение
```bash
./gradlew bootRun
```

### Шаг 2: Найдите в логах секцию диагностики
Ищите блок:
```
=== ДИАГНОСТИКА КОНФИГУРАЦИИ ===
```

### Шаг 3: Анализируйте вывод

#### Проверьте рабочую директорию
```
Рабочая директория: /path/to/your/project
```
Файл `application-local.properties` должен находиться именно в этой директории.

#### Проверьте существование файла
```
Проверка файла: /absolute/path/to/application-local.properties
  - Существует: true/false
  - Читаемый: true/false
  - Размер: XXX байт
```

#### Проверьте переменные окружения
```
TELEGRAM_BOT_TOKEN из env: [УСТАНОВЛЕН]/[НЕ НАЙДЕН]
TELEGRAM_BOT_USERNAME из env: [УСТАНОВЛЕН]/[НЕ НАЙДЕН]
```

#### Проверьте загруженные значения
```
telegram.bot.token: [ЗАГРУЖЕН]/[НЕ ЗАГРУЖЕН]
telegram.bot.username: [ЗАГРУЖЕН]/[НЕ ЗАГРУЖЕН]
```

#### Проверьте PropertySource
Должны быть примерно такие источники:
```
PropertySource: configurationProperties
PropertySource: systemProperties
PropertySource: systemEnvironment
PropertySource: Config resource 'file [application-local.properties]'
PropertySource: Config resource 'class path resource [application.yml]'
```

## Типичные проблемы и решения

### 1. Файл не найден
**Симптом:** `Существует: false`

**Решения:**
- Убедитесь, что файл `application-local.properties` находится в корне проекта
- Проверьте имя файла (без опечаток)
- Скопируйте `application-local.properties.example` в `application-local.properties`

### 2. Файл не читается
**Симптом:** `Существует: true, Читаемый: false`

**Решения:**
- Проверьте права доступа к файлу
- На Linux/Mac: `chmod 644 application-local.properties`

### 3. Переменные окружения не установлены
**Симптом:** `[НЕ НАЙДЕН]` для переменных окружения

**Решения:**
- Установите переменные окружения:
  ```bash
  export TELEGRAM_BOT_TOKEN=your_token
  export TELEGRAM_BOT_USERNAME=your_username
  ```
- Или добавьте их в файл `application-local.properties`

### 4. Значения не загружаются
**Симптом:** `[НЕ ЗАГРУЖЕН]` для свойств

**Решения:**
- Проверьте синтаксис в `application-local.properties`:
  ```properties
  TELEGRAM_BOT_TOKEN=your_token_here
  TELEGRAM_BOT_USERNAME=your_bot_username
  ```
- Убедитесь, что нет лишних пробелов или символов
- Проверьте, что файл в кодировке UTF-8

### 5. PropertySource не содержит ваш файл
**Симптом:** Нет строки `Config resource 'file [application-local.properties]'`

**Решения:**
- Проверьте строку в `application.yml`:
  ```yaml
  spring:
    config:
      import: optional:file:application.properties
  ```
- Убедитесь, что путь указан правильно

## Дополнительные команды для отладки

### Проверка файла из командной строки
```bash
# Проверить существование
ls -la application.properties

# Показать содержимое (осторожно с токенами!)
cat application.properties

# Проверить кодировку
file application.properties
```

### Запуск с дополнительной отладкой
```bash
# Включить максимальную отладку Spring Boot
./gradlew bootRun --debug

# Или через переменную окружения
DEBUG=true ./gradlew bootRun
```

### Проверка переменных окружения
```bash
# Показать все переменные с TELEGRAM
env | grep TELEGRAM

# Показать конкретную переменную
echo $TELEGRAM_BOT_TOKEN
```

## После исправления проблем

Когда все заработает, вы можете:
1. Убрать отладочное логирование из `application.yml`
2. Удалить или закомментировать `ConfigDiagnostic.java`
3. Упростить логирование в главном классе

Это поможет уменьшить количество логов в продакшене.