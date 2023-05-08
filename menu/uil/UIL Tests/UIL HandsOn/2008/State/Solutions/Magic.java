import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Magic {
	

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("magic.dat"));

		int times = 0;
		int sum, r, c;
		int count = kb.nextInt();
		while(times < count) {
			times++;
			int a[][] = new int[4][4];
			// input array data
			for(r=0; r<4; r++)
				for(c=0; c<4; c++)
					a[r][c] = kb.nextInt();
			// find magic number
			int magicNumber = 0;
			for(c=0; c<4; c++)
				magicNumber += a[0][c]; 	
			boolean magic = true;
			//check rows 1-3
			for(r=1;magic && r<4;r++) 
				magic = check(magicNumber, a[r][0], a[r][1], a[r][2], a[r][3]);
			//check columns 0-3
			for(c=0;magic && c<4;c++) 
				magic = check(magicNumber, a[0][c], a[1][c], a[2][c], a[3][c]);
			//check diagonal \
			if(magic) magic =check(magicNumber, a[0][0], a[1][1], a[2][2], a[3][3]);
			//check diagonal /
			if(magic) magic = check(magicNumber, a[3][0], a[2][1], a[1][2], a[0][3]);
			//check corners
			if(magic) magic = check(magicNumber, a[0][0], a[0][3], a[3][0], a[3][3]);
			// check horizontal pairs
			if(magic) magic = check(magicNumber, a[1][0], a[2][0], a[1][3], a[2][3]);
			// check vertical pairs		
			if(magic) magic = check(magicNumber, a[0][1], a[0][2], a[3][1], a[3][2]);
			// check center square		
			if(magic) magic = check(magicNumber, a[1][1], a[1][2], a[2][1], a[2][2]);
			
			if(magic) out.println (magicNumber + " MAGIC");
			else out.println ("NOT MAGIC");
		}

	}
	public static boolean check(int magicNumber, int a, int b, int c, int d) {
		return a+b+c+d == magicNumber;
	}
}
