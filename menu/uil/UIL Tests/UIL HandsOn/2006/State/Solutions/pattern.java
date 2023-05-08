import java.util.Scanner;
import java.util.regex.*;
import java.io.File;
import java.io.IOException;

public class pattern
{
   public static void main(String[] args) throws IOException
   {
       Scanner s = new Scanner(new File("pattern.in"));
       Matcher m;
       Pattern p;
       int numDataSets, numPatterns, numLines, startIndex, endIndex;
       String patterns[];
       String inLines[];
       String outLines[];
char newLine[];

numDataSets = s.nextInt();
       
       for(int i = 0; i < numDataSets; i++)
       {
          System.out.println("Data Set #" + (i+1));
          numPatterns = s.nextInt();
          numLines = s.nextInt();

          //Skip to next line
          s.nextLine();

          patterns = new String[numPatterns];
          for(int j = 0; j < numPatterns; j++)
          {
              patterns[j] = s.nextLine();
              //Java uses \S to match a non-whitespace character in regular expressions,
              //Our input is using ?; so, replace them
              patterns[j] = patterns[j].replaceAll("\\?", "\\\\S");
          }

          inLines = new String[numLines];
          outLines = new String[numLines]; 
          for(int j = 0; j < numLines; j++)
          {
              inLines[j] = s.nextLine();
              outLines[j] = new String(inLines[j]);
              //Replace non-white space characters in output sentence with * for now
              //(fill in matching patterns as we find them)
              outLines[j] = outLines[j].replaceAll("\\S", "*");
              for(int k = 0; k < numPatterns; k++)
              {
                  p = Pattern.compile(patterns[k]);
                  m = p.matcher(inLines[j]);
                  
                  while(m.find())
                  {
                      //We found a matching pattern; get its substring indices and replace the matching
                      //substring in the line we're going to output
                      startIndex = m.start();
                      endIndex = m.end();
                      newLine = outLines[j].toCharArray();
                      inLines[j].getChars(startIndex, endIndex, newLine, startIndex);
                      outLines[j] = String.valueOf(newLine);
                  }
              }
              System.out.println(outLines[j]);               
          }
       }
   }
}

