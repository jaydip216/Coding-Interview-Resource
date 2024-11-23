package com.designPatterns.singleton;

public class MultiThreadingSingleton {

    // Volatile variable to ensure visibility of changes to instance across threads
    private static volatile MultiThreadingSingleton instance = null;

    // Private constructor to prevent instantiation
    private MultiThreadingSingleton() {
    }

    // Public method to provide access to the singleton instance
    public static MultiThreadingSingleton getInstance() {
        if (instance == null) {
            // Synchronized block to remove overhead
            synchronized (MultiThreadingSingleton.class) {
                if (instance == null) {
                    // Lazy initialization
                    instance = new MultiThreadingSingleton();
                }
            }
        }
        return instance;
    }
}