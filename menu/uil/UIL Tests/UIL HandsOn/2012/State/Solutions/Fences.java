import java.io.*;
import java.util.*;

public class Fences
{
	public static class HomeData {
		public char home;
		public int fence;
	}
	
	public static char charAtSafe(int x, int y) {
		if (x < 0 || x > 7)
			return '*';
		
		if (y < 0 || y > 15)
			return '*';
		
		return grid[x][y];
	}
	
	public static int fenceAmount(char ch, int x, int y) {
		int amount = charAtSafe(x, y - 1) != ch ? 660 : 0;
		amount += charAtSafe(x, y + 1) != ch ? 660 : 0;
		amount += charAtSafe(x - 1, y) != ch ? 330 : 0;
		amount += charAtSafe(x + 1, y) != ch ? 330 : 0;
		return amount;
	}
	
	public static HomeData[] homeData = null;
	public static char[][] grid = null;
	
	public static void main(String args[]) throws IOException
    {
		Scanner kb = new Scanner(new File("fences.dat"));
		int numSurveys = Integer.parseInt(kb.nextLine().trim());
		
		for (int s = 0; s < numSurveys; ++s) {
			String[] homes = kb.nextLine().trim().split(" ");
			homeData = new HomeData[homes.length];
			for (int h = 0; h < homes.length; ++h) {
				homeData[h] = new HomeData();
				homeData[h].home = homes[h].charAt(0);
			}
			
			for (int h1 = 0; h1 < homes.length; ++h1) {
				for (int h2 = 0; h2 < homes.length; ++h2) {
					if (homeData[h1].home < homeData[h2].home){
						HomeData tmp = homeData[h1];
						homeData[h1] = homeData[h2];
						homeData[h2] = tmp;
					}
				}
			}
			
			grid = new char[8][16];
			for (int x = 0; x < 8; ++x) {
				String line = kb.nextLine().trim();
				for (int y = 0; y < 16; ++y) {
					grid[x][y] = line.charAt(y);
				}
			}
			
			for (int x = 0; x < 8; ++x) {
				for (int y = 0; y < 16; ++y) {
					char ch = grid[x][y];
					if (ch != '*') {
						for (int h = 0; h < homeData.length; ++h) {
							if (homeData[h].home == ch) {
								homeData[h].fence += fenceAmount(ch, x, y);
								break;
							}
						}
					}
				}
			}
			
			System.out.printf("SURVEY %d\n", s + 1);
			for (int h = 0; h < homeData.length; ++h) {
				System.out.printf("%c %d\n", homeData[h].home, homeData[h].fence);
			}
		}
    }
}
