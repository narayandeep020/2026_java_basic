package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackXmlConfig {

    private static final Logger logger = LoggerFactory.getLogger(LogbackXmlConfig.class);

    public static void main(String[] args){
        logger.info("Application is starting...");

        String user = "Deep Narayan";
        logger.debug("User {} is attempting to log in.", user);

        try{
            throw new RuntimeException("Database Connection Failed");
        }catch (Exception e){
            logger.error("An unexpected error occurred", e);
        }

        logger.trace("Printing Trace Log");
        logger.debug("Printing Debug Log");
        logger.info("Printing Info Log");
        logger.warn("Printing Warn Log");
        logger.error("Printing Error Log");
    }
}
