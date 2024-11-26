package com.lowLevelDesign.vendingmachine;

public enum Note {
    FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private int denomination;

    Note(int denomination) {
        this.denomination = denomination;
    }

    public int getValue() {
        return denomination;
    }
}
