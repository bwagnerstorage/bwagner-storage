import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Blobs {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("blobs.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			char ch [][] = new char[Integer.parseInt(s[0])] [Integer.parseInt(s[1])];

			for(int i=0; i<ch.length; i++) 
					ch[i] = kb.nextLine().trim().toCharArray();

			int cases = Integer.parseInt(s[2]);
			for(int i=0; i<cases; i++) {
				t = kb.nextLine().trim();
				String w[] = t.split(" ");				
				int x = Integer.parseInt(w[0])-1;  //coordinates of start
				int y = Integer.parseInt(w[1])-1; 
				if(ch[x][y] == '.')
					out.println("NO BLOB");
				else {
					while (y>=0 && ch[x][y] != '.')
						y--;
					y++;
					while (x>=0 && ch[x][y] != '.')
						x--;
					x++;
					out.println((x+1) + " " + (y+1));
				}  
			}
		}
	}	
}
