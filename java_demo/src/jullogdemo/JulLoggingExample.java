package jullogdemo;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JulLoggingExample {

	private static final Logger logger = Logger.getLogger(JulLoggingExample.class.getName());

	static {
		try {
			FileHandler handler = new FileHandler("jul_logging.log", false);
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);

			ConsoleHandler console = new ConsoleHandler();
			console.setFormatter(new CustomFormatter());
			logger.addHandler(console);

			logger.setLevel(Level.ALL);
		} catch (IOException e) {
			logger.severe("Failed to initialize file handler: " + e.getMessage());
		}
	}

	public static void demonstrateBasicLogging() {
		logger.info("==== JUL Basic Logging Demo ===");

		logger.severe("SEVERE: Critical error occurred");
		logger.warning("WARNING: Potential issue detected");
		logger.info("INFO: General information message");
		logger.config("CONFIG: Configration details");
		logger.fine("FINE: Detailed debugging information");
		logger.finer("FINER: More detailed debugging");
		logger.finest("FINEST: Most detailed debugging");
	}

	public static void demonstrateParameterLogging() {
		logger.info("=== JUL Parameter Logging Demo ===");

		String user = "Amenika";
		int loginAttempts = 5;
		boolean success = false;

		logger.info("User: " + user + " Attempts Login: " + loginAttempts + " times");
		logger.info(String.format("Login status for %s: %s", user, success ? "Success" : "Failed"));
	}

	public static void demonstrateExceptionLogging() {
		logger.info("=== JUL Exception Logging Demo ===");

		try {
			String nullString = null;
			int length = nullString.length();

		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, "NullPointerException caught ", e);
			logger.log(Level.WARNING, "Failed to process string " + e.getMessage());
		}
		try {
			int result = 10 / 0;
		} catch (ArithmeticException e) {
			logger.log(Level.SEVERE, "ArithmeticException occurred", e);
		}
	}

	public static void demonstrateMethodLogging() {
		logger.entering(JulLoggingExample.class.getName(), "demonstrateMethodLogging");
		logger.info("Processing method execution : demonstrateMethodLogging");

		try {
			Thread.sleep(100);
			logger.info("Method processing completed successfully");
		} catch (InterruptedException e) {
			logger.log(Level.WARNING, "Method execution interrupted", e);
			Thread.currentThread().interrupt();
		}
		logger.info("exiting method execution : demonstrateMethodLogging");
		logger.exiting(JulLoggingExample.class.getName(), "demonstrateMethodLogging");
	}

	private static class CustomFormatter extends Formatter {

		public String format(LogRecord record) {
			return String.format("[%1$tF %1$tT] [%2$-7s] %3$-20s: %4$s %n", new java.util.Date(record.getMillis()),
					record.getLevel().getLocalizedName(), record.getLoggerName(), record.getMessage());
		}
	}

	public static void main(String[] args) {

//		demonstrateBasicLogging();
//		demonstrateParameterLogging();
//		demonstrateExceptionLogging();
		demonstrateMethodLogging();
	}

}
