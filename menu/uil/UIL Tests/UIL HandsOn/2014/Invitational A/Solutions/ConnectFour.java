import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {

	public static void main(String[] args)  throws FileNotFoundException {
		Scanner sc = new Scanner (new File("connectfour.dat"));
		int noOfBoards = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < noOfBoards; i++) {
			int rows = 6;
			int cols = 7;
			int [][] brd = readBoard(sc, rows, cols);
			
			if (isWin(brd, rows, cols)==1) 
				System.out.println("Blue Wins");
			else 
			if (isWin(brd, rows, cols)==2) 
				System.out.println("Red Wins");
			else
				System.out.println("No win");			
		}
	}
	
	public static int isWin (int [][] brd, int rows, int cols) {

		// Four in a row of the same color.
		
		int [] matchArray1 = {1, 1, 1, 1}; 
		int [] matchArray2 = {2, 2, 2, 2}; 
	
		// Check the columns
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row <= rows - 4; row++) {
				int [] current = {brd[row][col], brd[row+1][col], brd[row+2][col], brd[row+3][col]};
				if (Arrays.equals(current, matchArray1))
					return 1;
				if (Arrays.equals(current, matchArray2))
					return 2;
				}
			}		
		
		
		// Check the rows
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col <= cols - 4; col++) {
				int [] current = {brd[row][col], brd[row][col+1], brd[row][col+2], brd[row][col+3]};
				if (Arrays.equals(current, matchArray1))
					return 1;
				if (Arrays.equals(current, matchArray2))
					return 2;
				}
			}		
		
		
		// Check all NW to SE diagonals.
		for (int row = 0;  row <= rows-4; row++ ) {
			for (int col = 0; col <= cols-4; col++) {
				int [] current = {brd[row+3][col+3], brd[row+2][col+2], brd[row+1][col+1], brd[row][col]};
				if (Arrays.equals(current, matchArray1))
					return 1;
				if (Arrays.equals(current, matchArray2))
					return 2;
				}
			}
		
		
		// Check all SW to NE diagonals.
		for (int row = rows-1;  row >= 3; row-- ) {
			for (int col = 0; col <= cols-4; col++) {
				int [] current = {brd[row-3][col+3], brd[row-2][col+2], brd[row-1][col+1], brd[row][col]};
				if (Arrays.equals(current, matchArray1))
					return 1;
				if (Arrays.equals(current, matchArray2))
					return 2;
				}
			}
				
		return 0;
	}
	
	public static int [][] readBoard (Scanner sc, int rows, int cols) {
		int [][] board = new int [rows][cols];
		for (int row = 0; row < rows; row++) {
			String linesc = sc.nextLine();
			for (int col = 0; col < cols; col++ ) {
				char token = linesc.charAt(col);
				if (token=='b') board[row][col] = 1;
				if (token=='r') board[row][col] = 2;
				if (token=='-') board[row][col] = 0;

			}
		}
		
		return board;
	}
}
