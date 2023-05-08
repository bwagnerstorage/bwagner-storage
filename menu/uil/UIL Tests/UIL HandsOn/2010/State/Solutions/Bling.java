import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Bling {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("bling.dat"));
		while(kb.hasNext()) {
			int n = Integer.parseInt(kb.nextLine().trim());	
		
			String s = "                                 ";
			for(int i=0; i<n/2 + 1; i++) {
				out.print(s.substring(0,n/2-i));
				for(int j=0; j<2*i+1; j++)
					out.print("*");
				out.println();
			}
			for(int i=n/2-1; i>=0; i--) {
				out.print(s.substring(0,n/2-i));
				for(int j=0; j<2*i+1; j++)
					out.print("*");
				out.println();
			}	
			out.println();
		}		
	}	
}
