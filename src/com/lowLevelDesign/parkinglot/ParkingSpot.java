package com.lowLevelDesign.parkinglot;

import com.lowLevelDesign.parkinglot.vehicles.Vehicle;
import com.lowLevelDesign.parkinglot.vehicles.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;
    private VehicleType vehicleType;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public void parkVehicle(Vehicle vehicle) {
        if(!isOccupied() && vehicle.getVehicleType() == this.vehicleType) {
            this.vehicle = vehicle;
            this.isOccupied = true;
        } else {
            System.out.println("Parking spot is already occupied or vehicle type is not matching");
        }
    }

    public void releaseVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
