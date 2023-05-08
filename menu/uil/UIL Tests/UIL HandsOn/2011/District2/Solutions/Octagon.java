import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Octagon {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("octagon.dat"));
		
		int times = 0; 
		
		String t = kb.nextLine().trim();
		String []s = t.split(" ");
		int count = s.length;
		String pad = "                                         ";
		String ch = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		while(times < count) {
				
			int sides = Integer.parseInt(s[times]);
			out.println(pad.substring(0,sides-1) + ch.substring(0,sides));    // print top
			int i = 0;
			for( i=0; i<sides-1; i++) 										// print top diagonals
				out.println(pad.substring(0,sides-i-2) + "x" + pad.substring(0,sides+2*i) + "x");
			i--;
			for(int j=0; j<sides-1; j++) 									// print sides
				out.println("x" + pad.substring(0,sides+2*i) + "x");
			for( i=sides-2; i>0; i--) 										// print bottom diagonals
				out.println(pad.substring(0,sides-i-1) + "x" + pad.substring(0,sides+2*i-2) + "x");		
			out.println(pad.substring(0,sides-1) + ch.substring(0,sides));    // print bottom
			out.println();
			times++;		
		}
	}	
}
