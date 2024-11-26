package com.lowLevelDesign.loggubgframework;

public class Logger {
    private static final Logger instance = new Logger();
    private LogConfig config;

    private Logger() {
        // Private constructor to enforce singleton pattern
        config = new LogConfig(new ConsoleLogAdapter(), LogLevel.INFO);
    }

    public static Logger getInstance() {
        return instance;
    }

    public void setConfig(LogConfig config) {
        this.config = config;
    }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= config.getLogLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(message, level);
            config.getLogAdapter().append(logMessage);
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
