import java.io.*;
import java.util.*;

public class DNA
{
  public static void findSequence (String str1, String str2)
  {
    // Make sure that str1 is the larger of the two	  
    if (str1.length() < str2.length())
    {
      String tmp = str1;
      str1 = str2;
      str2 = tmp;
    }

    int len = str2.length();
    boolean found = false;

    // Check for substrings of ever decreasing lengths
    outer: 
      for (int i = len; i > 1; i--)
      {
        for (int j = 0; (i + j) <= len; j++)
        {       
          String subStr = str2.substring (j, i + j);
	  int idx = str1.indexOf (subStr);
	  if (idx >= 0)
	  {  
            found = true;
	    System.out.println (i + " " + subStr);
	    break outer;
	  }
        }
      }

    // If common sequence is not found write that
    if (!found)
    {
      System.out.println ("1");
    }
  }

  public static void main (String[] args) throws IOException
  {
    File inFile = new File ("dna.dat");
    Scanner sc = new Scanner (inFile);

    int num = sc.nextInt();

    // Read file and proccess the string pairs
    for (int i = 0; i < num; i++)
    {
      String str1 = sc.next();
      String str2 = sc.next();
      findSequence (str1, str2);
    }
    sc.close();
  }
}
