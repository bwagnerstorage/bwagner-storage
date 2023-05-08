//2018 UIL Invitational B - Nikita
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Nikita
{
	public static void main(String [] args) throws IOException
	{
		String line = "-----------------------------------------------------------";
		Scanner f = new Scanner(new File("nikita.dat"));
		Scanner kb = new Scanner(in);
		while(f.hasNext())
{
			int n = f.nextInt();
			int [][]g = new int[n][n];
			for(int r=0;r<n;r++)
				for(int c=0;c<n;c++)
					g[r][c]=f.nextInt();
			//find largest value in the matrix, representing
			//the longest of the shortest paths between nodes.
			int longest = 0;
			for(int r=0;r<n;r++)
				for(int c=0;c<n;c++)
					if(g[r][c]>longest)
						longest = g[r][c];
//			out.println("longest path is "+longest);
			int [][] list = new int[n][longest+1];
			//tally the number of paths of each length, 
			//not counting zero length paths
			for(int r=0;r<n;r++)
				for(int c=0;c<n;c++)
					if(g[r][c]!=0)
						list[r][g[r][c]]++;
//			out.print("list = ");		
			//output degree count for each node
//			for(int r=0;r<n;r++){
//				for(int c=0;c<=longest;c++)
//					out.print(list[r][c]);
//				out.println();
//			}
//			out.println("---");
			//calculate and output degree centrality
//			out.println("degree centrality");
			double deg[] = new double[n];
			//calc and store all degree centrality measures
			for(int r=0;r<n;r++){
				deg[r] = list[r][1]/(double)(n-1);
//				out.printf("%s %f\n",((char)(r+65)),deg[r]);
			}
			double least = deg[0];
			double greatest = deg[0];
			for(int r=1;r<n;r++){
				if(deg[r]<least)
					least=deg[r];					
				if(deg[r]>greatest)
					greatest=deg[r];					
				}
			String gr = "";
			String lst = "";
			for(int r=0;r<n;r++){
				if(deg[r]==least)
					lst+=(char)(r+65);	
				if(deg[r]==greatest)
					gr+=(char)(r+65);	
				}
			out.printf("least degree       %.2f %s\ngreatest degree    %.2f %s\n",least,lst,greatest,gr);
			
			//calculate and store closeness centrality for each node
//			out.println("closeness centrality");
			double [] close = new double[n];
			for(int r=0;r<n;r++)
			{
				int sum = 0;
				for(int c=0;c<longest+1;c++)
					sum+=list[r][c]*c;
				close[r] = (double)(n-1)/sum;
//				out.printf("%s %f\n",(char)(r+65),close[r]);
			}
			least = close[0];
			greatest = close[0];
			for(int r=1;r<n;r++){
				if(close[r]<least)
					least=close[r];					
				if(close[r]>greatest)
					greatest=close[r];					
				}
			gr = "";
			lst = "";
			for(int r=0;r<n;r++){
				if(close[r]==least)
					lst+=(char)(r+65);	
				if(close[r]==greatest)
					gr+=(char)(r+65);	
				}
			out.printf("least closeness    %.2f %s\ngreatest closeness %.2f %s\n",least,lst,greatest,gr);

//			for(int r=0;r<n;r++){
//				for(int c=0;c<n;c++)
//					out.print(g[r][c]);
//				out.println();
//			}
			out.println("---");
					
					
	  }	
	}
}
/*Judges data
4
0 1 2 2
1 0 1 1
2 1 0 1
2 1 1 0
8
0 1 2 3 4 5 6 7
1 0 1 2 3 4 5 6
2 1 0 1 2 3 4 5
3 2 1 0 1 2 3 4
4 3 2 1 0 1 2 3
5 4 3 2 1 0 1 2
6 5 4 3 2 1 0 1
7 6 5 4 3 2 1 0
6
0 1 1 2 2 2
1 0 2 1 1 1
1 2 0 3 3 1
2 1 3 0 1 2
2 1 3 1 0 2
2 1 1 2 2 0
6
0 1 3 2 3 3
1 0 2 1 2 2
3 2 0 1 2 2
2 1 1 0 1 1
3 2 2 1 0 1
3 2 2 1 1 0
5
0 1 2 1 2
1 0 2 1 2
2 2 0 1 2
1 1 1 0 1
2 2 2 1 0
7
0 1 2 2 3 2 1
1 0 1 1 2 2 2
2 1 0 1 2 1 2
2 1 1 0 1 2 3
3 2 2 1 0 1 2
2 2 1 2 1 0 1
1 2 2 3 2 1 0
9
0 1 2 3 0 0 0 0 0
1 0 1 2 0 0 0 0 0
2 1 0 1 0 0 0 0 0
3 2 1 0 0 0 0 0 0
0 0 0 0 0 1 0 0 1
0 0 0 0 1 0 0 0 2
0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 1 0 0
0 0 0 0 1 2 0 0 0
12
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
25
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
Judges output:
least degree       0.33 A
greatest degree    1.00 B
least closeness    0.60 A
greatest closeness 1.00 B
---
least degree       0.14 AH
greatest degree    0.29 BCDEFG
least closeness    0.25 AH
greatest closeness 0.44 DE
---
least degree       0.40 ACDEF
greatest degree    0.80 B
least closeness    0.50 C
greatest closeness 0.83 B
---
least degree       0.20 AC
greatest degree    0.80 D
least closeness    0.42 A
greatest closeness 0.83 D
---
least degree       0.25 CE
greatest degree    1.00 D
least closeness    0.57 CE
greatest closeness 1.00 D
---
least degree       0.33 AEG
greatest degree    0.50 BCDF
least closeness    0.55 AEG
greatest closeness 0.67 BCF
---
least degree       0.13 ADFGHI
greatest degree    0.25 BCE
least closeness    1.33 AD
greatest closeness 8.00 GH
---
least degree       0.09 FHL
greatest degree    0.45 B
least closeness    0.24 F
greatest closeness 0.52 BK
---
least degree       0.04 MNOPQRSTUVWXY
greatest degree    0.25 B
least closeness    0.18 S
greatest closeness 0.43 BK
---
*/
 