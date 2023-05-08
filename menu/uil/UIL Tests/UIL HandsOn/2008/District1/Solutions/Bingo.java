import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Bingo {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("bingo.dat"));
		
		int times = 0; 
		int count = kb.nextInt();
		String ff = kb.nextLine();
		while(times < count) {
			boolean valid = true;
			times++;
			int[][] card = new int [5][5];
			for(int i=0; i<5; i++) {
				String t[] = kb.nextLine().trim().split(" ");
				for(int j=0; j<5; j++) {
					if(t[j].equals("*"))
						card[i][j] = 0;
					else
						card[i][j] = Integer.parseInt(t[j]);
				}
			}
			valid = (card[2][2] == 0);  //check for freeSpace
			if(valid)			
				for(int i=0; i<5; i++)
					if(card[i][0]<1 || card[i][0]>15) {valid = false; break;	}
			if(valid)			
				for(int i=0; i<5; i++)
					if(card[i][1]<16 || card[i][1]>30) {valid = false; break;	}
			if(valid)
				for(int i=0; i<2; i++)
					if(card[i][2]<31 || card[i][2]>45) {valid = false; break;	}
			if(valid)
				for(int i=3; i<5; i++)
					if(card[i][2]<31 || card[i][2]>45) {valid = false; break;	}
			if(valid)			
				for(int i=0; i<5; i++)
					if(card[i][3]<46 || card[i][3]>60) {valid = false; break;	}
			if(valid)			
				for(int i=0; i<5; i++)
					if(card[i][4]<61 || card[i][4]>75) {valid = false; break;	}
			if(valid)
				out.println("VALID");	
			else
				out.println("INVALID");	
		}
	}	
}
