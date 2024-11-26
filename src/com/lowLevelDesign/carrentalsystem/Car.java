package com.lowLevelDesign.carrentalsystem;

import java.math.BigDecimal;

public class Car {

    private String make;
    private String model;
    private CarType carType;
    private BigDecimal rentPerDay;
    private String licencePlateNo;

    public Car(String make, String model, CarType carType, BigDecimal rentPerDay, String licencePlateNo) {
        this.make = make;
        this.model = model;
        this.carType = carType;
        this.rentPerDay = rentPerDay;
        this.licencePlateNo = licencePlateNo;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public CarType getCarType() {
        return carType;
    }

    public BigDecimal getRentPerDay() {
        return rentPerDay;
    }

    public String getLicencePlateNo() {
        return licencePlateNo;
    }

}
