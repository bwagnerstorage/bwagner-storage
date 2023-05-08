import java.util.*;
import java.io.*;

public class Roman {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner (new File("roman.dat"));
		//System.out.println(romanToDecimal("XIX"));
		//System.out.println(romanToDecimal("MCMLIII"));
		int testcases = reader.nextInt();
		reader.nextLine();
		for (int i = 0; i < testcases; i++) 
		{
			String s = reader.nextLine();
			System.out.println(s+" = "+romanToDecimal(s));
		}
	}
	
	public static int romanToDecimal (String roman) {
		// Uppercase O is added to take care of last letter.
		roman = roman + 'O';
		int sum = 0;
		Map<Character, Integer> table = new HashMap<Character, Integer>();
		
		table.put('I', 1);
		table.put('V', 5);
		table.put('X', 10);
		table.put('L', 50);
		table.put('C', 100);
		table.put('D', 500);
		table.put('M', 1000);
		table.put('O', 0); // psuedo character added to take care of last letter
		
		for (int i = 0; i < roman.length()-1; i++) {
			char [] pair = roman.substring(i, i+2).toCharArray();
			if (table.get(pair[1]) > table.get(pair[0])) {
				sum += table.get(pair[1])- table.get(pair[0]);
				i++;
			} else {
				sum += table.get(pair[0]);
			}
		}
		return sum;
	}	
}
