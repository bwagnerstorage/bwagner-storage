import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Words {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("words.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			String name = s[0];
			out.print(name+" ");
			for(int i=1; i<s.length; i++) {
				out.print(s[i].charAt(0)+" ");
			}
			out.println();
		}
	}	
}
