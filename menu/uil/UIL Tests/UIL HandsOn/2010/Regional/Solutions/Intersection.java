import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Intersection {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("intersection.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			int countSets = 2;
			int numSets = Integer.parseInt(kb.nextLine().trim());	
			String []t1 = kb.nextLine().trim().split(" ");
			String []t2 = kb.nextLine().trim().split(" ");

			TreeSet <Integer> a1 = new TreeSet<Integer> ();
			TreeSet <Integer> res = new TreeSet<Integer> ();

			for(int i=0; i<t1.length; i++)				//array 1
				a1.add(Integer.parseInt(t1[i]));

			
			for(int i=0; i<t2.length; i++) {			// elements common to array 1 and array 2
				Integer k = Integer.parseInt(t2[i]);
				if(a1.contains(k))
					res.add(k);
			}
			
			while(countSets < numSets) { 
				String []t = kb.nextLine().trim().split(" ");
				res = findDups(res, t);
				countSets++;
			}
			if(!res.isEmpty()) {
				for(Integer i : res)			// print the result
					out.print(i + " ");	
				out.println();	
			}
			else
				out.println("NO COMMON ELEMENT FOUND ");		
		}
	}
	public static TreeSet<Integer> findDups(TreeSet<Integer> r, String []t) {
		TreeSet <Integer> a = new TreeSet<Integer> ();
		TreeSet <Integer> temp = r;
		for(int i=0; i<t.length; i++)				//array to tree
			a.add(Integer.parseInt(t[i]));
			
			Iterator it = temp.iterator();			// remove elements in res that are not in array a
			while(it.hasNext()) {
				Integer item = (Integer)(it.next());
				if(!a.contains(item))
					it.remove();
			}
		return temp;
	}
}
