package com.designPatterns.abstractFactory;

public class VehicalFactory {

    public static Vehical getVehical(VehicalEnums vehicalEnums) {
        switch (vehicalEnums) {
            case CAR:
                return new Car();
            case TRUCK:
                return new Truck();
            case BUS:
                return new Bus();
            default:
                return null;
        }
    }
}
