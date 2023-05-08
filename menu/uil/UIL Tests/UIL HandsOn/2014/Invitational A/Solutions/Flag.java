import java.util.*;
import java.io.*;
public class Flag {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner (new File("flag.dat"));
		int testcases = reader.nextInt();

		for (int i = 0; i < testcases; i++ ) {
			printFlag(reader);
		}
		reader.close();
	}
	
	public static void printFlag (Scanner reader) {
		int width = reader.nextInt();
		int height = reader.nextInt();

		for (int row = 0; row < height; row++) {
			for (int col = 0; col <= width/3-1; col++ ) {
				System.out.print("G");
			}
			for (int col = 0; col <= width/3-1; col++ ) {
				if (row==0 || row == height-1) {
					System.out.print("-");
				} else {
					System.out.print(" ");
				}
			}
			for (int col = 0; col <= width/3-1; col++ ) {
				System.out.print("R");
			}
			System.out.println();
		}
		System.out.println();
	}
}
