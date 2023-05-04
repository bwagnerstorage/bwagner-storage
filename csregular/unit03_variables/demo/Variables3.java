public class Variables3
{
	public static void main(String[] args)
	{
		// variables
		long n1 = 2147483647000L;

		System.out.println("n1 = " + n1);
	//	n1 = 2147483647 + 2147483648;      // overflow error
	//	System.out.println("n1 = " + n1);

		//   01111111 11111111 1111111 1111111
		// + 00000000 00000000 0000000 0000001
		// -----------------------------------
		//   10000000 00000000 0000000 0000000
	}
}