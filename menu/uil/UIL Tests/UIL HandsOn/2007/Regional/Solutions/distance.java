//////////////////////////////////
//  File:        distance.java  // 
//  Programmer:  Marc Douet     //
//  Date:        04/16/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  distance                                               //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class distance {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;		
	private String 		line;
        private String 		inputLine;			
	private StringTokenizer tokenBuffer;
	private int 		listSize;
	private int    		unsortedList[];
	private int		sortedList[];


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public distance(void)				//
	//				                                //
	// Description: Initializes all data members of the distance    //
	//              class  						//
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public distance()
	{
		// Initialize all data members.
		numDatasets = 0;			
		line = null;
            	inputLine = null;			
		tokenBuffer = null;
		listSize = 0;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  buildUnsortedList					//
	// 								//
	// Synopsis:  public void buildUnsortedList(String list)        //
	// 						                //
	// Description: Builds an unsorted list of numbers using a      //
        //              string containing a list of numbers.            //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void buildUnsortedList(String list)
	{
		tokenBuffer = new StringTokenizer(line);
		listSize = Integer.parseInt(tokenBuffer.nextToken());
		unsortedList = new int[listSize];
		sortedList = new int[listSize];

		// Grab each integer from the line and throw it in our lists
		for(int i = 0; i < listSize; i++) 
		{
			unsortedList[i] = Integer.parseInt(tokenBuffer.nextToken());
			sortedList[i] = unsortedList[i];
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  sortList       				        //
	// 								//
	// Synopsis:  public void sortList()                            //
	// 						                //
	// Description: Sorts the unsorted list of numbers, storing the //
	//              new sorted list in a serprate array.            //
	//				                                //
	// Return Value: true if list is fully sorted, false otherwise  //
	//////////////////////////////////////////////////////////////////
	private Boolean sortList()
	{
		Boolean listSorted = true;

		// Perform a bubble sort on the unsorted list
		for(int i = 0; i < (listSize-1); i++) 
		{
			if(sortedList[i] > sortedList[i+1]) {
				listSorted = false;
				int swap = sortedList[i+1];
				sortedList[i+1] = sortedList[i];
				sortedList[i] = swap;
			}
		}

		// Return the state of our sort so the recursion can continue or cease
		return listSorted;
	}
		

	//////////////////////////////////////////////////////////////////
	// Function:  calcDistance       				//
	// 								//
	// Synopsis:  public int calcDistance()                         //
	// 						                //
	// Description: Gets the mean variance between the sorted and   //
	//              unsorted list by caculating the sum of the      //
        //              number of slots each number is displaced.       //
	//				                                //
	// Return Value: Integer representing the mean variance between //
	//               the sorted and unsorted lists.                 //
	//////////////////////////////////////////////////////////////////
	private int calcDistance()
	{
		int distance = 0;

		// Generate a sum of all of the difference in locations of each list element
		for(int i = 0; i < listSize; i++) 
		{
			distance += Math.abs(indexOf(unsortedList, sortedList[i]) - i);
		}

		return distance;
	}

	
	//////////////////////////////////////////////////////////////////
	// Function:  indexOf      				        //
	// 								//
	// Synopsis:  private int indexOf(int[] list, int item)         //
	// 						                //
	// Description: Searches for an item in a list and returns the  //
	//              the location index.                             //
	//				                                //
	// Return Value: Integer representing the index the item is     //
	//               located at on the list.                        //
	//////////////////////////////////////////////////////////////////
	private int indexOf(int[] list, int item)
	{
		// Search the list for the item and return the index when found
		for(int i = 0; i < listSize; i++)
		{
			if(list[i] == item) 
			{ 
				return i;
			}
		}

		// We should never get here, if we do something is wrong so throw a fatal error
		System.out.println("Fatal Error:  " + item + " does not exist on both lists!");
		System.exit(1);
		return -1;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the distance class by reading each list  //
	//              of numbers, sorting them, then calculating the  //
	//              mean variance between the lists.                //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("distance.in")));

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

			// Popluate the unsorted list using this line of data
			buildUnsortedList(line);

			// Sort the list using recursion
			while(!sortList());

			// Print the mean variable between the sorted and unsorted list
			System.out.println(calcDistance());
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the distance class.            //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		distance distanceEngine = new distance();
		distanceEngine.start();
		System.exit(0);
	}
}