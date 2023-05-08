//////////////////////////////////
//  File:        capital.java   // 
//  Programmer:  Marc Douet     //
//  Date:        04/14/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  capital                                                //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class capital {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;	
	private StringTokenizer tokenBuffer;
	private String		line;
	private String		testQuestion;
	private String[]	countries = {"Ireland", "UK", "Portugal", "Spain",
					     "Andorra", "France", "Switzerland",
					     "Liechtenstein", "Belgium", "Germany", "Austria",
					     "Italy", "Malta", "Norway", "Sweden", "Denmark",
					     "Vatican", "Hungary", "Greece", "Finland",
					     "Monaco", "Bosnia Herzegovina"};
	private String[]	capitals = {"Dublin", "London", "Lisbon", "Madrid", 
					    "Andorra", "Paris", "Bern", "Vaduz",
					    "Brussels", "Berlin", "Vienna", "Rome",
					    "Valletta", "Oslo", "Stockholm", "Copenhagen",
					    "Vatican City", "Budapest", "Athens", "Helsinki",
					    "Monaco", "Sarajevo"};


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public capital(void)				//
	//				                                //
	// Description: Initializes all data members of the capital     //
        //              class                                           //
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public capital()
	{
		// Initialize all data members.
		numDatasets = 0;			
		tokenBuffer = null;
		line = null;
		testQuestion = null;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getCountry   				        //
	// 								//
	// Synopsis:  private String getCountry(String capital)         //
	// 						                //
	// Description: Get the country by getting the index of the     //
	//              capital from the list of capitals, and then     //
	//              returning the country found at that index in    //
        //              the list of countries.                          //
	//				                                //
	// Return Value: The corresponding country is returned          //
	//////////////////////////////////////////////////////////////////
	private String getCountry(String capital)
	{
		for(int i = 0; i < capitals.length; i++)
		{
			if(capitals[i].equals(capital))
			{
				return countries[i];
			}
		}
		
		System.out.println("Fatal Error: " + capital + " is not a valid capital!");
		System.exit(1);
		return null;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getCapital   				        //
	// 								//
	// Synopsis:  private String getCapital(String country)         //
	// 						                //
	// Description: Get the capital by getting the index of the     //
	//              country from the list of countries, and then    //
	//              returning the capital found at that index in    //
        //              the list of capitals.                           //
	//				                                //
	// Return Value: The corresponding capital is returned          //
	//////////////////////////////////////////////////////////////////
	private String getCapital(String country)
	{
		for(int i = 0; i < countries.length; i++)
		{
			if(countries[i].equals(country))
			{
				return capitals[i];
			}
		}

		System.out.println("Fatal Error: " + country + " is not a valid country!");
		System.exit(1);
		return null;
	}

	
	//////////////////////////////////////////////////////////////////
	// Function:  fillInTheBlank   				        //
	// 								//
	// Synopsis:  private void fillInBlank()   	                //
	// 						                //
	// Description: Fill in the blank by using the given country or //
	//              capital to determine the missing info.          //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void fillInBlank()
	{
		String country = "";
		String capital = "";

		// Skip over "The capital city of"
		tokenBuffer = new StringTokenizer(testQuestion);
		for(int i = 0; i < 4; i++)
		{
			tokenBuffer.nextToken();
		}

		// Get the country
		country = tokenBuffer.nextToken();
		if(country.equals("Bosnia"))
		{
			country += " " + tokenBuffer.nextToken();
		}

		// Skip over "is"
		tokenBuffer.nextToken();

		// Get the capital
		capital = tokenBuffer.nextToken();
		if(capital.equals("Vatican"))
		{
			capital += " " + tokenBuffer.nextToken();
		}

		// Strip out the ending period
		tokenBuffer = new StringTokenizer(capital, ".");
		capital = tokenBuffer.nextToken();

		// Fill in the blank
		if(country.equals("_____"))
		{
			country = getCountry(capital);
		} 
		else 
		{
			capital = getCapital(country);
		}

		// Print the answer
		System.out.println("The capital city of " + country + " is " + capital + ".");
	}		
	

	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the capital class by reading each        //
	//              subject's info and using it to generate a name. //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("capital.in")));

		// Process 20 lines of data...
		for(int i = 0; i < 20; i++)
		{
			// Read the subject info       		
			try {
                  		testQuestion = in.readLine();

                        } catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
            		}

			// Generate a name for this person based on their info
			fillInBlank();
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the capital class.             //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		capital capitalEngine = new capital();
		capitalEngine.start();
		System.exit(0);
	}
}