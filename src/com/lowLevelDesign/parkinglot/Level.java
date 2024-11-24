package com.lowLevelDesign.parkinglot;

import com.lowLevelDesign.parkinglot.vehicles.Vehicle;
import com.lowLevelDesign.parkinglot.vehicles.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private int levelNumber;
    private List<ParkingSpot> parkingSpots;

    public Level(int levelNumber, int numberOfSpots) {
        this.levelNumber = levelNumber;
        this.parkingSpots = new ArrayList<>(numberOfSpots);

        int bikeSpots = numberOfSpots / 4;
        int carSpots = numberOfSpots / 4;
        int truckSpots = numberOfSpots - bikeSpots - carSpots;

        for (int i = 0; i < bikeSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.BIKE));
        }
        for (int i = bikeSpots; i < bikeSpots + carSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }
        for (int i = bikeSpots + carSpots; i < numberOfSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getVehicleType() == vehicle.getVehicleType() && !parkingSpot.isOccupied()) {
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        System.out.println("Parking spot is already occupied or vehicle type is not matching");
        return false;
    }

    public void releaseVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isOccupied() && parkingSpot.getVehicle() == vehicle) {
                parkingSpot.releaseVehicle();
                break;
            }
        }
    }

    public void displayAvailableSpots() {
        System.out.println("Available spots on level: " + levelNumber);
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (!parkingSpot.isOccupied()) {
                System.out.println("Spot number: " + parkingSpot.getSpotNumber() + " is available" +
                        " for vehicle type: " + parkingSpot.getVehicleType());
            }
        }
    }

}
