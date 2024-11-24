package com.designPatterns.template;

public class Application {

        public static void main(String[] args) {
            Game game = new Cricket();
            game.play();
            System.out.println();
            game = new Football();
            game.play();
        }
}
