import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Diamonds {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("diamonds.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			String fill = "                                                    ";
			String ch = s[0];
			int num = Integer.parseInt(s[1]);
			out.println(fill.substring(0, num/2)+ ch) ;
			for(int i=1; i<=num/2; i++) {
				String f1 = fill.substring(0, num/2 - i);
				String f2 = fill.substring(0, 2*i-1);
				out.println(f1 + ch + f2 + ch); 	
			}
			
			for(int i=num/2-1; i>0; i--) {
				String f1 = fill.substring(0, 2*i-1);
				String f2 = fill.substring(0, num/2 - i);
				out.println(f2 + ch + f1 + ch); 	
			}
			out.println(fill.substring(0, num/2)+ ch) ;			
			
			
			
			
			out.println();
		}
	}	
}
