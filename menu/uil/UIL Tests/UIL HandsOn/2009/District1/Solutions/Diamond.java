import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Diamond {

	public static void main(String args[]) throws IOException
	{
		char [][] ch = new char[23][25];
		for(int i=0;i<23; i++)
			Arrays.fill(ch[i],'*');

		for(int i=1; i<12; i++) {
				ch[i][12-i] = ' ';
				ch[i][13-i] = ' ';
				ch[i][12+i] = ' ';
				ch[i][11+i] = ' ';
			}
				
		for(int i=1; i<11; i++) {
				ch[11+i][1+i] = ' ';
				ch[11+i][2+i] = ' ';
				ch[11+i][23-i] = ' ';
				ch[11+i][22-i] = ' ';
			}
		
		for(int i=0; i<23; i++) {
			for(int j=0; j<25; j++)
				out.print(ch[i][j]);
			out.println();
		}			
	}	
}
