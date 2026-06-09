package main.java.com.demo;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    public class LogbackBasicDemo {
        // Best Practice: Define the logger as static final based on the class name
        private static final Logger logger = LoggerFactory.getLogger(LogbackBasicDemo.class);
        public static void main(String[] args) {
            logger.info("Application is starting...");
            String username = "Deep Narayan";
            logger.debug("User {} is attempting to log in.", username);

            try {
                throw new RuntimeException("Database connection failed");
            } catch (Exception e) {
                logger.error("An unexpected error occurred", e);
            }
            logger.info("============Printing Internal State============");

            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            StatusPrinter.print(loggerContext);
        }

    }

