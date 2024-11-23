package com.designPatterns.abstractFactory;

public class Truck implements Vehical{

        @Override
        public VehicalType getVehical() {
            return new CargoVehical();
        }
}
