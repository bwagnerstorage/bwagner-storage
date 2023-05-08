import java.io.*;
import java.util.*;
import static java.lang.System.*;  



public class Burpees {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("burpees.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			int num = Integer.parseInt(kb.nextLine().trim());
			int total = num * (num + 1) / 2;
			out.println(total);
		}
	}	
}
