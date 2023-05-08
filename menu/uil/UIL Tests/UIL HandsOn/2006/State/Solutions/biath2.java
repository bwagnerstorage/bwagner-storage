// UIL 2006 - State Programming Contest
//
// biath2.java
//
// This problem tests the competitor's ability to reuse biath1.java
// and use basic trig in a program.
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

public class biath2 {

   static int penalty (double inclinationDeg, double yawDeg) {

      // We know:
      //    - the distance to the target center is 50m.
      //    - the diameter of the target is 45mm
      //      (i.e., the radius of the target is 22.5mm)
      //    - the angle of incliation
      //    - the angle of yaw
      // Since a 'straight shot' will hit the target center,
      // we can imagine a right triangle with a long leg being
      // the 50m to the target and the short leg being on the
      // vertical axis passing through the target's center.
      // This triangle can be used to determine the vertical
      // displasement since we know that the tangent of the
      // inclination angle = vertical displacement / 50m.
      // A similar method can be used to determine the horizontal
      // displacement using the yaw angle. 
      // Once we know both the vertical and horizontal displacement
      // of the bullet on the plane of the target, we can treat
      // these as (x,y) coordinates and use the distance formula,
      // d = SQRT(x^2 + y^2), to see if the the bullet passed within
      // the radius of the target, which would indicate a hit.
      //
      // For simplicity, we'll do all calculations in mm.

      double x, y;

      if (inclinationDeg == 0) {
         y = 0;
      }
      else {
         y = 50000 * (Math.tan(Math.toRadians(inclinationDeg)));
      }

      if (yawDeg == 0) {
         x = 0;
      }
      else {
         x = 50000 * (Math.tan(Math.toRadians(yawDeg)));
      }

      // 60 seconds of penalty time if target is missed
      if ( Math.sqrt(x*x+y*y) < 22.5 ) {
         return 0;
      }
      else {
         return 60;
      }

   }

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("biath2.in") );
      infile.useDelimiter("[^a-zA-Z0-9\\.]+");

      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         int numAthletes = infile.nextInt(); infile.nextLine();

         athlete roster[] = new athlete[numAthletes];

         // calculate info for each athlete
         for (int a = 0; a < numAthletes; a++) {
            double inc, yaw;
            roster[a] = new athlete();
            roster[a].name = infile.next();
            roster[a].totalSeconds = infile.nextDouble() 
                                   + 60 * (19 - infile.nextInt())
                                   + penalty (infile.nextDouble(), infile.nextDouble());
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
