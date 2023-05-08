//UIL 2018 - Invitational B - Constanza
import java.io.*;
import java.lang.*;
import java.util.*;
import static java.lang.System.*;

public class Constanza{
	public static void main(String [] args) 
		throws IOException
	{ 
		Scanner f = new Scanner(new File("constanza.dat"));
		String [] col = {"red","orange","yellow","green","blue","indigo","violet"};
		int []color= new int[7];
		while(f.hasNext())
		{
			String s = f.next();
			switch(s)
			{
				case "red":color[0]++;break;
				case "orange":color[1]++;break;
				case "yellow":color[2]++;break;
				case "green":color[3]++;break;
				case "blue":color[4]++;break;
				case "indigo":color[5]++;break;
				case "violet":color[6]++;break;
			}
		}
		f.close();
		String star = "******************************************";
		for(int x=0;x<7;x++){
			out.printf("%-7s%s\n",col[x],star.substring(0,color[x]));
		}
	}
}