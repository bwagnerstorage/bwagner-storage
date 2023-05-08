import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Duplicates {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("duplicates.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;

			String word = kb.nextLine().trim();
			
			if(word.matches(".*A+.*E+.*I+.*O+.*U+.*"))  
				out.println("YES");
			else
				out.println("NO");
					
		}
	}
}
