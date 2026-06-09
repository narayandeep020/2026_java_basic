package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log4jPropertiesConfig {

    private static final Logger logger = LoggerFactory.getLogger(Log4jPropertiesConfig.class);

    public static void main(String[] args){
        logger.info("== Slf4j and Log4j With Properties Config Demo ==");

        logger.error("ERROR: Critical error occurred");
        logger.warn("WARN: Potential issue detected");
        logger.info("INFO: General information message");
        logger.debug("DEBUG: Detailed debugging information");
        logger.trace("TRACE: Most detailed debugging");


        String user = "John";
        int attempts = 5;
        logger.info("User {} made {} login attempts", user, attempts);
    }
}
