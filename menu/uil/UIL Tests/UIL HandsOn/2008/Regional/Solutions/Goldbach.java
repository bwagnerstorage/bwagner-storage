import java.util.*;
import java.io.*;

public class Goldbach
{
  public static boolean isPrime (int n)
  {
    int limit = (int)Math.round(Math.sqrt(n));
    for (int i = 2; i <= limit; i++)
    {
      if (n % i == 0)
        return false;
    }
    return true;
  }

  public static void printPrimes (int n)
  {
    int limit = n / 2;
    System.out.print (n);

    for (int i = 2; i < limit; i++)
    {
      if (isPrime(i))
      {
        int j = n - i;
        if (isPrime(j))
        {
          System.out.print (" = " + i + " + " + j);
        }
      }
    }
    System.out.println();
  }

  public static void main (String[] args) throws IOException
  {
    File inFile = new File ("goldbach.dat");
    Scanner sc = new Scanner (inFile);

    int numEntries = sc.nextInt();
    for (int i = 0; i < numEntries; i++)
    {
      int n = sc.nextInt();
      printPrimes (n);
    }
  }
}

