package com.javaProject.TicTacToe;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoardLayout(board);
            System.out.println("Player wins!");
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoardLayout(board);
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
        printBoardLayout(board);
        System.out.println("The game ended in a tie!");
        return true;
    }


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


    private static void computerTurn(char[][] board) {

        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }


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

    private static void playerTurn(char[][] board) {

        Scanner scn = new Scanner(System.in);
        String userInput;
        while (3 < 4) {
            System.out.println("Where would you like to play? (enter in the range  from 1 - 9)");
            userInput = scn.nextLine();
            if (isValidMove(board, userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput, 'X');
    }


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
                System.out.println("Invalid Input");
        }
    }




    private static void printBoardLayout(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    }


    public static void main(String[] args) {

        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        printBoardLayout(board);

        while (1 < 2) {
            playerTurn(board);
            if (isGameFinished(board)){
                break;
            }
            printBoardLayout(board);

            computerTurn(board);
            if (isGameFinished(board)){
                break;
            }
            printBoardLayout(board);
        }

        System.out.println("\"The Game Is Finished!\"");
    }

}

