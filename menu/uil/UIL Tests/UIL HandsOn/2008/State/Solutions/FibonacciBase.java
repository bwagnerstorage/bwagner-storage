import java.util.*;
import java.io.*;

public class FibonacciBase
{
  public static void main (String[] args) throws IOException
  {
    // Generate an ArrayList of Fibonacci Numbers less than 1000
    int limit = 1000;
    ArrayList<Integer> fib = new ArrayList<Integer>();
    int f1 = 0;
    int f2 = 1;
    int f = f1 + f2;
    while (f < 1000)
    {
      fib.add (f);
      f1 = f2;
      f2 = f;
      f = f1 + f2;
    }

    // Open file
    File inFile = new File ("fibonaccibase.dat");
    Scanner sc = new Scanner (inFile);

    // Process the input
    while (sc.hasNextInt())
    {
      int n = sc.nextInt();
      System.out.print (n + " = " );
      int sum = 0;
      for (int i = fib.size() - 1; i >= 0; i--)
      {
        int fi = fib.get(i);
        if ((sum + fi) < n)
        {
          System.out.print (fi + " + ");
          sum = sum + fi;
        }
        else if ((sum + fi) == n)
        {
          System.out.println (fi);
          break;
        }
      }
    }

    // Close file
    sc.close();
  }
}

