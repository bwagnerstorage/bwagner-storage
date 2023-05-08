import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class pager
{
    public static void main(String[] args) throws IOException
    {
        Scanner s = new Scanner(new File("pager.in"));
        int numDataSets;
        int pagerWidth, extraSpace;
        String pagerText;

	numDataSets = s.nextInt();
        
        for(int i = 0; i < numDataSets; i++)
        {
           System.out.println("Data Set #" + (i+1));

           pagerWidth = s.nextInt();

           //Skip single space
           s.skip("\\s");

           //Grab what's between the quotes
           s.useDelimiter("\"");
           pagerText = s.next();

           //Check if extra spaces needed
           extraSpace = pagerWidth - pagerText.length();
           
           if(extraSpace > 0)
           {
              //We need to pad extra spaces to the text

              //First print opening quote
              System.out.print("\"");

              //Then the text
              System.out.print(pagerText.substring(0, pagerText.length()));

              //Then the spaces
              for(int j = 0; j < extraSpace; j++)
                  System.out.print(" ");

              //Finally closing quote
              System.out.println("\""); 
           }
           else
           {
              //Print as much as can fit on the pager each time
              for(int beginIndex = 0; pagerText.length() - beginIndex >= pagerWidth; beginIndex++)
                 System.out.println("\"" + pagerText.substring(beginIndex, beginIndex + pagerWidth) + "\"");
           }

           //Skip to next line
           s.useDelimiter("\\s");
           s.nextLine();
        }
    }
}

