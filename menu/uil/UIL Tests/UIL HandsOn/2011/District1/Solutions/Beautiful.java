import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Beautiful {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("beautiful.dat"));
		
		int times = 0;
		double sum = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;	
				
			String []s = kb.nextLine().trim().split(" ");		
			sum += Double.parseDouble(s[1]);
		}
		out.printf("$%.2f",sum);
		out.println();
	}	
}
