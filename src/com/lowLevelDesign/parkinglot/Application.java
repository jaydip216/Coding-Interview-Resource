package com.lowLevelDesign.parkinglot;

import com.lowLevelDesign.parkinglot.vehicles.Bike;
import com.lowLevelDesign.parkinglot.vehicles.Car;
import com.lowLevelDesign.parkinglot.vehicles.Vehicle;

public class Application {

    public static void main(String[] args) {
        Parking parking = Parking.getInstance();
        Level level1 = new Level(1, 10);
        //Level level2 = new Level(2, 10);
        parking.addLevel(level1);
        //parking.addLevel(level2);

        parking.displayAvailableSpots();

        Vehicle car1 = new Car(1);
        Vehicle car2 = new Car(2);
        Vehicle bike1 = new Bike(3);
        Vehicle bike2 = new Bike(4);
        Vehicle bike3 = new Bike(5);

        parking.parkVehicle(car1);
        parking.parkVehicle(car2);
        parking.parkVehicle(bike1);
        parking.parkVehicle(bike2);
        parking.parkVehicle(bike3);

        parking.displayAvailableSpots();

    }
}
