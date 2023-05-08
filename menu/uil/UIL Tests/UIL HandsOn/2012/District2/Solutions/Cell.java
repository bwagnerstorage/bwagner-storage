import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class Cell {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("cell.dat"));
		

		int a = 0;
		int b = 0;
		while(kb.hasNext()) {
			double d = Double.parseDouble(kb.nextLine().trim());
			a += Math.floor(d);
			b += Math.ceil(d);
		}	
		out.println("PLAN A: " + a); 
		out.println("PLAN B: " + b);
	}	
}
