// UIL 2007 - District B Hands-On Programming Contest
//
// graph.java


import java.io.*;
import java.util.*;
import java.util.regex.*;


public class graph {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("graph.in") );

      int numDataSets = infile.nextInt(); infile.nextLine();
      Pattern p = Pattern.compile("#");
      Matcher m;

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {
         int vegCount = 0;
         for (int i = 0; i < 5; i++) {
            m = p.matcher(infile.nextLine());
            while(m.find())
               vegCount++;
         }
         System.out.println(vegCount + " vegetables consumed in week " + (d+1));
      }
   }
}
