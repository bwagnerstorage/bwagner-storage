// UIL 2006 - Regional Programming Contest
//
// triage.java
//
// The purpose of this problem is to test contestant
// ability to perform a simulation using priority queues.
// Whether the Java ADT for a priority queue is directly
// used does not matter.  Solutions will have to
// determine which patient in the waiting room has the
// highest priority in some fashion, and that counts.
//

import java.io.*;
import java.util.*;

class patient implements Comparable<patient> {
   int arrived;
   int priority;
   int duration;
   public patient (int a, int p, int d) {
      arrived  = a;
      priority = p;
      duration = d;
   }
   public int compareTo (patient p) {
      if (this.priority != p.priority) {
         return (this.priority - p.priority);
      }
      return (this.duration - p.duration);
   }
}

public class triage {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("triage.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {
         int treatmentEndTime = 0;
         int numPatients = infile.nextInt();
         infile.nextLine();

         PriorityQueue<patient> waiting = new PriorityQueue<patient>();
         LinkedList<patient> arrivals = new LinkedList<patient>();
         patient beingTreated = null;
         for (int p=0; p<numPatients; p++) {
            arrivals.add(new patient(infile.nextInt(), 
                                     infile.nextInt(), 
                                     infile.nextInt()));
            infile.nextLine();
         }

         // get everyone treated
         int time=0;
         while ((waiting.size() + arrivals.size()) > 0) {

            // we only get here when nobody is being treated
            // the first thing to do is check the waiting room
            // GET THE HIGHEST PRIORITY PERSION TO THE OR
            if (waiting.size() == 0) {

               // have everyone arriving at the 
               // next tick go to the waiting room
               time = arrivals.peek().arrived;
               while (arrivals.size() > 0 &&
                      arrivals.peek().arrived == time) {
                  waiting.add(arrivals.poll());
               }
            }

            // now we know someone is in the waiting room and
            // nobody is being treated, so let's treat someone!
            beingTreated = waiting.poll();
            treatmentEndTime = time + beingTreated.duration;

            // now, we need to keep processing arrivals into the
            // waiting room until the current treatment is complete
            // or until a higher priority case arrives.
            while (true) {
               if (arrivals.size() == 0 ||
                   arrivals.peek().arrived >= treatmentEndTime) {
                  time = treatmentEndTime;
                  beingTreated = null; 
                  break;
               }
               time = arrivals.peek().arrived;
               while (arrivals.size() > 0 &&
                      arrivals.peek().arrived == time) {
                  waiting.add(arrivals.poll());
               }
               if (waiting.peek().priority < beingTreated.priority) {
                  waiting.add(beingTreated);
                  beingTreated = null;
                  break;
               }
            }

            // at this point, nobody is being treated, so it's
            // time to go back to the top of the loop.
         }

         // if we're here, then the treatmentEndTime has already
         // been calculated for the final patient.
         System.out.println(treatmentEndTime);
      }
   }
}
