//UIL 2018 - Invitational B - Barb
import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Math.*;

class Barb{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("barb.dat"));
		while(f.hasNext())
		{
			String s = f.next();
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			out.print(s+" "+new String(sb).toUpperCase()+" ");
			out.println(new String(sb).substring(s.length()/2)+" "+s.substring(s.length()/2).toUpperCase());
			
		}
	}
}
