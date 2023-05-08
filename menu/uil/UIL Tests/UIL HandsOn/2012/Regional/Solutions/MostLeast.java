import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class MostLeast {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("mostleast.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split("[ ,.?]+");
			Map <String, Integer> mp = new TreeMap <String, Integer> ();

			for(int i=0; i<s.length; i++) {
				int tempCount = 0;
				String word = s[i];	
				if(!mp.containsKey(word)) 					//not in map, add word
					mp.put(s[i],1);
				else {										//in map, add value to current value
					int temp = mp.get(word);
					mp.put(word, temp + 1);
				}
			}
			int min = 100;
			int max = 0;						

			Set set = mp.entrySet(); 
			Iterator it = set.iterator(); 
			while(it.hasNext()) { 
				Map.Entry me = (Map.Entry)it.next(); 
				int temp = (Integer) me.getValue();
				if(temp > max)
					max = temp;
				if(temp < min)
					min = temp;
			}

			it = set.iterator();
			boolean flag = true;					
			while(it.hasNext()) {						//print most words
				Map.Entry me = (Map.Entry)it.next();
				if((Integer) me.getValue() == max) {
					if(flag) {							//print max value
						out.print(max + " ");
						flag = false;
					}
					out.print(me.getKey() + " ");
				}
			}
			out.println();
			it = set.iterator();
			flag = true;
			while(it.hasNext()) {						//print least words
				Map.Entry me = (Map.Entry)it.next();
								
				if((Integer) me.getValue() == min) {
					if(flag) {							//print max value
						out.print(min + " ");
						flag = false;
					}
					out.print(me.getKey() + " ");
				}
			}
			out.println();
		}
	}	
}
