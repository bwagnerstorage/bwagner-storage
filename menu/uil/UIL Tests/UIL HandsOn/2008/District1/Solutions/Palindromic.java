import java.util.*;
import java.io.*;

public class Palindromic
{
  public static boolean isPalindrome (int n)
  {
    int origN = n;
    int revN = n % 10;
    n = n / 10;
    while (n > 0)
    {
      revN = revN * 10 + (n % 10);
      n = n / 10;
    }
    return (origN == revN);
  }

  public static boolean isSquare (int n)
  {
    int i = 1;
    boolean verified = false;
    while (i < n)
    {
      int j = i + 1;
      int sum = (i * i) + (j * j);
      while ((j <= n) && (sum < n))
      {
        j++;
        sum = sum + (j * j);
      }
      if (sum == n)
      {
        verified = true;
        break;
      }
      i++;
    }
    return verified;
  }

  public static void main (String[] args) throws IOException
  {
    File inFile = new File ("palindromic.dat");
    Scanner sc = new Scanner (inFile);
    int numLines = sc.nextInt();
    for (int i = 0; i < numLines; i++)
    {
      int num = sc.nextInt();
      System.out.print (num + " ");
      if (isPalindrome (num))
      {
        System.out.print ("PALINDROMIC ");
        if (isSquare (num))
        {
          System.out.println ("SQUARE");
        }
        else
        {
          System.out.println ("NOT SQUARE");
        }
      }
      else
      {
        System.out.println ("NOT PALINDROMIC");
      }
    }
    sc.close();
  }
}

