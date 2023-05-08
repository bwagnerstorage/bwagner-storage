import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Quilt {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("quilt.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String s = "";
			for(int i=0; i<10; i++)  		// read in master pattern
				s += kb.nextLine().trim();
			
			int numTests = Integer.parseInt(kb.nextLine().trim());	//number of test patterns
		
			for(int t=0; t<numTests; t++) {
				Map<Character,Character> m = new TreeMap <Character,Character>();
				boolean match = true;
				String st = "";
				for(int i=0; i<10; i++)  		// read in test pattern
					st += kb.nextLine().trim();	
				m.put(s.charAt(0),st.charAt(0));
				
				int i = 1;
				while(match && i < s.length())	{
					if(!m.containsKey(s.charAt(i)))
						m.put(s.charAt(i),st.charAt(i));
					else if (!(m.get((Character)(s.charAt(i))).equals((Character)(st.charAt(i)))))
						match = false;
					i++;
				}
				if (match)
					out.println("SAME");
				else
					out.println("NOT SAME");		
						

			}
					
		}
	}


}
