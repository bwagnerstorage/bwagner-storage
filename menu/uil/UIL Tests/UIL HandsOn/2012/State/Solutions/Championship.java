import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Championship {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("championship.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			String event = kb.nextLine().trim();					  
			int numSwimmers = Integer.parseInt(kb.nextLine().trim()); 
			ArrayList<String> swimmers = new ArrayList<String> ();    
			int tempSwimmers = numSwimmers;
			for(int i=0; i<numSwimmers; i++) {
				String t = kb.nextLine().trim();
				String []s = t.split(" ");
				String first = s[0];
				String last = s[1];
				String time = s[2];
				if(!time.equals("DQ"))
					swimmers.add(time+" "+last+", "+first+" "+time);
				else
					tempSwimmers--;
			}
			numSwimmers = tempSwimmers;
			Collections.sort(swimmers);
			int order[] = {4,5,3,6,2,7,1,8};
			ArrayList <String> consolations = new ArrayList<String>();
			ArrayList <String> finals = new ArrayList<String>();
			for(int i=0; i<8; i++) 		//get swimmers for championships
				 finals.add(order[i]+" "+swimmers.get(i).substring(9));
			for(int i=0; i<Math.min(numSwimmers-8,8); i++)  //get swimmers for consolations
				consolations.add(order[i]+" "+swimmers.get(8+i).substring(9));
			Collections.sort(finals);			
			Collections.sort(consolations);
			out.println(event + " CONSOLATION FINALS");
			for(int i=0; i<consolations.size(); i++)				
				out.println(consolations.get(i)); 
			out.println();
			out.println(event + " CHAMPIONSHIP FINALS");
			for(int i=0; i<finals.size(); i++)				
				out.println(finals.get(i)); 					
			out.println();
	
		}
	}	
}
