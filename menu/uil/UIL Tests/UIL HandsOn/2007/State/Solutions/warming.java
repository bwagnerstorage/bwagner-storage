//////////////////////////////////
//  File:        warming.java   // 
//  Programmer:  Marc Douet     //
//  Date:        04/14/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;
import java.lang.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  warming                                                //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class warming {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;		
	private String 		line;
        private String 		inputLine;			
	private StringTokenizer tokenBuffer;
	private char    	map[][];
	private int 		erosionLevel;
	private int		numRows;
	private int		numCols;


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public warming(void)				//
	//				                                //
	// Description: Initializes all data members of the warming     //
	//              class  						//
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public warming()
	{
		// Initialize all data members.
		numDatasets = 0;			
		line = null;
            	inputLine = null;			
		tokenBuffer = null;
		erosionLevel = 0;
		numRows = 0;
		numCols = 0;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  absorb     					//
	// 								//
	// Synopsis:  private char absorb(int row, int col)             //
	// 						                //
	// Description: Absorb a cell of the map if it is near the ocean//
	//              if it isn't, then it is a lake.			//
	//				                                //
	// Return Value: New value of this cell is returned	        //
	//////////////////////////////////////////////////////////////////
	private char absorb(int row, int col)
	{
		// If this cell is on the border, absorb it
		if (row == 0 || row == numRows - 1 ||
		    col == 0 || col == numCols - 1) {
                	return '.';
		}

		// If this cell is near the ocean, absorb it
		if (map[row-1][col] == '.') {
			return '.';
		} 
		if (map[row+1][col] == '.') {
			return '.';
		}
		if (map[row][col-1] == '.') {
			return '.';
		}
		if (map[row][col+1] == '.') {
			return '.';
		}

		// If this cell was not near the ocean it is a lake
		return 'w';
	}
		

	//////////////////////////////////////////////////////////////////
	// Function:  applyErosion					//
	// 								//
	// Synopsis:  private void applyErosion()                       //
	// 						                //
	// Description: Modify the map by first reducing the height of  //
	//              each land mass based on the erosion level, then //
	//              by absorbing any remaining non-land mass as a   //
	//              lake if it is not near an ocean mass, or an     //
	//              ocean mass if it is.  Two passes are made to    //
	//              accomplish this, we continue to make passess    //
  	//              until we have 2 passes with no absorptions.	//
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void applyErosion()
	{
		boolean noLakesAbsorbed = false;

		// First pass: Apply erosion to land masses
		for(int row = 0; row < numRows; row++)
		{
			for(int col = 0; col < numCols; col++)
			{
				if(Character.isDigit(map[row][col]))
				{
					// Adjust the land height based on the erosion level
					int landHeight = Character.getNumericValue(map[row][col]);
					landHeight -= erosionLevel;

					// If the land is below sea level, absorb it
					if(landHeight <= 0)
					{
						map[row][col] = absorb(row, col);
					}

					// If it is above sea level, adjust its height on the map
					else
					{
						map[row][col] = (char)(landHeight + '0');
					}
				}
			}
		}

		// Continue to pass through the map to absorb non land masses
		// until there are no more to absorb
		while(!noLakesAbsorbed)
		{
			// Reset our exit state for this pass
			noLakesAbsorbed = true;

			// First absorption pass: Run through the map in reverse order, 
			// absorbing any lakes that are not surrounded by land
			for(int row = (numRows-1); row >= 0; row--)
			{
				for(int col = (numCols-1); col >= 0; col--)
				{
					// If we found a lake, attempt to absorb it
					if(map[row][col] == 'w')
					{
						map[row][col] = absorb(row, col);

						// If we were able to absorb this lake, set our 
						// flag so we make another pass through the map
						if(map[row][col] == '.')
						{
							noLakesAbsorbed = false;
						}
					}
				}
			}

			// Second absorption pass: Run through the map in forward order,
			// absorbing any lakes that are not surrounded by land
			for(int row = 0; row < numRows; row++)
			{
				for(int col = 0; col < numCols; col++)
				{
					// If we found a lake, attempt to absorb it
					if(map[row][col] == 'w')
					{
						map[row][col] = absorb(row, col);

						// If we were able to absorb this lake, set our 
						// flag so we make another pass through the map
						if(map[row][col] == '.')
						{
							noLakesAbsorbed = false;
						}
					}
				}
			}
		}

		// Print the resultant map
		for(int row = 0; row < numRows; row++)
		{
			for(int col = 0; col < numCols; col++)
			{
				System.out.print(map[row][col]);
			}

			System.out.println();
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the warming class by reading in each map //
	//              and corresponding erosion level and prints out  //
	//              the resultant map.				//
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("warming.in")));

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
			// Read in the map dimensions and erosion level
			try {
           			line = in.readLine();
				tokenBuffer = new StringTokenizer(line);
				numRows = Integer.parseInt(tokenBuffer.nextToken());
				numCols = Integer.parseInt(tokenBuffer.nextToken());
				erosionLevel = Integer.parseInt(tokenBuffer.nextToken());

            		} catch(IOException ioError) {
				System.out.println(
					"Error occurred while reading in the first line of input.");
                		ioError.printStackTrace();
				System.exit(1);
            		}

			// Instantiate the map
			map = new char[numRows][numCols];
			for(int row = 0; row < numRows; row++)
			{
				// Grab a line of input          		
				try {
                  			line = in.readLine();
                        	} catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
				}

				for(int col = 0; col < numCols; col++)
				{
					map[row][col] = line.charAt(col);
				}
			}

			// Apply the specified amount of erosion to the map
			applyErosion();
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the warming class.             //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		warming warmingEngine = new warming();
		warmingEngine.start();
		System.exit(0);
	}
}