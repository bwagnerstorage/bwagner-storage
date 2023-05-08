import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Chairs {
	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("chairs.dat"));
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			int numPlayers = Integer.parseInt(kb.nextLine().trim())+1;
			String t[] = kb.nextLine().trim().split(", ");
			for(int i=numPlayers; i>1; i--) {
				ArrayList<String> a = new ArrayList<String>();				
				String []temp = kb.nextLine().trim().split(" ");
				int begin = Integer.parseInt(temp[0])-1;
				int omit = Integer.parseInt(temp[1]);
								
				for(int j=0; j<i; j++) {
					int index = (i+j-begin)%i;
					if(t[index] == null)
						break;
					a.add(t[index]);
				}
				if(begin >= omit) {
					a.add(0,a.remove(i-1));
				 	a.remove(omit-1);
				}
				else
					a.remove(omit-1);
				t = a.toArray(t);
				Iterator it = a.iterator();
				while(it.hasNext())
					out.print(it.next()+" ");
				out.println();
			}
			out.println();	
		}
	}	
}
