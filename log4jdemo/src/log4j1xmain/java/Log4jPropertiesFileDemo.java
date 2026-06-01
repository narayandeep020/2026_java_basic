package log4j1xmain.java;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jPropertiesFileDemo {

	private static final Logger logger = Logger.getLogger(Log4jPropertiesFileDemo.class);

	public static void main(String[] args) {

		PropertyConfigurator.configure("src/log4j1xmain/resources/log4j1x.properties");

		logger.trace("This is a trace message");
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");

		String user = "Narayana";
		int userId = 88423;
		logger.info("User logged in: " + user + "(ID: " + userId + ")");

		try {
			int result = 10 / 0;
		} catch (Exception e) {
			logger.error("Division by zero error occurred ", e);
		}

		logger.info("Log4j 1.x demonstration completed successfully!");
	}

}
