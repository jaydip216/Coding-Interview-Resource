package com.lowLevelDesign.loggubgframework;

public class LogMessage {
    private String content;
    private LogLevel logLevel;
    private long timestamp;

    public LogMessage(String content, LogLevel logLevel) {
        this.content = content;
        this.logLevel = logLevel;
        this.timestamp = System.currentTimeMillis();
    }

    public String getContent() {
        return content;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
