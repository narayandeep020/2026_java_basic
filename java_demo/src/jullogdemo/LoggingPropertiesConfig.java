package jullogdemo;

import java.util.logging.*;
import java.io.IOException;
import java.io.InputStream;

public class LoggingPropertiesConfig {

	private static final Logger logger = Logger.getLogger(LoggingPropertiesConfig.class.getName());

	static {
		try {
			loadLoggingConfiguration();
			logger.info("Logging configuration loaded successfully from properties file");

		} catch (Exception e) {
			logger.warning("Failed to load logging configuration" + e.getMessage());
		}
	}

	private static void loadLoggingConfiguration() throws Exception {

		String configFileName = "logdemo\\logging.properties";
		InputStream configStream = (InputStream) LoggingPropertiesConfig.class.getClassLoader()
				.getResourceAsStream(configFileName);

		if (configStream != null) {
			LogManager.getLogManager().readConfiguration(configStream);
			configStream.close();
		} else {
			throw new IOException("Configuration file not found: " + configStream);
		}
	}

	public static void demonstrateBasicLogging() {
		logger.info("=== Configuration Basic Logging Demo ===");

		logger.severe("Critical error occurred");
		logger.warning("Potential issue detected");
		logger.info("General information message");
		logger.config("Configuration details");
		logger.fine("Detailed debugging information");
		logger.finer("More detailed debugging");
		logger.finest("Most detailed debugging");
	}

	public static void configurationFeatures() {
		logger.info("=== Configuration Feature Demo ===");

		logger.info("Logger Name: " + logger.getName());
		logger.info("Logger Level: " + logger.getLevel());
		logger.info("Logger using parent handlers: " + logger.getUseParentHandlers());

		Handler[] handlers = logger.getHandlers();
		logger.info("Number of handlers: " + handlers.length);
		for (Handler handler : handlers) {
			logger.info("Handler: " + handler.getClass().getSimpleName() + ", Level: " + handler.getLevel()
					+ ", Formatter: " + handler.getFormatter().getClass().getSimpleName());
		}
		for (int i = 0; i <= 10; i++) {
			logger.info("Log message: " + (i + 1) + "for testing file rotation");
		}
	}

	public static void demonstrateParameterLogging() {
		logger.info("=== Parameter Logging Demo ===");

		String user = "Bob";
		int loginAttempts = 3;
		boolean success = true;

		logger.info("User: " + user + " Attempt login: " + loginAttempts + " times");
		logger.info(String.format("Login status for %s: %s", user, success ? "Success" : "Failed"));
	}

	public static void demonstrateExceptionLogging() {
		logger.info("=== Exception Logging Demo ===");

		try {
			String nullString = null;
			int length = nullString.length();

		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, "NullPointerException caught", e);
			logger.log(Level.WARNING, "Failed to process string: " + e.getMessage());
		}

		try {
			int result = 10 / 0;

		} catch (ArithmeticException e) {
			logger.log(Level.SEVERE, "ArithmeticException caught", e);
		}
	}

	public static void main(String[] args) {

		demonstrateBasicLogging();
//		configurationFeatures()
//		demonstrateParameterLogging();
//		demonstrateExceptionLogging();

	}

}
