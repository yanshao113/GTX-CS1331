import java.util.*;
import java.io.*;

public class Battleship {
    public static void main(String[] args) {
        String error = "Invalid coordinates. Choose different coordinates.";
        String alShip = "You already have a ship there. Choose different coordinates.";
        String alFired = "You already fired on this spot. Choose different coordinates.";
//build ship
        System.out.println("Welcome to Battleship!");
        System.out.println();
        char[][] player1 = new char[5][5];
        char[][] player2 = new char[5][5];
        char[][] player1_hit = new char[5][5];
        char[][] player2_hit = new char[5][5];
        initializeBoard(player1);
        initializeBoard(player2);
        initializeBoard(player1_hit);
        initializeBoard(player2_hit);
        Scanner location = new Scanner(System.in);
        int num_row;
        int num_col;

        for (int user = 1; user <= 2; user++) {
            System.out.println("PLAYER " + user + ", ENTER YOUR SHIPS’ COORDINATES.");
            char[][] currentPlayer;

            if (user == 1) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }

            for (int count = 1; count < 6; count++) {
                System.out.println("Enter ship " + count + " location:");

                if (location.hasNextInt() && (num_row = location.nextInt()) >= 0 && num_row <= 4 && location.hasNextInt() && (num_col = location.nextInt()) >= 0 && num_col <= 4) {
                    if (currentPlayer[num_row][num_col] != '@') {
                        currentPlayer[num_row][num_col] = '@';
                    } else {
                        System.out.println(alShip);
                        count--;
                    }
                } else {
                    System.out.println(error);
                    count--;

                    // Clear the invalid input
                    location.next();
                }
            }

            printBattleShip(currentPlayer);

            for (int new_line = 1; new_line <= 100; new_line++) {
                System.out.println();
            }
        }
// begin hitting
        int count_hit_1 = 0;
        int count_hit_2 = 0;

        for (int round = 1; round <= 5; round++) {
            int user = 1;
            char[][] currentPlayer;
            char[][] currentOpponent;
            char[][] currentPlayerHit;

            if (user == 1) {
                currentPlayer = player1;
                currentOpponent = player2;
                currentPlayerHit = player1_hit;
            } else {
                currentPlayer = player2;
                currentOpponent = player1;
                currentPlayerHit = player2_hit;
            }

            do {
                System.out.println("Player " + user + ", enter hit row/column:");

                if (location.hasNextInt() && (num_row = location.nextInt()) >= 0 && num_row <= 4 && location.hasNextInt() && (num_col = location.nextInt()) >= 0 && num_col <= 4) {
                    char isShip = currentOpponent[num_row][num_col];

                    if (isShip == '@') {
                        System.out.println("PLAYER " + user + " HIT PLAYER " + (user == 1 ? "2" : "1") + "’S SHIP!");
                        currentPlayerHit[num_row][num_col] = 'X';
                        currentPlayer[num_row][num_col] = 'X';
                        printBattleShip(currentPlayerHit);
                        System.out.println();
                        if (user == 1) {
                            count_hit_1 += 1;
                        } else {
                            count_hit_2 += 1;
                        }
                    } else if (isShip == 'X' || isShip == 'O') {
                        System.out.println(alFired);
                        user -= 1;
                    } else {
                        System.out.println("PLAYER " + user + " MISSED!");
                        currentPlayerHit[num_row][num_col] = 'O';
                        currentPlayer[num_row][num_col] = 'O';
                        printBattleShip(currentPlayerHit);
                    }
                } else {
                    System.out.println(error);
                    user -= 1;
                    location.next();
                }

                user += 1;
            } while (user == 1);

            if (round == 4) {
                System.out.println("***Skipping to the last turn***");
                System.out.println();
            } else {
                System.out.println();
            }
        }

        if (count_hit_1 > count_hit_2) {
            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
        } else {
            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
        }
        // final board:
        System.out.println();
        System.out.println("Final board");
        System.out.println();
        printBattleShip(player1);
        System.out.println();
        printBattleShip(player2);
        System.out.println();
        location.close();
    }


    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
    private static void initializeBoard(char[][] board) {
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                board[row][column] = '-';
            }
        }
    }

}

