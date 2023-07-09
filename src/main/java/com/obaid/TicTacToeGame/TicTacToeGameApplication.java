package com.obaid.TicTacToeGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeGameApplication {

    public static void main(String[] args) {

        SpringApplication.run(TicTacToeGameApplication.class, args);

		makeGameBoard();
        System.out.println("test ");
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
    }

	public static void printGameBoard(char[][] gameBoard){
		for (char[] row : gameBoard) {
			for (char col : row) {
				System.out.print(col);
			}
			System.out.println();
		}
	}
}
