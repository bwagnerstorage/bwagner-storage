//////////////////////////////////
//  File:        text.java      // 
//  Programmer:  Marc Douet     //
//  Date:        04/16/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  text                                                   //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class text {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;		
	private String 		line;
        private String 		inputLine;			
	private StringTokenizer tokenBuffer;


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public text(void)					//
	//				                                //
	// Description: Initializes all data members of the text class  //
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public text()
	{
		// Initialize all data members.
		int numDatasets = 0;			
		String line = null;
            	String inputLine = null;			
		StringTokenizer tokenBuffer = null;
	}

	
	//////////////////////////////////////////////////////////////////
	// Function:  removePunct				        //
	// 								//
	// Synopsis:  public String removePunct(String line)		//
	// 						                //
	// Description: Removes all non-alphanumeric characters from a  //
        //              a line of text.                                 //
	//				                                //
	// Return Value: String containing no non-alphanumeric          //
	//               characters                                     //
	//////////////////////////////////////////////////////////////////
	public String removePunct(String line)
	{
		String good = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    		String result = "";

		// Step through each character in the line and strip out the non alpanumerics
		for ( int i = 0; i < line.length(); i++ ) {
        		if ( good.indexOf(line.charAt(i)) >= 0 )
           			result += line.charAt(i);
        	}

    		return result;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  removeVowels				        //
	// 								//
	// Synopsis:  public String removeVowels(String line)		//
	// 						                //
	// Description: Removes all vowels from words that have more    //
        //              than 3 characters in a line of text.            //
	//				                                //
	// Return Value: String containing no vowels for words that are //
        //               longer than 3 characters                       //
	//////////////////////////////////////////////////////////////////
	public String removeVowels(String line)
	{
		String bad = " aeiou";
		String result = "";
		String word = "";
		tokenBuffer = new StringTokenizer(line);

		// For each word in the line....
		for( int j = tokenBuffer.countTokens(); j > 0; j--) 
		{
			// Get the next token from the string
			word = tokenBuffer.nextToken();
            
			// If this token is a word...
			if(word.length() >= 4) 
			{
				// Step through each character in the word and strip out the vowels
				for ( int i = 0; i < word.length(); i++ ) 
				{
					if ( bad.indexOf(word.charAt(i)) < 0 )
						result += word.charAt(i);
				}
			} 

			// If this was not a word, just add it back to the result.
			else 
			{
				result += word;
			}

			// Don't forget to add the spaces back between each word
			result += " ";
		}

		return result;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the text message editor by reading each  //
        //              message and editing them accordingly.           //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("text.in")));

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

			// Remove all punctuation from the line
			line = removePunct(line);

			// Make all letters in the line lowercase
			line = line.toLowerCase();

			// Remove all vowels from the line
			line = removeVowels(line);

			// Print out the resulting line
			System.out.println(line);
		}
	}

	


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the text class.                //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		text textEngine = new text();
		textEngine.start();
		System.exit(0);
	}
}