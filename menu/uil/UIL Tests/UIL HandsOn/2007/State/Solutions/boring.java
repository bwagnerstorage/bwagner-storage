//////////////////////////////////
//  File:        boring.java    // 
//  Programmer:  Marc Douet     //
//  Date:        04/14/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;

//////////////////////////////////////////////////////////////////////////
//  Class Name:  boring		        	               	        //
//	                                                                //
//  Description: Simply prints 200 lines of text                        //
//////////////////////////////////////////////////////////////////////////
public class boring {

	//////////////////////////////////////////////////////////////////
	//  Function:  main                                             //	
	//								//
	//  Synopsis:  public static void main(String args[])		//	   	
	//								//
	//	       args  [IN]  Not used.	  			//                         	
	//								//
	//  Description: The main driver of the boring class.        	//     
	//               Simply prints a 200 lines of text.             //
	//							        //  
        //                                                              //
	//  Return Value: None.						//
	//////////////////////////////////////////////////////////////////
	public static void main(String args[])
	{
		for(int i = 0; i < 200; i++)	
		{
			System.out.println("I will not talk during this boring class.");
		}

		System.exit(0);
	}
}