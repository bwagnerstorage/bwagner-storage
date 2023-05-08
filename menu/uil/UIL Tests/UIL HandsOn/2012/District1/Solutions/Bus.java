import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Bus {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("bus.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			int [] sections = new int [s.length/2 + 1];
			int total = Integer.parseInt(s[0]);
			sections[0] = total;
			int min = total;
			for(int i=2; i<s.length; i+=2) {
				total += Integer.parseInt(s[i-1]);
				total += Integer.parseInt(s[i]);
				sections[i/2] = total;
				if(total < min)
					min = total;
			}
			for(int i=0; i<sections.length; i++) {
//				out.print(sections[i] +" ");
				if(sections[i] == min)
					out.print((char)('A' + i) + " ");
				
			}
			out.println(min);
		}
	}	
}
