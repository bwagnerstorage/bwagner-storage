import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Count {
	

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("count.dat"));
		int count = 0;
		while(kb.hasNext()) {	
			kb.nextLine();
			count++;
		}
		out.println(count);
	}
	
}
