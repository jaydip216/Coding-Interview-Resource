package com.designPatterns.factory;

public enum OperatingSystemEnums {
    WINDOWS(0, "Windows OS"),
    MAC(1, "Mac OS");

    private final int id;
    private final String name;

    OperatingSystemEnums(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
