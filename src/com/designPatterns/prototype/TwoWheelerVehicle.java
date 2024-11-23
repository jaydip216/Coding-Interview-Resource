package com.designPatterns.prototype;

public class TwoWheelerVehicle extends Vehicle {

    private String twoWheelerType;

    public String getTwoWheelerType() {
        return twoWheelerType;
    }

    public void setTwoWheelerType(String twoWheelerType) {
        this.twoWheelerType = twoWheelerType;
    }

    public TwoWheelerVehicle(String vehicleName, String vehicleType, String vehicleModel, String vehicleColor, String vehicleNumber, String twoWheelerType) {
        super(vehicleName, vehicleType, vehicleModel, vehicleColor, vehicleNumber);
        this.twoWheelerType = twoWheelerType;
    }

}
