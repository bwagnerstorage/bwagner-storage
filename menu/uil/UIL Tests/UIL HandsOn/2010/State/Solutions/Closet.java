import java.util.*;
import java.io.*;
import java.awt.*;

public class Closet {

    static class clothes {
        int[] givenClothes = new int[MAX_CLOTHES];
        int lowestSoFar;
        Stack <Integer> preserve;
        

        public clothes (int[] inClothes) {

           for(int i=0;i<MAX_CLOTHES;i++)
              givenClothes[i] = inClothes[i];

           lowestSoFar=MAX_CLOTHES;
           preserve=new Stack <Integer>();
        }

        public int leastMoves(int start) {
           //This function finds the size of the longest
           //set of numbers that are "in order", subtracting
           //that from MAX_CLOTHES yields fewest moves needed
           //Ex: 10 9 2 1 4 3 6 5 8 7
           //Either 1 3 5 7 or 2 4 6 8 are the longest
           //in order, thus 6 moves are needed

           int lastNum;

           for(int i=start;i<MAX_CLOTHES;i++) {
             if(preserve.empty())
                lastNum=-1;
             else
                lastNum=((Integer)(preserve.peek())).intValue();

             if(givenClothes[i] > lastNum) {
                preserve.push(Integer.valueOf(givenClothes[i]));
                leastMoves(i+1);
                preserve.pop();
             }
           }

           if(MAX_CLOTHES - preserve.size() < lowestSoFar)
              lowestSoFar=MAX_CLOTHES - preserve.size();

           return lowestSoFar;
        }

    }
    static final int MAX_CLOTHES=10;

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

        int[] currClothes = new int[MAX_CLOTHES];
        clothes theClothes;

        // Create a new scanner
        Scanner sin = new Scanner(new File("closet.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {
            // Get the initial order of clothes
            for(int i = 0; i < MAX_CLOTHES; i++)
               currClothes[i] = sin.nextInt();

            theClothes = new clothes(currClothes);

            System.out.println(theClothes.leastMoves(0));

            sin.nextLine();        
        }
        sin.close();
    }
}
