import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Landscape {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("landscape.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			char [][] ch = new char [15][10];	
			for(int i=0; i<10; i++) {
				String s = kb.nextLine().trim();
				for(int j=0; j<15; j++)
					ch[14-j][i] = s.charAt(j);
			}	
			for(int i=0; i<15; i++) {
				for(int j=0; j<10; j++) 
					out.print(ch[i][j]);
				out.println();
			}
			out.println(kb.nextLine());
		}
	}	
}
