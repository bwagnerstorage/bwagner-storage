import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Savings {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("savings.dat"));

		float sum = 0;
		while(kb.hasNext()) {
			double amtPurchase = Double.parseDouble(kb.nextLine());
			double nextDollar = Math.ceil(amtPurchase);
			double diff = nextDollar - amtPurchase;   
			sum  += diff;
		}
		out.println("$" + sum);			
	}	
}
