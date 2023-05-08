import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Valet {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("valet.dat"));

		int times = 0; 
		int count = kb.nextInt();
		String ff = kb.nextLine();
		while(times < count) {
			times++;
			String [] s = kb.nextLine().trim().split(" ");
			String cars = s[0];
			out.println(cars);			
			for(int i=1; i<s.length; i++) {
				
				int numCars = cars.length();
				int index = cars.indexOf(s[i]);
				String q = "";
				if(index <= numCars / 2) {
					for(int j = 0; j<index; j++) {
						q = cars.charAt(j) + q;
					}
					cars = q + cars.substring(index+1);
					numCars = cars.length();
											
				}
				else
				{
					for(int j = numCars-1; j>index; j--) {
						q += cars.charAt(j);
					}
					cars = cars.substring(0,index) + q;
					numCars = cars.length();
				}
				if(cars.length() != 0)
					out.println(s[i] + " " + cars);
				else
					out.println(s[i] + " PARKING LOT EMPTY");
				
			}
			out.println();			
		}
	}	
}
