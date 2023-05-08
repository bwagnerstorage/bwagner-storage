import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Semester {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("semester.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		Map<String, Integer> m = new TreeMap<String, Integer>();
		while(times < count) {
			times++;
			String [] t = kb.nextLine().trim().split(" ");
			double ave = (Double.parseDouble(t[1])+Double.parseDouble(t[2])+Double.parseDouble(t[3]))/3;
			double desired = Double.parseDouble(t[4]);
			int min = (int) Math.ceil((desired - .8*ave) / .2);
			m.put(t[0],min);			
		}
		Set s   = m.keySet();
		Iterator it = s.iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			int minimum = (int) m.get(key);
			out.println(key + " " + minimum);
		}
	}
}
