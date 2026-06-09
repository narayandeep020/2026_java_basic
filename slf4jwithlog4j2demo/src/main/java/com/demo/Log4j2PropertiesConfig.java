package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log4j2PropertiesConfig {
    private static final Logger logger = LoggerFactory.getLogger(Log4j2PropertiesConfig.class);

    public static void main(String[] args){
        logger.info("== Slf4j With Log4j2 Properties Config ==");

        logger.trace("Trace message - very detailed");
        logger.debug("Debug message - useful for developers");
        logger.info("Info message - general application flow");
        logger.warn("Warning message - something unexpected but not fatal");
        logger.error("Error message - something went wrong");

        String user = "Deep Nama";
        int count = 10;
        logger.info("User {} to attempt {} operation",user,count);
    }
}
