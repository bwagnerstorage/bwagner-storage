import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class OddNumbers
{
  public static void main (String[] args) throws IOException
  {
    File inFile = new File ("oddnumbers.dat");

    Scanner sc = new Scanner (inFile);
    while (sc.hasNextLine())
    {
      String line = sc.nextLine();
      int numOdd = Integer.parseInt (line);

      // Compute the first odd number in the line
      int n = numOdd / 2;
      int sn = n * n;
      int t1 = 2 * sn + 1;
      int sum = 3 * t1 + 6 * numOdd - 12;
      System.out.println (sum);
    }
    sc.close();
  }
}
