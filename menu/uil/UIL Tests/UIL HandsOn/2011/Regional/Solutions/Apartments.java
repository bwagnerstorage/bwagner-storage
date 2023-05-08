import java.io.*;
import java.util.*;
import static java.lang.System.*;  



public class Apartments {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("apartments.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			int apts = Integer.parseInt(kb.nextLine().trim());
			int sum = 0;
			int notRented = 0;
			for(int i=0; i<apts; i++) {
				String t = kb.nextLine().trim();	
				String []s = t.split(" ");
				int num = Integer.parseInt(s[1]);
				if(num == 0)
					notRented++;
				else
					sum += num;
			}
			double ave = (double)sum/(apts-notRented);
			if (ave > 4)
				out.println("NO " + notRented); 
			else
				out.println("YES " + notRented); 
		}
	}	
}
