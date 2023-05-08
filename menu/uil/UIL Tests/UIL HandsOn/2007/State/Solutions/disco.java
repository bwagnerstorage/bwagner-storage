// UIL 2007 - State Hands-On Programming Contest
// disco.java
//

import java.io.*;
import java.util.*;

public class disco {

   public static int turn;
   public static int result;
   public static char[][] floor;
   public static char[][] floorB;
   public static int[][] score;
   public static int startRow;
   public static int startCol;

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("disco.in") );
      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         // read in the starting position
         startRow = infile.nextInt();
         startCol = infile.nextInt();
         infile.nextLine();

         // read in the disco
         floor = new char[9][];
         for (int row = 0; row < 9; row++) {
            floor[row] = new char[9];
            String tempString = infile.nextLine();
            for (int col = 0; col < 9; col++) {
               floor[row][col] = tempString.charAt(col);
            }
         }

         calcResult();

         if (result < 0) {
            System.out.println("I'm the next ingredient in disco stew #"
                               + (d+1) + "!");
         }
         else {
            System.out.println("I escaped disco #" + (d+1) + " in " 
                               + result + " turn(s) of the disco ball.");
         }
      }
   }

   // determine the min number of turns of the disco ball to exit
   // put the value in variable 'result'
   private static void calcResult() {

         int stagnantTurns = 0;

         // init the scores for this disco floor
         // these 'scores' indicate the lowest number of turns of
         // the disco ball needed to arrive at that (row,col) of the
         // dance floor.  -1 means infinity.
         score = new int[9][];
         for (int row = 0; row < 9; row++) {
            score [row] = new int[9];
            for (int col = 0; col < 9; col++) {
               score[row][col] = -1;
            }
         }
         score[startRow-1][startCol-1] = 0;  // since this is where we start

         turn = 0;
         while (stagnantTurns < 4 && score[0][0] == -1) {
            int changes = 0, totalchanges = 0;

            // Mark all the locations where we can go from here
            while ((changes=floodFill()) != 0) {
               totalchanges += changes;
            }

            // If we made no progress on this turn, count it
            if (totalchanges == 0) stagnantTurns++;

            // Turn the disco ball
            turnBall();
         }

         result = score[0][0];
   }

   // flood fill
   private static int floodFill() {
      int changes = 0;

      for (int row=0; row <9; row++) {
         for (int col=0; col <9; col++) {
            if (score[row][col] != -1) continue;
            if ( ( row > 0 &&
                   floor[row][col] == floor[row-1][col] &&
                   score[row-1][col] != -1 ) 
               ||( col > 0 && 
                   floor[row][col] == floor[row][col-1] &&
                   score[row][col-1] != -1 )
               ||( row < 8 &&
                   floor[row][col] == floor[row+1][col] &&
                   score[row+1][col] != -1 )
               ||( col < 8 &&
                   floor[row][col] == floor[row][col+1] &&
                   score[row][col+1] != -1 ) )
            {
               score[row][col] = turn;
               changes++;
            }
         }
      }
      return changes;
   }

   // turn the disco ball
   private static void turnBall() {

      floorB = new char[9][9];
  
      for (int row=0; row <9; row++) {
         for (int col=0; col <9; col++) {
            floorB[row][col] = floor[8-col][row];
         }
      }

      floor = floorB;
      turn++;
   }

}
