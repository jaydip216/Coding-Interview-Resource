package com.designPatterns.prototype;

public class Application {

    public static void main(String[] args) {
        Vehicle vehicle = VehicleRegistry.getVehicle(VehicleEnums.TWO_WHEELER);
        System.out.println(vehicle);
    }
}
