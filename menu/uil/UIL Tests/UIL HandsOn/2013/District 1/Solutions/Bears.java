import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Bears {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("bears.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			String maps="";
			for(int i=0; i<10; i++)
				maps += kb.nextLine().trim();
			int numBears = 0;
			for(int j=0; j<maps.length(); j++) 
				if(maps.charAt(j) == 'B')
					numBears++;
			out.println(numBears);
		}
	}	
}
