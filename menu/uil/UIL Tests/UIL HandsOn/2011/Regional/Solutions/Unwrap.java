
import java.util.*;
import java.io.*;

public class Unwrap
{
  public static int[] unravel (int[][] a)
  {
    int n = a.length;
    int n2 = n * n;
    int [] b = new int [n2];

    int count = 0;
    int i_start = 0;
    int i_end = 0 ;
    int j_start = 0;
    int j_end = 0;
    int cycle = 0;
    outer: while (count < n2)
    {
      // go left to right
      i_start = cycle;
      j_start = cycle;
      j_end = n - cycle;
      for (int j = j_start; j < j_end; j++)
      {
        b[count++] = a[i_start][j];
	if (count == n2)
	  break outer;
      }

      // go top to bottom
      i_start = i_start + 1;
      i_end = n - cycle;
      j_end = j_end - 1;
      for (int i = i_start; i < i_end; i++)
      {
        b[count++] = a[i][j_end];
	if (count == n2)
	  break outer;
      }

      // go right to left
      j_start = j_end - 1;
      j_end = cycle;
      i_end = i_end - 1;
      for (int j = j_start; j >= j_end; j--)
      {
        b[count++] = a[i_end][j];
	if (count == n2)
	  break outer;
      }

      // go bottom to top
      i_start = i_end - 1;
      i_end = cycle + 1;
      for (int i = i_start; i >= i_end; i--)
      {
        b[count++] = a[i][j_end];
	if (count == n2)
	  break outer;
      }

      cycle = cycle + 1;
    }
    
    return b;
  }

  public static void printArray (int[] b)
  {
    int count = 0;
    for (int i = 0; i < b.length; i++)
    {
      count = count + 1;
      System.out.print (b[i] + " ");
      if (count == 10)
      {
        System.out.println();
	count = 0;
      }
    }
    if (count != 0)
    {
      System.out.println();
    }
  }

  public static void main (String[] args) throws IOException
  {
    Scanner sc = new Scanner (new File ("unwrap.dat"));
    int n = sc.nextInt();

    int[][] a = new int[n][n];  // matrix to hold the data

    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {
        a[i][j] = sc.nextInt();
      }
    }
    sc.close();

    int[] b = unravel (a);
    printArray (b);
  }
}
