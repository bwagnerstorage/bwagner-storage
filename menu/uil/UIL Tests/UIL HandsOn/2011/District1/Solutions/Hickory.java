import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Hickory {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("hickory.dat"));
		while(kb.hasNextLine()) {
			out.println(kb.nextLine());
			if(kb.hasNextLine())
				kb.nextLine();
		}
	}
}
