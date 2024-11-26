package com.lowLevelDesign.loggubgframework;

public class Appliation {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Logging with default configuration
        logger.info("This is an information message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");

        // Changing log level and appender
        LogConfig config = new LogConfig(new FileLogAdapter("app.log"), LogLevel.DEBUG);
        logger.setConfig(config);

        logger.debug("This is a debug message");
        logger.info("This is an information message");
    }
}
