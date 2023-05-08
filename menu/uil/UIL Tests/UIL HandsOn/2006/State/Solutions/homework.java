// UIL 2006 - State Programming Contest
//
// homework.java
//
// PURPOSE: Shows that teams can process multiple input
// data sets and can perform conditional comparisons.
//

import java.io.*;
import java.util.*;


public class homework {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("homework.in") );

      int numLines = infile.nextInt();
      infile.nextLine();

      // process the data sets
      for (int l=0; l<numLines; l++) {

         int A, B, result = 0;
         String operation;

         A  = infile.nextInt();
         operation = infile.next();
         B  = infile.nextInt();
         infile.nextLine();

         switch (operation.charAt(0)) {
            case '+':
               result = A + B;
               break;
            case '-':
               result = A - B;
               break;
            case '*':
               result = A * B;
               break;
         }

         System.out.println(A + " " + operation + " " + B + " = " + result);

      }
   }
}
