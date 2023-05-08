import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Black {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("black.dat"));
		
		int times = 0; 	
		int count = Integer.parseInt(kb.nextLine().trim());		
		while(times < count) {
			times++;
			String[][] grid = new String[7][8];  //extra row and column at beginning and end
			Arrays.fill(grid[0],"W");
			Arrays.fill(grid[6],"W");			
			for(int r=1; r<6; r++) {
				String g[] = (kb.nextLine().trim()).split(" ");
				grid[r][0] = "W";				//assign values to first and last element of each row
				grid[r][7] = "W";
				for(int c=1; c<7; c++)			//assign values to grid
					grid[r][c] = g[c-1];
			}
			int m = Integer.parseInt(kb.nextLine().trim());
			for(int i=0; i<m; i++) {
				String point[] = (kb.nextLine().trim()).split(" ");
				int r = Integer.parseInt(point[0]);
				int c = Integer.parseInt(point[1]);
				reverse(grid,r,c);
				reverse(grid,r+1,c);
				reverse(grid,r-1,c);
				reverse(grid,r,c+1);
				reverse(grid,r,c-1);
		//		printGrid(grid);			//check intermediate steps	
		//		out.println();
			}
			printGrid(grid);
			if (times < count) out.println();
		}  
	}	
	public static void printGrid(String[][] g) {
		for(int r=1; r<6; r++) { 
			out.print(g[r][1]);
			for(int c=2; c<7; c++) 
				out.print(" " + g[r][c]);
			out.println();
		}
	}
	public static void reverse(String[][] g, int r, int c) {
		if(g[r][c].equals("W"))
			g[r][c] = "B";
		else
			g[r][c] = "W";
		
	}
}
