import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Words {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("words.dat"));
		
		int times = 0; 
		TreeSet<String> dict = new TreeSet<String> ();
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;	
			
			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			for(int i=0; i<s.length; i++)
				dict.add(s[i]);
		}
		times = 0;
		count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String t = kb.nextLine().trim();
			String []s = t.split(" ");			
			int len = Integer.parseInt(s[0]);
			char ch = s[1].charAt(0);
			Iterator it = dict.iterator();
			boolean found = false;
			while(it.hasNext())  {
				String word = (String)(it.next());
				if(word.length() == len  && word.charAt(len-1) == ch) {
					out.println(word); 
					found = true;
				}
			}
			if(!found)
				out.println("NONE");
			out.println();
		}

	}	
}
