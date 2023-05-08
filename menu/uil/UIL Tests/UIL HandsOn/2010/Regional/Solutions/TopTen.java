import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class TopTen {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("topten.dat"));
		String [] list = new String[10];
		for(int i=0; i<10; i++)
			list[i] = (kb.nextLine().trim());
		for(int i=9; i>=0; i--)
			out.println(list[i]);
	}
}
