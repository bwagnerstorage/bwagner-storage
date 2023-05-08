import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Message {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("message.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			int len = Integer.parseInt(kb.nextLine().trim());
			String t = kb.nextLine().trim();
			String []s = t.split("[ ,.]");
			for(int i=0; i<s.length; i++) {
				if(s[i].length() == len)
					out.print(s[i]+" ");
			}
			out.println();	
		}
	}	
}
