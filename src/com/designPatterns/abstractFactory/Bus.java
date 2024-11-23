package com.designPatterns.abstractFactory;

public class Bus implements Vehical{

        @Override
        public VehicalType getVehical() {
            return new PessagerVehical();
        }
}
