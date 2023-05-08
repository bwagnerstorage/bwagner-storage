import java.io.*;
import java.util.*;

public class Chutes {
    
    public static class Node {
        public Node next = null;
        public Node prev = null;
        public Node path = null;
        
        public boolean isEnd = false;
        
        public int id = 0;
    }
    
    public static final int GRID_DIM = 8;
    public static final int LIST_SIZE = GRID_DIM * GRID_DIM;
    
    public static Node[] grid;
    
       
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("chutes.dat"));
        
        int games = Integer.parseInt(kb.nextLine().trim());
        
        // For each game
        for (int g = 0; g < games; ++g) {
            // Initialize game board
            grid = new Node[LIST_SIZE];
            for (int r = 0; r < LIST_SIZE; ++r) {
                grid[r] = new Node();
                grid[r].id = r + 1;
                
                if (0 < r) {
                    grid[r - 1].next = grid[r];
                    grid[r].prev = grid[r - 1];
                }
                
                if ((LIST_SIZE - 1) == r) {
                    grid[r].isEnd = true;
                }
            }
            
            // Read number of players
            int numPlayers = Integer.parseInt(kb.nextLine().trim());
            Node[] players = new Node[numPlayers];
            for (int p = 0; p < numPlayers; ++p) {
                players[p] = grid[0];      
            }
            
            String strSeed = kb.nextLine().trim();
            long seed = Long.parseLong(strSeed); 
            
            // Read line of num chutes and num ladders
            String strLine = kb.nextLine().trim();
            String[] strLineArr = strLine.split(" ");
            int numChutes = Integer.parseInt(strLineArr[0]);
            int numLadders = Integer.parseInt(strLineArr[1]);
            
            // Read chutes
            for (int c = 0; c < numChutes; ++c) {
                strLine = kb.nextLine().trim();
                strLineArr = strLine.split(" ");
                int src = Integer.parseInt(strLineArr[0]) - 1;
                int dst = Integer.parseInt(strLineArr[1]) - 1;
                grid[src].path = grid[dst];
            }
            
            // Read ladders
            for (int l = 0; l < numLadders; ++l) {
                strLine = kb.nextLine().trim();
                strLineArr = strLine.split(" ");
                int src = Integer.parseInt(strLineArr[0]) - 1;
                int dst = Integer.parseInt(strLineArr[1]) - 1;
                grid[src].path = grid[dst];
            }
            
            Random rand = new Random(seed);
            
            // Game loop
            int curPlayer = 0;
            int numRolls = 0;
            while (true) {
                ++numRolls;
                
                // Roll between 1 and 6 inclusive
                int roll = rand.nextInt(6) + 1;
                
                //char ch1 = (char) ('A' + curPlayer);
                //System.out.printf("*** Player %c rolls %d\n", ch1, roll);
                
                for (int r = 0; r < roll; ++r) {
                    if (!players[curPlayer].isEnd) {
                    	players[curPlayer] = players[curPlayer].next;
                    }
                }
                
                // Move up/down while there is a path
                while (null != players[curPlayer].path) {
                    players[curPlayer] = players[curPlayer].path;
                }
                
                // Do they win?
                if (players[curPlayer].isEnd) {
                    char ch = (char) ('A' + curPlayer);
                    System.out.printf("Player %c wins after %d rolls!\n", ch, numRolls);
                    break;
                }
                
                // Next player
                curPlayer = (curPlayer + 1) % numPlayers;
            }
        }
    }    
}

