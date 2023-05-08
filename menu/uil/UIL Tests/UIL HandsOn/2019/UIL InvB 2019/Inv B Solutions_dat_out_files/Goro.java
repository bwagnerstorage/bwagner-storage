//2019 UIL B Packet - Solution
//Goro
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Goro {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("goro.dat"));
		int n=f.nextInt();
		double sum_of_terms=1;
		out.printf("%1.5f\n", Math.sqrt(12.0));
		double base=3;
		for(int exponent=1;exponent<n;exponent++) {
			double term=1/(base*Math.pow(3, exponent));
			if(exponent%2==1)
				sum_of_terms-=term;
			else
				sum_of_terms+=term;
			out.printf("%1.5f\n",Math.sqrt(12.0)*sum_of_terms);
			base+=2;
		}
	}
}
