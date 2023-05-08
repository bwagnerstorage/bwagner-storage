import java.util.*;
import java.io.*;
import static java.lang.System.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class Palindrome {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("palindrome.dat"));
		int dash = 1;
		Map <String,Integer> m = new TreeMap <String,Integer> ();
		String t = kb.nextLine().trim(); // read number of data sets
		while(kb.hasNext()) {
			t = kb.nextLine().trim(); 			
			if(t.equals("-")) {						//print results
			 	out.println("ESSAY #" + dash +":");
				Set ks = m.entrySet();
				Iterator it = ks.iterator();
				while(it.hasNext()) {
					Map.Entry<String, Integer> me = (Map.Entry)it.next();
					out.print(me.getKey());
					int v = (Integer)(me.getValue());
					if(v > 1)
						out.println(" (" + v + ")");
					else
						out.println();
				}
				out.println();
				m.clear();
				dash++;
			}
			else {									//read data; put in map
				String []s = t.split("[ .,]+");
				for(int i=0; i<s.length; i++) 
					if(s[i].length() > 1) 
						if(isPalindrome(s[i]))
							if(!(m.containsKey(s[i]))) 
								m.put(s[i],1);
							else {
								int x = (int)(m.remove(s[i]));
								x++;  
								m.put(s[i],x);
							}
			}		
		}
	}
	public static boolean isPalindrome(String a) {
		boolean boo = true; 
        for (int i=0; i < a.length()/2; i++) {
            if (a.charAt(i) != a.charAt(a.length()-1-i)) {
                boo = false;
            }
        }
        return boo;
    }
}
