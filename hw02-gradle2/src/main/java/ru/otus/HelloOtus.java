package ru.otus;

import com.zaxxer.hikari.HikariConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloOtus {
    private static final Logger logger = LoggerFactory.getLogger(HelloOtus.class);

    public static void main(String... args) {
        HikariConfig config = new HikariConfig();
        logger.info("{}", config);
    }
}
