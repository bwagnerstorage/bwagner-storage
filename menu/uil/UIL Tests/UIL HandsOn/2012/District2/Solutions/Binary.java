import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Binary {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("binary.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			String result = "";
			String [] s = new  String [4];
			// read in strings
			for(int i = 0; i<4; i++)
				s[i]=kb.nextLine().trim();
				
			//get hours	-- can't read the leading space
			result += chValue(s[3].charAt(0));	
			result += chValue(s[3].charAt(1)) + 2*chValue(s[2].charAt(0)) + 4*chValue(s[1].charAt(0))+ 8*chValue(s[0].charAt(0));	
			result += ":"; 
			//get minutes
			result += chValue(s[3].charAt(2)) + 2*chValue(s[2].charAt(1)) + 4*chValue(s[1].charAt(1));	
			result += chValue(s[3].charAt(3)) + 2*chValue(s[2].charAt(2)) + 4*chValue(s[1].charAt(2))+ 8*chValue(s[0].charAt(2));	
			result += ":";
			//get seconds
			result += chValue(s[3].charAt(4)) + 2*chValue(s[2].charAt(3)) + 4*chValue(s[1].charAt(3));	
			result += chValue(s[3].charAt(5)) + 2*chValue(s[2].charAt(4)) + 4*chValue(s[1].charAt(4))+ 8*chValue(s[0].charAt(4));	
			out.println(result);	
		}		
	}

	public static int chValue(char ch) {   //convert char to int
		if(ch== '*')
			return 1;
		return 0;
	}
}