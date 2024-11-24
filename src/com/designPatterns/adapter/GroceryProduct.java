package com.designPatterns.adapter;

public class GroceryProduct implements GroceryItem {
    private String name;
    private String price;
    private String groceryStoreName;

    public GroceryProduct(String name, String price, String groceryStoreName) {
        this.name = name;
        this.price = price;
        this.groceryStoreName = groceryStoreName;
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
    public String getGroceryStoreName() {
        return groceryStoreName;
    }
}
