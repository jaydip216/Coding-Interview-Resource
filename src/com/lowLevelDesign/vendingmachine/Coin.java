package com.lowLevelDesign.vendingmachine;

public enum Coin {
    PENNY(0.01), NICKLE(0.5), DIME(0.1), QUARTER(0.25);

    private double denomination;

    Coin(double denomination) {
        this.denomination = denomination;
    }

    public double getValue() {
        return denomination;
    }
}
