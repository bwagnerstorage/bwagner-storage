//2018 UIL Invitational B - Peter
import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Math.*;

class Peter{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("peter.dat"));
		while(f.hasNext())
		{
			//load data
			int s = f.nextInt();
			int sum = s;
			f.nextLine();
			args = f.nextLine().split(" ");
			int[]coin = new int[args.length];
			for(int x=0;x<coin.length;x++)
				coin[x] = Integer.parseInt(args[x]);			
			//process Greedy
			String coins = "";
			int count = 0;
			int x=coin.length-1;
			while(sum>0)
			{
				if(coin[x]<=sum)
				{
					coins = coin[x]+" "+coins;
					count++;
					sum-=coin[x];
				}
				if(coin[x]>sum)
					x--;
			}
			out.printf("%d %d %s\n",s,count,coins);
		}
	}
}
/*
Sample input:
11
1 3 5
70
1 5 10 25 50 100
131
1 4 9 14 22 53
Sample output:
11 3 1 5 5
70 3 10 10 50
131 6 1 1 1 22 53 53
*/