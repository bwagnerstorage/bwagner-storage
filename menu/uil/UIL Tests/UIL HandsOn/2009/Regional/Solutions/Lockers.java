import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Lockers {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("lockers.dat"));
		
		int times = 0; 	
		int count = Integer.parseInt(kb.nextLine().trim());		
		while(times < count) {
			times++;
			String[] s = kb.nextLine().trim().split(" ");
			int target = Integer.parseInt(s[2]); //target locker	
			int begin = Integer.parseInt(s[3]);  // first guess
			
			int diff = Math.abs(begin - target);
			if(target==begin)
				out.println(target+" FOUND ON FIRST TRY");
			else {
				for(int i=4; i<s.length; i++) {
					int guess = Integer.parseInt(s[i]);
					if(guess == target) 
						break;		
					int newDiff = Math.abs(guess - target);
					if(newDiff > diff)
						out.println(guess+" "+"COLDER");
					else if(newDiff == diff)
						out.println(guess+" "+"SAME");
					else 
						out.println(guess+" "+"WARMER");	
					diff = newDiff;
				}
			out.println(target+" "+"FOUND");
			}
			out.println();
		}  
	}	
}
