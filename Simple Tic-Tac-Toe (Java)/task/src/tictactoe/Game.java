package tictactoe;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    int[][] board = new int[3][3];

    char[] pieces = {' ','X','O'};

    int countX = 0; // X == 1
    int countO = 0; // O == 2
    int winX = 0;
    int winO = 0;
    boolean isImpossible = false;

    void displayBoard() {
        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(pieces[board[i][j]] + " "); // X|O|" "
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    /*
     returns 0: when game not finished
             1: when X won
             2: when O won
             3: when draw
            -1: when impossible
     */
    int analyzeBoard() {
        winO = 0;
        winX = 0;
        if ( countO > countX + 1 || countX > countO + 1) {
            isImpossible = true;
            return -1;
        }
        if (!isImpossible) {
            if (board[0][0] == board[0][1] &&  board[0][1] == board[0][2]) {
                if (board[0][0] == 1) {
                    winX++;
                } else if (board[0][0] == 2) {
                    winO++;
                }
            }
            if (board[0][0] == board[1][0] &&  board[1][0] == board[2][0]) {
                if (board[0][0] == 1) {
                    winX++;
                } else if (board[0][0] == 2) {
                    winO++;
                }
            }
            if (board[0][0] == board[1][1] &&  board[1][1] == board[2][2]) {
                if (board[0][0] == 1) {
                    winX++;
                } else if (board[0][0] == 2) {
                    winO++;
                }
            }
            if (board[0][1] == board[1][1] &&  board[1][1] == board[2][1]) {
                if (board[0][1] == 1) {
                    winX++;
                } else if (board[0][1] == 2) {
                    winO++;
                }
            }
            if (board[0][2] == board[1][2] &&  board[1][2] == board[2][2]) {
                if (board[0][2] == 1) {
                    winX++;
                } else if (board[0][2] == 2) {
                    winO++;
                }
            }
            if (board[0][2] == board[1][1] &&  board[1][1] == board[2][0]) {
                if (board[0][2] == 1) {
                    winX++;
                } else if (board[0][2] == 2) {
                    winO++;
                }
            }
            if (board[1][0] == board[1][1] &&  board[1][1] == board[1][2]) {
                if (board[1][0] == 1) {
                    winX++;
                } else if (board[1][0] == 2) {
                    winO++;
                }
            }
            if (board[2][0] == board[2][1] &&  board[2][1] == board[2][2]) {
                if (board[2][0] == 1) {
                    winX++;
                } else if (board[2][0] == 2) {
                    winO++;
                }
            }
        }
        if (winX > 1 || winO > 1 || winX > 0 && winO > 0) {
            isImpossible = true;
            return -1;
        }

        if (winX > 0) {
            System.out.println("X wins");
            return 1;
        } else if (winO > 0) {
            System.out.println("O wins");
            return 2;
        } else if (countO + countX == 9) {
            System.out.println("Draw");
            return 3;
        }
        return 0;
    }

    Game(String input) {
        countX = 0;
        countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int tile = 0;
                char c = input.charAt(i * 3 + j);
                if (c == 'X') {
                    tile = 1;
                    this.countX++;
                } else if (c == 'O') {
                    tile = 2;
                    this.countO++;
                }
                this.board[i][j] = tile;
            }
        }
    }

    int playerMove(int player) {
        int x;
        int y;

        String xinp = scanner.next();
        String yinp = scanner.next();

        try {
            x = Integer.parseInt(xinp);
            y = Integer.parseInt(yinp);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return -1;
        }
        if (x < 1 || y < 1 || x > 3 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return -1;
        }
        if (board[x-1][y-1] == 0) {
            board[x - 1][y - 1] = player;
            if (player == 1) {
                countX++;
            } else {
                countO++;
            }
            return 0;
        }
        System.out.println("This cell is occupied! Choose another one!");
        return -1;
    }
}
