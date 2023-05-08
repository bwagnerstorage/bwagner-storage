import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Minutes {
	

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("minutes.dat"));

		int times = 0; 
		int count = kb.nextInt();
		String ff = kb.nextLine();
		while(times < count) {
			times++;
			String[] player = kb.nextLine().trim().split(" ");
			String name = player[0];
			int seconds = 0;
			for(int i=1; i < player.length - 1; i+=4) {
				String qIn = player[i];
				int tIn = convert(player[i+1]);
				String qOut = player[i+2];
				int tOut = convert(player[i+3]);
				if(qIn.charAt(1) == qOut.charAt(1)) // same quarter
					seconds += tIn - tOut;
				else if (qIn.charAt(1)+ 1 == qOut.charAt(1)) // consecutive quarters
					seconds += tIn + 720 - tOut;
				else if (qIn.charAt(1)+ 2 == qOut.charAt(1)) // 1st & 3rd or 2nd & 4th quarters
					seconds += tIn + 1440 - tOut;
				else if (qIn.charAt(1)+ 3 == qOut.charAt(1)) // 1st & 4th quarters
					seconds += tIn + 2160 - tOut;
			}
			 	int minutes = seconds / 60;
			 	seconds %= 60;
			 	out.printf ("%s %d:%02d\n",name, minutes, seconds);
		}
	}
	public static int convert(String s) {
		String []t = s.split(":");
		return 60*(Integer.parseInt(t[0]))+Integer.parseInt(t[1]);
	}
}
