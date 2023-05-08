import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class ReversePals {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("reversepals.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			String t = kb.nextLine().trim();
			
			int iter = 0;
			while (!isPalindrome(t)) {
				iter++;
				String st = reverseString(t);
				int sum = Integer.parseInt(t) + Integer.parseInt(st);
//				out.println(t +" + "+ st +" = "+sum);		
					
				t = String.valueOf(sum);

			}
			out.println(t + " " + iter);
		}
	}
	public static boolean isPalindrome(String s) {
		for(int i=0; i<s.length()/2; i++) 
			if(s.charAt(i) != s.charAt(s.length() - i -1))
				return false;
		return true;		
	}
	public static String reverseString(String s) {
		String temp = "";
		for(int i=s.length()-1; i>=0; i--)
			temp += s.charAt(i);
		return temp;
	}	
}
