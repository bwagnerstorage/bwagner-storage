import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Almost {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("almost.dat"));
		String [] s = {"1","2","3","4","5","B","I","N","G","O","\\","/"};
		int [] num = new int [12]; 
		int times = 0; 
		int count = kb.nextInt();
		String ff = kb.nextLine();
		while(times < count) {
			boolean valid = true;
			times++;
			String[][] card = new String [5][5];
			for(int i=0; i<5; i++) 
				card[i] = kb.nextLine().trim().split(" ");
			card[2][2] = "*";
			String [] ball = kb.nextLine().trim().split(" ");

			for(int i=0; i<ball.length; i++) {
				if(!ball[i].equals("x")) {
					replaceWithStar(card, ball[i].trim().substring(1));
				}
				else {
					clearAll(num);	
					checkBingo(card, num);
					int max = findMax(num);
					for(int j=0; j<num.length; j++) 
						if(num[j] == max) {
							out.print(s[j] + " " );
							if(max == 5)
								out.print("BINGO");
							else
								out.print(5-max + " ");
						}
					out.println();
				}
			}
			out.println();
		}
	}
	public static void replaceWithStar(String c[][], String b) {
		for(int i=0; i<5; i++)   
			for(int j=0; j<5; j++)
				if(c[i][j].equals(b))
					c[i][j] = "*";
	}
	public static void checkBingo(String c[][], int [] num) {
		int stars = 0;
		for(int i=0; i<5; i++) {   // check rows
			for(int j=0; j<5; j++)
				if(c[i][j] == "*")
					num[i]++;			
		}
		for(int i=0; i<5; i++) {   // check cols
			for(int j=0; j<5; j++)
				if(c[j][i] == "*")
					num[i+5]++;
		}	
		for(int i=0; i<5; i++) {   // check \ diagonal 
				if(c[i][i] == "*")
					num[10]++;			
		}	
		for(int i=0; i<5; i++) {   // check / diagonal 
				if(c[i][4-i] == "*")
					num[11]++;			
		}	
	}	
	public static void clearAll(int [] a) {
		for(int i = 0; i < a.length; i++)
			a[i] = 0;
	}
	public static int findMax(int [] a) {
		int max = 0;
		for(int i = 0; i < a.length; i++)
			if(a[i] > max)
				max = a[i];
		return max;
	}
}
