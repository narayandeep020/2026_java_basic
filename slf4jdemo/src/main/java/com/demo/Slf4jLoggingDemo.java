package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLoggingDemo {
    // Create a logger for this class
    private static final Logger logger = LoggerFactory.getLogger(Slf4jLoggingDemo.class);

    public static void main(String[] args) {
        logger.trace("This is a TRACE message");
        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");

        try {
            int result = divide(10, 0);
            logger.info("Result: {}", result);
        } catch (Exception e) {
            logger.error("An exception occurred", e);
        }
    }

    private static int divide(int a, int b) {
        return a / b; // Will throw ArithmeticException if b == 0
    }
}



