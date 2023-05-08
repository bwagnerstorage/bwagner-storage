import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Elevator {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("elevator.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");

			s = t.split(" ");
			int sum = Integer.parseInt((s[0].trim()));
			int numPeople = 1;
			while(sum <= 2000 && numPeople < s.length) {
				sum += Integer.parseInt((s[numPeople].trim()));
				numPeople++;
				
			}
			if(sum==2000 || numPeople==s.length)
				numPeople++;
			out.println(numPeople-1);	
		}
	}	
}
