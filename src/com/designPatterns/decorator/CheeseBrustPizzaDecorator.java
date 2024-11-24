package com.designPatterns.decorator;

public class CheeseBrustPizzaDecorator extends PizzaDecorator {

    public CheeseBrustPizzaDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bakePizza() {
        return pizza.bakePizza() + " with Cheese Brust";
    }
}