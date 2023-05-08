import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Multiple {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("multiple.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			int num = Integer.parseInt(s[0]);
			boolean digits = false;
			Integer temp = num;
			while(!digits) {		
				digits = true;
				temp += num;
				String word = temp.toString();			
				for(int i=0; i<word.length(); i++)  {
					String ch = word.substring(i,i+1);
					if(s[1].contains(ch)) {
					  	digits = false;
					  	break;
					}
				}
				if(digits)
					out.println(temp);
			}
		}
	}
}
