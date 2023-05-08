/*2018 UIL Invitational A - Polina
*/
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Polina
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("polina.dat"));
		Scanner kb = new Scanner(in);
		while(f.hasNext())
		{
			String s = f.next();
			String sp = new String(s);
			args = f.nextLine().trim().split(" ");
			out.print(s+" ");
			for(int x=0;x<args.length;x++)
			{
				String t = args[x];
				int r = Integer.parseInt(t);
				int hun = r / 100;
				int ten = r % 100 / 10;
				int one = r % 10;
				String hex = Integer.toHexString(r);
//				out.println(r+" "+hex);
				//if first digit of decimal router number is odd
				//count from right...adjust values accordingly
				if(hun%2==1)
				{
					one = sp.length()-one;
					ten = sp.length()-ten;
				}
				else//reduce by one for zero indexing
				{
					one--;
					ten--;
				}
				int offset = 0;
//				if(x==1)
//					offset=1;
				
				//assign to fi the min of one and ten
				int fi = Math.min(ten,one)+offset;
				//assign to l the max of one and ten
				int la = Math.max(ten,one)+offset;
				
					
				char first = hex.charAt(0);
				char last =  hex.charAt(2);
//				out.println(fi+" "+la);
				sp = sp.substring(0,fi)+sp.charAt(la)
						+sp.substring(fi+1,la)+sp.charAt(fi)
						+sp.substring(la+1);
				if(x==0)
					sp = ""+first+"A"+ sp +"AA"+last;
				else
					sp = ""+first+ sp +last;
//			out.println(sp.toUpperCase());
//			kb.nextLine();
			}
			out.println(sp.toUpperCase());
//			out.println();


		}
	}	
}
/*Judges data
INVITATIONAL 914
DISTRICT 425 562
UILCONTEST 691 472 456
ELEPHANT 756 451
GIRAFFE 451 284 962 942
CHEETAH 962 756
RHINOCEROS 693 454 314 285
CHIMPANZEE 325 451 314 586 618 442
COMPUTERS 325
PROGRAMMING 962 451 618
ZEBRA 451 314 586 618 442
PACKETSWEEP 756 451 284 693 942 876 693 454 314 285

Judges output:
INVITATIONAL 3AINVITATILNAOAA2
DISTRICT 21ADRSTIACTAI92
UILCONTEST 112OSLICANTEUTAA388
ELEPHANT 1PAEL2EHANTAA43
GIRAFFE 3311AFFRAG3EACIA2E
CHEETAH 23ACAEEHTHAA24
RHINOCEROS 1112ANOHROCERIS6A5AAD
CHIMPANZEE 12111IACH2MPENEAZ3A5AAAAA
COMPUTERS 1ACOMPRTEUSAA5
PROGRAMMING 2ROAPR3G1NMMIAGAA23A
ZEBRA 1211EAARB23AAZAAAA
PACKETSWEEP 1112311A3PEA22KCSTWEEPAAC3456C5EAD
*/
 