package ru.otus;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppFrom_hw01 {
    private static final Logger logger = LoggerFactory.getLogger(AppFrom_hw01.class);

    private AppFrom_hw01() {}

    public static void say() {
        logger.info("{}", Lists.reverse(new ArrayList<>()));
        logger.info("I am from hw01");
    }
}
