import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.regex.*;

public class Boxes {

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

        class boxclass {
            public int x, y, z;
            public boxclass (int xin, int yin, int zin) {

                int temp;
                x = xin; y = yin; z = zin;

                // sort the dimensions in ascending order
                if ( x > y ) { temp = x; x = y; y = temp; }
                if ( y > z ) { temp = y; y = z; z = temp; }
                if ( x > y ) { temp = x; x = y; y = temp; }

            }
            public boolean fitsin (boxclass bigbox) {
                if (bigbox.x <= x || bigbox.y <= y || bigbox.z <= z) {
                    return false;
                }
                return true;
            }
        }

        // Setup some variables
        String token;

        // Create a new scanner
        Scanner sin = new Scanner(new File("boxes.dat"));

        // Add 'x' to the list of delimiters
        sin.useDelimiter(Pattern.compile("[\\p{javaWhitespace}x]+"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            int numBoxes, count;

            // Get the number of boxes for this set
            numBoxes = sin.nextInt(); 
            sin.nextLine();

            // Read in the boxes for this set
            boxclass lastbox = null;
            boxclass thisbox = null;
            count = 0;
            for (int box=0; box < numBoxes; box++) {

               lastbox=thisbox;
               thisbox = new boxclass( sin.nextInt(), 
                                       sin.nextInt(),
                                       sin.nextInt() );

               // Don't compare if we just have one box
               if (lastbox == null) continue;

               if (lastbox.fitsin(thisbox)) {
                   count++;
               }
               else {
                   break;
               }
            }
            sin.nextLine();

            System.out.println(count);

        }
        sin.close();
    }
}
