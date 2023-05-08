// UIL 2006 - Regional Programming Contest
//
// count.java
//
// The purpose of this problem is to test contestant
// ability to read input from a file and use arrays
// (or more complicated structures)
//

import java.io.*;
import java.util.*;


public class count {
   
   public static final int ASCII_a = 97;

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("count.in") );

      int charCount[] = new int[26];

      int numLines = infile.nextInt();
      infile.nextLine();

      // zero character counts
      for (int i=0; i<26; i++) {
         charCount[i] = 0;
      }

      // count the letters
      for (int l=0; l<numLines; l++) {

         // convert next line to lower case
         String line = new String( infile.nextLine().toLowerCase() );

         for (int i=0; i<line.length(); i++) {

            if ( Character.isLetter( line.charAt(i) ) ) {
               charCount[(line.charAt(i))-ASCII_a]++;
            }

         }

      }

      // output the results
      for (int i=0; i<26; i++) {
         System.out.println( ((char)(ASCII_a+i)) + " " + charCount[i] );
      }
   }
}
