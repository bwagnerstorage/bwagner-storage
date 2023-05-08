import java.io.*;
import java.util.*;
import java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Lawn {
	
	public static void mowBig(char[][] mat, int r, int c) {
		if (r < 0 || r + 2 >= mat.length) {
			return;
		}
		
		if (c < 0 || c + 2 >= mat[0].length) {
			return;
		}
		
		boolean bCanMow = true;
		bCanMow = bCanMow && (mat[r + 0][c + 0] != '*');
		bCanMow = bCanMow && (mat[r + 0][c + 1] != '*');
		bCanMow = bCanMow && (mat[r + 0][c + 2] != '*');
		bCanMow = bCanMow && (mat[r + 1][c + 0] != '*');
		bCanMow = bCanMow && (mat[r + 1][c + 1] != '*');
		bCanMow = bCanMow && (mat[r + 1][c + 2] != '*');
		bCanMow = bCanMow && (mat[r + 2][c + 0] != '*');
		bCanMow = bCanMow && (mat[r + 2][c + 1] != '*');
		bCanMow = bCanMow && (mat[r + 2][c + 2] != '*');
		
		// Prevent going back over the same spot
		int numMowed = 0;
		if (mat[r + 0][c + 0] == 'B') ++numMowed;
		if (mat[r + 0][c + 1] == 'B') ++numMowed;
		if (mat[r + 0][c + 2] == 'B') ++numMowed;
		if (mat[r + 1][c + 0] == 'B') ++numMowed;
		if (mat[r + 1][c + 1] == 'B') ++numMowed;
		if (mat[r + 1][c + 2] == 'B') ++numMowed;
		if (mat[r + 2][c + 0] == 'B') ++numMowed;
		if (mat[r + 2][c + 1] == 'B') ++numMowed;
		if (mat[r + 2][c + 2] == 'B') ++numMowed;
		
		if (bCanMow && numMowed < 9) {
			mat[r + 0][c + 0] = 'B';
			mat[r + 0][c + 1] = 'B';
			mat[r + 0][c + 2] = 'B';
			mat[r + 1][c + 0] = 'B';
			mat[r + 1][c + 1] = 'B';
			mat[r + 1][c + 2] = 'B';
			mat[r + 2][c + 0] = 'B';
			mat[r + 2][c + 1] = 'B';
			mat[r + 2][c + 2] = 'B';
			
			mowBig(mat, r - 1, c);
			mowBig(mat, r, c - 1);
			mowBig(mat, r + 1, c);
			mowBig(mat, r, c + 1);
		}
	}
	
	public static void main(String args[]) throws IOException {
		Scanner kb = new Scanner(new File("lawn.dat"));
		
		int count = Integer.parseInt(kb.nextLine().trim());
		for (int x = 0; x < count; ++x) {
			String[] s = kb.nextLine().trim().split(" ");
			int r = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);
			
			char[][] mat = new char[r][c];
			for (int i = 0; i < r; ++i) {
				String line = kb.nextLine().trim();
				for (int j = 0; j < c; ++j) {
					mat[i][j] = line.charAt(j);
				}
			}
			
			// Mow with big mower
			mowBig(mat, 0, 0);
			
			// Print matrix. Anything left as '.' is for the small mower.
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					if (mat[i][j] == '.') {
						System.out.print('s');
					}
					else {
						System.out.print(mat[i][j]);
					}
				}
				
				System.out.println();
			}
			
			System.out.println();
		}
	}
}
