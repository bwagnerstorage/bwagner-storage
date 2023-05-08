import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Duck {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("duck.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
            String strSeed = kb.nextLine();		// set seed
            long seed = Long.parseLong(strSeed);
            Random rand = new Random(seed);		
		
		int [] level = new int[count];
		while(times < count) {
			times++;		


            
            int sum = 0;
			for(int i=0; i<5; i++) 	// generate random number
				sum += rand.nextInt(10) + 1;
			 
			if (sum <= 25) 			// decide level
				level[0]++;
			else if (sum <= 30)
				level[1] ++;
			else if (sum <= 35)
				level[2] ++;
			else
				level[3]++;
		}
		out.println("Level 1: " + level[0]);
		out.println("Level 2: " + level[1]);			
		out.println("Level 3: " + level[2]);			
		out.println("Level 4: " + level[3]);			
	}	
}
