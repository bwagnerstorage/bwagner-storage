import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Weak {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("weak.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			boolean vowel = false;
			boolean consonant = false;
			boolean digit = false;
			boolean consecutive = false;
			String vowels = "AEIOUaeiou";
			String word = kb.nextLine().trim();
			
			if(word.length() >= 8) {
				for(int i=0; i<word.length(); i++) {
					char ch = word.charAt(i);
					String chars = word.substring(i,i+1);
					
					if (Character.isLetter(ch) && vowels.contains(chars))
						vowel = true;
					if (Character.isLetter(ch) && !vowels.contains(chars))
						consonant = true;
					if(Character.isDigit(ch))
						digit = true;	
				}
				int c = 0;
				for(int i=0; i<word.length()-2; i++) {
					String char1 = word.substring(i,i+1);
					String char2 = word.substring(i+1,i+2);
					String char3 = word.substring(i+2,i+3);
					if (vowels.contains(char1)&&vowels.contains(char2)&&vowels.contains(char3)){
						consecutive = true;
						break;
					}	
				}
			}
			
			if(vowel && consonant && digit && !consecutive)
				out.println("VALID");
			else
				out.println("WEAK");
					
		}
	}
}
