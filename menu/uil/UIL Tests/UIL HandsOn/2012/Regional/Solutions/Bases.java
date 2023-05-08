import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class Bases {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("bases.dat"));
		
		int t = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		out.println("Base 10   Base 2    Base 4    Base 8    Base 12   Base 16");
		while(t < count) {
			t++;		
			out.printf("%-10s%-10s%-10s%-10s%-10s%-10s",t, Integer.toString(t,2),Integer.toString(t,4),Integer.toString(t,8),Integer.toString(t,12),Integer.toString(t,16));
			out.println();
		}
	}	
}
