package com.designPatterns.strategy;

public class OperationAdd implements Strategy {

    public OperationAdd() {
    }

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }

}
