//////////////////////////////////
//  File:        shipping.java  // 
//  Programmer:  Marc Douet     //
//  Date:        04/30/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  shipping                                               //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class shipping {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;		
	private String 		line;		
	private StringTokenizer tokenBuffer;
	private int 		numOrders;
	private int 	 	widgetsShipped;
	private final int	WIDGETS_PER_DAY = ((16*60)/5);  // Widgets made per day (from 4AM-8PM)
	


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public shipping(void)				//
	//				                                //
	// Description: Initializes all data members of the shipping    //
	//              class  						//
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public shipping()
	{
		// Initialize all data members.
		numDatasets = 0;			
		line = null;			
		tokenBuffer = null;
		numOrders = 0;
		widgetsShipped = 0;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getShipTime  					//
	// 								//
	// Synopsis:  private String getShipTime(int minutes)           //
	// 						                //
	// Description: Takes the number of minutes and converts it to  //
	//              the exact time the order will be shipped by     //
	//              adding the number of minutes to 4:00AM.         //
	//				                                //
	// Return Value: String representing the time the next shipment //
	//               will go out.                                   //
	//////////////////////////////////////////////////////////////////
	private String getShipTime(int minutes)
	{
		// Convert the minutes to hours (float)
		float time = (float)(minutes / 60.0);

		// Break up the float to get the number of hours and the remainder,
		// which represents the number of minutes (fraction of an hour)
		tokenBuffer = new StringTokenizer(Float.toString(time), ".");

		// Get the hour by adding the number of hours to 4 (we start packaging at 4AM)
		int hour = Integer.parseInt(tokenBuffer.nextToken()) + 4;

		// Determine the minute by multiplying the remainder by 60 (fraction of an hour)
		int min = (int)(Float.parseFloat("." + tokenBuffer.nextToken()) * 60.0);

		// Determine the format for the minutes
		String minStr = null;
		if (min == 0) {
			minStr = "00";
		} else {
			minStr = Integer.toString(min);
		}

		// If the hour is before 12 it's AM
		if(hour < 12) {
			return Integer.toString(hour) + ":" + minStr + "AM";
		} 

		// Else, it is the PM
		else {
			// subtract 12 from the hour unless it's 12
			if (hour > 12)	hour -= 12;
			return Integer.toString(hour) + ":" + minStr + "PM";
		}
	}


	
	//////////////////////////////////////////////////////////////////
	// Function:  getNumCases  					//
	// 								//
	// Synopsis:  private int getNumCases(Float numCases)           //
	// 						                //
	// Description: Determines how many cases will be shipped.  9   //
	//              items are shipped per case, if the number of    //
	//              cases is not divisable by 9, ship an extra case //
	//              so the extra items still get shipped.           //
	//				                                //
	// Return Value: Integer representing the number of cases to be //
	//               shipped is returned.				//
	//////////////////////////////////////////////////////////////////
	private int getNumCases(Float numCases)
	{
		// Break up the float into a whole number and remainder
		tokenBuffer = new StringTokenizer(numCases.toString(), ".");
		int wholeNumber = Integer.parseInt(tokenBuffer.nextToken());
		int remainder = Integer.parseInt(tokenBuffer.nextToken());

		// If there is a remainder, then we ship the whole number amount + 1
		if(remainder > 0) {
			return (wholeNumber + 1);
		} 

		// If there is no remainder, then we ship the whole number amount
		else {
			return wholeNumber;
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  processOrder 					//
	// 								//
	// Synopsis:  private void processOrder(String order)	        //
	// 						                //
	// Description: Determine the number of cases will be shipped   //
	//              for this order (if any), and at what time.      //
	//				                                //
	// Return Value: None.						//
	//////////////////////////////////////////////////////////////////
	private void processOrder(String order)
	{
		// Break up the order into city and number of widgets ordered
		tokenBuffer = new StringTokenizer(order);
		String city = tokenBuffer.nextToken();
		int numWidgets = Integer.parseInt(tokenBuffer.nextToken());

		// Get the number of cases for this order
		int numCases = getNumCases((float)(numWidgets / 9.0));
		
		// Since we could be shipping extra widgets, recalculate the number of
		// widgets to be shipped (9 widgets per case)
		numWidgets = (numCases * 9);

		// If we have time in our workday to ship these widgets...
		if((widgetsShipped + numWidgets) < WIDGETS_PER_DAY) {
			// Increment the running count of widgets shipped
			widgetsShipped += numWidgets;

			// Get the time this shipment will go out (5 minutes for each widget),
			// and print the order
			System.out.println("Ship " + numCases + " cases to " + city + " at " 
				                   + getShipTime(widgetsShipped*5) + ".");
		} 

		// If we didn't have time in our workday to process this order, say so
		else {
			System.out.println(city + " does not get a shipment today.");

			// Since orders are processed in order of arrival, none of our
			// other orders can be shipped either.
			widgetsShipped = WIDGETS_PER_DAY;
		}
	}		
	
		
	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the shipping class by reading in each    //
	//              order and processing it.                        //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("shipping.in")));

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
			// Read in the number of orders.
			try {
           			line = in.readLine();
				tokenBuffer = new StringTokenizer(line);
				numOrders = Integer.parseInt(tokenBuffer.nextToken());

            		} catch(IOException ioError) {
				System.out.println(
					"Error occurred while reading in the first line of input.");
                		ioError.printStackTrace();
				System.exit(1);
            		}

			// Since this is a new day, reset the widget count and print a header
			widgetsShipped = 0;
			System.out.println("Day #" + (index+1));

			// Process each order individually
			for(int i = 0; i < numOrders; i++) {
				// Grab a line of input          		
				try {
                  			line = in.readLine();
                        	} catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
				}

				// Process this order
				processOrder(line);
			}
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the shipping class.            //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		shipping shippingEngine = new shipping();
		shippingEngine.start();
		System.exit(0);
	}
}