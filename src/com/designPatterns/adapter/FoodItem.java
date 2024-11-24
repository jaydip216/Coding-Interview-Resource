package com.designPatterns.adapter;

public class FoodItem implements Item {
    private String name;
    private String price;
    private String restaurantName;

    public FoodItem(String name, String price, String restaurantName) {
        this.name = name;
        this.price = price;
        this.restaurantName = restaurantName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public String getRestaurantName() {
        return restaurantName;
    }
}
