// UIL 2006 - Regional Programming Contest
//
// skyline.java
//
// The purpose of this problem is to test contestant
// ability to manipulate 3-dimensional arrays.
//

import java.io.*;
import java.util.*;

public class skyline {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("skyline.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {
         int maxheight = 0;
         int size = infile.nextInt();
         infile.nextLine();

         // downtown[height][south][east]
         boolean[][][] downtown = new boolean[9][size][size];

         // recreate a 3D logical representation of downtown
         for (int s=0; s<size; s++) {
            String line = infile.nextLine();
            for (int e=0; e<size; e++) {
               int height = ((int)line.charAt(e)) - 48;
               for (int h=0; h<height; h++) {
                  downtown[h][s][e] = true;
               }
               if (height > maxheight) { maxheight = height; }
            }
         }

         // now print the view from the west
         System.out.println("Data Set #" + (i+1));
         for (int h = maxheight - 1; h>=0; h--) {
            for (int s = 0; s < size; s++) {
               int e;
               for (e = 0; ; e++) {
                  if (e == size) {
                     System.out.print(".");
                     break;
                  }
                  if (downtown[h][s][e]) {
                     System.out.print(e+1);
                     break;
                  }
               }
            }
            System.out.println("");
         }
      }
   }
}
