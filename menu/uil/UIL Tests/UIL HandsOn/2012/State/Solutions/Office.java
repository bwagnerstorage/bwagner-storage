import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Office {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("office.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			int numPeople = Integer.parseInt(kb.nextLine().trim());
			Map<String, Double> mp = new TreeMap<String, Double>();
			for(int i=0; i<numPeople; i++) {
				String t = kb.nextLine().trim();
				String []s = t.split(" ");
				String name = s[0];	
				double amt = Double.parseDouble(s[1]);		//initial budget
				if(!mp.containsKey(name)) 					//not in map, add him
					mp.put(s[0],-1 * amt);
				else {										//in map, add value to current value
					double temp = mp.get(name);
					mp.put(name, temp - amt);
				}
				double part = amt / (s.length - 2);					//amt to give to each person
				for(int j=2; j<s.length; j++) {
					name = s[j];
					if(!mp.containsKey(name)) 				//not in map, add him
						mp.put(s[j], part);
					else {									//in map, add value to current value
						double temp = mp.get(name);
						mp.put(name, temp + part);  	
					}
				}
			}
			Set set = mp.entrySet(); 
			Iterator it = set.iterator(); 
			while(it.hasNext()) { 
				Map.Entry me = (Map.Entry)it.next(); 
				System.out.print(me.getKey() + " "); 
				double temp = (Double) me.getValue();
				System.out.printf("%.2f", temp); 
				out.println();
			} 
			out.println();

				
		}
	}	
}
