import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Roses {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("roses.dat"));

		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String t[] = kb.nextLine().trim().split(", ");
			String rose[] = kb.nextLine().trim().split(" ");
			ArrayList<String> a = new ArrayList<String>();
			for(int i=0; i<t.length; i++)
				a.add(t[i]);
			int j = 0;
			while(a.size()>1) { 
				int numPetals = Integer.parseInt(rose[j++]);
				int loser = (numPetals-1) % a.size();
				out.println("LOSER " + a.get(loser));
				a.remove(loser);	
				for(int i=loser; i<a.size(); i++) 
					a.add(0,a.remove(a.size()-1));
			}
			out.println("WINNER "+a.get(0));
			out.println();
		}
	}	
}
