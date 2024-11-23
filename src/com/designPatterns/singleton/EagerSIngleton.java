package com.designPatterns.singleton;

public class EagerSIngleton {

    private static final EagerSIngleton instance = new EagerSIngleton();

    private EagerSIngleton() {
    }

    public static EagerSIngleton getInstance() {
        return instance;
    }
}
