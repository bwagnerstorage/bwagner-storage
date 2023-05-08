// UIL 2006 - Regional Programming Contest
//
// notes.java
//
// The purpose of this problem is to test contestant
// ability to simulate 'infection' of a group using
// a mathematical formula for group contact.
//

import java.io.*;
import java.util.*;

public class notes {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("notes.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {
         int source = infile.nextInt();
         int target = infile.nextInt();
         int time   = 0;

         // only the source person is infected at the start
         boolean[] isInfected = new boolean[101]; // for unit indexing
         isInfected[source] = true;

         // process divisors until target is infected
         while (!isInfected[target]) {
            int divisor = infile.nextInt();

            // spread the infection
            // there are <divisor> groups, made up of:
            //   group 0: 0,   d,   2d,   3d, ...
            //   group 1: 1, 1+d, 1+2d, 1+3d, ...
            //   group x: x, x+d, x+2d, x+3d, ...
            for (int group=0; group<divisor; group++) {
               boolean groupInfected = false;
               for (int member = group; member <= 100; member += divisor) {
                  if (isInfected[member]) {
                     groupInfected = true;
                     break;
                  }
               }
               if (groupInfected) {
                  for (int member = group; member <= 100; member += divisor) {
                     isInfected[member] = true;
                  }
               }
            }

            if (isInfected[target]) { break; }
            time += 5;
         }
         infile.nextLine();

         System.out.println(time + " minutes");
      }
   }
}
