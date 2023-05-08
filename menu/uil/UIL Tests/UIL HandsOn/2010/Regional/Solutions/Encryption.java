import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Encryption {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("encryption.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String s = kb.nextLine().trim();
			String t = "";

			for(int i=0; i<16; i++) {
				char d = s.charAt(i);
				//change char to int, add 7, mod by 10
				t += ((int)(d-'0') + 7) % 10;			
			}
			for(int i=0; i<16; i+=4) {
				out.print((char)t.charAt(2+i));
				out.print((char)t.charAt(3+i));
				out.print((char)t.charAt(0+i));
				out.print((char)t.charAt(1+i));
			}
			out.println();						
		}
	}
}
