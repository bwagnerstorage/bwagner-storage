import java.util.*;

public class scores
{
	public static void main(String[] args)
	{	
                String		name;
		int		score;
		UILFileReader 	input = new UILFileReader("scores.dat");

		
		while( input.ready() )
		{
                        score = input.readInt();	
			name = input.readWord();

			System.out.println(name + " " + score);					
		}
	}

}