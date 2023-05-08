import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Emirp {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("emirp.dat"));
		
		while(kb.hasNext()) {
			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int count = 0;
			while(a <= b ) {
				String r = String.valueOf(a);
	        		String rev = "";
      	  			for(int i=r.length()-1; i>=0; i--) {
        				rev += r.charAt(i);
				}
				if(isEmirp(a) 
				   && isEmirp(Integer.parseInt(rev))
				   && !rev.equals(r)) {
					out.print(a + " ");
					count++;
				}
				a++;
			}
			if(count == 0)
				out.println("NONE");
			else
				out.println();
		}
	}
	public static boolean isEmirp(int a) {
	        for (int i=2; i < (1+Math.sqrt(a)); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
}
