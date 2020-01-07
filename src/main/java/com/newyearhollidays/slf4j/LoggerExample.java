package com.newyearhollidays.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerExample {
private static Logger logger = LoggerFactory.getLogger(LoggerExample.class);

    public static void main(String[] args) {
        String s = "My string";

        logger.warn("Hello Mike {}", s);
        logger.info("Hello Mike {}", s);
        logger.debug("Hello Mike {}", s);
    }
}
