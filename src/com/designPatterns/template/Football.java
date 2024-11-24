package com.designPatterns.template;

public class Football implements Game {

    @Override
    public void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    public void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    public void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    public void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
