/*
 * Contest: 2010 UIL (district)
 *
 * Author: James Goodwin
 *
 * Notes: This problem is a variant of the well-known Knapsack Problem.
 *        For some background on this class of problem, you might want to
 *        check out the article on Wikipedia:
 *
 *           http://en.wikipedia.org/wiki/Knapsack_problem
 *
 *        This is not exactly the same problem, but it is close enough that
 *        there is not an elegant solution. We have to write something
 *        relatively brute force, and hope that the size of the data sets we
 *        are given is small.  For very large data sets, any solution could,
 *        quite literally, run until the sun burns out without finding an
 *        optimal solution.
 *
 *        Note that dynamic programming could be used to speed this up, but
 *        we do not expect students at UIL to have developed that skill.
 */

import java.util.*;
import java.io.*;
import java.awt.*;

public class Convoy {

    static final int MAX_TRUCKS = 10;
    static final int MAX_WEIGHT = 42;
    static int numTrucks; 
    static int numTrucksAllocated;
    static int[] Weight;
    static int[] Group;

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

        // Create a new scanner
        Scanner sin = new Scanner(new File("convoy.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            // read in the convoy size
            numTrucks = sin.nextInt(); 

            // read in the convoy weights
            Weight = new int[numTrucks];
            Group  = new int[numTrucks];
            for (int i = 0; i < numTrucks; i++) {
               Weight[i] = sin.nextInt();
               Group[i] = -1; // means this truck is unassigned
            }
            sin.nextLine();

            // now lets find the best-case scenario
            numTrucksAllocated = 0;
            System.out.println(solution(1,0));

        }
        sin.close();
    }

    // Now we actually have to solve this.  Darn.
    private static int solution(int currentGroup, int weightOfCurrentGroup) {

        // Ok, now all we do is add the next truck to it's
        // appropriate group.  Actually, we add *every* truck
        // to the current group (if possible), or to a new 
        // group (if necessary).  We then recursively call ourselves,
        // terminating when we either realize that the current avenue
        // is going to be fruitless or when we have assigned all the
        // trucks to a group.  We keep track of the smallest number of
        // groups that we're able to make, and viola, we have the answer.

        int minGroupsFound = MAX_TRUCKS;

        // always check the termination condition first...
        if (numTrucksAllocated == numTrucks) {
            return currentGroup;
        }

        // now try allocating all the unallocated trucks...
        for (int truck = 0; truck < numTrucks; truck++) {

            int thisTry;
            int newGroup = currentGroup;
            int newWeight = weightOfCurrentGroup;

            // skip allocated trucks
            if (Group[truck] != -1) continue;

            // do we need to start a new group?
            if (Weight[truck] + weightOfCurrentGroup > MAX_WEIGHT) {

                // if we've found a better solution, skip this
                // whole line of investigation...
                if ( newGroup+1 == minGroupsFound ) return MAX_TRUCKS;

                // start the new group
                newGroup++;
                newWeight=0;
            }

            // allocate this truck
            newWeight += Weight[truck];
            Group[truck] = newGroup;
            numTrucksAllocated++;

            // now solve the rest of the problem...
            thisTry = solution(newGroup, newWeight);
            if (thisTry < minGroupsFound) {
                minGroupsFound = thisTry;
            }

            // remove this truck
            newWeight -= Weight[truck];
            Group[truck] = -1;
            numTrucksAllocated--;

        }

        return minGroupsFound;

    }
}
