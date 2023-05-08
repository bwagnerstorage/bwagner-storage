/*
 * Contest: 2010 UIL
 *
 * Author: James Goodwin
 */

import java.util.*;
import java.io.*;
import java.awt.*;

public class Unite4 {

    static char[][] Board;
    static boolean redsMove;

    public static void main(String[] args) throws Exception {

        // Allocate the board
        Board = new char[7][8]; // 6+1 rows, 7+1 cols

        // Create a new scanner
        Scanner sin = new Scanner(new File("unite4.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            // how many moves?
            int numMoves = sin.nextInt(); 
            sin.nextLine();

            // process the moves
            clearBoard();
            redsMove = true;
            for (int i = 0; i < numMoves; i++) {
               doMove(sin.nextInt());
            }
            sin.nextLine();

            // display the winner
            showBoard();
            showWinner();

        }
        sin.close();
    }

    private static void showWinner () {

        char lastChip;
        int inARow;

        // check for horizontal win
        lastChip = 'O';
        inARow = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 8; j++) {
                if (Board[i][j] != 'O') {
                    if (Board[i][j] == lastChip) {
                        if (inARow == 3) {
                            if ( lastChip == 'R' ) {
                                System.out.println("RED WINS"); return;
                            }
                            else {
                                System.out.println("BLACK WINS"); return;
                            }
                        }
                        inARow++;
                    }
                    else {
                        lastChip = Board[i][j];
                        inARow = 1;
                    }
                }
                else {
                    lastChip = 'O';
                    inARow = 0;
                }
            }
            lastChip = 'O';
            inARow = 0;
        }

        // check for vertical win
        lastChip = 'O';
        inARow = 0;
        for (int j = 1; j < 8; j++) {
            for (int i = 1; i < 7; i++) {
                if (Board[i][j] != 'O') {
                    if (Board[i][j] == lastChip) {
                        if (inARow == 3) {
                            if ( lastChip == 'R' ) {
                                System.out.println("RED WINS"); return;
                            }
                            else {
                                System.out.println("BLACK WINS"); return;
                            }
                        }
                        inARow++;
                    }
                    else {
                        lastChip = Board[i][j];
                        inARow = 1;
                    }
                }
                else {
                    lastChip = 'O';
                    inARow = 0;
                }
            }
            lastChip = 'O';
            inARow = 0;
        }

        // check for diagonal win, (top-left to bottom-right)
        lastChip = 'O';
        inARow = 0;
        for (int col = -4; col < 5; col++) {
            int i = 1;
            int j = col;
            for (; j < 8; j++,i++ ) {
                if (j < 1 || i > 6) continue;
                if (Board[i][j] != 'O') {
                    if (Board[i][j] == lastChip) {
                        if (inARow == 3) {
                            if ( lastChip == 'R' ) {
                                System.out.println("RED WINS"); return;
                            }
                            else {
                                System.out.println("BLACK WINS"); return;
                            }
                        }
                        inARow++;
                    }
                    else {
                        lastChip = Board[i][j];
                        inARow = 1;
                    }
                }
                else {
                    lastChip = 'O';
                    inARow = 0;
                }
            }
            lastChip = 'O';
            inARow = 0;
        }

        // check for diagonal win, (bottom-left to top-right)
        lastChip = 'O';
        inARow = 0;
        for (int row = 1; row < 10; row++) {
            int i = row;
            int j = 1;
            for (; i > 0; j++,i-- ) {
                if (i > 6 || j > 7) continue;
                if (Board[i][j] != 'O') {
                    if (Board[i][j] == lastChip) {
                        if (inARow == 3) {
                            if ( lastChip == 'R' ) {
                                System.out.println("RED WINS"); return;
                            }
                            else {
                                System.out.println("BLACK WINS"); return;
                            }
                        }
                        inARow++;
                    }
                    else {
                        lastChip = Board[i][j];
                        inARow = 1;
                    }
                }
                else {
                    lastChip = 'O';
                    inARow = 0;
                }
            }
            lastChip = 'O';
            inARow = 0;
        }

        System.out.println("NO WINNER YET"); return;
    }

    private static void showBoard () {

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(Board[i][j]);
            }
            System.out.println("");
        }
    }

    private static void doMove (int col) {

        int row=6;
        while (Board[row][col] != 'O') {
            row--;
        }
        Board[row][col] = redsMove ? 'R' : 'B';

        // swap moves
        redsMove = !redsMove;
    }

    private static void clearBoard () {

        Board[0][0] = ' ';
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                if ( i == 0 ) {
                    if ( j == 0 ) {
                        Board[i][j] = ' ';
                    }
                    else {
                        Board[i][j] = (char) ((int)'0'+j);
                    }
                }
                else if ( j == 0 ) {
                    Board[i][j] = (char) ((int)'0'+i);
                }
                else {
                    Board[i][j]='O';
                }
            }
        }
    }

}
