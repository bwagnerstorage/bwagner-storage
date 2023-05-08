import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Threes {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("threes.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			int x = (Integer.parseInt(kb.nextLine().trim()));
			boolean flag = false;
			int i = 2;
			int num30 = x;
			while(!flag) {
				num30 = x * i;
				flag =  check30(num30);
				i++;
			}
			out.println(num30);
		}
	}
	public static boolean check30 (int x) {
		String check = "12456789";	
		String xx = String.valueOf(x);
		for(int i=0; i<xx.length(); i++)
			if(check.indexOf(xx.charAt(i)) >= 0) 
				return false;
		return true;
	}
}
