import java.util.*;

public class primes
{
	public static void main(String[] args)
	{	
                int		start, end;
		UILFileReader 	input = new UILFileReader("primes.dat");
		int i, j;
		boolean primeFound, divisorFound;
		
		while( input.ready() )
		{	
			start = input.readInt();
                        end = input.readInt();

			primeFound = false;
                        for (i = start; i <= end; i++)
			{
				if (i == 2)   //Special case
				{
					System.out.print("2");
					primeFound = true;
				}
				else
				{
					divisorFound = false;
					for (j = 2; j <= i / 2 && !divisorFound; j++)
					{
						if (i % j == 0)
							divisorFound = true;
					}

					if (!divisorFound)
					{
						if(!primeFound)
							primeFound = true;
						else
							System.out.print(" ");
						System.out.print(i);
					}
				}
			}
			if (!primeFound)
				System.out.println("No primes found!");
			else
				System.out.println();			
		}
	}

}