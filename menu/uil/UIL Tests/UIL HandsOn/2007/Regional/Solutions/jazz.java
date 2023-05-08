//////////////////////////////////
//  File:        jazz.java      // 
//  Programmer:  Marc Douet     //
//  Date:        04/17/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  jazz                                                   //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class jazz {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;	
	private StringTokenizer tokenBuffer;
	private String		line;
	private String 		musicianNotes;
	private String		clubNotes;


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public jazz(void)					//
	//				                                //
	// Description: Initializes all data members of the jazz class  //
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public jazz()
	{
		// Initialize all data members.
		numDatasets = 0;			
		tokenBuffer = null;
		line = null;
		musicianNotes = null;
		clubNotes = null;
	}

	
	//////////////////////////////////////////////////////////////////
	// Function:  compareMelodies				        //
	// 								//
	// Synopsis:  private void compareMelodies()   	                //
	// 						                //
	// Description: Compare the musician's melody with the club's   //
	//              to see the club's melody contains the same      //
	//              melody, specifying the length of the smallest   //
	//              matching melody.                                //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void compareMelodies()
	{
		int clubIndex = 0;
		int beginIndex = 0;
		int melodyLength = 0;
		int m, c;
		boolean foundNote = false;
		boolean foundMelody = false;

		// Step through each note in the musician's melody to try to find a match in the club's melody
		for(m = 0; m < musicianNotes.length(); m++)
		{
			// Searching for a new note
			foundNote = false;

			// For every note in the club's melody...
			for(c = clubIndex; c < clubNotes.length(); c++)
			{
				// If a note matches...
				if(clubNotes.charAt(c) == musicianNotes.charAt(m)) 
				{
					// We found a note
					foundNote = true;

					// If this is the first note on the musician's melody, mark it's position
					if(m == 0) 
					{
						// Handle the case where the first note repeats, set our index
						// to the position of the last occurrence of the first note
						for(int tempIndex = (c+1); tempIndex < clubNotes.length(); tempIndex++)
						{
							if(clubNotes.charAt(tempIndex) != musicianNotes.charAt(m)) 
							{
								c = (tempIndex-1);
								break;
							}
						}

						// Mark this as our beginning index of the melody
						beginIndex = c;
					}

					// Increment our club melody position counter
					clubIndex = c+1;
					
					// If this is the last note in musician's melody...
					if(m == (musicianNotes.length() - 1))
					{
						// We found a complete melody
						foundMelody = true;

						// Set the melody length, update it if we've found a smaller melody length
						if ((melodyLength == 0) || ((clubIndex - beginIndex) < melodyLength))
						{
							melodyLength = (clubIndex - beginIndex);
						}

						// Go back to the musician's first note to look for a smaller melody match
						m = -1;
					}

					// We found a note, so break so we can look for the musician's next note
					break;
				}
			}

			// If we didn't find this note after a complete pass through the club's notes,
			// we need to break here since we don't have a melody match
			if(!foundNote) 
			{
				// If no previous melody was found, make sure the melody length is zero
				// (this is neccessary since the melody length is tallied as notes are found)
				if(!foundMelody)
				{
					melodyLength = 0;
				}

				break;
			}

		}

		// If the melody length is smaller than the muscian's melody, we never found a match, 
  		// print the appropriate result
		if(melodyLength < musicianNotes.length()) 
		{
			System.out.println("There is no match.");
		}

		// Else, we found a matching melody, so print the appropriate melody length.
		else 
		{

			System.out.println("There is a match consisting of " + melodyLength + " notes.");
		}
	}			
	

	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the jazz message editor by reading each  //
        //              note list and looking for matching melodies.    //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("jazz.in")));

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
			// Grab the musician's notes          		
			try {
                  		musicianNotes= in.readLine();

                        } catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
            		}

			// Grab the club's notes          		
			try {
                  		clubNotes= in.readLine();

                        } catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
            		}

			// Look for matching melodies and print the results
			compareMelodies();
		}
	}

	


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the jazz class.                //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		jazz jazzEngine = new jazz();
		jazzEngine.start();
		System.exit(0);
	}
}
