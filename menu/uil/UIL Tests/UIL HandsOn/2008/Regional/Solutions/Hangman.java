import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Hangman {
	

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("hangman.dat"));

		int times = 0; 
		int count = kb.nextInt();
		String ff = kb.nextLine();
		while(times < count) {
			times++;
			String puzzle = kb.nextLine().toUpperCase();
			puzzle = puzzle.replaceAll(" ","");
			String guesses = kb.nextLine().toUpperCase();
			int numGuesses = 7;
			int i = 0;
			while(puzzle.length() > 0 && numGuesses>0 && i < guesses.length()) {
				if(puzzle.contains(guesses.substring(i,i+1)))
					puzzle = puzzle.replaceAll(guesses.substring(i,i+1),"");
				else
					numGuesses--;
				i++;			
			}
			if(puzzle.length() > 0 && numGuesses>0) out.println ("QUIT " + numGuesses);
			else if(puzzle.length() == 0) out.println ("WON " + numGuesses);
			else out.println ("LOSE " + numGuesses);
		}

	}
	
}
