//////////////////////////////////
//  File:        race.java      // 
//  Programmer:  Marc Douet     //
//  Date:        04/18/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  race                                                   //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class race {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;	
	private StringTokenizer tokenBuffer;
	private String		line;
	private String 		gameData;
	private int[]		rollList;
	

	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public race(void)				        //
	//				                                //
	// Description: Initializes all data members of the race class   //
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public race()
	{
		// Initialize all data members.
		numDatasets = 0;			
		tokenBuffer = null;
		line = null;
		gameData = null;
	}
				
	
	//////////////////////////////////////////////////////////////////
	// Function:  isWholeNumber                             	//
	// 								//
	// Synopsis:  private boolean isWholeNumber(double number)      //
	// 						                //
	// Description: Determines whether a double is a whole number.  //
	//				                                //
	// Return Value: True if this number is a whole number,         //
	//               False otherwise                                //
	//////////////////////////////////////////////////////////////////
	private boolean isWholeNumber(double number)
	{
		// Convert the double to a sting, then tokenize it using the decimal as the delimiter,
 		// this will allow us to get the value of the remainder
		String numberString = Double.toString(number);
		tokenBuffer = new StringTokenizer(numberString, ".");
		tokenBuffer.nextToken();
		String remainderString = tokenBuffer.nextToken();

		// If there is no remainder, this is a whole number
		if(remainderString.equals("0")) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isPerfectSquare  				        //
	// 								//
	// Synopsis:  private boolean isPerfectSquare(int number)       //
	// 						                //
	// Description: Determines wheither a number is a perfect square//
 	//              by taking it's square root and making sure it's //
	//              a whole number.					//
	//				                                //
	// Return Value: True if this number is a perfect square,       //
	//               false otherwise.                               //
	//////////////////////////////////////////////////////////////////
	private boolean isPerfectSquare(int number)
	{
		// Base Case:  We never want to return true for this, or will we have a negative position move!
		if(number == 1)
		{
			return false;
		}

		// If the square root of this number is a whole number, we have a winner
		if(isWholeNumber(Math.sqrt(number)))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getPrevPerfectSquare			        //
	// 								//
	// Synopsis:  int getPrevPerfectSquare(int number)              //
	// 						                //
	// Description: Gets the perfect square that comes before this  //
	//              perfect square.                                 //
	//				                                //
	// Return Value: Integer representing the previous perfect      //
	//               square
	//////////////////////////////////////////////////////////////////
	int getPrevPerfectSquare(int number)
	{
		// Get the square root, subtract 1, and square it to get the previous perfect square
		int newSquare = (int)Math.sqrt(number);
		newSquare -= 1;
		newSquare *= newSquare;
		return newSquare;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isPrime   				        //
	// 								//
	// Synopsis:  private boolean isPrime(double number)            //
	// 						                //
	// Description: Determine whether this number is prime by seeing//
 	//              if any number between 2 and itself will divide  //
	//              into it evenly.                                 //
	//				                                //
	// Return Value: True if this number is a prime, False otherwise//
	//////////////////////////////////////////////////////////////////	
	private boolean isPrime(double number)
	{
		// Starting with the number 2, start dividing into the number until we reach the number itself,
 		// if we get a whole number from any of these operations, we do not have a prime
		for(double i = 2; i < number; i++)
		{
			if(isWholeNumber(number/i))
			{
				return false;
			}
		}

		// If we made it this far we must have a prime on our hands
		return true;
	}

	
	//////////////////////////////////////////////////////////////////
	// Function:  getNextPrime  				        //
	// 								//
	// Synopsis:  int getNextPrime(double number)                   //
	// 						                //
	// Description: Get the next prime number following this one.   //
	//				                                //
	// Return Value: Integer representing the next prime number in  //
	//               the series                                     //
	//////////////////////////////////////////////////////////////////	
	int getNextPrime(double number)
	{
		// Start checking all numbers following this one for a prime, stop at 1000 
		// since that is where our game board stops
		for(int j = ((int)number + 1); j <= 1000; j++)
		{
			if(isPrime(j)) 
			{
				return j;
			}
		}

		// If we got here the next prime is greater than our board size, 
		// so just return the last space on the game board
		return 1000;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  playGame    				        //
	// 								//
	// Synopsis:  private int playGame()                            //
	// 						                //
	// Description: Play the game by moving the player according to //
	//              the number that was rolled, as well as the rules//
	//              for landing on a prime or perfect square        //
	//              numbered space.                                 //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private int playGame()
	{
		// Get the number of rolls
		tokenBuffer = new StringTokenizer(gameData);
		int numRolls = Integer.parseInt(tokenBuffer.nextToken());
		rollList = new int[numRolls];
		int currentPos = 1;

		// Populate the list of die rolls for this player
		for(int i = 0; i < numRolls; i++)
		{
			rollList[i] = Integer.parseInt(tokenBuffer.nextToken());
		}

		// Play the game by rolling the die, moving the player, and applying the rules
		for(int i = 0; i < numRolls; i++)
		{
			// Move the distance corresponding to the die roll
			currentPos += rollList[i];
			if (currentPos > 1000) {
				currentPos=1000;
				break;
			}

			// If we landed on a perfect square space, move back to the previous perfect square numbered space
			if(isPerfectSquare(currentPos))
			{
				//System.out.print("Hit square " + currentPos + " moved to ");
				currentPos = getPrevPerfectSquare(currentPos);
			}

			// Else, if we landed on a prime numbered space, move forward to the next prime numbered space
			else if(isPrime(currentPos))
			{
				//System.out.print("Hit prime " + currentPos + " moved to ");
				currentPos = getNextPrime(currentPos);
			}
			//System.out.println(currentPos);
		}

		// The game is over, return the ending position
		return currentPos;
	}
	

	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the race class by reading the game data  //
	//              and printing the ending position of the player. //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("race.in")));

		// Read in the number of datasets.
		try {
           		line = in.readLine();
			tokenBuffer = new StringTokenizer(line);
			numDatasets = Integer.parseInt(tokenBuffer.nextToken());

            	} catch(IOException ioError) {
				System.out.println(
					"Error occurred while reading in the first line of input.");
                		ioError.printStackTrace();
				System.exit(1);
            	}

		// While we have data to process...
		for(int index = 0; index < numDatasets; index++) {  
			// Read the game data	
			try {
                  		gameData = in.readLine();

                        } catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
            		}

			// Play the game and print the results
			System.out.println("Player #" + (index+1) + " ended up in square " + playGame());
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the race class.                 //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		race raceEngine = new race();
		raceEngine.start();
		System.exit(0);
	}
}