import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class BlobCount {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("blobcount.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			int rows = Integer.parseInt(s[0]);
			int cols = Integer.parseInt(s[1]);
			char ch [][] = new char[rows] [cols];

			for(int i=0; i<ch.length; i++) 
					ch[i] = kb.nextLine().trim().toCharArray();

			int cases = Integer.parseInt(s[2]);
			for(int i=0; i<cases; i++) {
				t = kb.nextLine().trim();
				String w[] = t.split(" ");				
				int x = Integer.parseInt(w[0])-1;  //coordinates of start
				int y = Integer.parseInt(w[1])-1; 
				int c = 0;
				int r = 0;
				if(ch[x][y] == '.')
					out.println("NO BLOB");
				else {
					while (y<cols && ch[x][y] != '.') {
						y++;
						c++;
					}
					y--;
					while (x<rows && ch[x][y] != '.') {
						x++;
						r++;
					}
					out.println(r*c);
				}  
			}
		}
	}	
}

