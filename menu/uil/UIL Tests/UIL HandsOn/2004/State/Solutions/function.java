import java.lang.*;
import java.io.*;

/**
 * @author James Goodwin
 * @version 1.0
 */
public class function
{
    static String reserved = "if,while,for,switch,return";

    public static void main (String args[])
    {
        UILFileReader input = new UILFileReader("function.dat");
        
        while(input.ready())
        {
            // read the next line
            String line = input.readLine();
            
            // process the line
            processLine(line);
        }
    }
    
    private static void processLine(String line)
    {
        int last_brace = 0;
        String substrings[];

        // We'll split this line on open parenthesis first 
        // and then process those substrings individually.
        substrings = line.split("\\(");
        
        for (int i = 0; i < substrings.length - 1; i++)
        {
            processSubstring(substrings[i]);
        }
    }

    private static void processSubstring(String substring)
    {
        String subsubstrings[];
        String candidate;
        
        // If the string has length 0, skip it.
        if (substring.length() == 0) return;
        
        // If the last character isn't alphabetical, then we can skip this substring.
        if (!Character.isLetter(substring.charAt(substring.length()-1))) return;
        
        // If we get here, we know we have a function name to print.
        // Just split the substring on non-alphabetical characters and print
        // the last element of the split.
        subsubstrings = substring.split("[^a-zA-Z]");
        candidate = subsubstrings[subsubstrings.length-1];
        if (!isReserved(candidate))
        {
            System.out.println(candidate);
        }
        return;
    }
    
    private static boolean isReserved(String candidate)
    {
        for (int i=0; i < reserved.split(",").length; i++)
        {
            if (candidate.equals(reserved.split(",")[i])) return true;
        }
        reserved += "," + candidate;
        return false;
    }
}
