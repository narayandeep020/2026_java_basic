package main.java;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class Log4j2JavaConfig {
    private static Logger logger;

    public static void main(String[] args){
        System.out.println("=== Log4j2 Java Config ===");

        Configuration config = createConfiguration();
        LoggerContext text = Configurator.initialize(Log4j2JavaConfig.class.getClassLoader(), config);

        logger = LogManager.getLogger(Log4j2JavaConfig.class);

        demonstrateAllAppenders();

        Configurator.shutdown(text);
    }

    private static Configuration createConfiguration(){
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

        builder.setStatusLevel(Level.ERROR)
        .setConfigurationName("Log4j2AllAppendersConfig")
                .add(builder.newFilter("ThresholdFilter", Filter.Result.ACCEPT, Filter.Result.NEUTRAL)
                        .addAttribute("level", Level.DEBUG));


        // Console Appender
        AppenderComponentBuilder consoleAppend = builder.newAppender("console", "CONSOLE")
        .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT)
                .add(builder.newLayout("PatternLayout")
                        .addAttribute("pattern", "%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"));
        builder.add(consoleAppend);


        //File Appender
        AppenderComponentBuilder fileAppend = builder.newAppender("File", "File")
                .addAttribute("filename", "logs/log4j2-file.log")
                .addAttribute("Appender", "false")
                .add(builder.newLayout("PatternLayout"))
                .addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n");
builder.add(fileAppend);


//Rolling File Appender
        AppenderComponentBuilder rollingfile = builder.newAppender("RollingFile", "RollingFile")
                .addAttribute("filename", "logs/log4j2-rolling.log")
                .addAttribute("filePattern", "logs/log4j2-rolling-%d{yyyy-MM-dd}-%i.log")
                .add(builder.newLayout("PatternLayout")
                        .addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"))
        .addComponent(builder.newComponent("Policies")
                .addComponent(builder.newComponent("TimeBasedTriggeringPolicy")
                        .addAttribute("Interval", "1"))
                .addComponent(builder.newComponent("SizeBasedTriggeringPolicy")
                        .addAttribute("size", "1 KB")))
                .addComponent(builder.newComponent("DefaultRolloverStrategy")
                        .addAttribute("max", "10"));
builder.add(rollingfile);

//Daily Rolling file Appender
        AppenderComponentBuilder dailyRolling = builder.newAppender("DailyRollingFile", "RollingFile")
                .addAttribute("fileName", "logs/log4j2-dailyrolling.log")
                .addAttribute("filePattern", "logs/log4j2-daily-%d{yyyy-MM-dd}.log")
                .add(builder.newLayout("PatternLayout")
                        .addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"))
                .addComponent(builder.newComponent("Policies")
                        .addComponent(builder.newComponent("TimeBasedTriggeringPolicy")
                                .addAttribute("interval", "1")
                                .addAttribute("modulate", "true")));
        builder.add(dailyRolling);


        // Random Access File Appender
        AppenderComponentBuilder randomAccess = builder.newAppender("RandomAccessFile", "RandomAccessFile")
                .addAttribute("fileName", "logs/log4j2-randomaccess.log")
                .addAttribute("append", "true")
                .addAttribute("immediateFlush", "true")
                .add(builder.newLayout("PatternLayout")
                        .addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"));
        builder.add(randomAccess);

        // Memory Mapped File Appender
        AppenderComponentBuilder memoryMapped = builder.newAppender("MemoryMappedFile", "MemoryMappedFile")
                .addAttribute("fileName", "logs/log4j2-memorymapped.log")
                .addAttribute("append", "true")
                .addAttribute("immediateFlush", "true")
                .addAttribute("regionLength", 33554432)
                .add(builder.newLayout("PatternLayout")
                        .addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"));
        builder.add(memoryMapped);

        builder.add(builder.newRootLogger(Level.DEBUG)
                .add(builder.newAppenderRef("Console"))
                .add(builder.newAppenderRef("File"))
                .add(builder.newAppenderRef("RollingFile"))
                .add(builder.newAppenderRef("DailyRollingFile"))
                .add(builder.newAppenderRef("RandomAccessFile"))
                .add(builder.newAppenderRef("MemoryMappedFile")));
        return builder.build();
    }
    public static void demonstrateAllAppenders(){
        logger.trace("This is a Trace message");
        logger.debug("This is a Debug message");
        logger.info("This is an Info message");
        logger.warn("This is a Warn message");
        logger.error("This is an Error message");
        logger.fatal("This is a Fatal message");


        String user = "Satya";
        int id = 24;
        logger.info("User {} has performed {} operations", user,id);

        try{
            throw new RuntimeException("Simple exception for demonstration");
        }catch (Exception e){
            logger.error("An exception occurred", e);
        }

        System.out.println("\n=== Log files created in 'logs' directory ===");

        System.out.println("1. Console output");
        System.out.println("2. logs/log4j2-file.log");
        System.out.println("3. logs/log4j2-rolling.log");
        System.out.println("4. logs/log4j2-dailyrolling.log");
        System.out.println("5. logs/log4j2-randomaccess.log");
        System.out.println("6. logs/log4j2-memorymapped.log");
    }
}
