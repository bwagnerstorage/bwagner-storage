import java.util.*;
import java.io.*;
import java.awt.*;

public class Bingeaux {

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

        // Create a new scanner
        Scanner sin = new Scanner(new File("bingeaux.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Process the data sets
        for (int ds = 0; ds < numSets; ds++) {

            // Get the starting word
            String baseword = new String(sin.next());
            sin.nextLine();

            // Initialize the array of variants
            int numvariants = 0;
            String[] variants = new String[40];

            // Try the "ph" variants
            int index = 0;
            int lastindex = 0;
            while ( (index = baseword.indexOf("ph", lastindex)) != -1 ) {

                variants[numvariants] = 
                 new String ( baseword.substring(0,index ) + "f" );

                if (index < baseword.length() - 2) {
                    variants[numvariants] = variants[numvariants] +
                                            baseword.substring(index+2);
                }

                lastindex = index + 2;
                ++numvariants;
            }

            // Try the "ai" variants
            index = 0;
            lastindex = 0;
            while ( (index = baseword.indexOf("ai", lastindex)) != -1 ) {

                // are we at the end of the word?
                if ( index == baseword.length() - 2 ) {
                    // yep, we're done
                    break;
                }

                variants[numvariants] = 
                 new String ( baseword.substring(0,index) + "ay" );

                if (index < baseword.length() - 2) {
                    variants[numvariants] = variants[numvariants] +
                                            baseword.substring(index+2);
                }

                lastindex = index + 2;
                ++numvariants;
            }

            // Try the double-letter variants
            for (index = 0; index < baseword.length() - 1; index++) {
                if (baseword.charAt(index) != baseword.charAt(index+1)) {
                    // no match
                    continue;
                }
                if ( (baseword.length() > index + 2) &&
                     (baseword.charAt(index+1) == baseword.charAt(index+2)) ||
                     (index > 0) &&
                     (baseword.charAt(index-1) == baseword.charAt(index))) {
                    // 3 match
                    continue;
                }
                // yay, just 2 match

                variants[numvariants] = 
                 new String ( baseword.substring(0,index+1) );

                if (index < baseword.length() - 2) {
                    variants[numvariants] = variants[numvariants] +
                                            baseword.substring(index+2);
                }

                ++numvariants;
            }

            // Try the 'o' variant
            if (baseword.charAt(baseword.length()-1) == 'o') {
                variants[numvariants] = 
                 new String ( baseword.substring(0,baseword.length()-1) 
                              + "eaux" );
                ++numvariants;
            }

            // Now sort the strings
            Arrays.sort(variants,0,numvariants);

            // Now print the sorted strings
            System.out.println(baseword);
            for (int i = 0; i < numvariants; i++ ) {
                System.out.println(variants[i]);
            }
        }
     
        sin.close();
    }
}
