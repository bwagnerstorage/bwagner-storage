/*2018 UIL Invitational A - Klara
*/
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Klara
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("klara.dat"));
		Scanner kb = new Scanner(in);
		
		while(f.hasNext())
		{
			int n = f.nextInt();
			f.nextLine();
			char[][]g = new char[n][n];
			int midRow = n/2;
			int midCol = n/2;
			for(int r = 0;r<n;r++)
			{
				String s = f.nextLine();
				for(int c = 0;c<n;c++)
					g[r][c] = s.charAt(c);
			}
//			for(int r = 0;r<n;r++){
//				for(int c = 0;c<n;c++)
//					out.print(g[r][c]);
//				out.println();
//			}
//			kb.nextLine();
			char ch = g[midRow][midCol];
			flood(g,ch,midRow,midCol);
			for(int r = 0;r<n;r++){
				for(int c = 0;c<n;c++)
					out.print(g[r][c]);
				out.println();
			}
//			kb.nextLine();
out.println("=====");
		}
		f.close();
	}
	static void flood(char[][]g,char ch,int r,int c)
	{
		g[r][c]='-';
		//look north
		if(r>0&&g[r-1][c]==ch)
			flood(g,ch,r-1,c);
		//look west
		if(c>0&&g[r][c-1]==ch)
			flood(g,ch,r,c-1);
		//look south
		if(r<g.length-1&&g[r+1][c]==ch)
			flood(g,ch,r+1,c);
		//look east
		if(c<g[r].length-1&&g[r][c+1]==ch)
			flood(g,ch,r,c+1);
	}
}
/*
Test data:

Test output:

*/