import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class FastMile {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("fastmile.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;	
			String s = kb.nextLine().trim();	
				
			String [] t = s.split(" ");
			ArrayList<String> al = new ArrayList<String> ();
			for(int i = 1; i< t.length; i++) 
				al.add(t[i]); 
			Collections.sort(al);
			out.println(t[0] + " " + al.get(0));
	
		}
				
	}

		 	
}
