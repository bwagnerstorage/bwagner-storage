import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Multiplication {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("multiplication.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []tt = t.split(" ");

			int r = Integer.parseInt(tt[0]);
			int s = Integer.parseInt(tt[1]);
			int temp_s = s;
			for(int i=0; i<tt[1].length(); i++) {
				int x = temp_s%10;
				out.print(r*x + " ");
				temp_s /= 10;
				
			}
			out.println((long)r * s);	
		}
	}	
}
