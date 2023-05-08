//////////////////////////////////
//  File:        rock.java      // 
//  Programmer:  Marc Douet     //
//  Date:        04/27/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  rock                                                   //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class rock {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;		
	private String 		line;		
	private StringTokenizer tokenBuffer;
	


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public rock(void)				        //
	//				                                //
	// Description: Initializes all data members of the rock        //
	//              class  						//
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public rock()
	{
		// Initialize all data members.
		numDatasets = 0;			
		line = null;			
		tokenBuffer = null;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isStartingAction 					//
	// 								//
	// Synopsis:  private boolean isStartingAction(String action)   //
	// 						                //
	// Description: Determine if this is a starting action.         //
	//				                                //
	// Return Value: true if this is a starting action, else false. //
	//////////////////////////////////////////////////////////////////
	private boolean isStartingAction(String action)
	{
		if(action.equals("cone") || action.equals("waffle") || 
		   action.equals("scup") || action.equals("cup")    ||
		   action.equals("bcup")) {
			return true;
		} else {
			return false;
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  examineRecipe  					//
	// 								//
	// Synopsis:  private void examineRecipe()                      //
	// 						                //
	// Description: Determine if this is a valid recipe, output the //
	//              number of scoops if it is a valid recipe.       //
	//				                                //
	// Return Value: None.                                          //
	//////////////////////////////////////////////////////////////////
	private void examineRecipe()
	{
		tokenBuffer = new StringTokenizer(line);
		int numTokens = tokenBuffer.countTokens();
		int numScoops = 0;
		int maxScoops = 0;
		boolean foundTopping = false;
		boolean dipValid = false;
		int foundWC = -2;

		// Scan through each action and make sure the recipe is legit
		for(int i = 0; i < numTokens; i++)
		{
			String action = tokenBuffer.nextToken();

			// If the first action is not a starting action OR 
                        // the last action is not "cash", this recipe is invalid
			if(((i == 0) && (!isStartingAction(action))) ||
			   ((i == (numTokens-1)) && !action.equals("cash"))) {
				numScoops = 0;
				break;
			}

			// If this is a "cone" action make sure it is the first action
			// since it is a starting action, and set max scoops to 2
			if(action.equals("cone")) {
				dipValid = true;
				if(i != 0) { 
					numScoops = 0;
					break;
				} else {
					maxScoops = 2;
				}
			}
			
			// If this is a "waffle" action make sure it is the first action
			// since it is a starting action, and set max scoops to 4
			else if(action.equals("waffle")) {
				dipValid = true;
				if(i != 0) { 
					numScoops = 0;
					break;
				} else {
					maxScoops = 4;
				}
			}

			// If this is a "scup" action make sure it is the first action
			// since it is a starting action, and set max scoops to 2
			else if(action.equals("scup")) {
				if(i != 0) { 
					numScoops = 0;
					break;
				} else {
					maxScoops = 2;
				}
			}
			
			// If this is a "cup" action make sure it is the first action
			// since it is a starting action, and set max scoops to 3
			else if(action.equals("cup")) {
				if(i != 0) { 
					numScoops = 0;
					break;
				} else {
					maxScoops = 3;
				}
			}
		
			// If this is a "bcup" action make sure it is the first action
			// since it is a starting action, and set max scoops to 4
			else if(action.equals("bcup")) {
				if(i != 0) { 
					numScoops = 0;
					break;
				} else {
					maxScoops = 4;
				}
			}

			// If this is a "dip" action, make sure it is the second action
			else if(action.equals("dip")) {
				if(i != 1 || !dipValid) { 
					numScoops = 0;
					break;
				}	
			}

			// If this is a "scoop" action, incrememt the number of scoops, 
			// making sure it doesn't exceed the scoop capacity
			else if(action.equals("scoop")) {
				if(foundTopping || (++numScoops > maxScoops)) {
					numScoops = 0;
					break;
				}
			}
		
			// If this is a "sprinkles" action, set a flag so we remember 
			// we've had a topping action
			else if(action.equals("sprinkles")) {
				foundTopping = true;
			}

			// If this is a "wc" action, make sure it hasn't occurred before and 
			// mark the position for future reference and set a flag so we remember
			// we've had a topping action
			else if(action.equals("wc")) {
				if(foundWC != -2) {
					numScoops = 0;
					break;
				} else {
					foundWC = i;
					foundTopping = true;
				}
			}

			// If this is a "cherry" action,  make sure the last action was a "wc" action and
			// set a flag so we remember we've had a topping action
			else if(action.equals("cherry")) {
				if(foundWC != (i-1)) {
					numScoops = 0;
					break;
				} else {
					foundTopping = true;
				}
			}

			// If this is a "cash" action, make sure this is the last action
			else if(action.equals("cash")) {
				if(i != (numTokens-1)) {
					numScoops = 0;
					break;
				}
			}

			// If this is an unsupported action, break
			else {
				numScoops = 0;
				break;
			}
		}

		// Print a message based on whether this recipe is valid or not, specifying
		// the number of scoops if it is a valid recipe
		if(numScoops == 0) {
			System.out.println("Your prospects for promotion are looking grim");
		} else {
			System.out.println("You created a dessert with " + numScoops + " scoop(s)");
		}
	}		


	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the rock class by reading in each        //
	//              message and rocking it.                         //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("rock.in")));

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

			// Examine the recipe
			examineRecipe();
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the rock class.                //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		rock rockEngine = new rock();
		rockEngine.start();
		System.exit(0);
	}
}
