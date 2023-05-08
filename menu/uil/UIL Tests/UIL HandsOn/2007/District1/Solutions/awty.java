// UIL 2007 - District A Hands-On Programming Contest
//
// awty.java
//
// This problem tests contestant ability to perform calculations.
//

import java.io.*;
import java.util.*;


public class awty {
   
   public static final int TRIPLEN=200;  // Whole trip is 200 miles

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("awty.in") );

      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         // do three estimates
         int DistanceTraveled, SecondsTaken;
         double Speed;
         int RemainingSeconds;
         for (int leg=0; leg < 3; leg++) {
            DistanceTraveled  = infile.nextInt();
            SecondsTaken      = infile.nextInt();
            Speed = ((double) DistanceTraveled) / 
                    ((double) SecondsTaken);
            RemainingSeconds = (int) Math.floor(
                                 ((double) (TRIPLEN - DistanceTraveled)) /
                                                  Speed);
            System.out.print(RemainingSeconds + " "); 
         }

         infile.nextLine();
         System.out.println();

      }
   }
}
