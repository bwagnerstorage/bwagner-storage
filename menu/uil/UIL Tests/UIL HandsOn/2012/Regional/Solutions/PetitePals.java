import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class PetitePals {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("petitepals.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			ArrayList<String> a = new ArrayList<String>();
			String t = kb.nextLine().trim();
			int len = t.length();
			String st = "";
			for(int i=0; i<len; i++) {
				for(int j=i+1; j<len + 1; j++) {
					st = t.substring(i,j);
					if(isPalindrome(st) && st.length() < len)
						if(!a.contains(st))
							a.add(st);
				}
			}
			out.println(a.size());

		}
	}
	public static boolean isPalindrome(String s) {
		for(int i=0; i<s.length()/2; i++) 
			if(s.charAt(i) != s.charAt(s.length() - i -1))
				return false;
		return true;		
	}	
}
