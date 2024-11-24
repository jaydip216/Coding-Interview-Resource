package com.designPatterns.facade;

public class Application {
    public static void main(String[] args) {
        ZomatoFacade orderFacade = new ZomatoFacade();
        orderFacade.orderFood();
    }
}
