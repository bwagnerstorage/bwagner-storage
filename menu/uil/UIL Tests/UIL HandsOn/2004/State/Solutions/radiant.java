import java.lang.*;
import java.io.*;

/**
 * Write a description of class radiant here.
 * 
 * @author James Goodwin 
 * @version 1.0
 */
public class radiant
{
    public static void main(String args[])
    {
        int datasets;
        UILFileReader input = new UILFileReader("radiant.dat");

        datasets = input.readInt();
        
        for (int i = 0; i < datasets; i++)
        {
            String line;
            int candidate, base;
            int convertedNum;
            boolean prime;
            
            // Read in the candidate and the base
            candidate = input.readInt();
            base = input.readInt();
            
            // Display the primality
            if (isPrime(convert(candidate,base)))
            {
                System.out.println("prime");
            }
            else
            {
                System.out.println("non-prime");
            }
        }
    }

    private static boolean isPrime(int candidate)
    {
        // Check for the special case
        if (candidate == 1) return false;

        // We only have to check up to the square root of candidate, but
        // in this case the time needed to remember how to do square roots
        // in Java is prohibitive.
        for (int factor = 2; factor < candidate; factor++)
        {
            if (((candidate/factor)*factor) == candidate) return false;
        }
        return true;
    }

    // This performs the base conversions and flipping
    private static int convert(int candidate, int base)
    {
        String oldString, newString;
        char oldArray[], newArray[];
        
        // Create a string in the new base
        oldString = Integer.toString(candidate,base);
        
        // Reverse the string
        oldArray = oldString.toCharArray();
        newArray = oldString.toCharArray();
        for (int i = 0; i < oldArray.length; i++)
        {
            newArray[i] = oldArray[(oldArray.length-i)-1];
        }
        newString = String.copyValueOf(newArray);
        
        // Convert back to a number
        return Integer.parseInt(newString,base);
    }
}
