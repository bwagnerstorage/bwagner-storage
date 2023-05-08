// UIL 2006 - Regional Programming Contest
//
// vowel.java
//
// The purpose of this problem is to test contestant
// ability to read input from a file and use conditional tests.
//

import java.io.*;
import java.util.*;

public class vowel {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("vowel.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {

         String word = new String(infile.nextLine());
         String vORc;

         if (word.substring(0,1).matches("[aeiouAEIOU]")) {
            vORc = "vowel";
         }
         else {
            vORc = "consonant";
         }

         System.out.println(
                         "The word '" + word + "' begins with a " + vORc + ".");
      }
   }
}
