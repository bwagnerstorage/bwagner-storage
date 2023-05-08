import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class Local {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("local.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			int year = Integer.parseInt(s[0]);
			int below30 = 0;
			int above50 = 0;

			for(int i=1; i<=31; i++) {
				int temp = Integer.parseInt(s[i]);
				if (temp < 32) 
					below30++;
				else if (temp >50)
					above50++;
			}
			out.println(year + " " + below30 + " " + above50);	
		}
	}	
}
