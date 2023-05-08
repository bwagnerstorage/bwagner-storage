
import java.io.File;
import java.io.IOException;
import java.util.*;

public class HardMoney {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("hardmoney.dat"));
        int numSets = s.nextInt();
        for(int i = 1; i <= numSets; i++){
            int goal = s.nextInt();
            // System.out.println(i + " " + goal);
            int[] coinDenominations = new int[s.nextInt()];
            for(int j = 0; j < coinDenominations.length; j++)
                coinDenominations[j] = s.nextInt();
            // System.out.println(Arrays.toString(coinDenominations));
            int ways = numWays(goal, coinDenominations, 0);
            System.out.println(ways);
        }
        s.close();
    }

    private static int numWays(int goal, int[] coinDenominations, int currentDenom) {
        if( goal < 0 || currentDenom == coinDenominations.length )
            return 0;
        else if( goal == 0 )
            return 1;
        else{ 
            int newGoalWithOne = goal - coinDenominations[currentDenom];
            int withOne = numWays(newGoalWithOne, coinDenominations, currentDenom);
            int withNone = numWays(goal, coinDenominations, currentDenom + 1);
            int total = withOne + withNone;
            return total;
        }
    }
}