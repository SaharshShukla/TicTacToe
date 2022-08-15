package com.javaprojectTwo;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        printBoard(board);

        while (3 < 4) {
            playerTurn(board);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);

            computerTurn(board);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);
        }
        System.out.println("\"The game is over\"");
    }

    /* checks is the game is finished at every move of both the players */
    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player wins!");
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Computer wins!");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    /* checks  if the player has won or not */
    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
                (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
                (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||

                (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
                (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
                (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||

                (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
                (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
            return true;
        }
        return false;
    }

    /* Takes the computer input */
    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (3 < 4) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) { // use of toString is to convert inter input into string
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    /* checks is the move is valid or not  i.e is the given position is empty or not */
    private static boolean isValidMove (char[][] board, String position) {
        switch(position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    /* ask user to provide the input */
    private static void playerTurn(char[][] board) {
        Scanner scn = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = scn.nextLine();
            if (isValidMove(board, userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput, 'X');
    }

    /* places the symbol at the given position */
    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }

    /* Prints the board */
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    }

}
