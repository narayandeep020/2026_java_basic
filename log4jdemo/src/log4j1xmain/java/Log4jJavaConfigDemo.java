package log4j1xmain.java;

import org.apache.log4j.*;
import org.apache.log4j.varia.LevelRangeFilter;

public class Log4jJavaConfigDemo {
	private static final Logger logger = Logger.getLogger(Log4jJavaConfigDemo.class);

	public static void main(String[] args) {
		LogManager.resetConfiguration();

		configureConsoleAppender();
		configureFileAppender();
		configureRollingFileAppender();
		configureDailyRollingFileAppender();

		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.DEBUG);

		demonstrateLogging();

	}

	private static void configureConsoleAppender() {
		ConsoleAppender console = new ConsoleAppender();
		PatternLayout layout = new PatternLayout();

		layout.setConversionPattern("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");

		console.setLayout(layout);
		console.setTarget("System.out");
		console.activateOptions();

		Logger.getRootLogger().addAppender(console);
		logger.info("ConsoleAppender configured successfully");
	}

	private static void configureFileAppender() {
		FileAppender file = new FileAppender();
		PatternLayout layout = new PatternLayout();

		layout.setConversionPattern("%d{ISO8601} [%t] %-5p %c{2}:%L - %m%n");

		file.setLayout(layout);
		file.setFile("logfiles/java-config-file.log");
		file.setAppend(true);
		file.activateOptions();

		LevelRangeFilter filter = new LevelRangeFilter();
		filter.setLevelMin(Level.INFO);
		filter.activateOptions();
		file.addFilter(filter);

		Logger.getRootLogger().addAppender(file);
		logger.info("FileAppender configured successfully");
	}

	private static void configureRollingFileAppender() {
		RollingFileAppender rolling = new RollingFileAppender();
		PatternLayout layout = new PatternLayout();

		layout.setConversionPattern("%d{yyyy-MM-dd HH:mm:ss.SSS} %-5p [%t] %c{1}:%L - %m%n");

		rolling.setLayout(layout);
		rolling.setFile("logfiles/java-config-rolling.log");
		rolling.setAppend(true);
		rolling.setMaxFileSize("2KB");
		rolling.setMaxBackupIndex(5);
		rolling.activateOptions();

		Logger.getRootLogger().addAppender(rolling);
		logger.info("RollingFileAppender configured successfully");

	}

	private static void configureDailyRollingFileAppender() {
		DailyRollingFileAppender dailyRolling = new DailyRollingFileAppender();
		PatternLayout layout = new PatternLayout();

		layout.setConversionPattern("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1} - %m%n");

		dailyRolling.setLayout(layout);
		dailyRolling.setFile("logfiles/java-config-daily.log");
		dailyRolling.setAppend(true);
		dailyRolling.setDatePattern("'.'yyyy-MM-dd");
		dailyRolling.activateOptions();

		Logger.getRootLogger().addAppender(dailyRolling);
		logger.info("DailyRollingFileAppender congiured successfully");
	}

	private static void demonstrateLogging() {

		logger.trace("This is a TRACE message");
		logger.debug("This is a DEBUG message");
		logger.info("This is a INFO message");
		logger.warn("This is a WARN message");
		logger.error("This is an ERROR message");
		logger.fatal("This is a FATAL message");

		String userName = "DeepTechno";
		int userId = 9872;
		logger.info("User logged in: " + userName + "( ID: " + userId + ")");

		try {
			int result = 10 / 0;
		} catch (Exception e) {
			logger.error("Division by zero error occurred", e);
		}

		long startTime = System.currentTimeMillis();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			logger.error("Sleep interrupted: ", e);
		}

		long endTime = System.currentTimeMillis();

		logger.debug("Operation took: " + (endTime - startTime) + " ms");
		logger.info("Log4j 1.x Java-Based configuration demonstration completed");
	}

}
