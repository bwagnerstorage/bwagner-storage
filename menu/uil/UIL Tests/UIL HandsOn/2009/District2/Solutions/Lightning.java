import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Lightning {

	public static void main(String args[]) throws IOException
	{
		char [][] ch = new char[27][30];
		for(int i=0;i<27; i++)
			Arrays.fill(ch[i],'*');

		for(int i=0; i<9; i++) {
			ch[i+1][3*i+1] = ' ';
			ch[i+1][3*i+2] = ' ';
			ch[i+1][3*i+3] = ' ';
			ch[i+1][3*i+4] = ' ';
		}
				
		for(int i=1; i<9; i++) {
			ch[9+i][28-3*i] = ' ';
			ch[9+i][27-3*i] = ' ';
			ch[9+i][26-3*i] = ' ';
			ch[9+i][25-3*i] = ' ';
		}
		
		for(int i=0; i<9; i++) {
			ch[i+17][3*i+1] = ' ';
			ch[i+17][3*i+2] = ' ';
			ch[i+17][3*i+3] = ' ';
			ch[i+17][3*i+4] = ' ';
		}

		for(int i=0; i<27; i++) {
			for(int j=0; j<30; j++)
				out.print(ch[i][j]);
			out.println();
		}		
	}	
}
