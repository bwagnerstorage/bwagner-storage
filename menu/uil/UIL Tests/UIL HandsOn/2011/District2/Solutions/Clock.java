import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Clock {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("clock.dat"));
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		m.put(12,11);
		m.put(1,10);
		m.put(2,9);
		m.put(3,8);
		m.put(4,7);
		m.put(5,6);
		m.put(6,5);
		m.put(7,4);
		m.put(8,3);
		m.put(9,2);
		m.put(10,1);
		m.put(11,12);
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(":");
			int hour = m.get(Integer.parseInt(s[0]));
			int minute = Math.abs(60 - Integer.parseInt(s[1]));
			if(minute == 60) {		// take care of even hours
				minute = 0;
				hour++;
			}
			out.printf("%d:%02d",hour, minute);
			out.println(); 	
		}
	}	
}
