plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    java
}

group = "ru.otus"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

configurations.all {
    resolutionStrategy {
        // Оставляем принудительные версии для разрешения конфликтов других библиотек
        force(
            "org.javassist:javassist:3.30.2-GA",
            "org.checkerframework:checker-qual:3.48.3",
            "javax.xml.bind:jaxb-api:2.3.1",
            "com.squareup.okhttp3:okhttp:4.12.0"
        )
        // Удалена сложная логика eachDependency для telegram, так как теперь версия указана явно в dependencies.
    }
}

dependencies {
    // Spring Boot BOM и стартеры остаются без изменений
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.4.2"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // ✅ ЗАМЕНА: Используем корректные зависимости Telegram Bot 9.2.0
    implementation("org.telegram:telegrambots-springboot-longpolling-starter:9.2.0")
    implementation("org.telegram:telegrambots-client:9.2.0")
    implementation("org.telegram:telegrambots-extensions:9.2.0")

    // База данных
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.hibernate.orm:hibernate-core")

    // Миграции
    implementation("org.flywaydb:flyway-core")
    runtimeOnly("org.flywaydb:flyway-database-postgresql")

    // Логирование
    implementation("ch.qos.logback:logback-classic")

    // Утилиты
    implementation("com.google.guava:guava")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("com.google.code.findbugs:jsr305")

    // JSON обработка
    implementation("org.glassfish:jakarta.json")
    implementation("com.google.code.gson:gson")
    implementation("com.google.errorprone:error_prone_annotations")

    // Рефлексия и утилиты
    implementation("org.reflections:reflections")

    // Тестирование
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    archiveBaseName.set("hwsm-telegram-bot")
    archiveClassifier.set("")
    archiveVersion.set("")

    exclude("META-INF/*.SF")
    exclude("META-INF/*.DSA")
    exclude("META-INF/*.RSA")

    manifest {
        attributes["Main-Class"] = "ru.otus.hwsm.HwsmTelegramBotApplication"
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}