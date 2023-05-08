//////////////////////////////////
//  File:        witness.java   // 
//  Programmer:  Marc Douet     //
//  Date:        04/18/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  witness                                                //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class witness {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;	
	private StringTokenizer tokenBuffer;
	private String		line;
	private String          subjectInfo;
	private String[]	maleNames = {"Jimmy", "Freddie", "Mack", "Anthony",
					     "Manny", "Junior", "Jason", "Artie",
					     "Stoolie", "Otto", "Nick", "Dino"};
	private String[]	femaleNames = {"Janice", "Fanny", "Mae", "April", 
					       "Meadow", "Joanne", "Jackie", "Adriana",
					       "Sophia", "Olivia", "Nell", "Donna"};


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public witness(void)				//
	//				                                //
	// Description: Initializes all data members of the witness     //
        //              class                                           //
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public witness()
	{
		// Initialize all data members.
		numDatasets = 0;			
		tokenBuffer = null;
		line = null;
		subjectInfo = null;
	}

	
	//////////////////////////////////////////////////////////////////
	// Function:  genName    				        //
	// 								//
	// Synopsis:  private void genName()   	                        //
	// 						                //
	// Description: Generate a full name based on the subject's     //
        //              birth month, birth day, and sex.                //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void genName()
	{
		String birthDate = "";
		int birthMonth = 0;
		int birthDay = 0;
		String sex = "";
		String firstName = "";
		String middleName = "";

		// Extract the birthdate and sex from the subject info
		tokenBuffer = new StringTokenizer(subjectInfo);
		birthDate = tokenBuffer.nextToken();
		sex = tokenBuffer.nextToken();

		// Extract the birth month and day from the birth date
		tokenBuffer = new StringTokenizer(birthDate, "/");
		birthMonth = Integer.parseInt(tokenBuffer.nextToken());
		birthDay = Integer.parseInt(tokenBuffer.nextToken());

		// Get the first name based on birth month and sex
		if(sex.equals("M"))
		{	
			firstName = maleNames[(birthMonth - 1)];
		}
		else if(sex.equals("F"))
		{
			firstName = femaleNames[(birthMonth - 1)];
		}
		else
		{
			System.out.println("Fatal Error: Sex was not M or F!");
			System.exit(1);
		}

		// Get the middle name based on the birth day
		if(birthDay <= 15)
		{
			middleName = "Carmine";
		}
		else if(birthDay >= 16)
		{
			middleName = "Corleone";
		}

		// Print the generated full name
		System.out.println(firstName + " " + middleName + " Smith");
	}
	

	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the witness class by reading each        //
	//              subject's info and using it to generate a name. //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("witness.in")));

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
			// Read the subject info       		
			try {
                  		subjectInfo = in.readLine();

                        } catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
            		}

			// Generate a name for this person based on their info
			genName();
		}
	}

	


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the witness class.             //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		witness witnessEngine = new witness();
		witnessEngine.start();
		System.exit(0);
	}
}