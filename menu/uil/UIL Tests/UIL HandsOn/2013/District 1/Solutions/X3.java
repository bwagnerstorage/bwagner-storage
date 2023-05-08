import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class X3 {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("x3.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			String name = s[0];
			int a = Integer.parseInt(s[0]);	
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			int d = Integer.parseInt(s[3]);

			boolean flag = false;
			for(int i=-100; i<=100; i++) 
				if(a*i*i*i + b*i*i + c*i + d ==0) {
					out.print(i + " ");
					flag = true;
				}
			if(!flag)
				out.println("NO INTEGER SOLUTION");
			else
				out.println();
		}
	}	
}
