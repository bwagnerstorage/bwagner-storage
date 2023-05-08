import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Superhero {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("superhero.dat"));
		
		int len = 24; 
		String [] s = new String[17];
		String b = "                          ";
		int i = 0;
		while(kb.hasNext()) {
			s[i] = kb.nextLine() + b;	
			i++;
		}	
		for(int r=0; r<17; r++) {
			for(int c=24; c>=0; c--)
				out.print(s[r].charAt(c));
			out.println();
		}
	}	
}
