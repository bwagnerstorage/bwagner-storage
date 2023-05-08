// UIL 2006 - State Programming Contest
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

enum medal_type { GOLD, SILVER, BRONZE, NONE };

class athlete {
   String name;
   double totalSeconds;
   medal_type medal;
}

public class biath1 {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("biath1.in") );

      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         int numAthletes = infile.nextInt(); infile.nextLine();

         athlete roster[] = new athlete[numAthletes];

         // calculate info for each athlete
         for (int a = 0; a < numAthletes; a++) {
            roster[a] = new athlete();
            roster[a].name = infile.next();
            roster[a].totalSeconds = infile.nextDouble() 
                                   + 60 * (20 - infile.nextInt());
            roster[a].medal = medal_type.NONE;
            infile.nextLine();
         }

         // determine medal winners
         medal_type medalToAward = medal_type.GOLD;

         // loop while we have a medal to award
         while (medalToAward != medal_type.NONE) {

            int best_index;

            // find the next winner
            best_index = -1;
            for (int a = 0; a < numAthletes; a++) {
               if ( roster[a].medal == medal_type.NONE 
                    && ( best_index == -1 
                         || roster[a].totalSeconds 
                         <  roster[best_index].totalSeconds ) ) {
                  best_index = a;
               }
            }

            // award the medal
            roster[best_index].medal = medalToAward;

            // determine next medal to award
            switch (medalToAward) {
               case GOLD:
                  medalToAward = medal_type.SILVER;
                  break;
               case SILVER:
                  medalToAward = medal_type.BRONZE;
                  break;
               case BRONZE:
                  medalToAward = medal_type.NONE;
                  break;
            }
         }

         // output the results
         System.out.println("Data Set #" + (d+1));
         for (int a = 0; a < numAthletes; a++) {
            System.out.printf("%s %.2f", roster[a].name, roster[a].totalSeconds);
            switch (roster[a].medal) {
               case GOLD:
                  System.out.print(" GOLD");
                  break;
               case SILVER:
                  System.out.print(" SILVER");
                  break;
               case BRONZE:
                  System.out.print(" BRONZE");
                  break;
               default:
            }
            System.out.println("");
         }
      }
   }
}
