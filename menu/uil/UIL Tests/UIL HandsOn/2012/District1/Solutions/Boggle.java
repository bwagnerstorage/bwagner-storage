import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Boggle {

    public static char[][] grid = null;
    
    public static boolean findWord(String word, int x, int y) {
        if (x < 0 || x > 3)
            return false;
        
        if (y < 0 || y > 3)
            return false;
        
        if (word.isEmpty())
            return true;
        
        char nextChar = word.charAt(0);
        char bk = grid[x][y];
        if (bk == nextChar) {
            grid[x][y] = '#';
            boolean ret =   findWord(word.substring(1), x + 1, y + 1) ||
                            findWord(word.substring(1), x + 1, y + 0) ||
                            findWord(word.substring(1), x + 1, y - 1) ||
                            findWord(word.substring(1), x + 0, y + 1) ||
                            findWord(word.substring(1), x + 0, y - 1) ||
                            findWord(word.substring(1), x - 1, y + 1) ||
                            findWord(word.substring(1), x - 1, y + 0) ||
                            findWord(word.substring(1), x - 1, y - 1) ;
            grid[x][y] = bk;
            return ret;
        }
        
        return false;
    }
    
	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("boggle.dat"));
		
		int count = Integer.parseInt(kb.nextLine().trim());
		for (int c = 0; c < count; ++c) {
		    grid = new char[4][4];
		    for (int x = 0; x < 4; ++x) {
		        String line = kb.nextLine().trim();
		        for (int y = 0; y < 4; ++y) {
		            grid[x][y] = line.charAt(y);
		        }
		    }
		    
		    int score = 0;
		    String line = kb.nextLine().trim();
		    int words = Integer.parseInt(line);
		    for (int w = 0; w < words; ++w) {
		        line = kb.nextLine().trim();
		        char ch = line.charAt(0);
		        boolean bFound = false;
		        for (int x = 0; x < 4 && !bFound; ++x) {
		            for (int y = 0; y < 4 && !bFound; ++y) {
		                if (ch == grid[x][y]) {
		                    bFound = findWord(line, x, y);
		                }
		            }
		        }
		        
		        if (bFound) {
		            int length = line.length();
		            if (length < 5)
		                score += 1;
		            else if (length < 6)
		                score += 2;
		            else if (length < 7)
		                score += 3;
		            else if (length < 8)
		                score += 5;
		            else if (length >= 8)
		                score += 11;
		        }
		    }
		    
		    System.out.printf("PUZZLE #%d: %d\n", c + 1, score);
		}
	}	
}
