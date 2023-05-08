import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Values {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("values.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		String [] s = new String [count];
		while(times < count) {
			times++;		
			String t = kb.nextLine().trim();
			int sum = 0;
			for(int i=0; i<t.length(); i++) 	// find sum
				if(t.charAt(i) != ' ')
					sum += t.charAt(i) - 'A' + 1;
			String str = "00000000000000000000" + String.valueOf(sum);
			s[times-1] = str.substring(str.length() - 20) +" "+t;		
			
		}
		Arrays.sort(s);
		for(int i=0; i<s.length; i++) {
			String []word = s[i].split("[\\s]",2);
			int val = Integer.parseInt(word[0]);
			out.println(val + " " + word[1]);
		}
	}	
}
