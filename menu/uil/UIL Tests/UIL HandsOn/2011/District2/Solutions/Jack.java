import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Jack {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("jack.dat"));
		while(kb.hasNextLine()) {
			kb.nextLine();
			if(kb.hasNextLine())
				out.println(kb.nextLine());
		}
	}
}
