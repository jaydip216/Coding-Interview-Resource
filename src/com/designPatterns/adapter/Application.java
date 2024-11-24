package com.designPatterns.adapter;

public class Application {

    public static void main(String[] args) {
        Item foodItem = new FoodItem("Pizza", "$10", "Pizza Hut");
        GroceryProduct groceryProduct = new GroceryProduct("Milk", "$2", "Walmart");
        Item groceryItem = new GroceryAdapter(groceryProduct);
        SwiggyStore swiggyStore = new SwiggyStore();
        swiggyStore.addItem(foodItem);
        swiggyStore.addItem(groceryItem);
        swiggyStore.displayItems();
    }
}
