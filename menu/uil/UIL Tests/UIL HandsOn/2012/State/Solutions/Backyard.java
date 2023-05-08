import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Backyard {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("backyard.dat"));
		double picket = 1.875;   // add spacing to board width
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			int len = Integer.parseInt(kb.nextLine().trim());
			int numBoards = (int) Math.ceil(2 * len / 6.); 

			double lenInches = len * 12;
			int numPickets = (int) (lenInches / picket);    
			numPickets += Math.ceil(len / 10.);  // add overage

			out.println(numBoards + " " + numPickets);
		}
	}	
}
