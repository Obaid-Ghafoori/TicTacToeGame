package com.obaid.TicTacToeGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class TicTacToeGameApplication {
    private static char SYMBOL;
    private static int playerPos;
    private static Scanner input;
    private static char[][] gameBoard;
    private static ArrayList<Integer> playerPositions = new ArrayList<>();
    private static ArrayList<Integer> computerPositions = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeGameApplication.class, args);
        makeGameBoard();
    }

    public static void makeGameBoard() {
       gameBoard = new char[][]{
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        printGameBoard(gameBoard);

        while (true) {
            // player enter a number
            input = new Scanner(System.in);
            System.out.println("Enter number from 1 to 9");
            playerPos = input.nextInt();

            while (playerPositions.contains(playerPos) || computerPositions.contains(playerPositions)) {
                System.out.println("this position is taken, try it in other free spot!");
                playerPos = input.nextInt();
            }

            playYourTurn(gameBoard, playerPos, "player");


            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            // let the computer chose a random number
            Random randomizer = new Random();
            int computerPos = randomizer.nextInt(9) + 1;

            while (playerPositions.contains(computerPos) || computerPositions.contains(computerPos)) {
                computerPos = randomizer.nextInt(9) + 1;
            }
            playYourTurn(gameBoard, computerPos, "computer");
            printGameBoard(gameBoard);

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

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

    public static void playYourTurn(char[][] gameBoard, Integer position, String player) {

        if (player.equals("player")) {
            SYMBOL = 'X';
            playerPositions.add(position);

        } else if (player.equals("computer")) {
            SYMBOL = 'O';
            computerPositions.add(position);
        }else {
            System.out.println("this position is taken, try it in other free spot!");
            playerPos = input.nextInt();
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

    public static String checkWinner() {
        String result = "";
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);

        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

        List leftToRightDiagonal = Arrays.asList(1, 5, 9);
        List rightToLeftDiagonal = Arrays.asList(7, 5, 3);

        List<List> wining = new ArrayList<>();
        wining.add(topRow);
        wining.add(midRow);
        wining.add(bottomRow);
        wining.add(leftCol);
        wining.add(midCol);
        wining.add(rightCol);
        wining.add(leftToRightDiagonal);
        wining.add(rightToLeftDiagonal);

        for (List element : wining) {
            if (playerPositions.containsAll(element)) {
                return result = "Congrats player Won!";
            } else if (computerPositions.containsAll(element)) {
                return result = "Congrats computer Won!";
            } else if (playerPositions.size() + computerPositions.size() == 9) {
                return result = "Game is Tie!";
            }
        }


        return result;

    }


}
