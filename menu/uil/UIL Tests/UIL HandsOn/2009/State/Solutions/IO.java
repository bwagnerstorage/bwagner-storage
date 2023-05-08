import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class IO {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("io.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;   
			String [] t = kb.nextLine().trim().split(" ");
			char[] ch = t[0].toCharArray();
			String target = t[1];
			ArrayList<Character>table = new ArrayList<Character>();
			for(int j=0; j<ch.length; j++)
				table.add(ch[j]);
			Stack<Character> tube1 = new Stack<Character>();
			String moves[] = kb.nextLine().trim().split(" ");
			String tube2 = "";
			for(int j=0; j<moves.length; j++) {
				if(moves[j].equals("I")) {   // put in tube #1
					if(!table.isEmpty())
						tube1.push(table.remove(0));
					else
						break;
				}
				else if(moves[j].equals("O")) { // remove from tube #1; place in tube #2
					if(!tube1.isEmpty())
						tube2 += tube1.pop();
					
				}	
				else {	// remove from tube #1; place on end of table
					if(!tube1.isEmpty())
						table.add(tube1.pop());
					else
						break;
				} 
			}
			if(table.isEmpty() && tube1.isEmpty() && tube2.equals(target))
				out.println("MATCH");
			else if (table.isEmpty() && tube1.isEmpty() && !tube2.equals(target))
				out.println("NO MATCH");
			else
				out.println("NOT ENOUGH MOVES");
		}
	}
}
