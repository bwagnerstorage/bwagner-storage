import java.util.*;
import java.lang.*;
import java.io.*;

class CandyFest
{
	private static int i,n,t,ans,lo,hi,mid;
	private static int[] ar = new int[10001];
	private static int[] tmp = new int[10001];
	public static int solve(int candy)
	{

		for(i=0;i<n;i++)
			tmp[i] = ar[i];

		for(i=0;i<n-1;i++)
		{
			if(tmp[i] < candy)return 0;
			int rem = tmp[i] - candy;
			tmp[i] = candy;
			tmp[i+1] += rem;
		}

		if(tmp[n-1] < candy)return 0;

		return 1;
	}
	public static void main(String []Args) throws Exception{

		BufferedReader br = new BufferedReader(new FileReader("candyfest.dat"));

		String line = br.readLine();

		t = Integer.parseInt(line);

		while((t--) > 0)
		{

			line = br.readLine();

			n = Integer.parseInt(line);


			String[] str=br.readLine().split(" ");

			int len=str.length;

			for(i=0;i<len;i++)
				ar[i]=Integer.parseInt(str[i]);


			lo = 0;
			hi = 1000000010;
			ans = 0;

			while(lo <= hi)
			{
				mid = (lo + hi)/2;

				if(solve(mid) == 1)
				{
					lo = mid + 1;
					if(ans < mid)
						ans = mid;
				}
				else hi = mid - 1;
			}

			System.out.println(ans);

		}
	}
}
