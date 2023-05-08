/*2018 UIL Invitational A - Stelios
*/
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Stelios
{
	public static void main(String [] args) throws IOException
	{
		String line = "-----------------------------------------------------------";
		Scanner f = new Scanner(new File("stelios.dat"));
		Scanner kb = new Scanner(in);
		while(f.hasNext()){
			int n = f.nextInt();
//			f.nextLine();
			args = f.nextLine().trim().split(" ");
		
		
		int[][]m1 = new int[n][n];
		//3D matrix containing N matrices for 
		int[][][]m = new int[n][n][n];
		
		//calculate M1, adjacency matrix, direct connections
		for(int x = 0;x<args.length;x++)
		{
			int r = args[x].charAt(0)-65;
			int c = args[x].charAt(1)-65;
			m[1][r][c]=1;
			m[1][c][r]=1;
		}
		//calculate m[2] through m[n-1] using matrix multiplication
		int X = 2;
		for(;X<n;X++)
		{
		
		for(int r=0;r<n;r++){
			for(int c=0;c<n;c++)
			{
				int sum = 0;
				for(int x=0;x<n;x++)
				{
					sum+=m[1][r][x]*m[X-1][x][c];
				}
				m[X][r][c]=sum;
			}
		  }
		}
		
		//calculate M0, the connection matrix
		for(int r=0;r<n;r++){
			for(int c=0;c<n;c++)
			{
				if(r!=c)
				{
					//loop through all matrices to find
					//the shortest distance between two nodes
					for(int a = 1;a<n;a++){
						//find the first non-zero value for each location
						if(m[a][r][c]!=0&&m[0][r][c]==0)
						{
							m[0][r][c]=a;
						}						
					}
				}
			}
		}
		//output connection matrix
		for(int r1=0;r1<n;r1++){
			for(int c1=0;c1<n;c1++)
				out.print(m[0][r1][c1]+" ");
			out.println();
		}
		//output dashed boundary line
		out.println(line.substring(0,n*2-1));
	  }	
	}
}
/*Judges data
3
AB BC CA
4
AB BC CD BD
6
AB AC CF BF BD BE ED
5
AB BD DA DC DE
7
AB BC CD DE EF FG BD CF GA
8
HG GF FE ED DC CB BA
9
AB BC CD EF GH EI FE
12
AB BC CD EF GH EI FE AK KJ JI BJ KB BD GK LA
25
AB BC CD EF GH EI FE AK KJ JI BJ KB BD GK LA AM AN BO CP DQ ER FS GT HU IV JW KX LY
Judges output:
0 1 1
1 0 1
1 1 0
-----
0 1 2 2
1 0 1 1
2 1 0 1
2 1 1 0
-------
0 1 1 2 2 2
1 0 2 1 1 1
1 2 0 3 3 1
2 1 3 0 1 2
2 1 3 1 0 2
2 1 1 2 2 0
-----------
0 1 2 1 2
1 0 2 1 2
2 2 0 1 2
1 1 1 0 1
2 2 2 1 0
---------
0 1 2 2 3 2 1
1 0 1 1 2 2 2
2 1 0 1 2 1 2
2 1 1 0 1 2 3
3 2 2 1 0 1 2
2 2 1 2 1 0 1
1 2 2 3 2 1 0
-------------
0 1 2 3 4 5 6 7
1 0 1 2 3 4 5 6
2 1 0 1 2 3 4 5
3 2 1 0 1 2 3 4
4 3 2 1 0 1 2 3
5 4 3 2 1 0 1 2
6 5 4 3 2 1 0 1
7 6 5 4 3 2 1 0
---------------
0 1 2 3 0 0 0 0 0
1 0 1 2 0 0 0 0 0
2 1 0 1 0 0 0 0 0
3 2 1 0 0 0 0 0 0
0 0 0 0 0 1 0 0 1
0 0 0 0 1 0 0 0 2
0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 1 0 0
0 0 0 0 1 2 0 0 0
-----------------
0 1 2 2 4 5 2 3 3 2 1 1
1 0 1 1 3 4 2 3 2 1 1 2
2 1 0 1 4 5 3 4 3 2 2 3
2 1 1 0 4 5 3 4 3 2 2 3
4 3 4 4 0 1 4 5 1 2 3 5
5 4 5 5 1 0 5 6 2 3 4 6
2 2 3 3 4 5 0 1 3 2 1 3
3 3 4 4 5 6 1 0 4 3 2 4
3 2 3 3 1 2 3 4 0 1 2 4
2 1 2 2 2 3 2 3 1 0 1 3
1 1 2 2 3 4 1 2 2 1 0 2
1 2 3 3 5 6 3 4 4 3 2 0
-----------------------
0 1 2 2 4 5 2 3 3 2 1 1 1 1 2 3 3 5 6 3 4 4 3 2 2
1 0 1 1 3 4 2 3 2 1 1 2 2 2 1 2 2 4 5 3 4 3 2 2 3
2 1 0 1 4 5 3 4 3 2 2 3 3 3 2 1 2 5 6 4 5 4 3 3 4
2 1 1 0 4 5 3 4 3 2 2 3 3 3 2 2 1 5 6 4 5 4 3 3 4
4 3 4 4 0 1 4 5 1 2 3 5 5 5 4 5 5 1 2 5 6 2 3 4 6
5 4 5 5 1 0 5 6 2 3 4 6 6 6 5 6 6 2 1 6 7 3 4 5 7
2 2 3 3 4 5 0 1 3 2 1 3 3 3 3 4 4 5 6 1 2 4 3 2 4
3 3 4 4 5 6 1 0 4 3 2 4 4 4 4 5 5 6 7 2 1 5 4 3 5
3 2 3 3 1 2 3 4 0 1 2 4 4 4 3 4 4 2 3 4 5 1 2 3 5
2 1 2 2 2 3 2 3 1 0 1 3 3 3 2 3 3 3 4 3 4 2 1 2 4
1 1 2 2 3 4 1 2 2 1 0 2 2 2 2 3 3 4 5 2 3 3 2 1 3
1 2 3 3 5 6 3 4 4 3 2 0 2 2 3 4 4 6 7 4 5 5 4 3 1
1 2 3 3 5 6 3 4 4 3 2 2 0 2 3 4 4 6 7 4 5 5 4 3 3
1 2 3 3 5 6 3 4 4 3 2 2 2 0 3 4 4 6 7 4 5 5 4 3 3
2 1 2 2 4 5 3 4 3 2 2 3 3 3 0 3 3 5 6 4 5 4 3 3 4
3 2 1 2 5 6 4 5 4 3 3 4 4 4 3 0 3 6 7 5 6 5 4 4 5
3 2 2 1 5 6 4 5 4 3 3 4 4 4 3 3 0 6 7 5 6 5 4 4 5
5 4 5 5 1 2 5 6 2 3 4 6 6 6 5 6 6 0 3 6 7 3 4 5 7
6 5 6 6 2 1 6 7 3 4 5 7 7 7 6 7 7 3 0 7 8 4 5 6 8
3 3 4 4 5 6 1 2 4 3 2 4 4 4 4 5 5 6 7 0 3 5 4 3 5
4 4 5 5 6 7 2 1 5 4 3 5 5 5 5 6 6 7 8 3 0 6 5 4 6
4 3 4 4 2 3 4 5 1 2 3 5 5 5 4 5 5 3 4 5 6 0 3 4 6
3 2 3 3 3 4 3 4 2 1 2 4 4 4 3 4 4 4 5 4 5 3 0 3 5
2 2 3 3 4 5 2 3 3 2 1 3 3 3 3 4 4 5 6 3 4 4 3 0 4
2 3 4 4 6 7 4 5 5 4 3 1 3 3 4 5 5 7 8 5 6 6 5 4 0
-------------------------------------------------
*/
 