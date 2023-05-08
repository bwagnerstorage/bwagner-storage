import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Degree {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("degree.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			int []val = new int [s.length];
			for(int i=0; i<val.length; i++) 	// change to ints
				val[i] = Integer.parseInt(s[i]);
			int degree = 0;
			for(int i=0; i<val.length; i++)	{  // check array
				int small = 0;
				for(int j=i; j<val.length; j++)
					if(val[j] < val[i])            
						small++;					
				degree += small;                 
			}
			out.println(degree);
		}
	}	
}
