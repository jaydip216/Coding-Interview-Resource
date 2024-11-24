package com.designPatterns.command;

public class CloseTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    public CloseTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.close();
    }
}
