import java.util.*;
import java.io.*;
import java.awt.*;

// Note that the "fun" part of this problem is that
// the mailboxes are UNIT INDEXED.

public class Mail {

    static class pobox {
        public int numkeys;
        public int[] keylist;
        public pobox () {
           keylist = new int[MAX_BOXES];
           numkeys=0;
        }
        public void addkey( int newkey) {
           keylist[numkeys]=newkey;
           numkeys++;
        }
        public void display() {
           System.out.print("Box(" + numkeys + "): ");
           for (int i=0; i < numkeys; i++ ) {
              System.out.print(keylist[i] + " ");
           }
           System.out.println("");
        }
    }

    static final int MAX_BOXES=30;

    static boolean boxOpen[];
    static int numBoxes;

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

        boxOpen = new boolean[MAX_BOXES+1];
        pobox Boxes[] = new pobox[MAX_BOXES+1];

        // Create a new scanner
        Scanner sin = new Scanner(new File("mail.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            // Get the number of boxes
            numBoxes = sin.nextInt(); 
            sin.nextLine();

            // Read in the pobox contents
            for (int box=1; box <= numBoxes; box++) {

               Boxes[box] = new pobox();

               // How many keys in this one?
               int numKeys = sin.nextInt(); 

               // Now note the keys
               for (int key=0; key < numKeys; key++) {
                  Boxes[box].addkey(sin.nextInt());
               }
//debug
//Boxes[box].display();
            }
            sin.nextLine();

            // Initialize the current maximum number
            // of boxes we can open
            int maxcount=1;

            // Now let's figure out the answer
            // We do this by trying each initial box
            // with our master key and seeing where
            // that leads.
            for (int box=1; box <= numBoxes; box++) {

               // 'box' is the one we're opening, so
               // let's setup where all others are
               // locked but 'box'
               for (int i=1; i <= numBoxes; i++) {
                  boxOpen[i] = false;
               }
               boxOpen[box] = true;

               boolean newboxopened = true;
               while ( newboxopened == true ) {
                   newboxopened = false;

                   for (int b = 1; b <= numBoxes; b++) {
                       if (boxOpen[b]) {
                           // Ensure all boxes it can open are
                           for (int keyindex = 0; 
                                keyindex < Boxes[b].numkeys; 
                                keyindex++) {
                               if (!boxOpen[Boxes[b].keylist[keyindex]]) {
                                   boxOpen[Boxes[b].keylist[keyindex]] = true;
                                   newboxopened = true;
//System.out.println("Dude! unlocked " + Boxes[b].keylist[keyindex]);
                               }
                           }
                       }
                   }
               }
               int count = 0;
               for (int i=1; i <= numBoxes; i++) {
                   if (boxOpen[i]) {
                       count++;
                   }
               }

               if ( maxcount < count ) {
                  maxcount = count;
               }
            }

            System.out.println(maxcount);

        }
        sin.close();
    }
}
