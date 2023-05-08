import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class LetsDeal {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("letsdeal.dat"));

		int times = 0; 
		int count = kb.nextInt();
		String ff = kb.nextLine();
		while(times < count) {
			times++;
			int choice = 0;
			String [] s = kb.nextLine().trim().split(" ");
			ArrayList<Integer> amts = new ArrayList<Integer>();
			ArrayList<Integer> doors = new ArrayList<Integer>();
			for(int i=0; i<3; i++) {
				amts.add(Integer.valueOf(s[i]));
				doors.add(Integer.valueOf(s[i+3]));
			}
			int first = amts.get(doors.get(0) - 1);
			choice = doors.get(1) - 1;
			if(amts.get(choice) <= first)
				choice = doors.get(2) - 1;
			int amtWon = amts.get(choice);
			Collections.sort(amts);
			if (amtWon == amts.get(2))
				out.println(choice + 1 + " " + "WON");
			else
				out.println(choice + 1 + " " + "LOST");			
		}
	}	
}
