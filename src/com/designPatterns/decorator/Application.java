package com.designPatterns.decorator;

public class Application {

    public static void main(String[] args) {
        Pizza cheesePizza = new CheeseBrustPizzaDecorator(new JalepanoDecorator(new BasePizza()));
        System.out.println(cheesePizza.bakePizza());
    }
}
