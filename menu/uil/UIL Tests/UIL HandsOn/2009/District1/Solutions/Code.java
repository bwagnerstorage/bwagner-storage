import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Code {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("code.dat"));	
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			double cost = 0;
			String t = kb.nextLine();
			int len = (int)Math.sqrt(t.length());
			for(int i = 0; i<len; i++)
				for(int j = i; j<t.length(); j+=len)
					out.print(t.charAt(j));
			out.println();
		}
	}
}
