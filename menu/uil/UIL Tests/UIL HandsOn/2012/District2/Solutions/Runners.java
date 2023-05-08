import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Runners {
     
    public static final char EMPTY = '.';
    public static final char WALL = '*';
    public static final char PROBLEM = 'P';
    public static final char JUDGES = 'J';
    
    public static final char RUSSEL = 'R';
    public static final char SETH = 'S';
    public static final char THOMAS = 'T';
    
    public static final char VISITED1 = '#';
    public static final char VISITED2 = '@';
    
    public static enum Phase
    {
        kPhase_1,
        kPhase_2,
    }
    
    public static char[][] grid = null;
    
    public static class Runner implements Comparable<Runner> {
        int score;
        String name;
        
        public int compareTo(Runner r)
        {
            if (r.score > score) {
                return -1;
            }
            else if (r.score < score) {
                return 1;
            }
            else {
                int ret = r.name.compareTo(name);
                if (ret > 0)
                    return -1;
                else if (ret < 0)
                    return 1;
                else
                    return 0;
            }
        }
    }
    
    public static char GetGridValueSafe(int r, int c) {
        if (r < 0 || r >= grid.length)
            return WALL;
        
        if (c < 0 || c >= grid[0].length)
            return WALL;
        
        return grid[r][c];
    }
    
    public static boolean IsAdjacentToProgram(int r, int c) {
        if (r < 0 || r >= grid.length)
            return false;
        
        if (c < 0 || c >= grid[0].length)
            return false;
        
        char up = GetGridValueSafe(r - 1, c);
        char down = GetGridValueSafe(r + 1, c);
        char left = GetGridValueSafe(r, c - 1);
        char right = GetGridValueSafe(r, c + 1);
        
        return up == PROBLEM || down == PROBLEM || left == PROBLEM || right == PROBLEM;
    }
    
    public static int Recurse(char runner, Phase phase, int r, int c) {
        final char ch = GetGridValueSafe(r, c);
        
        if (IsAdjacentToProgram(r, c)) {
            if (phase == Phase.kPhase_1)
                phase = Phase.kPhase_2;
        }
        
        if (ch == PROBLEM) {
            // Don't move into the problem square
            return 0;
        }
        else if (ch == JUDGES) {
            if (phase == Phase.kPhase_1)
                return 0;
            else
                return 1;
        }
        else if (ch != EMPTY) {
            if (    !(phase == Phase.kPhase_1 && (ch == runner)) &&
                    !(phase == Phase.kPhase_2 && ch == VISITED1) &&
                    !(ch == runner) )
                return 0;
        }
        
        grid[r][c] = (phase == Phase.kPhase_1) ? VISITED1 : VISITED2;
        
        int up = Recurse(runner, phase, r - 1, c);
        if (up == 0)
            up = Integer.MAX_VALUE;
        int dn = Recurse(runner, phase, r + 1, c);
        if (dn == 0)
            dn = Integer.MAX_VALUE;
        int lt = Recurse(runner, phase, r, c - 1);
        if (lt == 0)
            lt = Integer.MAX_VALUE;
        int rt = Recurse(runner, phase, r, c + 1);
        if (rt == 0)
            rt = Integer.MAX_VALUE;
        
        int val = Math.min(up, Math.min(dn, Math.min(lt, rt)));
        if (val == Integer.MAX_VALUE)
            val = 0;
        else if (val != 0 && ch != PROBLEM)
            ++val;

        grid[r][c] = ch;
        return val;
    }
    
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("runners.dat"));
        
        int numRooms = Integer.parseInt(kb.nextLine().trim());
        
        for (int n = 0; n < numRooms; ++n) {
            String line = kb.nextLine().trim();
            String[] rc = line.split(" ");
            int rows = Integer.parseInt(rc[0]);
            int cols = Integer.parseInt(rc[1]);
            
            grid = new char[rows][cols];
            
            int russelX = 0;
            int russelY = 0;
            int sethX = 0;
            int sethY = 0;
            int thomasX = 0;
            int thomasY = 0;
            
            for (int r = 0; r < rows; ++r) {
                line = kb.nextLine().trim();
                for (int c = 0; c < cols; ++c) {
                    grid[r][c] = line.charAt(c);
                    
                    if (grid[r][c] == RUSSEL) {
                        russelX = r;
                        russelY = c;
                    }
                    else if (grid[r][c] == SETH) {
                        sethX = r;
                        sethY = c;
                    }
                    else if (grid[r][c] == THOMAS) {
                        thomasX = r;
                        thomasY = c;
                    }
                }
            }
            
            Runner russel = new Runner();
            russel.name = "RUSSELL";
            russel.score = Recurse(RUSSEL, Phase.kPhase_1, russelX, russelY);
            if (russel.score == 0)
                russel.score = Integer.MAX_VALUE;
            else
                russel.score -= 1;
            
            Runner seth = new Runner();
            seth.name = "SETH";
            seth.score = Recurse(SETH, Phase.kPhase_1, sethX, sethY);
            if (seth.score == 0)
                seth.score = Integer.MAX_VALUE;
            else
                seth.score -= 1;
            
            Runner thomas = new Runner();
            thomas.name = "THOMAS";
            thomas.score = Recurse(THOMAS, Phase.kPhase_1, thomasX, thomasY);
            if (thomas.score == 0)
                thomas.score = Integer.MAX_VALUE;
            else
                thomas.score -= 1;
            
            ArrayList<Runner> arr = new ArrayList<Runner>();
            arr.add(russel);
            arr.add(seth);
            arr.add(thomas);
            
            Collections.sort(arr);
            int least = arr.get(0).score;
            System.out.print(least);
            for (int i = 0; i < 3; ++i) {
                Runner run = arr.get(i);
                if (run.score == least)
                    System.out.print(" " + run.name);
            }
            
            System.out.println();
        }
    }    
}

