// UIL 2007 - District A Hands-On Programming Contest
//

import java.io.*;
import java.util.*;

public class gravity {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("gravity.in") );

      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         String [] board = new String[10];
         int [] rowcount = new int[10];
         int [] colcount = new int[10];
         char direction;

         // read in the next data set
         for (int row=0; row < 10; row++) {
            board[row]=infile.nextLine();
         }
         direction = infile.nextLine().charAt(0);

         // count the number of rocks in each row and col
         for (int row=0; row < 10; row++) {
            for (int col=0; col < 10; col++) {
               if ( board[row].charAt(col) == '#' ) {
                  ++rowcount[row];
                  ++colcount[col];
               }
            }
         }

         // output the result
         System.out.println("Data Set #" + (d+1));
         for (int row=0; row < 10; row++) {
            for (int col=0; col < 10; col++) {
               switch (direction) {
                  case 'U':
                     if (colcount[col] > row) System.out.print("#");
                     else                     System.out.print(".");
                     break;
                  case 'D':
                     if (colcount[col] > (9-row)) System.out.print("#");
                     else                         System.out.print(".");
                     break;
                  case 'L':
                     if (rowcount[row] > col) System.out.print("#");
                     else                     System.out.print(".");
                     break;
                  case 'R':
                     if (rowcount[row] > (9-col)) System.out.print("#");
                     else                         System.out.print(".");
                     break;
               }
            }
            System.out.println("");
         }
      }
   }
}
