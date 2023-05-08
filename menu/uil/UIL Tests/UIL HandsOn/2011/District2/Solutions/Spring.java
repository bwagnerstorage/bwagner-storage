import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Spring {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("spring.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String tt = kb.nextLine().trim();
			String []s = tt.split(" ");
			String name = s[0];
			int transactions = Integer.parseInt(s[1]);
			int t = 0;   // number of tubs
			int p = 0;   // number of packages
			int d = 0;   // amount of donations
			for(int i=0; i<transactions; i++) {
				tt = kb.nextLine().trim();
				s = tt.split(" ");
				for(int j=0; j<s.length; j++) {
					char ch = s[j].charAt(0);
					int num = Integer.parseInt((s[j].substring(1)).trim());  
					switch (ch) {
						case 'T' : t += num; break;
						case 'D' : d += num; break;
						case 'P' : p += num;
					}
				}
			}
			double sum = .45 * t * 15 + .48 * p * 14 + d;
			if (sum > 500) {
				out.printf("%s OVER $%.2f", name, sum-500.); 
				out.println();
			}
			else {
				out.printf("%s $%.2f", name, 500.-sum); 
				out.println();
			}	
		}
	}	
}
