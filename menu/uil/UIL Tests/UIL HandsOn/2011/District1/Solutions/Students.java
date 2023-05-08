import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Students {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("students.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		int []bar = {0,0,0,0,0,0,0};
		
		for(int i=0; i<count; i++) {
			String t = kb.nextLine().trim();
			String []n = t.split(" "); 
			int num = Integer.valueOf(n[n.length - 1]);
			if(num < 40) 
				bar[0]++;
			else if (num < 50)
				bar[1]++;
			else if (num < 60)
				bar[2]++;	
			else if (num < 70)
				bar[3]++;	
			else if (num < 80)
				bar[4]++;	
			else if (num < 90)
				bar[5]++;
			else
				bar[6]++;
		}
		out.print("   <40: ");
		for(int i=0; i<bar[0]; i++)
			out.print("*");
		out.println();
		out.print(" 40-49: ");
		for(int i=0; i<bar[1]; i++)
			out.print("*");
		out.println();
		out.print(" 50-59: ");
		for(int i=0; i<bar[2]; i++)
			out.print("*");
		out.println();
		out.print(" 60-69: ");
		for(int i=0; i<bar[3]; i++)
			out.print("*");
		out.println();
		out.print(" 70-79: ");
		for(int i=0; i<bar[4]; i++)
			out.print("*");
		out.println();
		out.print(" 80-89: ");
		for(int i=0; i<bar[5]; i++)
			out.print("*");
		out.println();
		out.print("90-100: ");
		for(int i=0; i<bar[6]; i++)
			out.print("*");
		out.println();
	}	
}
