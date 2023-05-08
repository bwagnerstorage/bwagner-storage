import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class LSquare {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("lsquare.dat"));

		int count = kb.nextInt();
		String ff = kb.nextLine();
		int times = 0;
		while(times < count) {
			times++;
			int p = Integer.parseInt(kb.nextLine());
			char [][] ch = new char[p][p];
			for(int r = 0; r < p; r++) {
				String st = kb.nextLine(); 
				ch[r] = st.toCharArray();
			}
			int numCenters = Integer.parseInt(kb.nextLine());		
			int cases = 0;
			while (cases < numCenters) {
				cases++;
				String [] s = kb.nextLine().trim().split(" ");
				int row = Integer.parseInt(s[0]);
				int col = Integer.parseInt(s[1]);
				int size = -1;
				boolean sq = true;
				int r=0,c=0,i = 0;
				
				while(sq && inbounds(row-i,row+i,col-i,col+i,p) && i < p) {
					
						for(r = row-i; r <= row+i; r++)
							for(c = col-i; c <= col+i; c++)
								if(ch[r][c] != ch[row][col]) 
									sq = false; 
						if(sq)
							size+=2;	
						i++;
	
				}
				out.println(row + " " + col + " " + " " + size);
						
			}
			out.println();	
		}
	}
	public static boolean inbounds(int a, int b,int c,int d, int p) {
		return a>=0 && b<p && c>=0 && d<p;
	}	
}
