package com.lowLevelDesign.loggubgframework;

public class LogConfig {
    private LogAdapter logAdapter;
    private LogLevel logLevel;


    public LogConfig(LogAdapter logAdapter, LogLevel logLevel) {
        this.logAdapter = logAdapter;
        this.logLevel = logLevel;
    }

    public LogAdapter getLogAdapter() {
        return logAdapter;
    }

    public void setLogAdapter(LogAdapter logAdapter) {
        this.logAdapter = logAdapter;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
