import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class CDs {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("cds.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;	
			int sum = 0;	
			int cdNum = 0;	
			int numSongs = Integer.parseInt(kb.nextLine().trim());	
			for(int i=0; i<numSongs; i++) {
				String t = kb.nextLine().trim();
				String []s = t.split(" ");
	
				int minutes = Integer.parseInt(s[0]);
				int secs = Integer.parseInt(s[1]);
				int seconds = 60*minutes + secs;  
				if(sum + seconds <= 1200) {
					sum+=seconds;
				}
				else {
					cdNum++;
					sum = seconds;
				} 
				
					
			}
			if(sum>0)
				cdNum++;
			out.println("PARTY #"+times+": "+cdNum);		
		}
	}	
}
