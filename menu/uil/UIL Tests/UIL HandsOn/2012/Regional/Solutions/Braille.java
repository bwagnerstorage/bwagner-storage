import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Braille {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("braille.dat"));
		TreeMap <String, Character> mp = new TreeMap <String, Character> ();
	 	getMapping(mp);

		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
	
			char [][] s = new  char [3][];			// read in characters
			for(int i = 0; i<3; i++)
				s[i] = (kb.nextLine().trim()).toCharArray();
			String letter = "";	
			boolean digit = false;					//set flags
			boolean capital = false;
			boolean allCaps = false;
			int numLetters = s[0].length;
			for(int i=0; i<numLetters; i+=2) {		//read in letters from Braille matrix
				letter = "";
				for(int col=i; col<i+2; col++)
					for (int row=0; row<3; row++) 
						letter += s[row][col];
						
				char ch = mp.get(letter);
				switch(ch) {
					case '#' : digit = true;			//set digit flag
							   capital = false;
							   allCaps = false;
							   break;
					case '>' : if(capital) {			//set allCaps flag
									allCaps = true;
									capital = false;
									digit = false;
								 	break;
								}
								else {					//set single caps flag
									capital = true; 
									allCaps = false;
									digit = false;
									break;
								}			
					case '<' : capital = false; 		//unset flags
							   allCaps = false;
							   digit = false;
							   break;	
					default  :
						if(digit) {
							if(ch == ' ')
								out.print(mp.get(letter));
							else {
								letter = "001111" + letter;
								out.print(mp.get(letter));
							}
						}
						else if(capital) {
							out.print((String.valueOf(mp.get(letter))).toUpperCase());
							digit = false;
							allCaps = false;
							capital = false;
						}
						else if(allCaps)
							out.print((String.valueOf(mp.get(letter))).toUpperCase());
						else  {
							digit = false;
							out.print(mp.get(letter));
						}	
				}
				
		
			}		
			out.println();
		}
	}
	public static void getMapping(TreeMap<String, Character> mp) {
		mp.put("100000",'a');
		mp.put("110000",'b');
		mp.put("100100",'c');
		mp.put("100110",'d');
		mp.put("100010",'e');
		mp.put("110100",'f');
		mp.put("110110",'g');
		mp.put("110010",'h');
		mp.put("010100",'i');
		mp.put("010110",'j');
		mp.put("101000",'k');
		mp.put("111000",'l');
		mp.put("101100",'m');
		mp.put("101110",'n');
		mp.put("101010",'o');
		mp.put("111100",'p');
		mp.put("111110",'q');
		mp.put("111010",'r');
		mp.put("011100",'s');
		mp.put("011110",'t');		
		mp.put("101001",'u');
		mp.put("111001",'v');
		mp.put("101101",'x');
		mp.put("101111",'y');
		mp.put("101011",'z');
		mp.put("011111",'w');
		mp.put("000000",' ');
		mp.put("010011",'.');

		mp.put("001111",'#');		//numbers follow
		mp.put("001111100000",'1');
		mp.put("001111110000",'2');
		mp.put("001111100100",'3');
		mp.put("001111100110",'4');
		mp.put("001111100010",'5');
		mp.put("001111110100",'6');
		mp.put("001111110110",'7');
		mp.put("001111110010",'8');
		mp.put("001111010100",'9');
		mp.put("001111010110",'0');
		mp.put("000011",'<');   	//lowercase letters follow
		mp.put("000001",'>'); 		//uppercase letters follow
	}
	
	public static int chValue(char ch) {   //convert char to int
		if(ch== '*')
			return 1;
		return 0;
	}
}
