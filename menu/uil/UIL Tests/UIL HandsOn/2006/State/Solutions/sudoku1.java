// UIL 2006 - State Programming Contest
//
// sudoku1.java
//
// PURPOSE: Shows that teams can perform analysis of 2-D arrays.
//

import java.io.*;
import java.util.*;


public class sudoku1 {
  
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("sudoku1.in") );

      int board[][] = new int[4][4];

      int numBoards = infile.nextInt();
      infile.nextLine();

      // process each of the sudoku boards
      for (int b=0; b<numBoards; b++) {

         // assume the board is valid
         boolean validBoard = true; 
         boolean found[] = new boolean[5];

         // read in the board, checking validity of columns as we go
         for (int row=0; row<4; row++) {
            String line = infile.nextLine();
            for (int col=0; col<4; col++) {
               board[row][col] = Character.digit(line.charAt(col),10);
               if (board[row][col] < 0 || board[row][col] > 4) { 
                  validBoard = false;
               }
            }
         }

         // Check the rows
         for (int row=0; row<4; row++) {

            found[1] = found[2] = found[3] = found[4] = false;

            for (int col=0; col<4; col++) {
               found[board[row][col]] = true;
            }

            if (!found[1] || !found[2] || !found[3] || !found[4]) {
               validBoard = false;
            }

         }

         // Check the columns
         for (int col=0; col<4; col++) {

            found[1] = found[2] = found[3] = found[4] = false;

            for (int row=0; row<4; row++) {
               found[board[row][col]] = true;
            }

            if (!found[1] || !found[2] || !found[3] || !found[4]) {
               validBoard = false;
            }

         }

         // Check the squares
         for (int scol=0; scol <= 2; scol+=2) {
            for (int srow=0; srow <= 2; srow+=2) {

               found[1] = found[2] = found[3] = found[4] = false;

               for (int col=scol; col<scol+2; col++) {
                  for (int row=srow; row<srow+2; row++) {
                     found[board[row][col]] = true;
                  }
               }

               if (!found[1] || !found[2] || !found[3] || !found[4]) {
                  validBoard = false;
               }

            }
         }
         
         // Print the results
         if (validBoard) {
            System.out.println("Board #" + (b+1) + " is valid");
         }
         else {
            System.out.println("Board #" + (b+1) + " is invalid");
         }

      }
   }
}
