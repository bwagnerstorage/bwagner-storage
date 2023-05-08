import java.util.*;
import java.io.*;
import static java.lang.System.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class Pals {

	public static void main(String args[]) throws IOException
	{
	Scanner kb = new Scanner(new File("pals.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			
			times++;	
			String t = kb.nextLine().trim(); 
			String []s = t.split(" ");
			int numPals = 0;
			int num = Integer.parseInt(s[0]);
			int d = Integer.parseInt(s[1]);	
			if(num%10 == 0)
				out.println(numPals);
			else {
				int mult = num;
				while ((String.valueOf(mult)).length() < d ){
					mult+=num;
				}
				
				while ((String.valueOf(mult)).length() < d+1 ) {
					
					if(isPalindrome(String.valueOf(mult)))     
						numPals++;           
					mult+=num;
				}				
				out.println(numPals);
			}
		}
	}
	public static boolean isPalindrome(String a) {
		boolean boo = true; 
        for (int i=0; i < a.length()/2; i++) {
            if (a.charAt(i) != a.charAt(a.length()-1-i)) {
                boo = false;
            }
        }
        return boo;
    }
}
