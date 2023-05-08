/*
UIL 2017
State - Guang

Numbers have always fascinated Guang, and recently he has been playing around with the idea of expressing numbers
in different bases. To make it even more interesting, he adds zeroes to the front of the converted value equal to how
many digits are in the converted value.  For example, the base 10 value 22 converts to 1333 in base 3, and so he writes his final
value with four leading zeroes. The decimal value 17 becomes 0021 in octal using his output scenario, and
29 becomes 001D in base 16.

Input: Several pairs of integers N (0 < N < 10000) and B (1 < B <37), each on one line with single space separation, N representing a base 10 value,
and B representing the base to which Guang will convert the value N.

Output: The converted value according to the expression format described above, with as many leading zeroes as there are digits in the newly converted value.

Sample input:
22 3
17 8
29 16

Sample output:
000211
0021
001D

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Guang
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("guang.dat"));
		String ss = "00000000000000000000000000000000000000000000000";
		while(f.hasNext())
		{
			int num = f.nextInt(), base = f.nextInt();
			String s = Integer.toString(num,base);
			out.printf("%s%s\n",ss.substring(0,s.length()),s.toUpperCase());
		}
	}
}
/*

Test input
22 3
17 8
29 16
42 22
41 4
62 16
72 4
97 5
78 30
393 22
583 26
7512 13
6063 13
1911 29
7436 25
3494 35

Test output
000211
0021
001D
001K
000221
003E
00001020
000342
002I
00HJ
00MB
0000355B
000029B5
00027Q
000BMB
0002TT
0007PR
*/