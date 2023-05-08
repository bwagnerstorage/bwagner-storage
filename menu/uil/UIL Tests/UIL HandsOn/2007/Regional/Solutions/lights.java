//////////////////////////////////
//  File:        lights.java    // 
//  Programmer:  Marc Douet     //
//  Date:        04/18/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  lights                                                 //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class lights {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;	
	private StringTokenizer tokenBuffer;
	private String		line;
	String			measurementData;
	

	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public lights(void)				//
	//				                                //
	// Description: Initializes all data members of the lights class//
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public lights()
	{
		// Initialize all data members.
		numDatasets = 0;			
		tokenBuffer = null;
		line = null;
		measurementData = null;
	}
				
	
	//////////////////////////////////////////////////////////////////
	// Function:  calcRoofLength                             	//
	// 								//
	// Synopsis:  private void calcRoofLength()                     //
	// 						                //
	// Description: Calulates the required roof length based on the //
	//              series radius and length of the lights and      //
	//              prints the result.                              //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void calcRoofLength()
	{
		// Get the radius and lights length from the measurement data
		tokenBuffer = new StringTokenizer(measurementData);
		int radius = Integer.parseInt(tokenBuffer.nextToken());
		int lightLength = Integer.parseInt(tokenBuffer.nextToken());

		// Required Roof Length = (Light Length / (PI*R)) * (2*R)
		int roofLength = ((int) Math.floor(lightLength / (Math.PI * radius)) * (radius * 2));

		// Print the required roof length
		System.out.println(roofLength);
	}
		


	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the lights class by reading the 		//
	//              measurement data and caculating the required    // 
	//              roof length, printing the result.               //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("lights.in")));

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
			// Read the measurement data	
			try {
                  		measurementData = in.readLine();

                        } catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
            		}

			// Caculate and print the required roof length
			calcRoofLength();
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the lights class.              //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		lights lightsEngine = new lights();
		lightsEngine.start();
		System.exit(0);
	}
}