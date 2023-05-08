//2019 UIL B Packet - Solution
//Harmony
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Harmony {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner data = new Scanner(new File("harmony.dat"));
		int n = data.nextInt();
		while ( n-- > 0 ) {
			String acctNbr = data.next();
			int checkSum = calcCheckSum(acctNbr);
			char checkDigit = acctNbr.charAt(acctNbr.length() - 1);
			out.print(acctNbr + " ");
			if ( Character.getNumericValue(checkDigit) == checkSum )
				out.println("VALID");
			else
				out.println("INVALID " + checkSum);
		}
		data.close();
	}

	public static int calcCheckSum(String acctNumber) {
		int oddsum = 0;
		int evensum = 0;
		int oddcount = 0;
		for ( int i = 0; i < acctNumber.length()-1; i++ ) {
			char digit = acctNumber.charAt(i);
			int val = Character.getNumericValue(digit);
			if ( (i+1) % 2 == 0 ) {
				evensum += val;
			} else {
				oddsum += val;
				if ( val > 4 )
					oddcount++;
			}

		}
		int sums = oddsum * 3 + evensum + oddcount;
		return ( 10 - sums % 10 ) % 10;
	}
}