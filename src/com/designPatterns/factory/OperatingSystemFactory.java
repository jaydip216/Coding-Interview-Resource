package com.designPatterns.factory;

public class OperatingSystemFactory {

    public static OperatingSystem getOperatingSystem(OperatingSystemEnums os) {
        switch (os) {
            case WINDOWS:
                return new WindowsOperatingSystem();
            case MAC:
                return new MacOperatingSystem();
            default:
                throw new IllegalArgumentException("Invalid Operating System");
        }
    }
}
