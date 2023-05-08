// Problem start time: 7:40 PM
// Problem end time:

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Shopping
{
    public static double Remaining(double[] prices, boolean[] bools, int position)
    {
        double current = 0.0;
        
        //System.out.printf("--- ");
        for (int i = 0; i < prices.length; ++i)
        {
            if (bools[i])
            {
                current += prices[i];
                //System.out.printf("%.2f ", prices[i]);
            }
        }
        
        double curRem = 200.0 - current;
        if (curRem < 0.0)
            curRem = 9999.0;
        
        //System.out.printf(": %.2f\n", curRem);
        
        ++position;
        if (position < prices.length)
        {
            boolean[] newBools = new boolean[bools.length];
            for (int i = 0; i < bools.length; ++i)
            {
                newBools[i] = bools[i];
            }
            
            double nextY = Remaining(prices, newBools, position);
            newBools[position] = false;
            double nextN = Remaining(prices, newBools, position);
            
            if (nextY < 0.0)
                nextY = 9999.0;
            
            if (nextN < 0.0)
                nextN = 9999.0;
            
            curRem = nextY < curRem ? nextY : curRem;
            curRem = nextN < curRem ? nextN : curRem;
        }
        
        return curRem;
    }
    
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("shopping.dat"));
        
        int numStores = Integer.parseInt(kb.nextLine());
        for (int i = 0; i < numStores; ++i)
        {
            String strLine = kb.nextLine();
            String[] strPrices = strLine.split(" ");

            boolean[] boolsY = new boolean[strPrices.length];
            boolean[] boolsN = new boolean[strPrices.length];
            double[] prices = new double[strPrices.length];
            for (int d = 0; d < prices.length; ++d)
            {
                prices[d] = Double.parseDouble(strPrices[d]);
                boolsY[d] = true;
                boolsN[d] = true;
            }
            
            double remY = Remaining(prices, boolsY, 0);
            boolsN[0] = false;
            double remN = Remaining(prices, boolsN, 0);
            
            double remaining = remY < remN ? remY : remN;
            
            if (remaining < 1.0)
                System.out.printf(".%02d\n", (int)((remaining + 0.005) * 100.0));
            else
                System.out.printf("%.2f\n", remaining);
        }
    }
}
