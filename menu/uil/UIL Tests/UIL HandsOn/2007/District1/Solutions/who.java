// UIL 2007 - District A Hands-On Programming Contest
//

import java.io.*;
import java.util.*;

public class who {

   static String [] person = new String[100];
   static boolean [] [] knows = new boolean[100][100];
   static int numPeople = 0;

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("who.in") );

      int numAssocs = new Integer(infile.next());
      int numTests  = new Integer(infile.next());
      infile.nextLine();

      for (int assoc = 0; assoc < numAssocs; assoc++) {
         addAssoc( infile.next(), infile.next());
         infile.nextLine();
      }

      for (int test = 0; test < numTests; test++) {
         printAssoc(infile.next(), infile.next());
         infile.nextLine(); 
      }
   }

   static void addAssoc ( String name1, String name2 ) {
      int src=-1;
      int target=-1;

      for (int i=0; i < numPeople; i++) {
         if (name1.equals(person[i])) src=i;
         if (name2.equals(person[i])) target=i;
      }

      if (src == -1) {
         person[numPeople] = new String(name1);
         src = numPeople;
         numPeople++;
      }

      if (target == -1) {
         person[numPeople] = new String(name2);
         target = numPeople;
         numPeople++;
      }

      knows[src][target] = true;
      knows[target][src] = true;

      // all-pairs shortest path (modified)
      for (int k=0; k<numPeople; k++) {
         for (int i=0; i<numPeople; i++) {
            for (int j=0; j<numPeople; j++) {
               if (knows[i][k] && knows[k][j]) {
                  knows[i][j] = knows[j][i] = true;
               }
            }
         }
      }
   }

   static boolean isAssoc ( String name1, String name2 ) {
      int src=-1;
      int target=-1;

      for (int i=0; i < numPeople; i++) {
         if (name1.equals(person[i])) src=i;
         if (name2.equals(person[i])) target=i;
      }

      return knows[src][target];
   }

   static void printAssoc ( String name1, String name2 ) {
      if ( isAssoc (name1, name2) ) {
         System.out.println(name1 + " is connected to " + name2);
      } else {
         System.out.println(name1 + " has no known connection to " + name2);
      }
   }
}
