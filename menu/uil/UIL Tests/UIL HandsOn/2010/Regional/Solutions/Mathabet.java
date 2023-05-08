import java.util.*;
import java.io.*;
import java.awt.*;

public class Mathabet {

    static class Word implements Comparable {

        String myword;
        long mynumber;
        boolean isprime;
        boolean iseven;

        public Word(String newword) {

            // Store the word
            myword = new String(newword);

            // Construct the number
            mynumber = 0;
            long multiplier = 1; 
            for ( int i = (myword.length() - 1); i>=0 ; i-- ) {
                mynumber += multiplier * ((myword.charAt(i) - 'a') + 1);
                while (multiplier <= mynumber) {
                    multiplier *= 10;
                }
            }

            // Is it even?
            iseven = mynumber % 2 == 0 ? true : false;

            // Is it prime?
            isprime = true;
            for ( long i = 2; i <= Math.sqrt(mynumber); i++ ) {
                if ( mynumber % i == 0 ) {
                    isprime = false;
                    break;
                }
            }
            if ( mynumber == 1 ) isprime = false;

        }

        public int compareTo (Object o) {

            Word that = (Word) o;

            if      ( this.isprime && !that.isprime ) return 1;
            else if ( that.isprime && !this.isprime ) return -1;
            else if ( this.iseven  && !that.iseven  ) return 1;
            else if ( that.iseven  && !this.iseven  ) return -1;
            else return (int) ( this.mynumber - that.mynumber );

        }

    }

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

        // Create a new scanner
        Scanner sin = new Scanner(new File("mathabet.dat"));

        // Get the number of words
        int numWords = sin.nextInt(); 
        sin.nextLine();

        // Declare our array of words
        Word[] myWords = new Word[numWords];

        // Read in the list of words
        for (int w = 0; w < numWords; w++) {
            myWords[w] = new Word(sin.next());
            sin.nextLine();
        }

        // Sort the list
        Arrays.sort(myWords);

        // Output the sorted list
        for (int w = 0; w < numWords; w++) {
            System.out.println(myWords[w].myword);
        }

        sin.close();
    }
}
