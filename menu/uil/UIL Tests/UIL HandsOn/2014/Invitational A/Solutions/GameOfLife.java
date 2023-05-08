import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GameOfLife {
	public static final int XSIZE = 500;
	public static final int YSIZE = 500;

	public static void main(String[] args) throws FileNotFoundException {
		boolean T = true, F = false;		

		Scanner reader = new Scanner (new File ("gameoflife.dat"));
		int N = reader.nextInt();
		while(N-->0)
		{
		
			int size = reader.nextInt();
			int noGens = reader.nextInt();
			reader.nextLine();
			boolean [][] palet = readTest(reader, size);
			for (int i = 0; i < noGens; i++) {
				nextGen(palet);
			}	
			printArray(palet);
		}
	}
	
	public static boolean [][] readTest (Scanner sc, int size) {
		boolean palet [][] = new boolean [size][size];
		for (int i = 0; i < size; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < size; j++) {
				palet[i][j] = (line.charAt(j) == '1');
			}			
		}
		return palet;
	}
	
	/*
	 * Calculates the next generation of the Life palet.
	 */

	public static void nextGen (boolean [][] palet) {
		int xsize = palet[0].length;
		int ysize = palet.length;
		int [][] noNeighbors = new int [ysize][xsize];

		for (int col = 0; col < xsize; col ++ ) {
			for (int row= 0; row< ysize; row ++ ) {
				noNeighbors[row][col] = getLiveNeighbors(palet, row, col);
			}
		}

		for (int col = 0; col < xsize; col++) {
			for (int row= 0; row < ysize; row ++ ) {
				int n = noNeighbors[row][col];

				if ( n == 3) {
					palet[row][col] = true;	
				} else {
					if ((n > 3) || (n < 2)) {
						palet[row][col] = false;
					}
				}
			}
		}
	}
	
	/*
	 * This method returns the number of live neighbors of a given cell, specified by row 
	 * and column.
	 */

	public static int getLiveNeighbors (boolean [][] a, int row, int col ) {
		int noOfRows = a.length;
		int noOfCols = a[0].length;
		int neighbors = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				int neighborY = row + i;
				int neighborX = col + j;
				boolean isValid = !((i==0) && (j==0)) &&
						neighborY >=0 && neighborY < noOfRows &&
						neighborX >= 0 && neighborX < noOfCols;
						if (isValid) {
							if (a[neighborY][neighborX]) {
								neighbors++;
							}
						}				
			}
		}
		return neighbors;
	}
	
	/*
	 * Print an array of booleans with 0 and 1 representing false and true
	 * respectively.
	 */

	public static void printArray (boolean [][] array) {
		for (boolean[] row: array){
			for (boolean element: row) {
				if (element) System.out.print("1");
				else System.out.print("0");
			}
			System.out.println();
		}
		System.out.println();
	}
}
