import java.util.Scanner;

public class SelectionDemo
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int code = 0;

		System.out.print("Enter Access Code -->"); // prompt
		code = scan.nextInt();  // read a number

		if(code == 1234)
		{
			System.out.println("You may enter");
		}
		else
		{
			System.out.println("Access Denied!");
		}

		int temp = 0;
		System.out.print("Enter temperature -->"); // prompt
		temp = scan.nextInt();  // read a number

		if(temp >= 85)
		{
			System.out.println("Hot");
		}
		else if(temp >= 65 && temp < 85)
		{
			System.out.println("Warm");
		}
		else if(temp >= 40 && temp < 65)
		{
			System.out.println("Cool");
		}
		else
		{
			System.out.println("Cold");
		}

	}
}

