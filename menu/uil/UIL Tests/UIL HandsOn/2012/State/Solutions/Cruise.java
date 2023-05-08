import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Cruise {
	
	public static class Cell {
		enum CellType {
			kShip,
			kLand,
			kWater
		};
		
		public CellType type;
		public int depth;
		public boolean visited;
	}
	
	public static Cell[][] map = null;
	
	public static int minDistanceFromBoatToLand(final int boatR, final int boatC) {
		int minDist = Integer.MAX_VALUE;
		for (int r = 0; r < map.length; ++r) {
			for (int c = 0; c < map[0].length; ++c) {
				if (map[r][c].type == Cell.CellType.kLand) {
					int diffR = Math.abs(boatR - r);
					int diffC = Math.abs(boatC - c);
					int min = Math.min(diffR, diffC);
					
					int dist = min;
					diffR -= min;
					diffC -= min;
					dist += (diffR + diffC);
					
					minDist = Math.min(minDist, dist);
				}
			}
		}
		
		return minDist;
	}
	
	public static int recurse(int boatR, int boatC, int boatDepth) {
		if (boatR < 0 || boatR >= map.length)
			return Integer.MAX_VALUE;
		
		if (boatC < 0 || boatC >= map[0].length)
			return Integer.MAX_VALUE;
		
		Cell cell = map[boatR][boatC];
		if (cell.visited || map[boatR][boatC].depth <= boatDepth)
			return Integer.MAX_VALUE;
		
		int min = minDistanceFromBoatToLand(boatR, boatC);
		cell.visited = true;
		min = Math.min(min, recurse(boatR - 1, boatC - 1, boatDepth));
		min = Math.min(min, recurse(boatR - 1, boatC + 0, boatDepth));
		min = Math.min(min, recurse(boatR - 1, boatC + 1, boatDepth));
		min = Math.min(min, recurse(boatR + 0, boatC - 1, boatDepth));
		min = Math.min(min, recurse(boatR + 0, boatC + 1, boatDepth));
		min = Math.min(min, recurse(boatR + 1, boatC - 1, boatDepth));
		min = Math.min(min, recurse(boatR + 1, boatC + 0, boatDepth));
		min = Math.min(min, recurse(boatR + 1, boatC + 1, boatDepth));
		cell.visited = false;
		
		return min;
	}
	
	public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("cruise.dat"));
        
        final int scenarios = Integer.parseInt(kb.nextLine().trim());
        for (int s = 0; s < scenarios; ++s) {
        	String[] tokens = kb.nextLine().trim().split(" ");
        	int rows = Integer.parseInt(tokens[0]);
        	int cols = Integer.parseInt(tokens[1]);
        	int boat = Integer.parseInt(tokens[2]);
        	
        	int boatStartR = 0;
        	int boatStartC = 0;
        	
        	map = new Cell[rows][cols];
        	
        	for (int r = 0; r < rows; ++r) {
        		tokens = kb.nextLine().trim().split(" ");
        		for (int c = 0; c < cols; ++c) {
        			map[r][c] = new Cell();
        			map[r][c].visited = false;
        			if (tokens[c].trim().equalsIgnoreCase("S")) {
        				map[r][c].type = Cell.CellType.kShip;
        				map[r][c].depth = boat + 1;
        				boatStartR = r;
        				boatStartC = c;
        			}
        			else if (tokens[c].trim().equalsIgnoreCase("L")) {
        				map[r][c].type = Cell.CellType.kLand;
        			}
        			else {
        				map[r][c].type = Cell.CellType.kWater;
        				map[r][c].depth = Integer.parseInt(tokens[c].trim());
        			}
        		}
        	}
        	
        	int dist = recurse(boatStartR, boatStartC, boat) - 1;
        	if (dist == 1) {
        		System.out.printf("1 cell\n");
        	}
        	else {
        		System.out.printf("%d cells\n", dist);
        	}
        }
    }
}

