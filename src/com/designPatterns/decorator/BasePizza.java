package com.designPatterns.decorator;

public class BasePizza implements Pizza {

    @Override
    public String bakePizza() {
        return "Base Pizza";
    }
}
