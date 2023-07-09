package com.obaid.TicTacToeGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeGameApplication {
    private static char SYMBOL;

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeGameApplication.class, args);
        makeGameBoard();
    }

    public static void makeGameBoard() {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        printGameBoard(gameBoard);

	while(true){
		// player enter a number
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number from 1 to 9");
		int position = input.nextInt();
		System.out.println("Pos: " + position);
		playYourTurn(gameBoard, position, "player");

		// let the compture chose a rondom number
		Random randomizer = new Random();
		int computerPosition = randomizer.nextInt(9) + 1;
		playYourTurn(gameBoard, computerPosition, "computer");
		printGameBoard(gameBoard);
	}

    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void playYourTurn(char[][] gameBoard, int position, String player) {

        if (player.equals("player")) {
            SYMBOL = 'X';
        } else if (player.equals("computer")) {
            SYMBOL = 'O';
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = SYMBOL;
                break;
            case 2:
                gameBoard[0][2] = SYMBOL;
                break;
            case 3:
                gameBoard[0][4] = SYMBOL;
                break;
            case 4:
                gameBoard[2][0] = SYMBOL;
                break;
            case 5:
                gameBoard[2][2] = SYMBOL;
                break;
            case 6:
                gameBoard[2][4] = SYMBOL;
                break;
            case 7:
                gameBoard[4][0] = SYMBOL;
                break;
            case 8:
                gameBoard[4][2] = SYMBOL;
                break;
            case 9:
                gameBoard[4][4] = SYMBOL;
                break;
            default:
                break;
        }
    }
}
