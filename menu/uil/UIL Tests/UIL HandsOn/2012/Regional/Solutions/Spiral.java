import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Spiral {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("spiral.dat"));
		
		int times = 0; 
		String [] t = kb.nextLine().trim().split(" ");
		int count = t.length;
		int n = 25;
		int mat [][]= new int [n][n];	
		getMatrix(mat, n);
/*print
								for(int i=0; i<n; i++){ 
									for(int j=0; j<n; j++)System.
										out.print(mat[i][j] + " ");
										System.out.println(); 
									}   
								out.println();	
 end print*/				
										
		while(times < count) {
			int spiralNum = Integer.parseInt(t[times]);
			times++;
			int r=0, c=0; 
			boolean flag=true;
			for(r=0; flag && r<n; r++) 
				for(c=0; flag && c<n; c++)
					if(spiralNum == mat[r][c]) 
						flag = false;
			int sq = (int)(Math.ceil(Math.sqrt(spiralNum)));
			r = r - (int)((n-sq)/2);
			c = c - (n-sq)/2;
			out.println(r + " " + c);		
		}
	}
	public static void getMatrix(int [][] mat, int n) {
		int side = n;
		int x = 0; 			//initialize starting point to fill matrix
		int y = n-1;		
		int i=n*n;
		while(i>=1){
			for(int j=0; j<side; j++) //right side
				mat[x++][y] = i--;
			x--;
			y--;
			if(i>=1){
				for(int j=0; j<side-1; j++) //bottom
					mat[x][y--] = i--;
				x--;
				y++;
			}
			if(i>=1){
				for(int j=0; j<side-1; j++) //left side
					mat[x--][y] = i--;	
				x++;	
				y++;	
			}
			if(i>=1){
				for(int j=0; j<side-2; j++) //top
					mat[x][y++] = i--;
				y--;
				x++;
				side=side-2;
			}
		}
	}	
}
