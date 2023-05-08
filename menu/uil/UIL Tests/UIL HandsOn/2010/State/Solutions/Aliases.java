import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Aliases {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("aliases.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String []s = kb.nextLine().trim().split(", ");
			int i=0;
			while(i<s.length-1 && !s[i].equals(s[s.length-1]))
				i++;
			int alias = (i+1)*(i+1) + s[i].length() * s[i].length();
			out.println(alias);		
		}
	}
}
