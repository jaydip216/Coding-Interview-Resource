package com.lowLevelDesign.tictactoe;

public class Board {
    private char[][] board;
    private int moveCount;

    public Board(){
        board=new char[3][3];
        initializaBoard();
        moveCount=0;
    }

    private void initializaBoard(){
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                board[i][j] = Symbol.DEFAULT.getValue();
            }
        }
    }

    public void makeMove(int row, int col, Symbol symbol){
        if(row<0 || row>2 || col>2 || col<0 || board[row][col]!=Symbol.DEFAULT.getValue()){
            throw new IllegalArgumentException("Invalid move");
        }
        board[row][col]=symbol.getValue();
        moveCount++;
    }

    public boolean isFull(){
        return moveCount == 9;
    }

    public boolean isWinner(Symbol symbol){
        for(int i=0;i<3;i++){
            if(board[i][0] == symbol.getValue() && board[i][1] == symbol.getValue() &&
                    board[i][2] == symbol.getValue()){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if(board[0][i] == symbol.getValue() && board[1][i] == symbol.getValue() &&
                    board[2][i] == symbol.getValue()){
                return true;
            }
        }
        if(board[0][0] == symbol.getValue() && board[1][1] == symbol.getValue() &&
                board[2][2] == symbol.getValue()){
            return true;
        }
        return board[2][0] == symbol.getValue() && board[1][1] == symbol.getValue() &&
                board[0][2] == symbol.getValue();
    }

    public void printBoard(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++)
                System.out.print(board[j][i] + " ");
            System.out.println();
        }
    }
}
