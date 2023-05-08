
import java.util.*;
import java.io.*;

public class WordSearch
{
  public static boolean findDiagonal (char[][] a, String w)
  {
    boolean isFound = false;
    StringBuffer buf = new StringBuffer (w);
    String revW = (buf.reverse()).toString();

    int dim = a.length;
    int len = w.length();

    // diagonal top left to lower right
    for (int i = 0; i <= (dim - len); i++)
    {
      String dia = "";
      for (int j = 0; j < dim - i; j++)
      {
        dia = dia + a[i+j][j];
      }
      int jdx = dia.indexOf (w);
      if (jdx >= 0)
      {
        isFound = true;
	System.out.println (w + " " + (i + 1 + jdx) + " " + (jdx + 1));
	return isFound;
      }
      jdx = dia.indexOf (revW);
      if (jdx >= 0)
      {
        int idx = i + jdx + revW.length();
        jdx = jdx + revW.length();
	isFound = true;
	System.out.println (w + " " + idx + " " + jdx);
	return isFound;
      }
    }

    for (int j = 0; j <= (dim - len); j++)
    {
      String dia = "";
      for (int i = 0; i < dim - j; i++)
      {
        dia = dia + a[i][i+j];
      }
      int idx = dia.indexOf (w);
      if (idx >= 0)
      {
        isFound = true;
	System.out.println (w + " " + (idx + 1) + " " + (idx + j + 1));
	return isFound;
      }
      idx = dia.indexOf (revW);
      if (idx >= 0)
      {
        isFound = true;
        int jdx = idx + j + revW.length();
	idx = idx + revW.length();
	System.out.println (w + " " + idx + " " + jdx);
	return isFound;
      }
    }

    // diagonal upper right to lower left
    for (int i = 0; i <= (dim - len); i++)
    {
      String dia = "";
      for (int j = dim - 1; j >= i; j--)
      {
        dia = dia + a[dim - 1 + i - j][j];
      }
      int jdx = dia.indexOf(w);
      if (jdx >= 0)
      {
        isFound = true;
	System.out.println (w + " " +  (i + 1 + jdx) + " " + (dim - jdx));
	return isFound;
      }
      jdx = dia.indexOf (revW);
      if (jdx >= 0)
      {
        isFound = true;
	System.out.println (w + " " + (i + jdx + len) + " " + (dim - jdx - len + 1));
	return isFound;
      }
    }
    
    for (int j = dim - 1; j >= len - 1; j--)
    {
      String dia = "";
      for (int i = 0; i <= j; i++)
      {
        dia = dia + a[i][j - i];
      }
      int idx = dia.indexOf(w);
      if (idx >= 0)
      {
        isFound = true;
	System.out.println (w + " " + (idx + 1) + " " + (j + 1 - idx));
	return isFound;
      }
      idx = dia.indexOf(revW);
      if (idx >= 0)
      {
        isFound = true;
        System.out.println (w + " " + (idx + len) + " " + (j - idx - len + 2));
	return isFound;
      }
    }
    return isFound;
  }

  public static boolean findVertical (char[][] a, String w)
  {
    boolean isFound = false;
    StringBuffer buf = new StringBuffer (w);
    String revW = (buf.reverse()).toString();

    for (int j = 0; j < a.length; j++)
    {
      String col = "";
      for (int i = 0; i < a.length; i++)
      {
        col = col + a[i][j];
      }
      int idx = col.indexOf (w);
      if (idx >=0)
      {
        isFound = true;
	System.out.println (w + " " + (idx + 1) + " " + (j + 1));
	return isFound;
      }
      idx = col.indexOf (revW);
      if (idx >= 0)
      {
        idx = idx + revW.length();
	isFound = true;
	System.out.println (w + " " + idx + " " + (j + 1));
	return isFound;
      }
    }
    return isFound;
  }

  public static boolean findHorizontal (char[][] a, String w)
  {
    boolean isFound = false;
    StringBuffer buf = new StringBuffer (w);
    String revW = (buf.reverse()).toString();

    for (int i = 0; i < a.length; i++)
    {
      String row = new String (a[i]);
      int j = row.indexOf (w);
      if (j >= 0)
      {
        isFound = true;
	System.out.println (w + " " + (i + 1) + " " + (j + 1));
	break;
      }
      j = row.indexOf (revW);
      if (j >= 0)
      {
        j = j + revW.length();
        isFound = true;
	System.out.println (w + " " + (i + 1) + " " + j);
	break;
      }
    }

    return isFound;
  }

  public static void findLocation (char[][] a, String w)
  {
    boolean isFound = false;

    isFound = findHorizontal (a, w);

    if (! isFound)
    {
      isFound = findVertical (a, w);
    }

    if (! isFound)
    {
      isFound = findDiagonal (a, w);
    }

    if (! isFound)
    {
      System.out.println (w + " 0 0");
    }
  }

  public static void main (String[] args) throws IOException
  {
    Scanner sc = new Scanner (new File ("wordsearch.dat"));
    int n = sc.nextInt();
    String line = sc.nextLine();

    char[][] a = new char[n][n];  // grid of characters
    for (int i = 0; i < n; i++)
    {
      line = sc.nextLine();
      String[] letters = line.split("\\s+");
      for (int j = 0; j < letters.length; j++)
      {
        a[i][j] = (letters[j]).charAt(0);
      }
    }

    int m = sc.nextInt();
    String[] words = new String[m];
    for (int i = 0; i < m; i++)
    {
      words[i] = sc.next();
    }

    sc.close();

    for (int i = 0; i < m; i++)
    {
      findLocation (a, words[i]); 
    }

  }
}
