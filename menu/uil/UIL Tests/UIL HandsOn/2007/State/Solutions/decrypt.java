//////////////////////////////////
//  File:        decrypt.java   // 
//  Programmer:  Marc Douet     //
//  Date:        04/14/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  decrypt                                                //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class decrypt {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;		
	private String 		line;		
	private StringTokenizer tokenBuffer;
	


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public decrypt(void)				//
	//				                                //
	// Description: Initializes all data members of the decrypt     //
	//              class  						//
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public decrypt()
	{
		// Initialize all data members.
		numDatasets = 0;			
		line = null;			
		tokenBuffer = null;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  hexToBinary  					//
	// 								//
	// Synopsis:  private String hexToBinary(String number)         //
	// 						                //
	// Description: Converts a base 16 number to base 2.            //
	//				                                //
	// Return Value: String representing the binary equivalent of   //
	//               the hex number.                                //
	//////////////////////////////////////////////////////////////////
	private String hexToBinary(String number)
	{
		return Integer.toBinaryString(Integer.parseInt(number, 16));
	}


	//////////////////////////////////////////////////////////////////
	// Function:  binaryToInt 					//
	// 								//
	// Synopsis:  private int binaryToInt(String number)            //
	// 						                //
	// Description: Converts a base 2 number to an integer.         //
	//				                                //
	// Return Value: String representing the integer equivalent of  //
	//               the binary number.                             //
	//////////////////////////////////////////////////////////////////
	private int binaryToInt(String number)
	{
		return Integer.parseInt(number, 2);
	}

	
	//////////////////////////////////////////////////////////////////
	// Function:  flipBinary					//
	// 								//
	// Synopsis:  private String flipBinary(String number)          //
	// 						                //
	// Description: Flips each digit in a binary number.            //
	//				                                //
	// Return Value: String representing the flipped binary number. //
	//////////////////////////////////////////////////////////////////
	private String flipBinary(String number)
	{
		String newNumber = "";

		for(int i = 0; i < number.length(); i++)
		{
			if(number.charAt(i) == '0') 
			{
				newNumber += "1";
			} else {
				newNumber += "0";
			}
		}
		
		return newNumber;
	}
				


	//////////////////////////////////////////////////////////////////
	// Function:  decryptMessage   					//
	// 								//
	// Synopsis:  private void decryptMessage()                     //
	// 						                //
	// Description: Decrypts the message by getting the binary,     //
	//              flipping it, then converting to an integer to   //
	//              get the ASCII equivalent of each character.     //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void decryptMessage()
	{
		tokenBuffer = new StringTokenizer(line);
		int numTokens = tokenBuffer.countTokens();

		for(int i = 0; i < numTokens; i++)
		{
			System.out.print((char)binaryToInt(flipBinary(hexToBinary(tokenBuffer.nextToken()))));
		}

		System.out.println();
	}
		

	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the decrypt class by reading in each     //
	//              message and decrypting it.                      //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("decrypt.in")));

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
                  		line = in.readLine();
                        } catch(IOException ioError) {
				System.out.println(
					"Error occurred while reading in the next line of input.");
                		ioError.printStackTrace();
				System.exit(1);
			}

			// Decrypt the message
			decryptMessage();
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the decrypt class.             //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		decrypt decryptEngine = new decrypt();
		decryptEngine.start();
		System.exit(0);
	}
}