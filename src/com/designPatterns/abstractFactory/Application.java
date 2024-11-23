package com.designPatterns.abstractFactory;

public class Application {

    public static void main(String[] args) {
        Vehical vehical = VehicalFactory.getVehical(VehicalEnums.CAR);
        System.out.println(vehical.getVehical().getVehicalType());
    }
}
