//////////////////////////////////
//  File:        factor.java    // 
//  Programmer:  Marc Douet     //
//  Date:        04/14/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  factor                                                 //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class factor {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;		
	private String 		line;		
	private StringTokenizer tokenBuffer;
	private int		number;
	


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public factor(void)				//
	//				                                //
	// Description: Initializes all data members of the factor      //
	//              class  						//
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public factor()
	{
		// Initialize all data members.
		numDatasets = 0;			
		line = null;			
		tokenBuffer = null;
		number = 0;
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
	// Function:  factorNumber  					//
	// 								//
	// Synopsis:  private void factorNumber()                       //
	// 						                //
	// Description: Determines the prime factorization of a number. //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void factorNumber()
	{
		int[] factors = new int[20];
		int i = 0;
		int factorIndex = 0;
		int tempNumber = number;

		// First, determine if this number is a prime
		if(isPrime((double)number))
		{
			System.out.println(number + " is prime");
			return;
		}

		// Continue to get the smallest factor until we are down to a prime number,
		// adding each factor to our list of factors
		while(!isPrime(tempNumber))
		{
			for(i = 2; i < tempNumber; i++)
			{
				if(isWholeNumber((double)tempNumber/i))
				{
					factors[factorIndex++] = i;
					break;
				}
			}

			tempNumber /= i;
		}

		// Add the final prime factor to our list of factors
		factors[factorIndex] = tempNumber;

		// Print the resultant factorization
		System.out.print(number + " = ");
		for(i = factorIndex; i >= 0; i--)
		{
			// Determine if this factor has an exponent (repeats occurences of the same factor)
			int exponent = 1;
			while(((i-1) >= 0) && factors[i-1] == factors[i])
			{
				exponent++;
				i--;
			}

			// Print the next factor
			System.out.print(factors[i]);

			// Print the exponent if there is one
			if(exponent > 1)
			{
				System.out.print("^" + exponent);
			} 
				
			// Only print the x if we are not at the end of the list
			if (i != 0)
			{
				System.out.print(" x ");
			}
		}

		System.out.println();
	}
		
		
	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the factor class by reading in each      //
	//              number and factoring it.                        //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("factor.in")));

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
			// Grab a line of input          		
			try {
                  		number = Integer.parseInt(in.readLine());
                        } catch(IOException ioError) {
				System.out.println(
					"Error occurred while reading in the next line of input.");
                		ioError.printStackTrace();
				System.exit(1);
			}

			// factor the message
			factorNumber();
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the factor class.              //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		factor factorEngine = new factor();
		factorEngine.start();
		System.exit(0);
	}
}