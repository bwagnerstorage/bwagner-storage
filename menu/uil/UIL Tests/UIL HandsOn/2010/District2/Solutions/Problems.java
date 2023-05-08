import java.util.*;
import java.io.*;
import java.awt.*;

public class Problems {

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {
	String written;
        char difficultyChars[];
        int difficultyTotal;

        difficultyChars = new char[3];

        difficultyChars[0] = 'E';
        difficultyChars[1] = 'M';
        difficultyChars[2] = 'H';

        // Create a new scanner
        Scanner sin = new Scanner(new File("problems.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {
            written = sin.nextLine();
            int needed=-1;
            for(int difficulty = 0; difficulty < 3; difficulty++) {
               int currIndex=0;
               difficultyTotal=0;
               //Count the number of problems with this difficulty
               while((currIndex = (written.indexOf(difficultyChars[difficulty],currIndex) + 1)) != 0)
                  difficultyTotal++;
               //The total for two of the difficulties should be 4 and one should be 3
               if(difficultyTotal == 3) {
                  if(needed != -1) {
                     //We already have a difficulty we need
                     needed = -1;
                     break;
                  }
                  needed = difficulty;
                }
                else if(difficultyTotal != 4) {
                   needed = -1;
                   break;
                }
            }
            switch (needed) {
               case -1: System.out.println("Oh well, that's what I get for procrastinating"); break;
               case  0: System.out.println("easy"); break;
               case  1: System.out.println("medium"); break;
               case  2: System.out.println("hard"); break;
            }
            
        }
        sin.close();
    }
}
