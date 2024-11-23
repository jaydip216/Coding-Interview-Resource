package com.designPatterns.abstractFactory;

public class Car implements Vehical {

    @Override
    public VehicalType getVehical() {
        return new CommuteVehical();
    }

}
