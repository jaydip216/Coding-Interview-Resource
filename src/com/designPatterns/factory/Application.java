package com.designPatterns.factory;

public class Application {

    public static void main(String[] args) {
        OperatingSystem operatingSystem = OperatingSystemFactory.getOperatingSystem(OperatingSystemEnums.MAC);
        operatingSystem.button();
        operatingSystem.display();
    }
}
