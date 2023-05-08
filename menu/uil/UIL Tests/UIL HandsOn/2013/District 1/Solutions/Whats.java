import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Whats {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("whats.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			ArrayList<Integer>diff = new ArrayList<Integer>();
			ArrayList<Integer> d = new ArrayList<Integer>();
			
			int first = Integer.parseInt(s[0]);
			for(int i=1; i<29; i++) {
				int second = Integer.parseInt(s[i]);
				diff.add(second-first);
				d.add(second-first);
				first = second;
			}
			Collections.sort(d);
			
//			out.println(diff); out.println(); out.println(d);
			
			for(int i=0; i<4; i++) {
				int f = d.get(i);
				out.println(f + " " + (diff.indexOf(f)+1));
			}
			out.println();
		}
	}

}
