import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class DVDs {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("dvds.dat"));

		int times = 0; 
		String [] s = kb.nextLine().trim().split(", ");
			ArrayList<String> a = new ArrayList<String>();
			for(int i=0; i<s.length; i++) 
				a.add(s[i]);		
		int count = Integer.parseInt(kb.nextLine().trim()); 
		while(times < count) {
			times++;
			String t[] = kb.nextLine().trim().split(", ");
			for(int i=0; i<t.length; i++) {
				if(a.contains(t[i]) )
					a.remove(t[i]);
				a.add(0,t[i]);
			}			
			int i=0;
			String crate[] = {"ALPHA", "BETA", "GAMMA"};
			int crateNum = 0;
			String target = kb.nextLine().trim();
			int targetNum = 0;
			boolean found = false;
			int ordinal = 1;
			while(!found) {
				double sum = 0;
				ordinal = 0;
				String item ;
				while(sum<=6.0 && i<a.size()-1) {
					
					item = a.get(i);
					if(item.endsWith(" (2)"))
						sum+=.875;
					else
						sum+=.625;
					if(sum>6.0)
						break;	
					if(item.equals(target)) {
						targetNum = ordinal;
						ordinal++;			
						found=true;
						break;
					}
					i++;
					ordinal++;									
				}	
				crateNum++;
			}	
			out.println(crate[crateNum-1] + " " + ordinal);			
		}
	}	
}
