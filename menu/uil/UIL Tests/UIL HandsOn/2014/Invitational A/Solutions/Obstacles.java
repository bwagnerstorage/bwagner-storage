import java.util.*;
import java.lang.*;
import java.io.*;

class Obstacles
{
    private static int n,m;
    private static int[][] dp = new int[1001][1001];
    private static int[][] valid = new int[1001][1001];
    

    public static int doit(int x,int y)
    {
            if(x == n-1 && y == m - 1)
                    return 1;

            if(dp[x][y] != -1)return dp[x][y];

            dp[x][y] = 0;

            if(x + 1 < n && valid[x+1][y] == 1)
                    dp[x][y] += doit(x+1,y);

//            dp[x][y] %= mod;

            if(y + 1 < m && valid[x][y+1] == 1)
                    dp[x][y] += doit(x,y+1);

//            dp[x][y] %= mod;

            return dp[x][y];
    }

    public static void main(String []Args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("obstacles.dat"));

        String line = br.readLine();

        int t = Integer.parseInt(line);

        while((t--) > 0)
        {

        line = br.readLine();

        n = Integer.parseInt(line);

        line = br.readLine();

        m = Integer.parseInt(line);

        int i,j;

        for(i=0;i<n;i++)
            for(j=0;j<m;j++)
                    valid[i][j] = 0;

        i = 0;

        while (i < n) {

                line = br.readLine();

                for(j=0;j<m;j++)
                {
                        if(line.charAt(j) == '.')
                                valid[i][j] = 1;
                        else valid[i][j] = 0;
                }

                i++;
        }



		for(i=0;i<n;i++)
                for(j=0;j<m;j++)
                    dp[i][j] = -1;


		int ans = doit(0,0);

		System.out.println(ans);

        }
	}
}
