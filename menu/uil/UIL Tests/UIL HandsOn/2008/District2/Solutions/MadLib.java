import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class MadLib {
	
	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("madlib.dat"));
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine());
		while(times < count) {
			ArrayList<String> items = new ArrayList<String>();
			int numWords = Integer.parseInt(kb.nextLine().trim());	
			for(int i=0; i<numWords; i++)
				items.add(kb.nextLine().trim());
			
			String s = kb.nextLine().trim();	
			for(int i=0; i<items.size(); i++) {
				s += " " + items.get(i);
				String temp = kb.nextLine().trim();
				if(!(temp.startsWith(".") || temp.startsWith(",")))
					s += " ";
				s += temp;
			}
			int len = s.length();  
			int spot = 0;
			int begin = 0;
			while(len > 40 && begin+41 <= s.length()) {
				String sub = s.substring(begin, begin + 41); // finds space if word ends on 40th character
				spot = sub.lastIndexOf(' ');
				out.println(sub.substring(0, spot));
				len -= spot;
				begin += spot+1;
			}
			out.println(s.substring(begin));
			out.println();
			times++;
		}
	}
}
