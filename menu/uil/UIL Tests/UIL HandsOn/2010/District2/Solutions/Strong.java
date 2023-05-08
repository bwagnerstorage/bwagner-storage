import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Strong {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("strong.dat"));
		String special = "!@#$%^&*()_+=";
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
						
			boolean spec = false;
			boolean digit = false;
			boolean illegal = true;
			String word = kb.nextLine().trim();
			
			if(word.length() >= 8) {
				int i=0;
				for(i=0; i<word.length(); i++) {
					char ch = word.charAt(i);
					String chars = word.substring(i,i+1);
					
					if (!Character.isLetterOrDigit(ch) && !special.contains(chars)) {
						illegal = false;
						break;
					}
					if(special.contains(chars) || Character.isUpperCase(ch)) 
						spec = true;
					if(Character.isDigit(ch))
						digit = true;	
				}
			}
			if(spec && digit && illegal)
				out.println("STRONG");
			else
				out.println("INVALID");
					
		}
	}
}
