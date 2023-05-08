import java.util.*;
import java.io.*;
public class Farkle {
	
	public static void main (String [] args) throws FileNotFoundException {
		Scanner sc = new Scanner (new File ("farkle.dat"));
		while (sc.hasNext())
		{
			
			int seed = sc.nextInt();
			Random rand = new Random(seed);
			int stopValue = sc.nextInt();
			
			List<Integer> rolls = new LinkedList<Integer>();
			int numberOfRolls = 0;
			boolean done = false;
			int sum = 0;
			
			for (int i = 0; i < 100; i++) {
				while (!done) {
					int currentRoll = rand.nextInt(6);
					numberOfRolls++;				
					rolls.add(currentRoll);
					if (i == 0) {
						System.out.print(currentRoll+1);
					}
					if (numberOfRolls > stopValue) {
						rolls.remove(0);
					}
					if (numberOfRolls >= stopValue) {
						done = isSame(rolls);
					}
				}
				rolls.clear();
				done = false;
				sum += numberOfRolls;
				numberOfRolls = 0;
				//System.out.println();
			}	
			System.out.println("\n" + Math.round(10.0*sum/100)/10.0);
		}
	}
	
	public static boolean isSame (List<Integer> array) {		
		for (int i = 1; i < array.size(); i ++) {
			if (array.get(i-1) != array.get(i)) return false;
		}
		return true;
	}
	
}

