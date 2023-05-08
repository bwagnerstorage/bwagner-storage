import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class Profit {

	public static void main(String args[]) throws IOException  	{
		Scanner kb = new Scanner(new File("profit.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			String code = s[0];
			String name = s[1];
			int numItems = Integer.parseInt(s[2]);
			double sum = 0;
			for (int i=0; i<numItems; i++) {
				t = kb.nextLine().trim();
				String vals[] = t.split(" ");
				String n = vals[0];
				double price = Double.parseDouble(vals[1].substring(1));
				String temp = "";
				for	(int j=0; j<n.length(); j++)
					temp += (code.indexOf(n.charAt(j)));
				double net = Double.parseDouble(temp) / 100;
				sum += price - net;	
			}
			out.printf("%s $%.2f", name, sum);
			out.println();
		}
	}
}
