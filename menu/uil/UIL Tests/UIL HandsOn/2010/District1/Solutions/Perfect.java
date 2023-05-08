
import java.util.*;
import java.io.*;

public class Perfect
{
  public static int sumDivisors (int n)
  {
    int limit = n / 2;
    int sum = 0;
    for (int i = 1; i <= limit; i++)
    {
      if (n % i == 0)
        sum = sum + i;
    }
    return sum;
  }

  public static void main (String[] args) throws IOException
  {
      File inFile = new File ("perfect.dat");
      Scanner sc = new Scanner (inFile);
      int numLines = sc.nextInt();
      for (int i = 0; i < numLines; i++)
      {
	int n = sc.nextInt();
        int sum = sumDivisors (n);
	if (sum < n)
	{
          System.out.println ("DEFICIENT");
	}
        else if (sum > n)
	{
          System.out.println ("ABUNDANT");
	}
	else
	{
          System.out.println ("PERFECT");
	}
      }
      sc.close();
  }
}
