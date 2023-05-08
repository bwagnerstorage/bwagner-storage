import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Petals {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("petals.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		int sum=0;
		while(times < count) {
			times++;
			
			sum=0;
			for(int i=0; i<5; i++) {
				ArrayList<String> al = new ArrayList<String>();
				for(int j=0; j<5; j++)
					al.add(kb.nextLine().trim());
				if((al.get(2)).equals("|  o  |")) {
					if((al.get(1)).equals("| o o |"))
						sum+=2;
					else if((al.get(1)).equals("| o   |"))
						sum++;	
					if((al.get(3)).equals("| o o |"))
						sum+=2;
					else if((al.get(3)).equals("|   o |"))
						sum++;			
				}
			}
			out.println(sum);	
		}
	}	
}
