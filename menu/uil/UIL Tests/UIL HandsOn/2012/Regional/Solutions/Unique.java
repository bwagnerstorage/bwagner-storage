import java.io.*;
import java.util.*;
import static java.lang.System.*;  

import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Unique {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("unique.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		ArrayList <Integer> a = new ArrayList<Integer>(); //create list of 21st century primes
		for(int i=2; i<1050; i++) {
			if(isPrime(i))
				a.add(i);
		}
		
		while(times < count) {
			times++;
	
			int year = Integer.parseInt(kb.nextLine().trim());
			if(!(isPrime(year)))							//check for prime
				out.println(year + " NOT A PRIME YEAR");
			else {
				boolean found = false;
				int numWays=0;
				int numTerms=0;
				for(int i = 0; !found && i<a.size(); i++) {  //iterate list of primes
					int sum = a.get(i);
					int j=i;
					int begin = 0;
					int end = 0;
					for(j=i+1; j<a.size() && sum <year;  j++) {   
					 	sum += a.get(j); 
					 	if(sum == year) {
					 		found = true;
					 		begin = i; 
					 		end = j;
					 	}
						if(found) {
							numTerms = end-begin+1;
							numWays++;
							found=false;
						}
					}
				}
				if(numWays==0)
					out.println( year + " PRIME YEAR");
				else if (numWays==1)
					out.println(year+" PRIME YEAR AND THE SUM OF " + numTerms + " CONSECUTIVE PRIMES");
				else 
					out.println(year+" PRIME YEAR AND THE SUM OF MORE THAN ONE SET OF CONSECUTIVE PRIMES");
			}
		}
	}
	
	
	public static boolean isPrime(int x) {
		boolean b = false;
		for(int i=2; i<=Math.sqrt(x); i++) 
			if(x%i == 0)
				return false;
		return true;
	}
}
