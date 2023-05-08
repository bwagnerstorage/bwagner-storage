import java.util.*;
import java.io.*;

public class CreditCard
{
  public static int[] makeIntArray (String str)
  {
    int[] a = new int[str.length()];
    for (int i = 0; i < str.length(); i++)
    {
      char ch = str.charAt(i);
      a[i] = (int) (ch - '0');
    }
    return a;
  }

  public static boolean checkValidity (String str)
  {
    int[] a = makeIntArray (str);
    for (int i = 0; i < a.length; i = i + 2)
    {
      int n = a[i] * 2;
      if (n > 9)
      {
        int p = n / 10;
        int q = n % 10;
        n = p + q;
      }
      a[i] = n;
    }
    int sum = 0;
    for (int i = 0; i < a.length; i++)
    {
      sum = sum + a[i];
    }
    return ((sum % 10) == 0);
  }

  public static void main (String[] args ) throws IOException
  {
    // Open file
    File inFile = new File ("creditcard.dat");
    Scanner sc = new Scanner (inFile);

    // Read input and process data
    int num = sc.nextInt();
    for (int i = 0; i < num; i++)
    {
       String str = sc.next();
       if ( checkValidity (str) )
       {
         System.out.println ("VALID");
       }
       else
       {
         System.out.println ("INVALID");
       }
    }

    // Close file
    sc.close();
  }
}

