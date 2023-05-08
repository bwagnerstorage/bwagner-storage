// UIL 2007 - Regional Hands-On Programming Contest
// pegged.java
//

import java.io.*;
import java.util.*;

public class pegged {

   public static final int MAXMOVES = 10;
   public static char[][] board;

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("pegged.in") );
      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         // read in the board
         board = new char[7][];
         for (int row = 0; row < 7; row++) {
            board[row] = infile.nextLine().toCharArray();
         }

         // display the best score
         System.out.print( "The best score for board #" + (d+1) + " is " );
         System.out.println( bestScore(MAXMOVES) + " points." );
      }
   }

   private static int bestScore( int moves ) {
      int bestSoFar;

      // determine the score for the board as-is
      bestSoFar = scoreBoard();
      if (moves == 0) {
         return bestSoFar;
      }

      // recursively try all possible peg moves
      for (int row = 0; row < 7; row++) {
         for (int col = 0; col < 7; col++) {

            // skip non-peg parts of the board
            if (board[row].length <= col ||
                board[row][col] != 'o') {
               continue;
            }

            // ok, we have found a peg; try each possible move
            // LEFT
            if ( col >= 2 &&
                 board[row][col-1] == 'o' &&
                 board[row][col-2] == '.') {
               int temp;
               board[row][col]   = '.';
               board[row][col-1] = '.';
               board[row][col-2] = 'o';
               temp = bestScore( moves-1 );
               bestSoFar = temp < bestSoFar ? temp : bestSoFar;
               board[row][col]   = 'o';
               board[row][col-1] = 'o';
               board[row][col-2] = '.';
            }

            // RIGHT
            if ( col <= board[row].length - 3 &&
                 board[row][col+1] == 'o' &&
                 board[row][col+2] == '.') {
               int temp;
               board[row][col]   = '.';
               board[row][col+1] = '.';
               board[row][col+2] = 'o';
               temp = bestScore( moves-1 );
               bestSoFar = temp < bestSoFar ? temp : bestSoFar;
               board[row][col]   = 'o';
               board[row][col+1] = 'o';
               board[row][col+2] = '.';
            }

            // UP
            if ( row >= 2 &&
                 col < board[row-1].length &&
                 col < board[row-2].length &&
                 board[row-1][col] == 'o' &&
                 board[row-2][col] == '.') {
               int temp;
               board[row][col]   = '.';
               board[row-1][col] = '.';
               board[row-2][col] = 'o';
               temp = bestScore( moves-1 );
               bestSoFar = temp < bestSoFar ? temp : bestSoFar;
               board[row][col]   = 'o';
               board[row-1][col] = 'o';
               board[row-2][col] = '.';
            }


            // DOWN
            if ( row <= 4 &&
                 col < board[row+1].length &&
                 col < board[row+2].length &&
                 board[row+1][col] == 'o' &&
                 board[row+2][col] == '.') {
               int temp;
               board[row][col]   = '.';
               board[row+1][col] = '.';
               board[row+2][col] = 'o';
               temp = bestScore( moves-1 );
               bestSoFar = temp < bestSoFar ? temp : bestSoFar;
               board[row][col]   = 'o';
               board[row+1][col] = 'o';
               board[row+2][col] = '.';
            }
         }
      }

      return bestSoFar;
   }

   private static int scoreBoard() {

      int score = 0;

      for (int row = 0; row < 7; row++) {
         for (int col = 0; col < 7; col++) {

            // skip non-peg parts of the board
            if (board[row].length <= col ||
                board[row][col] != 'o') {
               continue;
            }

            // score this peg
            if (row == 0 || col == 0 ||
                row == 6 || col == 6) {
               score += 9;
            }
            else if (row == 1 || col == 1 ||
                     row == 5 || col == 5) {
               score += 4;
            }
            else if (row == 2 || col == 2 ||
                     row == 4 || col == 4) {
               score += 1;
            }        
         }
      }

      return score;

   }
}
