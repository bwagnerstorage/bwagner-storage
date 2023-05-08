import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Candy {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("candy.dat"));

		int times = 0; 
		int count = kb.nextInt();
		String ff = kb.nextLine();
		while(times < count) {
			times++;
			String [] s = kb.nextLine().trim().split(" ");
			ArrayList<Integer> numCandies = new ArrayList<Integer>();
			for(int i=0; i<s.length; i++)
				numCandies.add(Integer.parseInt(s[i]));
			int sum = 0;
			for (Integer i : numCandies)
			 	sum += i;
			int numPackage = sum / numCandies.size();
			int teacher = sum % numCandies.size();
			for (Integer i : numCandies)
				out.print(numPackage - i + " ");
			out.println(teacher);			
		}
	}	
}
