import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.regex.*;

public class Widget {

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

        // Create a new scanner
        Scanner sin = new Scanner(new File("widget.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            int funds = sin.nextInt();
            int price = sin.nextInt();
            int deal  = sin.nextInt();
            int widgets  = 0;
            int wrappers = 0;

            // First buy as many as you can
            wrappers = widgets = funds / price;

            // Now trade in wrappers until you can't
            // get any more free ones.
            while ( wrappers >= deal ) {
               int newwidgets = wrappers / deal;

	       wrappers -= newwidgets * deal;

               widgets  += newwidgets;
               wrappers += newwidgets;
            }

            System.out.println(widgets);

        }
        sin.close();
    }
}
