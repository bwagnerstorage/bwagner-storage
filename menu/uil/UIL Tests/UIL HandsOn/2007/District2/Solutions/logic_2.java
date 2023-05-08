// UIL 2007 - District A Hands-On Programming Contest
//

import java.io.*;
import java.util.*;

public class logic {

   static final int MAXRESETS=10;

   static int target[] = new int[5];
   static int current[] = new int[5];
   static int minresetstomatch;
   static int maxnum;
   static int resets;

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("logic.in") );

      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {

         // read the target pattern & init starting pattern
         maxnum=5;
         for (int i=0; i<5; i++)
         {
            target[i]=infile.nextInt(); infile.nextLine();
            current[i]=i+1; // start with 1 2 3 4 5
            if (target[i] > maxnum) maxnum=target[i];
         }
         resets = 0;
         minresetstomatch = MAXRESETS;

         // display the result
         System.out.println(min_resets(5,4));

      }
   }

   static int min_resets ( int my_num, int my_pos ) {
      int best_reset, best_noreset, saved_value;

      saved_value = current[my_pos];
      current[my_pos] = my_num;

      if (my_num == maxnum) // primary termination condition
      {
         for (int i=0; i<5; i++) // check for a match
         {
            if (target[i] != current[i]) 
            {
               // no match
               current[my_pos] = saved_value;
               return MAXRESETS;
            }
         }
         // match
         minresetstomatch = resets;
         current[my_pos] = saved_value;
         return resets;
      }

      best_noreset = min_resets ( my_num+1, (my_pos+1)%5 );
      best_reset = MAXRESETS;
      if (my_pos != 4 && resets < minresetstomatch-1)
      {
         ++resets;
         best_reset = min_resets ( my_num+1, 0 );
         --resets;
      }

      current[my_pos] = saved_value;
      if (best_reset < best_noreset) return best_reset;
      else                           return best_noreset;
   }
}
