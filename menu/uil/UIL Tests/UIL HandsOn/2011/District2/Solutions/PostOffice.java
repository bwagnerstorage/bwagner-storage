import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class PostOffice {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("postoffice.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;	
			double sum = .4;	
			String t = kb.nextLine().trim();
			String []s = t.split(" ");	
			for(int i=0; i<s.length; i++) 
				sum += Double.parseDouble(s[i]);
			if(sum<5.0)
				out.println("OK");	
			else
				out.println("OVERWEIGHT");	
		}
	}	
}
