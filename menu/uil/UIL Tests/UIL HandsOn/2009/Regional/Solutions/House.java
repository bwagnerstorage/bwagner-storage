import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class House {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("house.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			double cost = 0;
			String []t = kb.nextLine().trim().split(" ");
			int zero = Integer.parseInt(t[0]);
			int one = Integer.parseInt(t[1]);
			int address10 = Integer.parseInt(t[2]);
			String address2 = Integer.toString(address10, 2);
			for(int i = 0; i<address2.length(); i++)
				switch (address2.charAt(i)) {
					case '0' : cost += zero; break;
					case '1' : cost += one;
				}
			cost /= 100;
			out.printf("%s $%.2f", address2,cost);
			out.println();
		}
	}
}
