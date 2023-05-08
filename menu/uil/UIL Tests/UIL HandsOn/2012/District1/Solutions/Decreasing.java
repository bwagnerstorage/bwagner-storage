import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Decreasing {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("decreasing.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			long x = (Long.parseLong(kb.nextLine().trim()));
			boolean flag = false;
			int i = 2;
			long num = x;
			while(!flag) {
				num = x * i;
				flag =  decrease(num);
				i++;
			}
			out.println(num);
		}
	}
	public static boolean decrease (long x) {
		String xx = String.valueOf(x);
		int i=0;
		for(i=0; i<xx.length()-1; i++)
			if(xx.charAt(i) < xx.charAt(i+1))
				return false;			
		return true;
	}
}
