// UIL 2007 - District B Hands-On Programming Contest
// logic.java
//

import java.io.*;
import java.util.*;
import java.lang.*;

public class logic {
   
   public static void main (String args[]) throws IOException {
      Scanner infile = new Scanner( new File("logic.in") );
      int screen[] = new int[5];
      int i, j, currIndex, nextIndex, currNum, min, numResets;
      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {
         min = 100;
         numResets = currNum = currIndex = 0;
         for (i = 0; i < 5; i++) {
            screen[i] = infile.nextInt(); infile.nextLine();
            if(screen[i] < min) {
               currIndex = i;
               currNum = min = screen[i];
            }
         }
         //Calculate if there was a reset for the smallest number
         if(((currNum-1) % 5) != currIndex)
            numResets = 1;
         else
            numResets = 0;

         //Now calculate resets for next four numbers
         for (i = 0; i < 4; i++) {
            //Find next smallest number
            min = 100;
            nextIndex = 0;
            for (j = 0; j < 5; j++) {
               if(screen[j] < min && screen[j] > currNum) {
                  nextIndex = j;
                  min = screen[j];
               }
            }
            for(;;) {
               //See if we reached the number we were looking for
               if(currNum == min) {
                  //If we don't have a match, add another reset
                  if(screen[currIndex] != min) {
                     numResets++;
                     currIndex = nextIndex;
                  }
                  break;
               }
               if(currIndex < 4 && screen[currIndex] > screen[currIndex+1] &&
                  screen[currIndex+1] < min) {
                  //Next number can't be smaller if it is smaller than min,
                  //do a reset
                  numResets++;
                  currIndex = 0;
                  currNum++;
                  continue;
               }
               if(++currIndex == 5)
                  currIndex = 0;
               currNum++;
            }
         }
         System.out.println(numResets);
      }
   }
}
