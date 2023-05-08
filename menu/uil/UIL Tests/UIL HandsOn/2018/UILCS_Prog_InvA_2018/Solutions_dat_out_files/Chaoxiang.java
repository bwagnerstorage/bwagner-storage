/*2018 UIL Invitational A - Chaoxiang
*/
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Chaoxiang
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("chaoxiang.dat"));
		while(f.hasNext())
		{
			double K = (f.nextDouble() - 32) * 5/9.0 + 273.16;
//			double K = (f.nextDouble() - 32.0) / 1.8 + 273.16;
			out.printf("%.2f\n",K);
		}
	}	
}
/*
Test data:
212
32
-459.68
55
-20
500
-200
299.99
-456

Test output:
373.16
273.16
0.00
285.94
244.27
533.16
144.27
422.04
2.05

*/