//////////////////////////////////
//  File:        math.java      // 
//  Programmer:  Marc Douet     //
//  Date:        04/15/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  math                                                   //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class math {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;		
	private String 		line;		
	private StringTokenizer tokenBuffer;
	private int[]        	set;


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public math(void)				        //
	//				                                //
	// Description: Initializes all data members of the math        //
	//              class  						//
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public math()
	{
		// Initialize all data members.
		numDatasets = 0;			
		line = null;			
		tokenBuffer = null;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  storeSet                                   	//
	// 								//
	// Synopsis:  private void storeSet()                           //
	// 						                //
	// Description: Stores the string of numbers in an int array.   //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void storeSet()
	{
		// Strip out the parenthesis
		line = line.substring(1, (line.length()-1));

		// Tokenize the string and instantiate the set array
		tokenBuffer = new StringTokenizer(line, ",");
		set = new int[tokenBuffer.countTokens()];

		// Extract the set of numbers and store them in the set array
		for(int i = 0; i < set.length; i++)
		{
			set[i] = Integer.parseInt(tokenBuffer.nextToken());
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isWholeNumber                             	//
	// 								//
	// Synopsis:  private boolean isWholeNumber(float number)       //
	// 						                //
	// Description: Determines whether a float is a whole number.   //
	//				                                //
	// Return Value: True if this number is a whole number,         //
	//               False otherwise                                //
	//////////////////////////////////////////////////////////////////
	private boolean isWholeNumber(float number)
	{
		// Convert the double to a sting, then tokenize it using the decimal as the delimiter,
 		// this will allow us to get the value of the remainder
		String numberString = Float.toString(number);
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
	// Function:  truncateNumber                             	//
	// 								//
	// Synopsis:  private String truncateNumber(float number)       //
	// 						                //
	// Description: Truncates a float down to 2 decimal points      //
        //              without rounding.  If the float is a whole      //
        //              number no decimal point is displayed.           //
	//				                                //
	// Return Value: String representing the float truncated down to//
 	//               two decimal places with no rounding.           //
	//////////////////////////////////////////////////////////////////
	private String truncateNumber(float number)
	{	
		String numberString = Float.toString(number);
		String newNumber = "";

		// If this is a whole number, don't show decimal point
		if(isWholeNumber(number))
		{
			tokenBuffer = new StringTokenizer(numberString, ".");
			newNumber = tokenBuffer.nextToken();
		} 

		// If this is not a whole number, show 2 decimal places
		else
		{
			// Store the first half of the float
			tokenBuffer = new StringTokenizer(numberString, ".");
			newNumber = tokenBuffer.nextToken() + ".";
			
			// Truncate the remainder if necessary
			String remainder = tokenBuffer.nextToken();
			if(remainder.length() > 2)
			{
				remainder = remainder.substring(0,2);
			}

			// Append the remainder
			newNumber += remainder;
		}
			
		// Return the formatted number as a string
		return newNumber;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getMean                                    	//
	// 								//
	// Synopsis:  private String getMean(int[] setList)             //
	// 						                //
	// Description: Averages a set of numbers                       //
	//				                                //
	// Return Value: String representing the mean is returned.      //
	//////////////////////////////////////////////////////////////////
	private String getMean(int[] setList)
	{
		float sum = 0;

		// Sum up the integers in the set
		for(int i = 0; i < setList.length; i++)
		{
			sum += setList[i];
		}

		// Divide the sum by the number of items in the set,
		// truncate the result, and return it as a string
		return truncateNumber(sum / setList.length);
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getMedian                                   	//
	// 								//
	// Synopsis:  private String getMedian(int[] setList)           //
	// 						                //
	// Description: Gets the median of a list of numbers by finding //
        //              the middle number if it is an odd number of     //
        //              numbers, and taking the mean of the 2 middle    //
 	//              numbers if it is an even number of numbers.     //
	//				                                //
	// Return Value: String representing the median is returned.    //
	//////////////////////////////////////////////////////////////////
	private String getMedian(int[] setList)
	{
		// Find the middle index of the set
		float middleIndex = ((float)setList.length / 2);

		// Special Case: If there is only one element, that is the median
		if(setList.length == 1)
		{
			return truncateNumber(setList[0]);
		}

		// If there are an odd number of elements, the middle one is the median
		else if(!isWholeNumber(middleIndex))
		{
			int index = (int)Math.floor(middleIndex);
			return truncateNumber(setList[index]);
		}

		// If there are an even number of elements, get the mean of the 2 middles
		else
		{
			int index = (int)middleIndex;
			int[] medianList = new int[2];
			medianList[0] = setList[index-1];
			medianList[1] = setList[index];
			return getMean(medianList);
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getMode                                      	//
	// 								//
	// Synopsis:  private String getMode()                          //
	// 						                //
	// Description: Gets the mode of a set of numbers by finding the//
	//              set of numbers that occur the most.             //
	//				                                //
	// Return Value: String representing the mode (list) is returned//
	//////////////////////////////////////////////////////////////////
	private String getMode()
	{
		int[] matchList = new int[set.length];
		int matchCount = 1;
		int largestMatchCount = 0;
		String modeList = "";

		// Parse through the set and get counts for each reoccurring number,
		// keeping track of the largest count
		for(int i = 0; i < set.length; i++)
		{
			// Look for matches of this number, keeping a running count
			while((i != (set.length-1)) && (set[i] == set[i+1]))
			{
				matchCount++;
				i++;
			}
			
			// If we found a larger count, make a note of it
			if(matchCount > largestMatchCount)
			{
				largestMatchCount = matchCount;
			}

			// Store the count for this number on a seperate list.
			// Note that this count is stored in the last occurence of this number
			matchList[i] = matchCount;
			matchCount = 1;
		}

		modeList = "{";
		boolean firstMatch = true;

		// Go through our list of match counts to find the largest counts and build our mode list
		for(int i = 0; i < matchList.length; i++)
		{
			if(matchList[i] == largestMatchCount)
			{
				if(firstMatch)
				{
					firstMatch = false;
				} 
				else 
				{
					modeList += ",";
				}
				
				modeList += set[i];
			}
		}

		modeList += "}";
		return modeList;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getMeanode                                 	//
	// 								//
	// Synopsis:  private String getMeanode()                       //
	// 						                //
	// Description: Get the meanode of a list of numbers by getting //
	//              the mode list and then getting the mean of that //
	//              list.                                           //
	//				                                //
	// Return Value: String representing the meanode is returned.   //
	//////////////////////////////////////////////////////////////////
	private String getMeanode()
	{
		// First, get the mode, tokenizing it so we can populate an int array with it
		String modeList = getMode();
		tokenBuffer = new StringTokenizer(modeList.substring(1, (modeList.length()-1)), ",");
		int[] meanodeList = new int[tokenBuffer.countTokens()];

		// Populate an int array with the contents of the mode list
		for(int i = 0; i < meanodeList.length; i++)
		{
			meanodeList[i] = Integer.parseInt(tokenBuffer.nextToken());
		}

		// Get the mean of the mode list
		return getMean(meanodeList);
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getMediode                                 	//
	// 								//
	// Synopsis:  private String getMediode()                       //
	// 						                //
	// Description: Get the mediode of a list of numbers by getting //
	//              the mode list and then getting the median of    //
	//              that list.                                      //
	//				                                //
	// Return Value: String representing the mediode is returned.   //
	//////////////////////////////////////////////////////////////////
	private String getMediode()
	{
		// First, get the mode, tokenizing it so we can populate an int array with it
		String modeList = getMode();
		tokenBuffer = new StringTokenizer(modeList.substring(1, (modeList.length()-1)), ",");
		int[] mediodeList = new int[tokenBuffer.countTokens()];

		// Populate an int array with the contents of the mode list
		for(int i = 0; i < mediodeList.length; i++)
		{
			mediodeList[i] = Integer.parseInt(tokenBuffer.nextToken());
		}

		// Get the median of the mode list
		return getMedian(mediodeList);
	}


	//////////////////////////////////////////////////////////////////
	// Function:  doMath                                     	//
	// 								//
	// Synopsis:  private void doMath()                             //
	// 						                //
	// Description: Gets the mean, median, mode, meanode, and       //
	//              mediode of a set of numbers and prints the      //
	//              results.                                        //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void doMath()
	{
		// Print the mean
		System.out.print(getMean(set) + " "); 

		// Print the median
		System.out.print(getMedian(set) + " ");

		// Print the mode
		System.out.print(getMode() + " ");

		// Print the meanode
		System.out.print(getMeanode() + " ");

		// Print the mediode
		System.out.println(getMediode());
	}
		
		
	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the math class by set of numbers and     //
	//              performing various mathematical operations on it//
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("math.in")));

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

			// Store the set in an array
			storeSet();

			// Perform mathematical operations on the set
			doMath();
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the math class.                //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		math mathEngine = new math();
		mathEngine.start();
		System.exit(0);
	}
}
