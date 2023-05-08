import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Vectors {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("vectors.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String s = kb.nextLine().trim();
			String [] t = s.split("[() ,]+");
	//		for (String st : t) 		out.println(st);
			int x = Integer.parseInt(t[1].trim());
			int y = Integer.parseInt(t[2].trim());
			for(int j=3; j<t.length; j+=2) {
				x += Integer.parseInt(t[j]);
				y += Integer.parseInt(t[j+1]);
			}
			out.println("("+ x + "," + y + ")");			
		}
	}
}
