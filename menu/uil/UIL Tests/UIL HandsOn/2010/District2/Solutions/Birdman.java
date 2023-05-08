import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Birdman {

	public static void main(String args[]) throws IOException
	{
		String[][] s = new String[30][25];
		for(int i=0; i<30; i++)		// array of *
			Arrays.fill(s[i],"*");
		
		for(int i=3; i<20; i++) {   //fill horizontal spaces
			s[3][i] = " ";
			s[14][i] = " ";
			s[26][i] = " ";
		}
		for(int i=3; i<27; i++) {   //fill vertical spaces
			s[i][3] = " ";
			s[i][4] = " ";
		}		
		for(int i=5; i<13; i++) {   //fill vertical spaces
			s[i][20] = " ";
			s[i][21] = " ";
		}		
		for(int i=16; i<24; i++) {   //fill vertical spaces
			s[i][20] = " ";
			s[i][21] = " ";
		}		
		s[4][19] = " ";				// fill odd corners
		s[4][20] = " ";
		s[13][19] = " ";				// fill odd corners
		s[13][20] = " ";
		s[15][19] = " ";				// fill odd corners
		s[15][20] = " ";
		s[24][19] = " ";				// fill odd corners
		s[24][20] = " ";
		s[25][18] = " ";				// fill odd corners
		s[25][19] = " ";
		s[26][19] = "*";
		
		for(int i=0; i<30; i++) {
			for(int j=0; j<25; j++)
				out.print(s[i][j]);
			out.println();
		}
	}
}
