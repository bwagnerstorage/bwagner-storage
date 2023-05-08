import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Lucky {

	public static void main(String args[]) throws IOException
	{
		char s[][] = new char [24][25];
		for(int i=0; i<24; i++)
			Arrays.fill(s[i],'*');
		for(int i=1; i<24; i++) 
			s[1][i]=' ';
		for(int i=2; i<23; i++) {
			s[i][25-i-1]=' ';
			s[i][25-i-2]=' ';
		}

		for(int i=0; i<24; i++) {
			for(int j=0; j<25; j++)
				out.print(s[i][j]);
			out.println();
		}			
	}	
}
