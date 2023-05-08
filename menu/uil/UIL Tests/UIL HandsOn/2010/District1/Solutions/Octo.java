import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Octo {

	public static void main(String args[]) throws IOException
	{
		String[][] s = new String[28][25];
		for(int i=0; i<28; i++)		// array of *
			Arrays.fill(s[i],"*");
		
		for(int i=5; i<20; i++) {   //fill horizontal spaces
			s[2][i] = " ";
			s[13][i] = " ";
			s[25][i] = " ";
		}
		for(int i=4; i<13; i++) {   //fill vertical spaces
			s[i][3] = " ";
			s[i][4] = " ";
			s[i][20] = " ";
			s[i][21] = " ";
		}		
		for(int i=15; i<23; i++) {   //fill vertical spaces
			s[i][3] = " ";
			s[i][4] = " ";			
			s[i][20] = " ";
			s[i][21] = " ";
			
			
		}		
		s[3][4] = " ";				// fill odd corners
		s[3][5] = " ";
		s[3][19] = " ";				// fill odd corners
		s[3][20] = " ";
		s[12][4] = " ";				// fill odd corners
		s[12][5] = " ";
		s[12][19] = " ";				// fill odd corners
		s[12][20] = " ";
		s[13][19] = " ";
		s[12][3] = "*";
		s[12][21] = "*";
		s[14][4] = " ";				// fill odd corners
		s[14][5] = " ";
		s[14][19] = " ";				// fill odd corners
		s[14][20] = " ";

		s[23][4] = " ";				// fill odd corners
		s[23][5] = " ";
		s[23][19] = " ";
		s[23][20] = " ";				// fill odd corners

		s[24][5] = " ";				// fill odd corners
		s[24][6] = " ";
		s[24][18] = " ";				// fill odd corners
		s[24][19] = " ";

		s[25][5] = "*";				// fill odd corners
		s[25][19] = "*";


		for(int i=0; i<28; i++) {
			for(int j=0; j<25; j++)
				out.print(s[i][j]);
			out.println();
		}
	}
}