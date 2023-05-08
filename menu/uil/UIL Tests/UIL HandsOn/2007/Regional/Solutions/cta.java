//////////////////////////////////
//  File:        cta.java       // 
//  Programmer:  Marc Douet     //
//  Date:        04/18/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  cta                                                    //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class cta {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;	
	private StringTokenizer tokenBuffer;
	private String		line;
	private String 		puppyData;
	

	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public cta(void)				        //
	//				                                //
	// Description: Initializes all data members of the cta class   //
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public cta()
	{
		// Initialize all data members.
		numDatasets = 0;			
		tokenBuffer = null;
		line = null;
		puppyData = null;
	}

	
	//////////////////////////////////////////////////////////////////
	// Function:  diagnosePup   				        //
	// 								//
	// Synopsis:  private void diagnosePup()   	                //
	// 						                //
	// Description: Give a diagnosis based on the toxicity level    //
	//              calculated using the puppy data.                //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void diagnosePup()
	{
		String chocolateType = "";
		int chocolateAmount = 0;
		int dogWeight = 0;
		int toxicLevel = 0;

		// Parse the puppy data to get the data necessary to make the diagnosis
		tokenBuffer = new StringTokenizer(puppyData);
		chocolateType = tokenBuffer.nextToken();
		chocolateAmount = Integer.parseInt(tokenBuffer.nextToken());
		dogWeight = Integer.parseInt(tokenBuffer.nextToken());

		// Calculate the toxicity level based on the chocolate type and puppy data
		if(chocolateType.equals("Milk"))
		{
			toxicLevel = ((44 * chocolateAmount) / dogWeight);
		}
		else if(chocolateType.equals("Semisweet"))
		{
			toxicLevel = ((150 * chocolateAmount) / dogWeight);
		}
		else if(chocolateType.equals("Baker's"))
		{
			toxicLevel = ((390 * chocolateAmount) / dogWeight);
		}		
		else 
		{
			System.out.println("Fatal Error: Invalid chocolate type!");
			System.exit(1);
		}

		// Print the diagnosis based on the toxicity level
		if(toxicLevel < 20)
		{
			System.out.println("Monitor animal's behavior.");
		}
		else if((toxicLevel >= 20) && (toxicLevel <= 100))
		{
			System.out.println("Induce vomiting and administer activated charcoal. Animal may return home.");
		}
		else if(toxicLevel > 100) 
		{
			System.out.println("Induce vomiting and administer activated charcoal. Leave animal at clinic.");
		}
	}	
	

	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the cta class by reading the puppy data  //
	//              and making a diagnosis based on the toxicity    //
	//              level.                                          //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("cta.in")));

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
			// Read the puppy data      		
			try {
                  		puppyData = in.readLine();

                        } catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
            		}

			// Calculate the toxicity level and make a diagnosis.
			diagnosePup();
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the cta class.                 //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		cta ctaEngine = new cta();
		ctaEngine.start();
		System.exit(0);
	}
}