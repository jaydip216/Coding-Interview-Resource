package com.designPatterns.command;

public class TextFileOperationExecutor {

    public String executeOperation(TextFileOperation textFileOperation) {
        return textFileOperation.execute();
    }

}
