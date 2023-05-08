/*
UIL 2017
State - Zachary

Zachary has always had fun generating number patterns, and his latest idea is to create a box of numbers
that represent the one's place of a series of products of two values.  For example, he takes the two values 7 and 9
and makes a box with 7 rows and 9 columns, with the products of the values from 1 to 7 and 1 to 9, as shown below.

1 2 3 4 5 6 7 8 9
2 4 6 8 10 12 14 16 18
3 6 9 12 15 18 21 24 27
4 8 12 16 20 24 28 32 36
5 10 15 20 25 30 35 40 45
6 12 18 24 30 36 42 48 54
7 14 21 28 35 42 49 56 63

The first row contains the products of 1 and the values from 1 to 9.
Numbers in the second row are products of 2 and the values from 1 to 9.
The third row values are products of 3 and the values from 1 to 9.
This continues until reaching the seventh row, which contains products of 7 and the values 1 to 9.

Once he has these values, he only takes the one value of each product, jams them altogether into a box,
which makes an interesting pattern that fascinates him. He calls this pattern a "one's box".

123456789
246802468
369258147
482604826
505050505
628406284
741852963

Input: A series of pairs of single digit positive integers, each pair on one line, separated by a single space.
Output: Create and output a "one's box" with each pair of integers, according to the description and example shown above.

Sample Input:
7 9
5 4
2 3

Sample Output:
123456789
246802468
369258147
482604826
505050505
628406284
741852963
1234
2468
3692
4826
5050
123
246

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class Zachary
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("zachary.dat"));
		
		while(f.hasNext()){
			int R = f.nextInt();
			int C = f.nextInt();
			for(int r = 1;r<=R;r++)
			{
				for(int c = 1;c<=C;c++)
					out.print((r*c)%10);
				out.println();
			}
		}
	}
}
/*

*/