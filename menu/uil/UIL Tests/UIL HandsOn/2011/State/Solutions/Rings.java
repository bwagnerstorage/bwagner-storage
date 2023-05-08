import java.util.*;
import java.io.*;
import static java.lang.System.*;



public class Rings {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("rings.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			String t = kb.nextLine().trim();
			int tLen = t.length();				//length of string
			String clock = t;
			clock+=t;							//add t to string
			// case B=1, W=0				
			String clockB = clock.replaceAll("B","1");
			clockB = clockB.replaceAll("W","0");
			int min = Integer.MAX_VALUE;
			int max = 0;
			for (int i=0; i<tLen; i++) {
				String p = clockB.substring(i,i+tLen);
				int v = Integer.valueOf(p,2);
				if(v<min)
					min=v;
				if(v>max)
					max=v;
			}
			// case B=1, W=0 counter-clockwise
			String revB = "";
			for(int i = 0; i < clockB.length(); i++)
				revB += clockB.charAt(clockB.length()-i-1);

			for (int i=0; i<tLen; i++) {
				String p = revB.substring(i,i+tLen);
				int v = Integer.valueOf(p,2);
				if(v<min)
					min=v;
				if(v>max)
					max=v;
			}
			// case B=0, W=1
			String clockW = clock.replaceAll("W","1");
			clockW = clockW.replaceAll("B","0");
			for (int i=0; i<tLen; i++) {
				String p = clockW.substring(i,i+tLen);
				int v = Integer.valueOf(p,2);
				if(v<min)
					min=v;
				if(v>max)
					max=v;
			}		
			// case B=0, W=1 counter-clockwise
			String revW = "";
			for(int i = 0; i < clockW.length(); i++)
				revW += clockW.charAt(clockW.length()-i-1);
			for (int i=0; i<tLen; i++) {
				String p = revW.substring(i,i+tLen); 
				int v = Integer.valueOf(p,2);
				if(v<min)
					min=v;
				if(v>max)
					max=v;
			}		
			out.println(min +" "+max);
			
		}
	}	
}
