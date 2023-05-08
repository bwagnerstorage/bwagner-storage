import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class PhoneNumbers {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("phonenumbers.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			boolean flag = true;
			String t = kb.nextLine().trim();
			if(t.charAt(3) != '-' || t.charAt(7) != '-' || t.length() != 12)
				flag = false;
			for (int i=0; flag && i<3; i++) 
				if( ! (t.substring(0,2).matches("\\d{3}") || 
				       t.substring(4,6).matches("\\d{3}") || 
				       t.substring(8,12).matches("\\d{4}") ))
					flag = false;
			if(flag)
				out.println(t);
			else
				out.println("INVALID PHONE NUMBER");
		}
	}	
}
