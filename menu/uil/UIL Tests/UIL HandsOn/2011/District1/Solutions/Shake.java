import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Shake {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("shake.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine();
			int len = t.length();
			int s = (int)(Math.sqrt(len));
			String [] a = new String[s];
			for(int i=0; i<s; i++)  
				a[i] = t.substring(i*s,i*s+s);	
			for(int i=0; i<s; i++)  {
				if(i%2 == 1)
					a[i] = a[i].charAt(s-1) + a[i].substring(0,s-1); 
				else 
					a[i] = a[i].substring(1) + a[i].charAt(0); 
			}			
			t = "";
			for(int i=0; i<s; i++)
			 	t += a[i];
			a = t.split("[*]");
			out.println(a[0]);
		}
	}	
}
