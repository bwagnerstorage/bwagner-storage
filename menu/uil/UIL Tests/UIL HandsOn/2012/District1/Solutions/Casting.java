import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Casting {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("casting.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;	
			String s = 	kb.nextLine().trim();
			int sum = 0;
			for(int i=0; i<s.length(); i++) 				//change sum to int size
				sum += Integer.valueOf(s.charAt(i)-'0');
			int degree = 0;	
			if(sum > 9)
				degree++;
			while(sum>9) {
				s = String.valueOf(sum);
				sum = 0;
				for(int i=0; i<s.length(); i++) 
					sum += Integer.valueOf(s.charAt(i)-'0');				
				degree++;
			}
			out.println(degree);
		}
	}	
}
