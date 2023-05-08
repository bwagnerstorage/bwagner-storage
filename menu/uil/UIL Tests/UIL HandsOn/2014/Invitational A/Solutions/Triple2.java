import java.util.*;
import java.lang.*;
import java.io.*;

class Triple
{
	private static int i,n,t,ans;
	private static int[] prime = new int[1001];
	public static void main(String []Args) throws Exception{

		BufferedReader br = new BufferedReader(new FileReader("triple.dat"));

		String line = br.readLine();

		t = Integer.parseInt(line);

		while((t--) > 0)
		{

			line = br.readLine();

			n = Integer.parseInt(line);

			for(i=1;i<=n;i++)
				prime[i] = 0;

			for(int i=2;i*i<=n;i++)
				if(n % i == 0)
				{
					prime[i] += 1;
					n /= i;

					while(n%i == 0)
					{
						prime[i] = -1;
						n /= i;
					}
				}

			if(n > 1)prime[n] = 1;

			ans = 0;

			for(i=2;i<=n;i++)
			{
				if(prime[i] == -1)ans = -1;
				else if(ans != -1 && prime[i] == 1)ans++;
			}

			if(ans == 3)
				System.out.println("YES");
			else
				System.out.println("NO");

		}
	}
}
