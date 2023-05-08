import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Difference {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("difference.dat"));

		double leslie = Double.parseDouble(kb.nextLine());
		float sum = 0;
		while(kb.hasNext()) {
			double grade = Double.parseDouble(kb.nextLine());
			if(grade > 90)
				leslie += grade - Math.floor(grade);
		}
		out.println(Math.round(leslie));			
	}	
}
