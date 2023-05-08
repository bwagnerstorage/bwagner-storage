import java.io.*;
import java.util.*;
import static java.lang.System.*;  



public class Squares {

	public static void main(String args[]) throws IOException  {
		Scanner kb = new Scanner(new File("squares.dat"));
		String t = kb.nextLine().trim();
		String []s = t.split(" ");
		int times = 0; 
		int count = s.length;
		while(times < count) {
			int size = Integer.parseInt(s[times]);
			times++;
			char [][]mat= new char [size][size];
                        for(int i=0; i<size; i++) // set up matrix of ' '
				for(int j=0; j<size; j++)  
					mat[i][j]=' ';
			
			for(int i=0; i<size; i+=2) {
				for(int j=i; j<size-i; j++) {  
					mat[i][j] = '*';
					mat[j][i] = '*';
					mat[size-j-1][size-i-1]  = '*'; 
					mat[size-i-1][size-j-1]  = '*'; 
				}
			}
			for(int i=0; i<mat.length; i++) {
				for (int j=0; j<mat.length; j++) 
					out.print(mat[i][j]);
				out.println();
			}
			out.println();
		}
	}	
}
