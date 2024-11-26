package com.lowLevelDesign.tictactoe;

public enum Symbol {
    X('x'),
    O('o'),
    DEFAULT('-');

    private char value;

    Symbol(char symbol){
        this.value=symbol;
    }

    public char getValue(){
        return this.value;
    }
}
