import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Music {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("music.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		ArrayList<String> cd = new ArrayList<String>();
		int sum = 0;
		int cdNum = 1;
		while(times < count) {
			times++;		
			String t = kb.nextLine().trim();
			int sp = t.indexOf(" ",t.length()-7);
			String sub = t.substring(sp).trim();
			String title = t.substring(0,sp).trim();    
			String []s = sub.split(" ");

			int minutes = Integer.parseInt(s[0]);
			int secs = Integer.parseInt(s[1]);
			int seconds = 60*minutes + secs;  
			if(sum + seconds <= 1200) {
				cd.add(title);
				sum+=seconds;
			}
			else {
				out.println("CD #" + cdNum);
				out.println(cd.get(0));
				out.println(cd.get(cd.size()-1));
				minutes = sum / 60;
				secs = sum % 60;
				out.printf("%d:%02d",minutes, secs);
				out.println();
				out.println();
				cdNum++;
				sum = seconds;
				cd.clear();
				cd.add(title);
			} 
			if(times == count) {
				out.println("CD #" + cdNum);
				out.println(cd.get(0));
				out.println(cd.get(cd.size()-1));
				minutes = sum / 60;
				secs = sum % 60;
				out.printf("%d:%02d",minutes, secs);
				out.println();	
				out.println();	
			}
				
		}
	}	
}
