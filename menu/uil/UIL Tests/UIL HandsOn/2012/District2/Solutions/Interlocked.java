import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Interlocked {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("interlocked.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			boolean interlock = true;
			int index = 0;
			for (int i=0; interlock && i<s[0].length(); i++) {
				int a = s[2].indexOf(s[0].charAt(i),index ); 
				if(a<0)
					interlock = false;
				else 
					index=a;
			}
			index=0;
			for (int i=0; interlock && i<s[1].length(); i++) {
				int a = s[2].indexOf(s[1].charAt(i),index );
				if(a<0)
					interlock = false;
				else 
					index=a;
			}
			
					
			if(interlock) 
				out.println("YES");
			else
				out.println("NO");
		}
	}	
}
