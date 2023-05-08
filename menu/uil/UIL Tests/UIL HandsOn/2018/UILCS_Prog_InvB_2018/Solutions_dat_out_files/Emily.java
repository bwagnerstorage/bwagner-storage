//2018 UIL Invitational B - Emily
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Emily
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("emily.dat"));
		Scanner kb = new Scanner(in);
		while(f.hasNext())
		{
			int b1,b2,h;
			b1=f.nextInt();
			b2=f.nextInt();
			h=f.nextInt();
			double area = (b1+b2)/2.0*h;
			if(area == (int)area)
				out.printf("%.0f\n",area);
			else
				out.printf("%.1f\n",area);
				
		}
	}	
}
/*Judges data
5 7 3
8 3 12
3 4 5
12 13 5
1 2 3
22 64 89
100 50 25
8 2 1

Judges output
18
66
17.5
62.5
4.5
3827
1875
5

*/
