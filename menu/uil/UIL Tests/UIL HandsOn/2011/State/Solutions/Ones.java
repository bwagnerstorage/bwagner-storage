import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class Ones {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("ones.dat"));
		String t = kb.nextLine().trim();
		String s[] = t.split(" ");
		int count = s.length;
		int times = 0; 

		while(times < count) {
			int num = Integer.parseInt(s[times]);
			times++;	
			if(num%2==0 || num%5==0)
				out.println("INVALID INPUT");
			else	{
				String ones = "1";
				while(Long.parseLong(ones)%num != 0)
					ones+="1";
				out.println(ones.length());
			}
		}
	}	
}
