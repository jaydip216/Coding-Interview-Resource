package com.lowLevelDesign.loggubgframework;

public class ConsoleLogAdapter implements LogAdapter{

    @Override
    public void append(LogMessage message) {
        System.out.println(message.getLogLevel() + " " + message.getTimestamp() + " " +message.getContent());
    }
}
