import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class Qualified {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("qualified.dat"));
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String []t = kb.nextLine().trim().split(" ");	
			if(t[2].equals("STC") && (Integer.parseInt(t[1]) >= 560))
				out.println(t[0]);
			else if(t[2].equals("WTC") && Integer.parseInt(t[1]) >= 340)
				out.println(t[0]);	
			else if(t[2].equals("NTC") && Integer.parseInt(t[1]) >= 420)
				out.println(t[0]);
			else if(t[2].equals("CTC") && Integer.parseInt(t[1]) >= 370)
				out.println(t[0]);
			else if(t[2].equals("LVC") && Integer.parseInt(t[1]) >= 470)
				out.println(t[0]);
		}
	}	
}
