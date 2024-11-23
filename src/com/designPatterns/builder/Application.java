package com.designPatterns.builder;

public class Application {
    public static void main(String[] args) {
        House house = new House.HouseBuilder()
                .rooms(4)
                .bathrooms(3)
                .parkingSpaces(2)
                .hasGarden(true)
                .build();
        System.out.println(house);
    }
}
