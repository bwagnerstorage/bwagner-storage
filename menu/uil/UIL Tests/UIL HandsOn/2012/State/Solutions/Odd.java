import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Odd {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("odd.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			char []s = t.toCharArray();
			Arrays.sort(s);
			t = String.valueOf(s);
			out.println(t);
	
		}
	}	
}
