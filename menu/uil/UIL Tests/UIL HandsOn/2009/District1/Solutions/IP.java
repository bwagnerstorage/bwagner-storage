import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class IP {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("ip.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String num = kb.nextLine().trim();
			out.print(Integer.parseInt(num.substring(0,8),2)+".");
			out.print(Integer.parseInt(num.substring(8,16),2)+".");
			out.print(Integer.parseInt(num.substring(16,24),2)+".");
			out.println(Integer.parseInt(num.substring(24),2));
		}
	}
}
