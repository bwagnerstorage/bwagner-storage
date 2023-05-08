import java.util.*;
import java.io.*;
import static java.lang.System.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class Digicount {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("digicount.dat"));
		String t = kb.nextLine().trim(); // read number of data sets
		String [] s = t.split(" ");
		int times = 0; 
		int count = s.length;
		while(times < count) {	
			int x = Integer.parseInt(s[times]);	
			String digits = "";
			for(int i=1; i<=x; i++)
				digits += i;			
			int [] ch = new int [10];
			for(int i=0; i<digits.length(); i++)
				ch[digits.charAt(i) - '0']++;
			for(int i=0; i<10; i++) 		
				out.print(ch[i] + " ");
			out.println();
			times++;	
		}
	}
}
