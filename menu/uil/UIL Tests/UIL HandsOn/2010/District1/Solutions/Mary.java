import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Mary {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("mary.dat"));
		
		while(kb.hasNext()) {
			out.println(kb.nextLine().trim());
		}
	}
}
