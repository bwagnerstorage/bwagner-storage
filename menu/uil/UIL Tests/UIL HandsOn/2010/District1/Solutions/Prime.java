import java.util.*;
import java.io.*;
import java.awt.*;

public class Prime {

    public static void main(String[] args) throws Exception {

        // Create a new scanner
        Scanner sin = new Scanner(new File("prime.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            int factor;

            // Get the number to factor
            int val = sin.nextInt(); 
            sin.nextLine();

            // Handle the special case
            if ( val == 1 ) {
               System.out.println("1");
               continue;
            }

            // Now let's reduce this puppy
            for ( factor=2; factor<val; ) {
               if ( 0 == (val % factor) ) {
                  val = val / factor;
               }
               else {
                  factor++;
               }
            }
            System.out.println(factor);
        }
        sin.close();
    }
}
