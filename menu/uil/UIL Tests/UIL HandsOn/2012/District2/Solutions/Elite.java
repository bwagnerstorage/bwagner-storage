import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Elite {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("elite.dat"));
		
		int times = 0; 
		ArrayList<Integer> al = new ArrayList<Integer> ();
		int i=0;
		for(i=1; i<1500; i+=2) 				// get Elite numbers
			al.add(i);
 		i = 2;
		while (al.get(i-1)<al.size()/2) {  // replace every nth number with zero
			int inc = al.get(i-1);
			int last = al.size()-1;
			int temp = inc;
			while(temp<last-inc) {
				al.set(temp-1,0);
				temp += inc;
			}
			for(int j=0; j<al.size(); j++)	// remove all zeros
				if(al.get(j).equals(0))
					al.remove(j);
                      	i++;
		}
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			int num = Integer.parseInt(kb.nextLine().trim());
			if(al.contains(num)) 
				out.println("ELITE");
			else
				out.println("NOT ELITE");

//			}
	
		}
	}	
}
