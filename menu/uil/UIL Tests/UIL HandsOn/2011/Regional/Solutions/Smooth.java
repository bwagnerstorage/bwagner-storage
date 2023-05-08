
import java.util.*;
import java.io.*;

public class Smooth
{
  public static int smoothImage (int[][] a, int m, int i, int j)
  {
    int n = a.length;
    int i_min = i - m / 2;
    if (i_min < 0)
      i_min = 0;
    int i_max = i + m / 2;
    if (i_max >= n)
      i_max = n - 1;
    int j_min = j - m / 2;
    if (j_min < 0)
      j_min = 0;
    int j_max = j + m / 2;
    if (j_max >= n)
      j_max = n - 1;

    int sum = 0;
    int count = 0;
    for (int idx = i_min; idx <= i_max; idx++)
    {
      for (int jdx = j_min; jdx <= j_max; jdx++)
      {
        sum = sum + a[idx][jdx];
	count = count + 1;
      }
    }
    double avg = ((double) sum / count) + 0.5;
    return (int)avg;
  }

  public static void main (String[] args) throws IOException
  {
    Scanner sc = new Scanner (new File ("smooth.dat"));
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[][] a = new int[n][n];  // original image
    int[][] b = new int[n][n];  // smoothed image

    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {
        a[i][j] = sc.nextInt();
      }
    }

    sc.close();

    // Smooth the image
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {
        b[i][j] = smoothImage (a, m, i, j);
      }
    }

    // Print the smoothed image
    for (int i= 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {
        System.out.print (b[i][j] + " ");
      }
      System.out.println();
    }

  }
}
