package com.designPatterns.adapter;

public class GroceryAdapter implements Item {
    private GroceryItem groceryItem;

    public GroceryAdapter(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }

    @Override
    public String getName() {
        return groceryItem.getName();
    }

    @Override
    public String getPrice() {
        return groceryItem.getPrice();
    }

    @Override
    public String getRestaurantName() {
        return groceryItem.getGroceryStoreName();
    }
}
