// UIL 2006 - Regional Programming Contest
//
// dinner.java
//
// The purpose of this problem is to test contestant
// ability to perform a simulation.
//

import java.io.*;
import java.util.*;

public class dinner {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("dinner.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {

         int numDogs    = infile.nextInt();
         int numRabbits = infile.nextInt();
         int numCarrots = infile.nextInt();
         int numDays    = infile.nextInt();
         infile.nextLine();

         for (int day=0; day<numDays; day++) {

            // rabbits eat carrots
            numCarrots -= numRabbits*3;
            if (numCarrots < 0) {
               numRabbits -= (Math.abs(numCarrots) + 2) / 3;
               numCarrots = 0;
            }

            // dogs eat rabbits
            numRabbits -= numDogs*2;
            if (numRabbits < 0) {
               numDogs -= (Math.abs(numRabbits) + 1) / 2;
               numRabbits = 0;
            }
         }

         System.out.println(numDogs + " " + numRabbits + " " + numCarrots);

      }
   }
}
