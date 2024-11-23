package com.designPatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {

    private static final Map<VehicleEnums, Vehicle> vehicleRegistry= new HashMap<>();
    static {
        TwoWheelerVehicle twoWheelerVehicle = new TwoWheelerVehicle("Honda", "Two Wheeler", "Activa", "Black", "KA-01-1234", "Scooter");
        FourWheelerVehicle fourWheelerVehicle = new FourWheelerVehicle("Toyota", "Four Wheeler", "Innova", "White", "KA-02-5678", "SUV");
        vehicleRegistry.put(VehicleEnums.TWO_WHEELER, twoWheelerVehicle);
        vehicleRegistry.put(VehicleEnums.FOUR_WHEELER, fourWheelerVehicle);
    }

    public static Vehicle getVehicle(VehicleEnums vehicleEnums) {
        Vehicle vehicle = null;
        try {
            vehicle = (Vehicle) vehicleRegistry.get(vehicleEnums).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return vehicle;
    }
}
