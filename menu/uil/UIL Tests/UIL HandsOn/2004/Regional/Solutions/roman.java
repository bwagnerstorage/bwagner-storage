////////////////////////////////
//  File:        roman.java   // 
//  Programmer:  Marc Douet   //
//  Date:        01/24/04     //
////////////////////////////////

import java.util.*;

public class roman
{
	public static void main(String[] args)
	{	
                char		letter;
		int		newVal, oldVal, total;
		UILFileReader 	input = new UILFileReader("roman.dat");
		
		while( input.ready())
		{	
			letter = '\0';
			newVal = 0;
			oldVal = 0;
			total = 0;
			
			while((letter = input.readChar()) != '\n')
			{
				switch(letter)
				{
					case 'M':	newVal = 1000;
							break;

					case 'D':	newVal = 500;
							break;

					case 'C':	newVal = 100;
							break;
		
					case 'L':	newVal = 50;
							break;

					case 'X':	newVal = 10;
							break;

					case 'V':	newVal = 5;
							break;

					case 'I':	newVal = 1;
							break;

					default:	System.out.println("Error: " + letter + " is not a valid character!");
							System.exit(1);
				}

				if(newVal > oldVal)
				{
					total += ((newVal-oldVal)-oldVal);
				}
				else
				{
					total += newVal;
				}

				oldVal = newVal;
			}

			System.out.println(total);
		}
	}
}