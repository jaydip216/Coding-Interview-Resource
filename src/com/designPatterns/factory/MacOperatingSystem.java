package com.designPatterns.factory;

public class MacOperatingSystem implements OperatingSystem {

    @Override
    public void button() {
        System.out.println("Mac button");
    }

    @Override
    public void display() {
        System.out.println("Mac display");
    }
}
