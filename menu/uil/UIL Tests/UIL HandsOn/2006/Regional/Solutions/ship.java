// UIL 2006 - Regional Programming Contest
//
// ship.java
//
// The purpose of this problem is to test contestant
// ability to perform a simulation of a game when
// given the moves.
//

import java.io.*;
import java.util.*;

public class ship {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("ship.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {
         String[] board = new String[10];

         System.out.println ("Data Set #" + (i+1));

         // read in game board
         for (int j=0; j<10; j++) {
            board[j] = infile.nextLine();
         }

         // prep counters
         int C_hitsleft = 5;
         int B_hitsleft = 4;
         int D_hitsleft = 3;
         int S_hitsleft = 3;
         int P_hitsleft = 2;

         // how many shots?
         int numShots = infile.nextInt();
         infile.nextLine();

         // process shots
         for (int s=0; s<numShots; s++) {
            String shot = infile.next();
            int row = ((int)shot.charAt(0)) - 65;
            int col = Integer.parseInt(shot.substring(1)) - 1;
            System.out.print(shot + " ");

            switch (board[row].charAt(col)) {
               case '.':
                  System.out.println("miss");
                  break;
               case 'C':
                  --C_hitsleft;
                  if (C_hitsleft <= 0) 
                     { System.out.println("sank my carrier!"); }
                  else 
                     { System.out.println("hit!"); }
                  break;
               case 'B':
                  --B_hitsleft;
                  if (B_hitsleft <= 0) 
                     { System.out.println("sank my battleship!"); }
                  else 
                     { System.out.println("hit!"); }
                  break;
               case 'D':
                  --D_hitsleft;
                  if (D_hitsleft <= 0) 
                     { System.out.println("sank my destroyer!"); }
                  else 
                     { System.out.println("hit!"); }
                  break;
               case 'S':
                  --S_hitsleft;
                  if (S_hitsleft <= 0) 
                     { System.out.println("sank my submarine!"); }
                  else 
                     { System.out.println("hit!"); }
                  break;
               case 'P':
                  --P_hitsleft;
                  if (P_hitsleft <= 0) 
                     { System.out.println("sank my patrol boat!"); }
                  else 
                     { System.out.println("hit!"); }
                  break;
               default:
                  System.err.println("Bad entry!!!");
            }
         }
         infile.nextLine();
      }
   }
}
