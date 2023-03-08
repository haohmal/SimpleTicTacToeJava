package tictactoe;

import java.util.Scanner;

public class Main {
    static String input = "_________";

    static Scanner scanner;

    static int player = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        //input = scanner.nextLine();

        Game ticTacToe = new Game(input);

        ticTacToe.displayBoard();

        while (ticTacToe.analyzeBoard() == 0) {
            while (ticTacToe.playerMove(player) != 0);
            ticTacToe.displayBoard();
            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }
    }
}
