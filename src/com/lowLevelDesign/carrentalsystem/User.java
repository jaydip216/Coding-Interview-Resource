package com.lowLevelDesign.carrentalsystem;

public class User {
    private String name;
    private String mobileNo;
    private String drivingLicenceNo;

    public User(String name, String mobileNo, String drivingLicenceNo) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.drivingLicenceNo = drivingLicenceNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getName() {
        return name;
    }

    public String getDrivingLicenceNo() {
        return drivingLicenceNo;
    }
}
