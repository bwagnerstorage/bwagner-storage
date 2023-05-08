import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Change {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("change.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			int ways = 0;
			int money = Integer.parseInt(kb.nextLine().trim());
			int half = money/50;
			int quarter = money/25;
			int dime = money/10;
			int nickel = money/5;
			int pennies = money;
			for(int h=0; h<2; h++)
				for(int q=0; q<4; q++)
					for(int d=0; d<10; d++)
						for(int n=0; n<20; n++) 
							for(int p=0; p<=pennies; p++)
								if(money == 50*h + 25*q + 10*d + 5*n + p)
									{ways++;
									//System.out.println(" " + 50*h + " " + 25*q+" "+10*d+" "+5*n+" "+p);
									}
			out.println(ways);
		}
							
	}	
}
