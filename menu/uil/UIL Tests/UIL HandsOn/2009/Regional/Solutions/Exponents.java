import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Exponents {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("exponents.dat"));
		while(kb.hasNext()) {
			String t[] = kb.nextLine().trim().split(" ");
			int n = Integer.parseInt(t[0]);
			long num = Long.parseLong(t[1]);
			int p = 0;
			long temp = 1;
			while(temp != num) {
				temp *= n;
				p++;
			}
			out.println(p);
		}
	}
}
