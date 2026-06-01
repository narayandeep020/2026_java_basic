package log4j1Xml.java;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jXmlConfigDemo {

	private static final Logger logger = Logger.getLogger(Log4jXmlConfigDemo.class);

	public static void main(String[] args) {

		DOMConfigurator.configure("src/log4j1Xml/resources/log4j.xml");

		logger.trace("This is a trace message");
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");

		String user = "GojoSir";
		int userId = 12345;
		logger.info("User Logged in: " + user + "(ID: " + userId + ")");

		try {
			int result = 10 / 0;
		} catch (Exception e) {
			logger.error("Division by zero error occurred: ", e);
		}

		logger.info("Log4j 1.x demonstration completed success");
	}

}
