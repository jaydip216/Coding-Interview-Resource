package com.designPatterns.observer;

public class Application {

    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer1 = new NewsChannel();
        NewsChannel observer2 = new NewsChannel();
        observable.addChannel(observer1);
        observable.addChannel(observer2);
        observable.update("news");
        System.out.println(observer1.getNews());
        System.out.println(observer2.getNews());
    }
}
