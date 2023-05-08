// UIL 2006 - Regional Programming Contest
//
// sort.java
//
// The purpose of this problem is to test contestant
// ability to sort data using non-trivial comparison
// operations.
//

import java.io.*;
import java.util.*;

class myword {

   String real_word;
   String rev_word;

   public myword (String input_word) {
      real_word = new String(input_word);

      char[] temp1 = real_word.toCharArray();
      char[] temp2 = new char[temp1.length];
      for (int i=0; i<temp1.length; i++) {
         temp2[i] = temp1[(temp1.length-i)-1];
      }

      rev_word = String.copyValueOf(temp2);
   }
}

public class sort {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("sort.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {
         int numWords = infile.nextInt();
         infile.nextLine();

         myword[] words = new myword[numWords];
         for (int w=0; w<numWords; w++) {
            words[w] = new myword(infile.nextLine());
         }

         //bubble sort
         boolean changed = true;
         while (changed) {
            changed = false;
            for (int w=0; w<(numWords-1); w++) {
               if (words[w].rev_word.compareToIgnoreCase(words[w+1].rev_word) > 0) {
                  changed = true;
                  myword temp_word = words[w];
                  words[w] = words[w+1];
                  words[w+1] = temp_word;
               }
            }
         }

         //display
         System.out.println("Data Set #" + (i+1));
         for (int w=0; w<numWords; w++) {
            System.out.println(words[w].real_word);
         }
      }
   }
}
