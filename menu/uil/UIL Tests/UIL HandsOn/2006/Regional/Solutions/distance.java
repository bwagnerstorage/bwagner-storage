// UIL 2006 - Regional Programming Contest
//
// distance.java
//
// The purpose of this problem is to test: 
//    choosing the best of several alternatives
//    reading formatted input
//    writing formatted output
//

import java.io.*;
import java.util.*;

class plan {
   String name;
   int minutes;
   float monthly;
   float additional;
   float cost;
}

public class distance {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("distance.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {
 
         int numPlans   = infile.nextInt();
         int numCallers = infile.nextInt();
         infile.nextLine();

         // print the header
         System.out.println("Data set #" + (i+1));

         // read in the plans
         plan planArray[] = new plan[numPlans];
         for (int p=0; p<numPlans; p++) {
            planArray[p] = new plan();

            infile.next(); // throw away token "Plan"
            planArray[p].name       = infile.next();
            planArray[p].minutes    = infile.nextInt();
            planArray[p].monthly    = 
               (new Float(infile.next().substring(1))).floatValue();
            planArray[p].additional = 
               (new Float(infile.next().substring(1))).floatValue();
            infile.nextLine();
         }

         // process the callers
         for (int c=0; c<numCallers; c++) {
            String caller = infile.next();
            int minutes   = infile.nextInt();
            infile.nextLine();

            //calculate the cost of each plan
            plan lowcostplan = null;
            for (int p=0; p<numPlans; p++) {
               plan myplan = planArray[p];

               int overage = minutes - myplan.minutes;
               if (overage < 0) { overage = 0; }

               myplan.cost = myplan.monthly + 
                            (myplan.additional * (float)overage);
               
               if (lowcostplan == null ||
                  lowcostplan.cost > myplan.cost)
               {
                  lowcostplan = myplan;
               }
            }

            //output the cheapest plan info
            System.out.printf(
                  "%s should choose plan %s for $%.2f per month.\n",
                  caller, lowcostplan.name, lowcostplan.cost ); 
         }
      }
   }
}
