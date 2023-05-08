// UIL 2007 - District B Hands-On Programming Contest
// untris.java
//

import java.io.*;
import java.util.*;

public class untris {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("untris.in") );
      String[] board = new String[9];
      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         for (int i = 0; i < 9; i++) {
             board[i] = infile.next();
             infile.nextLine();
         }

         int numMoves = infile.nextInt(); infile.nextLine();
         for (int i = 0; i < numMoves; i++) {
             int currMove = infile.nextInt();
             int topRow = 8;
             for (int j = 0; j < 9; j++) {
                //Find row to put block in
                if (board[j].charAt(currMove-1) == '#') {
                   topRow = j-1;
                   break;
                }
             }
             //Add block
             board[topRow] = board[topRow].substring(0, currMove-1) +
                             "#" +
                             board[topRow].substring(currMove);
             //Last row is the only one that can be full, check it
             if(board[8].compareTo("#########") == 0) {
                //Move everything down one and set top row to empty
                for (int j = 8; j > 0; j--)
                   board[j] = board[j-1];
                board[0] = ".........";
             }
         }
         infile.nextLine();

         // output the results
         System.out.println("Data Set #" + (d+1));
         for (int i = 0; i < 9; i++) {
            System.out.println(board[i]);
         }
      }
   }
}
