package com.designPatterns.factory;

public class WindowsOperatingSystem implements OperatingSystem {
    @Override
    public void button() {
        System.out.println("Windows button");
    }

    @Override
    public void display() {
        System.out.println("Windows display");
    }
}
