import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Bongo {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("bongo.dat"));
		
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
			int ballNum = 0;
			for(int i=0; i<ball.length; i++) {
				replaceWithStar(card, ball[i].trim().substring(1));
				valid = checkBingo(card);
				if(valid) { ballNum = i; break; }
			}
			if(valid && ballNum == ball.length - 1)
				out.println("BINGO");	
			else
				out.println("BONGO");	
		}
	}
	public static void replaceWithStar(String c[][], String b) { 
		for(int i=0; i<5; i++)   
			for(int j=0; j<5; j++)
				if(c[i][j].equals(b))
					c[i][j] = "*";
	}
	
	public static boolean checkBingo(String c[][]) {
		int stars = 0;
		for(int i=0; i<5; i++) {   // check rows
			stars=0;
			for(int j=0; j<5; j++)
				if(c[i][j].equals("*"))
					stars++;			
			if(stars==5) return true;
		}
		for(int i=0; i<5; i++) {   // check cols
			stars=0;
			for(int j=0; j<5; j++)
				if(c[j][i].equals("*"))
					stars++;		
			if(stars==5) return true;
		}	
		stars=0;
		for(int i=0; i<5; i++) {   // check \ diagonal 					
				if(c[i][i].equals("*"))		
					stars++;				
			if(stars==5) return true;
		}	
		stars=0;
		for(int i=0; i<5; i++) {   // check / diagonal 
				if(c[i][4-i].equals("*"))
					stars++;			
			if(stars==5) return true;
		}	
		return false;	
	}	
}
