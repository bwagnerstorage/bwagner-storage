import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Remnants {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("remnants.dat"));
		
		String [] s = kb.nextLine().trim().split(" ");
		int count = s.length;
		for(int i=0; i<count; i++) {
			int yard = Integer.parseInt(s[i]);
			int feet = (int)Math.ceil(yard * 3 / 14.);
			out.println(feet);
		}
	}	
}
