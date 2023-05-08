import java.util.*;
import java.io.*;


public class waiter {

	static int MAX_SIZE = 10;
	
	static void floodfill(char pieceArray[][], int row, int col, int numLines)
	{
		if (row < 0 || row >= numLines)
			return;
		if (col < 0 || col >= pieceArray[row].length)
			return;
		if (pieceArray[row][col] != '#')
			return;
		pieceArray[row][col] = ' ';
		floodfill(pieceArray, row-1, col, numLines);
		floodfill(pieceArray, row, col+1, numLines);
		floodfill(pieceArray, row+1, col, numLines);
		floodfill(pieceArray, row, col-1, numLines);
	}
	public static void main(String[] args) 
	throws FileNotFoundException, IOException {
		int numDatasets;
		String line;
		int numLines, numPieces;
		char pieceArray[][];
		
		UILFileReader infile = new UILFileReader("waiter.in");
		
		numDatasets = infile.readInt();			
		for (int i = 0; i < numDatasets; i++)
		{
			numLines = infile.readInt();
			numPieces = 0;
			pieceArray = new char[numLines][MAX_SIZE];
			for (int j = 0; j < numLines; j++)
			{
				line = infile.readLine();
				pieceArray[j] = line.toCharArray();
			}

			for (int j = 0; j < numLines; j++)
			{
				for (int k = 0; k < pieceArray[j].length; k++)
				{
					if (pieceArray[j][k] == '#')
					{
						numPieces++;
						floodfill(pieceArray, j, k, numLines);
					}
				}
			}
			System.out.println(numPieces);
		}
	}
}