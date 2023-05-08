/*
UIL 2017
State - Changpu

Changpu has just learned about numbers and their complements, especially since that is different than the opposite of a number.
He decided to write a simple program to test his newfound knowledge, but needs a little help.
For fun he wants to take all even numbers, either positive or negative, and print their complement, otherwise just print their opposite value.

Input: A series of two-digit integers, all on one line, with single space separation.
Output: For each input integer N, if it is even, print N and its complement value, otherwise print N and its opposite value, with single space separation.

Sample Input:
83 -70 81 -13 51

Sample Output:
83 -83
-70 69
81 -81
-13 13
51 -51

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class Changpu
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("changpu.dat"));
		while(f.hasNext())
		{
			int num = f.nextInt();
			if(num%2==0)
				out.println(num + " " + ~num);
			else
				out.println(num + " " + -num);
		}
	}
}
/*

*/