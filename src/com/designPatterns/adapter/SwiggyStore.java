package com.designPatterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class SwiggyStore {
    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println("Name: " + item.getName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Restaurant Name: " + item.getRestaurantName());
            System.out.println();
        }
    }

}
