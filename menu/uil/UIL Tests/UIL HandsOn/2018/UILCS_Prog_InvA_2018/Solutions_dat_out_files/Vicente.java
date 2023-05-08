/*2018 UIL Invitational A - Vicente
*/
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Vicente
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("vicente.dat"));
		while(f.hasNext())
		{
			String s = f.next();
			String ss = new String(s);
			String par = f.next();
			int sum = 0;
			for(int x=0;x<s.length();x++)
				if(s.charAt(x)=='1')
					sum++;
			if(sum%2==0)
				if(par.equals("EVEN"))
					s+='0';
				else
					s+='1';
			else
				if(par.equals("ODD"))
					s+='0';
				else
					s+='1';
			out.print(Long.toHexString(Long.parseLong(ss,2)).toUpperCase()+" ");
			out.println(Long.toHexString(Long.parseLong(s,2)).toUpperCase());
		}
	}	
}
/*
Test data:
10110101 EVEN
10110101 ODD
1000000001110001 ODD
10110100 EVEN
10110100 ODD
1101001011000111 EVEN
1111111111111110 ODD
10101010011000101010101001100010 ODD
11111111111111111111111111111110 EVEN

Test output:
B5 16B
B5 16A
8071 100E2
B4 168
B4 169
D2C7 1A58F
FFFE 1FFFC
AA62AA62 154C554C5
FFFFFFFE 1FFFFFFFD

*/