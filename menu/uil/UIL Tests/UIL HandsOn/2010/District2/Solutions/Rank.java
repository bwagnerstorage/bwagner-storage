import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Rank {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("rank.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;

			String []s = kb.nextLine().trim().split(" ");
			int []a = new int [s.length - 1];
			int target = Integer.parseInt(s[s.length-1]);
			for(int j=0; j<s.length-1; j++)
				a[j] = Integer.parseInt(s[j]);
			int c = 0;		//count the number of ints to the left of and less than target
			int i = 0;
			while(a[i] != target) {
				if (a[i] < target)
					c++;
				i++;
			}
			out.println(c + i + 1);			
		}
	}
}
