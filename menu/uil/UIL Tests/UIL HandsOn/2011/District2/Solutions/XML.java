/*

  File: XML.java

  Author: Shyamal Mitra

  Date created: 05 Jan 2011

  Date modified: 05 Jan 2011

*/

import java.util.*;
import java.io.*;

public class XML
{
  public static boolean isValid (Scanner sc, int numLines)
  {
    boolean result = true;
    Stack<String> xmlStack = new Stack<String>();
    for (int i = 0; i < numLines; i++)
    {
      String line = sc.nextLine();
      String[] wordList = line.split("\\s+");
      for (int j = 0; j < wordList.length; j++)
      {
        String word = wordList[j];
	if ((word.substring(0,2)).equals("</"))
	{
          String tag = word.substring(2, word.length() - 2);
	  if (xmlStack.empty())
	  {
            result = false;
	  }
	  else
	  {
            String savedTag = xmlStack.pop();
	    if (tag.equals(savedTag))
	    {
              continue;
	    }
	    else
	    {
              result = false;
	    }
	  }
	}
	else if ((word.substring(0,1)).equals("<"))
	{
          String tag = word.substring(1, word.length() - 2);
	  xmlStack.push(tag);
	}
      }
    }
    if (!xmlStack.empty())
    {
      result = false;
    }
    return result;
  }

  public static void main (String[] args) throws IOException
  {
    File inFile = new File ("xml.dat");
    Scanner sc = new Scanner (inFile);
    String line = sc.nextLine();
    int numInput = Integer.parseInt (line);
    for (int i = 0; i < numInput; i++)
    {
      line = sc.nextLine();
      int numLines = Integer.parseInt (line);
      if (isValid (sc, numLines))
      {
        System.out.println ("valid");
      }
      else
      {
        System.out.println ("invalid");
      }
    }
  }
}
