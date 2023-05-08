import java.util.*;
import java.io.*;
import static java.lang.System.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class Status {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("status.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;

			String []s = kb.nextLine().trim().split(" ");
			int []a = new int [s.length];
			
			Map<Integer, ArrayList<Integer> > m = new TreeMap<Integer, ArrayList<Integer> > ();
			
			for(int i=0; i<s.length; i++)
				a[i] = Integer.parseInt(s[i]);
			for(int i=0; i<a.length; i++) {	
				ArrayList<Integer> al = new ArrayList<Integer> ();
				int n = numLessThan(a,a[i]);
				int status = n + i + 1;  
				if(m.containsKey(status))  { 
					al = m.get(status);
					al.add(a[i]);
				}
				else {
					al.add(a[i]);
					m.put(status, al);
				}
	
			}
			Set<Integer> mm = new TreeSet(m.keySet());
			Iterator<Integer> it = mm.iterator();
															//out.println(mm +" "+m);
			while(it.hasNext()) {
            	ArrayList<Integer> al = new ArrayList<Integer> ();
            	al = m.get(it.next());
		Collections.sort(al);
		for(int i=0; i<al.size(); i++)
					out.print(al.get(i) + " ");
		
	 	}
	 	out.println();
		}
	}
	public static int numLessThan(int  a[], int tgt) {
		int c = 0;	int i=0;			
		for( i=0; i<a.length; i++) 
			if(a[i] < tgt) 
				c++;
		return c;
	}
}
