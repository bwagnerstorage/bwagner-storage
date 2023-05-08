import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Code3 {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("code3.dat"));	
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String t = kb.nextLine().trim();
			int len = (int)Math.sqrt(t.length());
			char[][]mat = new char[len][len];
			for(int i=0; i<len; i++) 
				mat[i]=t.substring(i*len,i*len+len).toCharArray();
			int k=0;
			int m;
			for(int i = len-1; i>0; i--)  {
				m=0;
				for(int j = k; j>=0; j--) {
					out.print(mat[j][m]); 
					m++;
				}
				k++;
			}
			k=0;   //out.println("xx");
			for(int i=len-1; i>=0; i--) {
				m=len-1;
				for(int j=k;j<len;j++ ) {
					out.print(mat[m][j]);
					m--;
				}
				k++; 	
			}
			out.println();
		}
	}
}
