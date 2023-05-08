import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Base3 {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("base3.dat"));

		while(kb.hasNext()) {
			String geek = kb.nextLine().trim();
			int exp = geek.length()-1;
			int sum = 0;
			for(int i=0; i<geek.length(); i++) {
				char ch =geek.charAt(i);
				switch(ch) {
					case 'M' : sum+=Math.pow(3,exp-i);break;
					case 'A' : sum+=-1 * Math.pow(3,exp-i);
//					case 'O' : sum+=0 * Math.pow(3,exp-i);
				}
			}
			out.println(sum);
		}
	}
}
