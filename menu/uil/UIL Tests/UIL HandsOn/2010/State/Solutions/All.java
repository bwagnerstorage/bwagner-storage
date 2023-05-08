import java.util.*;
import java.io.*;
import java.awt.*;

public class All {

    // Note that this array is already sorted.
    // This is critical since we'll be using the
    // Arrays.binarySearch method.
    private static String[] Teams = {
        "Anesthesiologists", "Apples", "Armadillos", 
        "Bananas", "Banditos", "Bratwursts", 
        "Cattle", "Chefs", "Coconuts",
        "Donkeys", "Donuts", "Dopplegangers"
    };

    private static int[][] Record;

    public static void main(String[] args) throws Exception {

        // Create a new scanner
        Scanner sin = new Scanner(new File("all.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            // First, let's create a new win/loss matrix
            Record = new int[12][12];

            // Second, read in the games
            int numGames = sin.nextInt(); sin.nextLine();
            for (int game=0; game < numGames; game++) {
                int windex = Arrays.binarySearch(Teams, sin.next());
                int lindex = Arrays.binarySearch(Teams, sin.next());
                sin.nextLine();
                Record[windex][lindex]+=1;
            }

            // Now, see who we're comparing
            int teamAindex = Arrays.binarySearch(Teams, sin.next());
            int teamBindex = Arrays.binarySearch(Teams, sin.next());
            sin.nextLine();

            // Check the Total Win Scores
            int twsA = 0;
            int twsB = 0;
            for (int i = 0; i < 12; i++) {
                twsA+=(Record[teamAindex][i] - Record[i][teamAindex]);
                twsB+=(Record[teamBindex][i] - Record[i][teamBindex]);
            }
//System.out.println("Method A: " + twsA + " vs " + twsB);
            if (twsA > twsB) {
                System.out.println(Teams[teamAindex]);
                continue;
            } else if (twsB > twsA) {
                System.out.println(Teams[teamBindex]);
                continue;
            }
            
            // Check head-to-head scores
            int hthA =   Record[teamAindex][teamBindex] 
                       - Record[teamBindex][teamAindex];
//System.out.println("Method B: " + hthA);
            if (hthA > 0) {
                System.out.println(Teams[teamAindex]);
                continue;
            } else if (hthA < 0) {
                System.out.println(Teams[teamBindex]);
                continue;
            }

            // Check Divisional Win Scores
            int dwsA = 0;
            int dwsB = 0;
            int teamAdiv = teamAindex / 3;
            int teamBdiv = teamBindex / 3;
            for (int i = 0; i < 3; i++) {
                dwsA +=   Record[teamAindex][teamAdiv*3+i] 
                        - Record[teamAdiv*3+i][teamAindex];
                dwsB +=   Record[teamBindex][teamBdiv*3+i] 
                        - Record[teamBdiv*3+i][teamBindex];
            }
//System.out.println("Method C: " + dwsA + " vs " + dwsB);
            if (dwsA > dwsB) {
                System.out.println(Teams[teamAindex]);
            } else if (dwsB > dwsA) {
                System.out.println(Teams[teamBindex]);
            }

        }
        sin.close();
    }
}
