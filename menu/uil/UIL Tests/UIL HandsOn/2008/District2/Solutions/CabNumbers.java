import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class CabNumbers {

	public static void main(String args[]) throws IOException 	{  
		int count = 0;
	  	Scanner kb = new Scanner(new File("cabnumbers.dat"));
	  	int max = Integer.parseInt(kb.nextLine().trim());
	  	int c=1729;
	  	while(c<1000000 && count < max) {
	  		int numWays = 0;
		  	for(int i=1; i<10000 && numWays<2; i++) {
		  		for(int j=i; j<100 && numWays<2; j++) {
		  			if(i*i*i + j*j*j == c)
		  				numWays++;
		  		}
		  		if(numWays == 2) {
		  			count++;
		  			out.println(c);
		  			break;     
		  		}
		  	}
		  	c++;
		 }			
  	}
}
/*
1729 = 1^3 + 12^3 = 9^3 + 10^3
4104 = 2^3 + 16^3 = 9^3 + 15^3
13832 = 2^3 + 24^3 = 18^3 + 20^3
20683 = 10^3 + 27^3 = 19^3 + 24^3
32832 = 4^3 + 32^3 = 18^3 + 30^3
39312 = 2^3 + 34^3 = 15^3 + 33^3
40033 = 9^3 + 34^3 = 16^3 + 33^3
46683 = 3^3 + 36^3 = 27^3 + 30^3
64232 = 17^3 + 39^3 = 26^3 + 36^3
65728 = 12^3 + 40^3 = 31^3 + 33^3
110656 = 4^3 + 48^3 = 36^3 + 40^3
110808 = 6^3 + 48^3 = 27^3 + 45^3
134379 = 12^3 + 51^3 = 38^3 + 43^3
*/