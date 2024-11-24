package com.designPatterns.decorator;

public class JalepanoDecorator extends PizzaDecorator {

        public JalepanoDecorator(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String bakePizza() {
            return pizza.bakePizza() + " with Jalepano";
        }
}
