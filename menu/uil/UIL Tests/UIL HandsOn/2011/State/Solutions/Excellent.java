import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Excellent {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("excellent.dat"));
		
		String t = kb.nextLine().trim();
		String []s = t.split(" "); 
		int s1 = Integer.parseInt(s[0]);
		int s2 = Integer.parseInt(s[1]);
		ArrayList<String> one = new ArrayList<String>();
		ArrayList<String> two = new ArrayList<String>();
		ArrayList<String> inOneNotTwo = new ArrayList<String>();	//ArrayList to hold elements in one but not in two
		ArrayList<String> inTwoNotOne = new ArrayList<String>(); //ArrayList to hold elements in two but not in one
		
		for(int i=0; i<s1; i++) 
			one.add(kb.nextLine().trim());
		for(int i=0; i<s2; i++) 
			two.add(kb.nextLine().trim());	

		Iterator it = one.iterator();
		while(it.hasNext()) {
			String temp = (String)(it.next());
			if(!(two.contains(temp)))
				inOneNotTwo.add(temp);
		}
		it = two.iterator();
		while(it.hasNext()) {
			String temp = (String)(it.next());
			if(!(one.contains(temp)))
				inTwoNotOne.add(temp);
		}
		
		Collections.sort(inOneNotTwo);
		Collections.sort(inTwoNotOne);
		
		out.println("NAMES IN SPREADSHEET 1 THAT ARE NOT IN SPREADSHEET 2");
		for(String st : inOneNotTwo)
			out.println(st);
		out.println("NAMES IN SPREADSHEET 2 THAT ARE NOT IN SPREADSHEET 1");
		for(String st : inTwoNotOne)
			out.println(st);			

	}	
}
