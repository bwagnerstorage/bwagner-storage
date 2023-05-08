import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class Life {

	public static void main(String args[]) throws IOException  	{
		Scanner kb = new Scanner(new File("life.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {	
			times++;	

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			String herStart = s[0];
			String herStop = s[1];
			t = kb.nextLine().trim();
			s = t.split(" ");
			for(int i=0; i<s.length/2; i++) {
				String hisStart=s[2*i];
				String hisStop =s[2*i+1];
				if( (herStart.compareTo(hisStart)>=0) && (herStart.compareTo(hisStop)<=0)||
					(herStop.compareTo(hisStart)>=0) && (herStop.compareTo(hisStop)<=0) ||
					(hisStart.compareTo(herStart)>=0) && (hisStart.compareTo(herStop)<=0)||
					(hisStop.compareTo(herStart)>=0) && (hisStop.compareTo(herStop)<=0) ) 
	
					out.println("DAY #"+times+" CONFLICT WITH CLASS #"+ (i+1));	
			}
		}
	}
}
