import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Buying {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("buying.dat"));
		double gas = 2.65;
		double oldCarGasCost = 12000.0 /12 * gas * 2;
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split("[-]+");
			String name = s[0]; 
			int mpg = Integer.parseInt(s[1]);;
			int price = Integer.parseInt(s[2]) - 4500; 
			double gasSavings = oldCarGasCost - 12000.0 / mpg * gas * 2 ;
			out.printf("%s $%d $%.2f", name, price, gasSavings); 
			out.println();
		}
	}	
}
