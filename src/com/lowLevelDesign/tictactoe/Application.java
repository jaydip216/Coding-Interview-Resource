package com.lowLevelDesign.tictactoe;

public class Application {
    public static void main(String[] args) {
        Player player1 = new Player("jaydip", Symbol.O);
        Player player2 = new Player("Bot", Symbol.X);

        Game game= new Game(player1,player2);
        game.play();
    }
}
