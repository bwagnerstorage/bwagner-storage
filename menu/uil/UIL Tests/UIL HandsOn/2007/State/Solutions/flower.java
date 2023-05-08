// UIL 2007 - State Hands-On Programming Contest
// flower.java
//

import java.io.*;
import java.util.*;

public class flower {

   private class plantClass {
      int above;
      int below;
      int x;
      int y;
   }

   public static int yesCount = 0;
   public static int plantCount = 0;
   public static int[] above = new int[100];
   public static int[] below = new int[100];
   public static int[] x = new int[100];
   public static int[] y = new int[100];

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("flower.in") );
      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         // read in the plant count
         plantCount = infile.nextInt(); infile.nextLine();

         // read in the plants
         for (int i = 0; i < plantCount; i++) {
            above[i] = infile.nextInt();
            below[i] = infile.nextInt();
            x[i] = infile.nextInt();
            y[i] = infile.nextInt();
            infile.nextLine();
         }

         if (enoughRoom()) {
            System.out.println("yes");
            yesCount++;
         } else {
            System.out.println("no");
         }
      }

      displayEncrypted(yesCount);

   }

   // returns true if all plants have enough room to grow
   private static boolean enoughRoom() {

      // compare each pair of plants to see if they interfere with each other
      for (int i = 0; i < plantCount; i++) {
         for (int j = i+1; j < plantCount; j++) {

            // determine the distance between the two plants
            int dx = x[i] - x[j];
            int dy = y[i] - y[j];
            double distance = Math.sqrt( dx * dx + dy * dy );

            // make sure it's not less than the sum of the radii
            if (distance < (above[i] + above[j]) ||
                distance < (below[i] + below[j]) ) {
               return false;
            }
         }
      }

      // since no plants are too close, there is enough room
      return true;
   }

   // display the encrypted yes count
   private static void displayEncrypted(int yesCount) {

      Integer yesCountInt = new Integer(yesCount);
      String clearText = yesCountInt.toString();

      // encrypt each character of the count
      for (int i = 0; i < clearText.length(); i++) {

         // get the ASCII value
         int ascii = clearText.charAt(i);

         // flip the bits
         ascii = ascii ^ 0xff;

         // display the value in hexadecimal
         System.out.print(Integer.toHexString(ascii) + " ");
      }

      // end the line
      System.out.println("");
   }
}
