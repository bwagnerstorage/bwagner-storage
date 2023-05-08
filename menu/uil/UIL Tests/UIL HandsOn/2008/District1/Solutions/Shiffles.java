import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Shiffles {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("shiffles.dat"));

		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String [] s = kb.nextLine().trim().split(" ");
			int shift = Integer.parseInt(s[0]);
			char [] word1 = s[1].toCharArray();
			char [] word2 = s[2].toCharArray();
			Arrays.sort(word1);
			Arrays.sort(word2);
			boolean shiffle = true;
			for(int i=0; i<word1.length; i++) 
				if((int)word1[i] + shift != (int)word2[i]){
				 	shiffle = false;
				 	break;
				}
			if(shiffle)
				out.println("YES");
			else
				out.println("NO");		
		}
	}	
}
