import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class MedMile {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("medmile.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			String name = s[0];
			ArrayList<String> al = new ArrayList<String> ();
			for(int i=1; i<s.length; i++) 
				al.add(s[i]);
			Collections.sort(al);
			int len = al.size();
			if(len%2 == 1)
				out.println(name + " " + al.get(len/2));
			else {
				s = al.get(len/2 - 1).trim().split(":");
				int minute = Integer.parseInt(s[0]);
				double seconds = Double.parseDouble(s[1]);
				s = al.get(len/2).trim().split(":");
				minute += Integer.parseInt(s[0]);
				seconds += Double.parseDouble(s[1]);
				seconds += minute * 60;					//convert minutes to seconds
				seconds /= 2;
				minute = (int) seconds/60;              //extract minutes
				out.print(name + " " + minute + ":");
				seconds = (int) (seconds * 100) / 100.;  //truncate to hundredths
				seconds = seconds % 60;		
				out.printf("%05.2f", seconds); 
				out.println();


			}
		}
	}	
}
