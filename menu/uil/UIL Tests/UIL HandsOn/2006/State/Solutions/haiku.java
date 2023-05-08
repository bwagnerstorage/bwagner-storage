import java.util.Scanner;
import java.util.regex.*;
import java.io.File;
import java.io.IOException;

public class haiku
{
    public static void main(String[] args) throws IOException
    {
        Scanner s = new Scanner(new File("haiku.in"));
        int numDataSets, numLines;
        int a, b, j, Fn1, Fn2, newFn1;
        boolean isGFH;
        String line;

	numDataSets = s.nextInt();
        
        for(int i = 0; i < numDataSets; i++)
        {
           numLines = s.nextInt();
           s.nextLine();

           line = s.nextLine();
           a = numSyllables(line);

           line = s.nextLine();
           b = numSyllables(line);

           for(j = 2, Fn1 = b, Fn2 = a, isGFH = true; j < numLines; j++)
           {
               line = s.nextLine();
               newFn1 = numSyllables(line);
               if(newFn1 == Fn1 + Fn2)
               {
                  Fn2 = Fn1;
                  Fn1 = newFn1;
               }
               else
                  isGFH = false;
           }
           if(isGFH)
              System.out.println(a + " " + b);
           else
              System.out.println("NOT A GENERALIZED FIBONACCI HAIKU");
        }
    }
    static int numSyllables(String line)
    {
        int num = 0;
        Pattern p = Pattern.compile("[aeiouyAEIOUY]");
        Matcher m = p.matcher(line);
        while(m.find())
           num++;
        return num;
    }
}

