import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Etch {
	static int r = 1;
	static int c = 1;
	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("etch.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			
			char frame[][] = new char[15][25];
			for(int i=0; i<15; i++) 			//initialize frame to all periods
				for(int j=0; j<25; j++)
					frame[i][j] = '.';	
					
			String t = kb.nextLine().trim();	//find current location
			String []rc = t.split(" ");
			r = Integer.parseInt(rc[0]) - 1;
			c = Integer.parseInt(rc[1]) - 1;
			frame[r][c] = '*';
			t = kb.nextLine().trim();			//get moves
			String []moves = t.split(" ");	
			for(int i=0; i<moves.length; i++) {
				char dir = moves[i].charAt(0);
				int len = Integer.parseInt(moves[i].substring(1));  
				switch (dir) {
					case 'L' : moveLeft(frame, len); break;
					case 'R' : moveRight(frame, len); break;
					case 'U' : moveUp(frame, len); break;
					case 'D' : moveDown(frame, len);
				}
			}
			for(int i=0; i<15; i++) {			//initialize frame to all periods
				for(int j=0; j<25; j++)
					out.print(frame[i][j]);	
				out.println();
			}
			out.println();			
		}
	}
	public static void moveLeft(char [][] f, int d) {
		int i=0;
		for(i=0; c-i>0 && i<d; i++)
			f[r][c-i-1] = '*'; 	
		c=c-i;
	}
	public static void moveRight(char [][] f, int d) {
		int i=0;
		for(i=0; c+i+1<25 && i<d; i++)
			f[r][c+i+1] = '*'; 	
		c=c+i;	
	}
	public static void moveUp(char [][] f, int d) {
		int i=0;
		for(i=0; r-i>0 && i<d; i++)
			f[r-i-1][c] = '*'; 	
		r=r-i;			
	}
	public static void moveDown(char [][] f, int d) {
		int i=0;
		for(i=0; r+i+1<15 && i<d; i++)
			f[r+i+1][c] = '*'; 	
		r=r+i;		
	}		
}
