import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Dice {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("dice.dat"));
		
		String line = "-------";
		String one =   line + "\r\n|     |\r\n|  o  |\r\n|     |\r\n" + line;
		String two =   line + "\r\n| o   |\r\n|     |\r\n|   o |\r\n" + line;
		String three = line + "\r\n| o   |\r\n|  o  |\r\n|   o |\r\n" + line;
		String four =  line + "\r\n| o o |\r\n|     |\r\n| o o |\r\n" + line;
		String five =  line + "\r\n| o o |\r\n|  o  |\r\n| o o |\r\n" + line;
		String six =   line + "\r\n| o o |\r\n| o o |\r\n| o o |\r\n" + line;		

		int times = 0; 	
		int count = Integer.parseInt(kb.nextLine().trim());		
		while(times < count) {
			if (times>0) out.println();
                        times++;
			int num = Integer.parseInt(kb.nextLine().trim());

			switch (num) {
				case 1: out.println(one); break;
				case 2: out.println(two); break;
				case 3: out.println(three); break;
				case 4: out.println(four); break;
				case 5: out.println(five); break;
				case 6: out.println(six); break;
			}	
			
		}  
	}	
}
