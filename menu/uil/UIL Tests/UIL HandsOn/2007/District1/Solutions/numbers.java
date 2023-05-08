// UIL 2007 - District A Hands-On Programming Contest
//
// biath1.java
//
// This problem tests contestant ability to calculate competitor scores
// and store them until the end of the data set for post-processing.
//
// This also serves as a building block for the biath2 problem if
// competitors write it in a way that can be reused.
//

import java.io.*;
import java.util.*;

// enum for what type of medal an athlete wins

public class numbers {

   private static class number_t {
      String row[];
      number_t ( String row0, 
                 String row1, 
                 String row2, 
                 String row3, 
                 String row4 ) {
         row = new String[5];
         row[0] = row0;
         row[1] = row1;
         row[2] = row2;
         row[3] = row3;
         row[4] = row4;
      }
      public String getRow ( int i ) {
         return row[i];
      }
   }

   public static void main (String args[]) throws IOException {

      number_t numbers[] = new number_t[10];
      numbers[0] = new number_t ( "00000",
                                  "0   0",
                                  "0   0",
                                  "0   0",
                                  "00000" );
      numbers[1] = new number_t ( "  1  ",
                                  " 11  ",
                                  "  1  ",
                                  "  1  ",
                                  "11111" );
      numbers[2] = new number_t ( "22222",
                                  "    2",
                                  "22222",
                                  "2    ",
                                  "22222" );
      numbers[3] = new number_t ( "33333",
                                  "    3",
                                  "  333",
                                  "    3",
                                  "33333" );
      numbers[4] = new number_t ( "4   4",
                                  "4   4",
                                  "44444",
                                  "    4",
                                  "    4" );
      numbers[5] = new number_t ( "55555",
                                  "5    ",
                                  "55555",
                                  "    5",
                                  "55555" );
      numbers[6] = new number_t ( "66666",
                                  "6    ",
                                  "66666",
                                  "6   6",
                                  "66666" );
      numbers[7] = new number_t ( "77777",
                                  "    7",
                                  "    7",
                                  "    7",
                                  "    7" );
      numbers[8] = new number_t ( "88888",
                                  "8   8",
                                  "88888",
                                  "8   8",
                                  "88888" );
      numbers[9] = new number_t ( "99999",
                                  "9   9",
                                  "99999",
                                  "    9",
                                  "99999" );

      Scanner infile = new Scanner( new File("numbers.in") );

      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      String myNumber;
      for (int d = 0; d < numDataSets; d++) {

         myNumber = infile.nextLine();

         for (int row=0; row<5; row++) {
            for (int digit=0; digit < myNumber.length(); digit++) {
               System.out.print(
                  numbers[myNumber.charAt(digit) - 48].getRow(row) + " ");
            }
            System.out.println();
         }
      }
   }
}
