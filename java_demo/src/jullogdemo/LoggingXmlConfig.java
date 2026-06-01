package jullogdemo;

import java.util.logging.*;
import java.io.IOException;
import java.io.InputStream;

public class LoggingXmlConfig {

	private static final Logger logger = Logger.getLogger(LoggingXmlConfig.class.getName());

	static {
		try {
			loadXmlConfiguration();
			logger.info("XML logging configuration loaded successfully");
		} catch (IOException e) {
			logger.warning("Failed to XML configuration, using fallback setup" + e.getMessage());
		}
	}

	private static void loadXmlConfiguration() throws SecurityException, IOException {

		String xmlFileName = "logging.xml";
		InputStream configStream = (InputStream) LoggingXmlConfig.class.getClassLoader()
				.getResourceAsStream(xmlFileName);

		if (configStream != null) {
			LogManager.getLogManager().readConfiguration(configStream);
			configStream.close();
		} else {
			throw new IOException("Xml configuration file not found: " + xmlFileName);
		}
	}

	public static void demonstrateXmlConfigLogging() {
		logger.info("=== JUL XML Configuration Demo ===");

		logger.severe("Critical error occurred");
		logger.warning("This is a Warning");
		logger.info("General infomation message");
		logger.config("Configuration details");
		logger.fine("Detailed debugging information");
		logger.finer("More detailed debugging");
		logger.finest("Most detaied debugging");
	}

	public static void demonstrateXmlConfigFeatures() {
		logger.info("=== XML Configuration Feature Demo ===");

		logger.info("Logger Name: " + logger.getName());
		logger.info("Logger Level: " + logger.getLevel());
		logger.info("Logger using parent handler: " + logger.getUseParentHandlers());

		Handler[] handlers = logger.getHandlers();
		logger.info("Number of Handler: " + handlers.length);
		for (Handler handler : handlers) {
			logger.info("Handler: " + handler.getClass().getSimpleName() + ", Level: " + handler.getLevel()
					+ ", Formatter: " + handler.getFormatter().getClass().getSimpleName());
		}

		logger.info("Testing Xml configuration with custom formatter");
		for (int i = 0; i < 5; i++) {
			logger.info("XML config test message: " + (i + 1));
		}
	}

	public static void demonstrateExceptionLogging() {
		logger.info("=== Exception Logging with XMl Config");

		try {
			String nullStr = null;
			int length = nullStr.length();
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, "NullPointerException caught", e);
			logger.log(Level.WARNING, "Failed to process string: " + e.getMessage());
		}
	}

	public static void main(String[] args) {

		demonstrateXmlConfigLogging();
//		System.out.println("hello");
	}

}
