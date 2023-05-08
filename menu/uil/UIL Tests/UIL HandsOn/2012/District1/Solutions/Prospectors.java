import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Prospectors {
       
    public static char[][] grid = null;
    
    public static int recurse(int x, int y) {
        if (x < 0 || x > 7)
            return 0;
        
        if (y < 0 || y > 15)
            return 0;
        
        char ch = grid[x][y];
        if (ch == '*') {
            grid[x][y] = '#';
            return  5 +
                    recurse(x - 1, y + 0) +
                    recurse(x + 0, y - 1) +
                    recurse(x + 0, y + 1) +
                    recurse(x + 1, y + 0) ;
        }
        
        return 0;
    }
    
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("prospectors.dat"));
        int numGrids = Integer.parseInt(kb.nextLine().trim());
        for (int n = 0; n < numGrids; ++n) {
            grid = new char[8][16];
            for (int x = 0; x < 8; ++x) {
                String line = kb.nextLine().trim();
                for (int y = 0; y < 16; ++y) {
                    grid[x][y] = line.charAt(y);
                }
            }
            
            if (n < (numGrids - 1)) {
                // Empty line
                kb.nextLine();
            }
            
            ArrayList<Integer> plots = new ArrayList<Integer>();
            for (int x = 0; x < 8; ++x) {
                for (int y = 0; y < 16; ++y) {
                    int ret = recurse(x, y);
                    if (ret != 0)
                        plots.add(ret);
                }
            }
            
            Collections.sort(plots);
            if (plots.size() > 0) {
                System.out.print(plots.get(plots.size() - 1));
                for (int p = plots.size() - 2; p > -1; --p) {
                    System.out.printf(" %d", plots.get(p));
                }
                System.out.println("");    
            }
        }
    }    
}
