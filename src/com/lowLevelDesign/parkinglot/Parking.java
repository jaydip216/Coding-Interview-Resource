package com.lowLevelDesign.parkinglot;

import com.lowLevelDesign.parkinglot.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private static Parking instance;
    private List<Level> levels;

    private Parking(){
        this.levels = new ArrayList<>();
    }

    public static Parking getInstance() {
        if(instance == null) {
            instance = new Parking();
        }
        return instance;
    }

    public void addLevel(Level level) {
        this.levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void releaseVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            level.releaseVehicle(vehicle);
        }
    }

    public void displayAvailableSpots() {
        for (Level level : levels) {
            level.displayAvailableSpots();
        }
    }

}
