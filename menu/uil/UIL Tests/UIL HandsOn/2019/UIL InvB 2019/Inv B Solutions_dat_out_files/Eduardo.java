//2019 UIL B Packet - Solution
//Eduardo
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Eduardo {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("eduardo.dat"));
		while(f.hasNextLine()) {
			String text=f.nextLine();
			String first_word="";
			if(text.indexOf(" ")!=-1)
				first_word=text.substring(0, text.indexOf(" "));
			else //if there is only one word in the text
				first_word=text;
			int len=first_word.length();
			String code="";
			for(int i=0;i<text.length();i++) {
				char c=text.charAt(i);
				if(text.charAt(i)!=' ') {					
					if(c+len>122)//wrap around to the front of the alphabet
						c=(char)((c+len)%122+96);
					else//just add the shift number
						c=(char)((c+len));
					code+=c;
				}
				else
					code+=c;//add the space to the string			
				}
			out.println(code);
		}
	}
}
