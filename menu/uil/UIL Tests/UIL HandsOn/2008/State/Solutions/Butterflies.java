import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Butterflies {
	

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("butterflies.dat"));

		int times = 0;
		int count = kb.nextInt();
		String ff = kb.nextLine();
		TreeMap<String,String> data = new TreeMap<String,String> ();
		while(times < count) {
			times++;
			String []s = kb.nextLine().trim().split(", ");
			data.put(s[0],s[1]);
		}
		times = 0;
		count = kb.nextInt();
		ff = kb.nextLine();
		while(times < count) {
			times++;
			String color = kb.nextLine().trim();
			out.println(color + ":");
			Iterator<String> it = data.keySet().iterator();
			while(it.hasNext()) {
				String str = it.next();
				String strColor = data.get(str);
				if(strColor.equals(color))
					out.println(str);
			}
			out.println();
		}
				
	}

}









