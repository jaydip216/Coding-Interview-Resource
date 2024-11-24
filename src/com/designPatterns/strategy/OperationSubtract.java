package com.designPatterns.strategy;

public class OperationSubtract implements Strategy {

    public OperationSubtract() {
    }

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
