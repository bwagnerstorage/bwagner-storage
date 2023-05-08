import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Nautical {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("nautical.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			double nautMiles = 1.15 * Double.parseDouble(kb.nextLine().trim());

			out.printf("%.1f", nautMiles); 
			out.println();	
		}
	}	
}
