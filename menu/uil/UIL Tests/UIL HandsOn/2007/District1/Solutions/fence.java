// UIL 2007 - District A Hands-On Programming Contest
//

import java.io.*;
import java.util.*;

public class fence {

   static final int UP = 0;
   static final int DOWN = 1;
   static final int LEFT = 2;
   static final int RIGHT = 3;

   static final int EMPTY = 0;
   static final int POST  = 1;
   static final int FENCE = 2;

   static int [] [] field = new int[101][101];

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("fence.in") );

      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         int numMoves = infile.nextInt(); infile.nextLine();
         int totalLength = 0;
         int direction = UP;
         int row, col;

         // clear the field
         for (row = 1; row < 101; row++) {
            for (col = 1; col < 101; col++) {
               field[row][col]=EMPTY;
            }
         }

         row = col = 50;

         // draw the fence
         for (int move=0; move < numMoves; move++) {
            int movelen = infile.nextInt();
            char turn = 'L';
            if (move < numMoves-1) turn = infile.next().charAt(0);

            totalLength += movelen;

            field[row][col] = POST;
            switch (direction) {
               case UP:
                  for (int i=0; i<movelen; i++) {
                     field[row-1][col] = FENCE;
                     row-=2;
                  }
                  if (turn == 'L') direction = LEFT;
                  else             direction = RIGHT;
                  break;
               case DOWN:
                  for (int i=0; i<movelen; i++) {
                    field[row+1][col] = FENCE;
                    row+=2;
                  }
                  if (turn == 'L') direction = RIGHT;
                  else             direction = LEFT;
                  break;
               case LEFT:
                  for (int i=0; i<movelen; i++) {
                    field[row][col-1] = FENCE;
                    col-=2;
                  }
                  if (turn == 'L') direction = DOWN;
                  else             direction = UP;
                  break;
               case RIGHT:
                  for (int i=0; i<movelen; i++) {
                    field[row][col+1] = FENCE;
                    col+=2;
                  }
                  if (turn == 'L') direction = UP;
                  else             direction = DOWN;
                  break;
            }
         } 
         int area = 0;

         for (row = 1; row < 101; row+=2) {
            boolean infence = false;
            for (col = 0; col < 101; col+=2) {
               if (field[row][col] == FENCE) infence = !infence;
               if (infence) area++;
            }
         }

         System.out.print("Fence " + (d+1));
         System.out.print(" is " + totalLength + " yards long");
         System.out.print(" and encloses an area of " + area);
         System.out.println(" square yard(s).");

      }
   }
}
