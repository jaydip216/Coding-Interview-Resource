package com.lowLevelDesign.loggubgframework;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogAdapter implements LogAdapter{

    private String filepath;

    public FileLogAdapter(String filepath){
        this.filepath=filepath;
    }

    @Override
    public void append(LogMessage message) {
        try{
            FileWriter fw = new FileWriter(filepath, true);
            fw.write(message.getContent() + "\n");
//            fw.write(message.getLogLevel().toString()+ "\n");
//            fw.write(Long.toString(message.getTimestamp())+ "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
