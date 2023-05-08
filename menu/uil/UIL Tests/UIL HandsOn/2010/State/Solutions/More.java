import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.regex.*;

public class More {

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

        class boxclass implements Comparable {
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



	public int compareTo(Object otherObject)
        {
		boxclass other = (boxclass) otherObject;
                if ( other.x > x) return -1;
		if ( other.x < x) return 1;
		if (other.y > y) return -1;
		if (other.y < y ) return 1;
		if (other.z > z) return -1;
		if (other.z < z) return 1;
		return 0;
         
        }
}

        // Setup some variables
        String token;
	//ArrayList<boxclass> boxes = new ArrayList<boxclass>();

        // Create a new scanner
        Scanner sin = new Scanner(new File("more.dat"));

        // Add 'x' to the list of delimiters
        sin.useDelimiter(Pattern.compile("[\\p{javaWhitespace}x]+"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {
            ArrayList<boxclass> boxes = new ArrayList<boxclass>();

            int numBoxes, count;

            // Get the number of boxes for this set
            numBoxes = sin.nextInt(); 
            sin.nextLine();

            // Read in the boxes for this set
             boxclass thisbox = null;
            count = 0;
            for (int box=0; box < numBoxes; box++) {

                thisbox = new boxclass( sin.nextInt(), 
                                       sin.nextInt(),
                                       sin.nextInt() );
		boxes.add(thisbox);

            }
            Collections.sort(boxes);
	    count= 0;
	    while(boxes.size() > 0)
            {	boxclass tester = boxes.get(0);
		boxes.remove(0);
	        int j = 0;
		count++;
		
     	        while (j < boxes.size())
	        {  boxclass nextbox = boxes.get(j);
		   if (tester.fitsin(nextbox)){
			tester=nextbox;
			boxes.remove(j);}
		   else j++;
	         }
            }
		
            sin.nextLine();

            System.out.println(count);

        }
        sin.close();
    }
}
