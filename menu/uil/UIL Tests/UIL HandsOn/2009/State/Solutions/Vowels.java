import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Vowels {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("vowels.dat"));
		
		int times = 0; 
		String v = "AEIOU";
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			//find all 5 vowels
			ArrayList<Character> noVowels = new ArrayList<Character>();
			ArrayList<Integer> vowels = new ArrayList<Integer>();
			String word = kb.nextLine().trim();
			for(int i=0; i<5; i++) {
				char ch =v.charAt(i);
				int loc =word.indexOf(ch);
				if(loc < 0)
					noVowels.add(ch);			
				else
					vowels.add(loc);
			}
			if(noVowels.size()>0) {   //some vowels are not in word
				out.print("DOES NOT CONTAIN");
				for(int i=0; i<noVowels.size(); i++)
					out.print(" "+noVowels.get(i));
				out.println();
			}
			else {   // see if loc values are in order ==> vowels are in order
				int index1 = vowels.get(0);  // first A
				int index2 = vowels.get(1);  // first E
				int i = 1;
				while(index1 < index2 && i<4) {
					i++;
					index1 = index2;
					index2 = vowels.get(i);
				}
				if(i==4)			
					out.println("ALL, IN ORDER");
				else
					out.println("ALL, NOT IN ORDER");
			}		
		}
	}
}
