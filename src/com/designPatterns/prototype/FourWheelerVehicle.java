package com.designPatterns.prototype;

public class FourWheelerVehicle extends Vehicle {

    private String fourWheelerType;

    public String getFourWheelerType() {
        return fourWheelerType;
    }

    public void setFourWheelerType(String fourWheelerType) {
        this.fourWheelerType = fourWheelerType;
    }

    public FourWheelerVehicle(String vehicleName, String vehicleType, String vehicleModel, String vehicleColor, String vehicleNumber, String fourWheelerType) {
        super(vehicleName, vehicleType, vehicleModel, vehicleColor, vehicleNumber);
        this.fourWheelerType = fourWheelerType;
    }
}
