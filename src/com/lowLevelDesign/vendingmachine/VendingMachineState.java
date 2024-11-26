package com.lowLevelDesign.vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface VendingMachineState {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
}