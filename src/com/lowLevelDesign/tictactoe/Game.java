package com.lowLevelDesign.tictactoe;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public Game(Player player1, Player player2){
        this.player1=player1;
        this.player2=player2;
        this.board = new Board();
        this.currentPlayer=player1;
    }

    public void play(){
        while (!board.isFull()){
            System.out.println(currentPlayer.getName() + "'s turn.");
            int row = getValidInput("Enter row (0-2): ");
            int col = getValidInput("Enter column (0-2): ");
            try{
                board.makeMove(row, col, currentPlayer.getSymbol());
                board.printBoard();
                if(board.isWinner(currentPlayer.getSymbol())){
                    announceWinner(currentPlayer);
                    return;
                }
                switchPlayer();
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        announceDraw();
    }

    private void switchPlayer(){
        this.currentPlayer = this.currentPlayer==player1 ? player2 : player1;
    }

    private void announceWinner(Player player){
        System.out.println("Winner is "+player.getName());
    }

    private void announceDraw(){
        System.out.println("Game is draw");
    }

    private int getValidInput(String message) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input! Please enter a number between 0 and 2.");
        }
    }
}
