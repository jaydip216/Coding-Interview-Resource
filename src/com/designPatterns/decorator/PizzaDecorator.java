package com.designPatterns.decorator;

public abstract  class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String bakePizza() {
        return pizza.bakePizza();
    }
}
