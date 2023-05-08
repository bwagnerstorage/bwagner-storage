// UIL 2007 - District B Hands-On Programming Contest
// scheme.java
//

import java.io.*;
import java.util.*;

public class scheme {
   
   public static void main (String args[]) throws IOException {
      Scanner infile = new Scanner( new File("scheme.in") );
      int numLines;
      String line;
      String[] lastHalfWords;
      char[] schemes;
      char nextScheme;
      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {
         numLines = infile.nextInt(); infile.nextLine();
         lastHalfWords = new String[numLines];
         schemes = new char[numLines];
         nextScheme = 'a';
         for (int i = 0; i < numLines; i++) {
             //Find last word in line
             line = infile.nextLine();
             lastHalfWords[i] = line.substring(line.lastIndexOf(' ')+1);
             //Chop last word in half
             lastHalfWords[i] = lastHalfWords[i].substring(lastHalfWords[i].length() / 2);
             if (i == 0)
                 schemes[i] = 'a';
             else {
                 int j;
                 for (j = 0; j < i; j++) {
                    if (lastHalfWords[j].compareTo(lastHalfWords[i]) == 0) {
                       schemes[i] = schemes[j];
                       break;
                    }
                 }
                 if (j == i)
                    schemes[i] = ++nextScheme;
             }
                 
             System.out.print(schemes[i]);
         }
         System.out.println();
      }
   }
}
