////////////////////////////////
//  File:        golf.java    // 
//  Programmer:  Marc Douet   //
//  Date:        01/24/04     //
////////////////////////////////

import java.util.*;

public class golf
{
	public static void main(String[] args)
	{	
                int 		numRolls = 0;
                int		player = 0;
                int[]		playerPosition = new int[2]; 
		UILFileReader 	input = new UILFileReader("golf.dat");
		
		while( input.ready())
		{	
                        player = 0;
                        numRolls = 0;
                        playerPosition[0] = 1;
                        playerPosition[1] = 1;

			numRolls = input.readInt();
          
                        for(int turn = 1; turn <= numRolls; turn++)
			{
                                if(turn%2 != 0)
                                {
					player = 0;
                                }  
                                else	player = 1;

                                int roll = input.readInt();

                                switch(roll)
                                {
                                	case 2:		roll = 9;
 							break;

 					case 3:		roll = -2;
							break;

					case 4:		roll = 2;
							break;

					case 5:		roll = 2;
							break;

					case 6:		roll = 1;
							break;
		
					case 7:		roll = -3;
							break;

					case 8:		roll = 1;
							break;

					case 9:		roll = -2;
							break;

					case 10:	roll = -2;
							break;

					case 11:	roll = 1;
							break;

					case 12:	roll = 1;
							break;

					default:	System.out.println("Error: " + roll + " is not a valid roll!");
							System.exit(1);
				}

                        	playerPosition[player] += roll;
                                
                                if(playerPosition[player] < 1)
                                {
                                	playerPosition[player] = 1;
                                }
                                else if(playerPosition[player] >= 10)
                                {
                                        player++;
                                	System.out.println("Player " + player + " wins!");

					if(turn != numRolls)
					{
                                        	input.readLine();
					}

                                        break;
                                }
			}
		}
	}

}