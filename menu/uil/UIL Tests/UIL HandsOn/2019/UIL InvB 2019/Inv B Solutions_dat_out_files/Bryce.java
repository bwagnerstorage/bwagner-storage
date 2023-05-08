//2019 UIL B Packet - Solution
//Bryce
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Bryce {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner data = new Scanner(new File("bryce.dat"));
		while ( data.hasNext() ) {
			int v = data.nextInt();
			out.print(v + ":");
			StringBuffer rn = new StringBuffer();
			// thousands
			int t = v / 1000;
			while (t-- > 0) rn.append('M');
			v %= 1000;
			// hundreds
			if (v / 100 == 9) {
				rn.append("CM");
				v -= 900;
			}
			else if (v / 100 >= 5) {
				rn.append("D");
				v -= 500;
			}
			t = v / 100;
			while (t-- > 0) rn.append('C');
			v %= 100;
			// tens
			if (v / 10 == 9) {
				rn.append("XC");
				v -= 90;
			}
			else if (v / 10 >= 5) {
				rn.append("L");
				v -= 50;
			}
			t = v / 10;
			while (t-- > 0) rn.append('X');
			v %= 10;
			// ones
			if (v == 9) {
				rn.append("IX");
				v -= 9;
			}
			if (v == 4) {
				rn.append("IV");
				v -= 4;
			}
			else if (v >= 5) {
				rn.append("V");
				v -= 5;
			}
			while (v-- > 0) rn.append('I');
			v %= 10;
			// done
			out.println(rn);
		}
		data.close();
	}
}
