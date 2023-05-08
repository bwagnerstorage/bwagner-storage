import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Trick {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("trick.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			int magicNum = Integer.parseInt(kb.nextLine().trim());
			int[][] square = new int [4][4];
			for(int i=0; i<4; i++) {
				String t[] = kb.nextLine().trim().split(" ");
				int index = 0;
				int sum = 0;
				for(int j=0; j<4; j++) 
					if(t[j].equals("*"))
						index = j;
					else {
						int temp = Integer.parseInt(t[j]);
						square[i][j] = temp;
						sum+=temp;
					}
				square[i][index] = magicNum-sum;
			}
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) 
					out.print(square[i][j] + " ");	
				out.println();	
			}
			out.println();	
		}
	}	
}
