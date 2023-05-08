//////////////////////////////////
//  File:        what.java      // 
//  Programmer:  Marc Douet     //
//  Date:        04/30/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;

//////////////////////////////////////////////////////////////////////////
//  Class Name:  what		        	               	        //
//	                                                                //
//  Description: Simply prints the input data                           //
//////////////////////////////////////////////////////////////////////////
public class what {

	//////////////////////////////////////////////////////////////////
	//  Function:  main                                             //	
	//								//
	//  Synopsis:  public static void main(String args[])		//	   	
	//								//
	//	       args  [IN]  Not used.	  			//                         	
	//								//
	//  Description: The main driver of the what class.        	//     
	//               Simply prints the input data.                  //
	//							        //  
        //                                                              //
	//  Return Value: None.						//
	//////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("what.in")));
		StringTokenizer tokenBuffer;
		String line = "";
		int numDatasets = 0;

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

			// Print the line
			System.out.println(line);
		}
	}
}