//////////////////////////////////
//  File:        quiz.java      // 
//  Programmer:  Marc Douet     //
//  Date:        04/18/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  quiz                                                   //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class quiz {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;	
	private StringTokenizer tokenBuffer;
	private String		line;
	private String          answerList;
	private final int 	NUM_ANSWERS = 4;
	private static char[][] answerKey = {{'D', 'A', 'B', 'C'}, {'C', 'B', 'D', 'A'},
                                             {'B', 'D', 'A', 'C'}, {'A', 'B', 'C', 'D'},
                                             {'A', 'C', 'B', 'D'}, {'B', 'D', 'A', 'C'},
                                             {'B', 'C', 'D', 'A'}, {'A', 'C', 'B', 'D'},
                                             {'C', 'B', 'D', 'A'}};


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public quiz(void)					//
	//				                                //
	// Description: Initializes all data members of the quiz class  //
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public quiz()
	{
		// Initialize all data members.
		numDatasets = 0;			
		tokenBuffer = null;
		line = null;
		answerList = null;
	}

	
	//////////////////////////////////////////////////////////////////
	// Function:  calcScore   				        //
	// 								//
	// Synopsis:  private void calcScore()   	                //
	// 						                //
	// Description: Look up each answer provided by the data set    //
	//              and find it's corresponding score based on the  //
   	//              answer key, talley up the total score and print //
        //              the quiz result.                                //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void calcScore()
	{
		int score = 0;

		// Go through each answer and calculate it's score based on it's position 
		// on the corresponding answer key row
		for(int i = 0; i < answerList.length(); i++)
		{
			score += getScore(answerKey[i], answerList.charAt(i));
		}

		// Print the quiz results based on the score
		printResult(score);
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getScore   				        //
	// 								//
	// Synopsis:  private int getScore(char[] list, char answer)    //
	// 						                //
	// Description: Search the passed in list to get the passed in  //
        //              answer's position, this is used to calculate    //
  	//              that answer's score.                            //
	//				                                //
	// Return Value: Integer representing the score for this answer //
	//               which is based on it's position on the list    //
	//               minus 1.                                       //
	//////////////////////////////////////////////////////////////////
	private int getScore(char[] list, char answer)
	{
		// Search each answer on the answer key row for our answer
		for(int i = 0; i < NUM_ANSWERS; i++)
		{
			// If we found the answer we're looking for, return it's score
			if(list[i] == answer)
			{
				return (i-1);
			}
		}

		// We should never get here, if we do something is wrong cause we could not find the answer!
		System.out.print("Fatal Error:  Did not find answer " + answer + " on score sheet!");
		System.exit(1);
		return -1;
	}	


	//////////////////////////////////////////////////////////////////
	// Function:  printResult 				        //
	// 								//
	// Synopsis:  private void printResult(int score)               //
	// 						                //
	// Description: Print a message based on the range of the score.//
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void printResult(int score)
	{
		// Print a message based on the score we got
		if(score < 0) 
		{
			System.out.println(score + " It's hopeless!");
		}

		else if((score >= 0) && (score <= 5))
		{
			System.out.println(score + " Don't give up!");
		}
	
		else if((score >= 6) && (score <= 10))
		{
			System.out.println(score +  " You're on target!");

		}

		else if(score > 10)
		{
			System.out.println(score + " It's a sure thing!");
		}
	}
	

	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the quiz by reading each answer list and //
	//              calcluated the score based on the answer key.   //
	//              A message is printed based on the score range.  //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("quiz.in")));

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
			// Read the answer list          		
			try {
                  		answerList = in.readLine();

                        } catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
            		}

			// Calulate the quiz score by comparing the answer list to the answer key
			calcScore();
		}
	}

	


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the quiz class.                //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		quiz quizEngine = new quiz();
		quizEngine.start();
		System.exit(0);
	}
}