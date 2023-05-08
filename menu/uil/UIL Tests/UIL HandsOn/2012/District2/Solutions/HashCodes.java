import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class HashCodes {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("hashcodes.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			int len = Integer.parseInt(s[0]);
			int hash = Integer.parseInt(s[1]);

			switch (len) {
				case 3 : out.println(hash3(hash)); break;
				case 4 : out.println(hash4(hash)); break;
				case 5 : out.println(hash5(hash));
			}
		}
	}
	public static int hash3(int hash) {
		int c = 0;
		for(int i=1; i<=26; i++)
			for(int j=i+1; j<=26; j++)	
				for(int k=j+1; k<=26; k++)
					if(i+j+k == hash) 
						c++;
		return c;
	}
	public static int hash4(int hash) {
		int c = 0;
		for(int i=1; i<=26; i++)
			for(int j=i+1; j<=26; j++)	
				for(int k=j+1; k<=26; k++)
					for(int m=k+1; m<=26; m++)
						if(i+j+k+m == hash) 
							c++;
		return c;
	}
	public static int hash5(int hash) {
		int c = 0;
		for(int i=1; i<=26; i++)
			for(int j=i+1; j<=26; j++)	
				for(int k=j+1; k<=26; k++)
					for(int m=k+1; m<=26; m++)
						for(int n=m+1; n<=26; n++)
							if(i+j+k+m+n == hash) 
								c++;
		return c;
	}
}
