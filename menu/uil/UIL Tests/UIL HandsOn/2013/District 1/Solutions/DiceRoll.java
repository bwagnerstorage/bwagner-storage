import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class DiceRoll {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("diceroll.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String t = kb.nextLine().trim();
					
			Random rand = new Random(Long.parseLong(t));	
 			String top = "WHITE";

			int dir = rand.nextInt(4) + 1;			// direction of roll
			int numTimes = rand.nextInt(25) + 1;			// number of times it rolls
			
			//numTimes is even, color stay the same
			//numTimes is odd, color changes
			//dir=1 or dir=2 ==> roll forward or backward
			//dir=3 or dir=4 ==> roll left or right

			if(numTimes % 2 == 1)
				if(dir==1 || dir==2)
					top = "RED";
				else
					top = "BLUE";		
			out.println(top);
			
//			print random numbers generated
//			out.print(dir + " " + numTimes + " ");		
		}
	}	
}
