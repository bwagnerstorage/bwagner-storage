import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Rattle {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("rattle.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine();
			int len = t.length();
			int s = (int)(Math.sqrt(len));
			String [] a = new String[s];
			
			for(int i=0; i<s; i++)  {
				a[i] = "";
				for(int j=i; j<len; j+=s)
					a[i] += t.charAt(j);	
			}	
			for(int i=0; i<s; i++)  {
				if(i%2 == 1)
					a[i] = a[i].charAt(s-1) + a[i].substring(0,s-1); 
				else 
					a[i] = a[i].substring(1) + a[i].charAt(0); 
			}				
			t = "";
			for(int i=0; i<s; i++)
				for(int j=0; j<s; j++)
			 		t += a[j].charAt(i);
			a = t.split("[*]");
			out.println(a[0]);    
		}
	}	
}
