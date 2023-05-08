//////////////////////////////////
//  File:        chase.java     // 
//  Programmer:  Marc Douet     //
//  Date:        05/03/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;
import java.awt.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  chase                                                  //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class chase {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;		
	private String 		line;		
	private StringTokenizer tokenBuffer;
	private int		numRows;
	private int		numCols;
	char[][]		mazeArray;
	Point			mouseLocation;
	Point			catLocation;
	char 			mouseDirection;
	char			catDirection;
	boolean 		mouseSpotted;
	Point 			mouseSpottedLocation;
	


	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public chase(void)				//
	//				                                //
	// Description: Initializes all data members of the chase       //
	//              class  						//
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public chase()
	{
		// Initialize all data members.
		numDatasets = 0;			
		line = null;			
		tokenBuffer = null;
		numRows = 0;
		numCols = 0;
		mouseSpotted = false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  printMaze  					//
	// 								//
	// Synopsis:  private void printMaze()                          //
	// 						                //
	// Description: Debug routine used to print the current state   //
	//              of the maze.                                    //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void printMaze()
	{
		for(int row = 0; row < numRows; row++) 
		{
			for(int col = 0; col < numCols; col++) 
			{
				System.out.print(mazeArray[row][col]);
			}
			System.out.println();
		}

		System.out.println();
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isMouseLoc         				//
	// 								//
	// Synopsis:  private boolean isMouseLoc(char letter)           //
	// 						                //
	// Description: Determine if a mouse resides at this location   //
	//              by checking if it is n, s, e, or w.             //
	//				                                //
	// Return Value: true if this is the location of a mouse.       //
	//////////////////////////////////////////////////////////////////
	private boolean isMouseLoc(char letter)
	{
		if(letter == 'n' || letter == 's' || letter == 'e' || letter == 'w') {
			return true;
		} else {
			return false;
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isCatLoc         			         	//
	// 								//
	// Synopsis:  private boolean isCatLoc(char letter)             //
	// 						                //
	// Description: Determine if a cat resides at this location by  //
	//              checking if it is N, S, E, or W.                //
	//				                                //
	// Return Value: true if this is the location of a cat.         //
	//////////////////////////////////////////////////////////////////
	private boolean isCatLoc(char letter)
	{
		if(letter == 'N' || letter == 'S' || letter == 'E' || letter == 'W') {
			return true;
		} else {
			return false;
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  findCat      					//
	// 								//
	// Synopsis:  private boolean findCat()                         //
	// 						                //
	// Description: Determine if a cat is in the mouse's line of    //
	//              site.                                           //
	//				                                //
	// Return Value: true if the mouse can see a cat.               //
	//////////////////////////////////////////////////////////////////
	private boolean findCat()
	{
		int x = (int)mouseLocation.getX();
		int y = (int)mouseLocation.getY();

		// If the mouse is looking north...
		if(mouseDirection == 'n') {
			// Look north for a cat
			for(int row = x; row >= 0; row--) {
				// We can't see through walls, so break if we find one
				if(mazeArray[row][y] == '#') {
					break; 
				}

				// If we found a cat, return true
				if(isCatLoc(mazeArray[row][y])) {
					return true;
				}
			}

		// If the mouse is looking south...
		} else if (mouseDirection == 's') {
			// Look south for a cat
			for(int row = x; row < numRows; row++) {
				// We can't see through walls, so break if we find one
				if(mazeArray[row][y] == '#') {
					break; 
				}

				// If we found a cat, return true
				if(isCatLoc(mazeArray[row][y])) {
					return true;
				}
			}

		// If the mouse is looking east...
		} else if (mouseDirection == 'e') {
			// Look east for a cat
			for(int col = y; col < numRows; col++) {
				// We can't see through walls, so break if we find one
				if(mazeArray[x][col] == '#') {
					break; 
				}

				// If we found a cat, return true
				if(isCatLoc(mazeArray[x][col])) {
					return true;
				}
			}

		// If the mouse is looking west...
		} else if (mouseDirection == 'w') {
			// Look west for a cat
			for(int col = y; col >= 0; col--) {
				// We can't see through walls, so break if we find one
				if(mazeArray[x][col] == '#') {
					break; 
				}

				// If we found a cat, return true
				if(isCatLoc(mazeArray[x][col])) {
					return true;
				}
			}

		// Throw a fatal error if we found an unexpected direction
		} else {
			System.out.println("Fatal Error: Invalid Mouse Direction!");
			System.exit(1);
		}

		// If we got here, we didn't see a cat
		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  findMouse     					//
	// 								//
	// Synopsis:  private boolean findMouse()                       //
	// 						                //
	// Description: Determine if a mouse is in the cat's line of    //
	//              site.                                           //
	//				                                //
	// Return Value: true if the cat can see a mouse.               //
	//////////////////////////////////////////////////////////////////
	private boolean findMouse()
	{
		int x = (int)catLocation.getX();
		int y = (int)catLocation.getY();

		// If the cat is looking north...
		if(catDirection == 'N') {
			// Look north for a mouse
			for(int row = x; row >= 0; row--) {
				// We can't see through walls, so break if we find one
				if(mazeArray[row][y] == '#') 
				{ 
					break; 
				}

				// If we found a mouse, return true
				if(isMouseLoc(mazeArray[row][y])) {
					return true;
				}
			}

		// If the cat is looking south...
		} else if (catDirection == 'S') {
			// Look south for a mouse
			for(int row = x; row < numRows; row++) {
				// We can't see through walls, so break if we find one
				if(mazeArray[row][y] == '#') 
				{ 
					break; 
				}

				// If we found a mouse, return true
				if(isMouseLoc(mazeArray[row][y])) {
					return true;
				}
			}

		// If the cat is looking east...
		} else if (catDirection == 'E') {
			// Look east for a mouse
			for(int col = y; col < numCols; col++) {
				// We can't see through walls, so break if we find one
				if(mazeArray[x][col] == '#') 
				{ 
					break; 
				}

				// If we found a mouse, return true
				if(isMouseLoc(mazeArray[x][col])) {
					return true;
				}
			}

		// If the cat is looking west...
		} else if (catDirection == 'W') {
			// Look west for a mouse
			for(int col = y; col >= 0; col--) {
				// We can't see through walls, so break if we find one
				if(mazeArray[x][col] == '#') 
				{ 
					break; 
				}

				// If we found a mouse, return true
				if(isMouseLoc(mazeArray[x][col])) {
					return true;
				}
			}

		// Throw a fatal error if we encountered an unexpected direction
		} else {
			System.out.println("[findMouse]Fatal Error: Invalid Cat Direction!");
			System.exit(1);
		}

		// If we got here, we didn't find a mouse, so return false
		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  turnMouse    					//
	// 								//
	// Synopsis:  private void turnMouse()                          //
	// 						                //
	// Description: Turn the mouse counter-clockwise.               //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void turnMouse()
	{
		if(mouseDirection == 'n') { mouseDirection = 'w'; }
		else if(mouseDirection == 's') { mouseDirection = 'e'; }
		else if(mouseDirection == 'e') { mouseDirection = 'n'; }
		else if(mouseDirection == 'w') { mouseDirection = 's'; }
		else {
			System.out.println("Fatal Error: Invalid Mouse Direction!");
			System.exit(1);
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  turnCat    					//
	// 								//
	// Synopsis:  private void turnCat()                            //
	// 						                //
	// Description: Turn the cat clockwise.                         //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void turnCat()
	{
		if(catDirection == 'N') { catDirection = 'E'; }
		else if(catDirection == 'S') { catDirection = 'W'; }
		else if(catDirection == 'E') { catDirection = 'S'; }
		else if(catDirection == 'W') { catDirection = 'N'; }
		else {
			System.out.println("[turnCat]Fatal Error: Invalid Cat Direction!");
			System.exit(1);
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  spotCat				                //
	// 								//
	// Synopsis:  private void spotMouse(int row, int col)          //
	// 						                //
	// Description: Determine if the mouse is in the cat's line of  //
	//              site, if it is set a flag and the position the  //
	//              mouse was spotted for use during the cat's turn.//
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void spotMouse(int row, int col)
	{
		int x = (int)catLocation.getX();
		int y = (int)catLocation.getY();

		if((catDirection == 'N') && ((col == y) && (row < x))) {
			for(int i = x; i >= 0; i--) {
				if(i == row) {
					mouseSpotted = true;
					mouseSpottedLocation = new Point(row, col);
					break;
				}

				if(mazeArray[i][col] == '#') { 
					break; 
				}
			}
		}

		else if((catDirection == 'S') && ((col == y) && (row > x))) {
			for(int i = x; i < numRows; i++) {
				if(i == row) {
					mouseSpotted = true;
					mouseSpottedLocation = new Point(row, col);
					break;
				}

				if(mazeArray[i][col] == '#') { 
					break; 
				}
			}
		}

		else if((catDirection == 'E') && ((row == x) && (col > y))) {
			for(int i = y; i < numCols; i++) {
				if(i == col) {
					mouseSpotted = true;
					mouseSpottedLocation = new Point(row, col);
					break;
				}

				if(mazeArray[row][i] == '#') { 
					break; 
				}
			}
		}

		else if((catDirection == 'W') && ((row == x) && (col < y))) {
			for(int i = y; i >= 0; i--) {
				if(i == col) {
					mouseSpotted = true;
					mouseSpottedLocation = new Point(row, col);
					break;
				}

				if(mazeArray[row][i] == '#') { 
					break; 
				}
			}
		}
	}
			

	//////////////////////////////////////////////////////////////////
	// Function:  advanceMouse					//
	// 								//
	// Synopsis:  private boolean advanceMouse()                    //
	// 						                //
	// Description: Move the mouse in the direction it's looking    //
	//              until it hits a wall or exits the maze.         //
	//				                                //
	// Return Value: true if the mouse exited the maze.             //
	//////////////////////////////////////////////////////////////////
	private boolean advanceMouse()
	{
		int x = (int)mouseLocation.getX();
		int y = (int)mouseLocation.getY();

		if(mouseDirection == 'n') {
			for(int row = x; row >= 0; row--) {
				if(mazeArray[row][y] == '#') {
					turnMouse();
					mazeArray[(int)mouseLocation.getX()][(int)mouseLocation.getY()] = '.';
					mouseLocation.move((row+1), y);
					mazeArray[(int)mouseLocation.getX()][(int)mouseLocation.getY()] = mouseDirection;
					return false;
				}
				spotMouse(row, y);
			}
		} else if (mouseDirection == 's') {
			for(int row = x; row < numRows; row++) {
				if(mazeArray[row][y] == '#') {
					turnMouse();
					mazeArray[(int)mouseLocation.getX()][(int)mouseLocation.getY()] = '.';
					mouseLocation.move((row-1), y);
					mazeArray[(int)mouseLocation.getX()][(int)mouseLocation.getY()] = mouseDirection;
					return false;
				}
				spotMouse(row, y);
			}
		} else if (mouseDirection == 'e') {
			for(int col = y; col < numCols; col++) {
				if(mazeArray[x][col] == '#') {
					turnMouse();
					mazeArray[(int)mouseLocation.getX()][(int)mouseLocation.getY()] = '.';
					mouseLocation.move(x, (col-1));
					mazeArray[(int)mouseLocation.getX()][(int)mouseLocation.getY()] = mouseDirection;
					return false;
				}
				spotMouse(x, col);
			}
		} else if (mouseDirection == 'w') {
			for(int col = y; col >= 0; col--) {
				if(mazeArray[x][col] == '#') {
					turnMouse();
					mazeArray[(int)mouseLocation.getX()][(int)mouseLocation.getY()] = '.';
					mouseLocation.move(x, (col+1));
					mazeArray[(int)mouseLocation.getX()][(int)mouseLocation.getY()] = mouseDirection;
					return false;
				}
				spotMouse(x, col);
			}
		} else {
			System.out.println("Fatal Error: Invalid Mouse Direction!");
			System.exit(1);
		}

		// If we got here, we made it out the maze, a-mazing!
		return true;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  advanceCat         				//
	// 								//
	// Synopsis:  private void advanceCat()                         //
	// 						                //
	// Description: Move the cat in the direction it's looking until//
	//              it reaches a wall.                              //
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void advanceCat()
	{
		int x = (int)catLocation.getX();
		int y = (int)catLocation.getY();
		int row, col;

		if(catDirection == 'N') {
			for(row = x; row >= 0; row--) {
				if(mazeArray[row][y] == '#') {
					turnCat();
					mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = '.';
					catLocation.move((row+1), y);
					mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = catDirection;
					break;
				}
			}

			if(row < 0) 
			{
				row++;
				turnCat();
				mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = '.';
				catLocation.move(row, y);
				mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = catDirection;
			}
		} else if (catDirection == 'S') {
			for(row = x; row < numRows; row++) {
				if(mazeArray[row][y] == '#') {
					turnCat();
					mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = '.';
					catLocation.move((row-1), y);
					mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = catDirection;
					break;
				}
			}

			if(row == numRows) 
			{
				row--;
				turnCat();
				mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = '.';
				catLocation.move(row, y);
				mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = catDirection;
			}
		} else if (catDirection == 'E') {
			for(col = y; col < numCols; col++) {
				if(mazeArray[x][col] == '#') {
					turnCat();
					mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = '.';
					catLocation.move(x, (col-1));
					mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = catDirection;
					break;
				}
			}

			if(col == numCols) 
			{
				col--;
				turnCat();
				mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = '.';
				catLocation.move(x, col);
				mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = catDirection;
			}
		} else if (catDirection == 'W') {
			for(col = y; col >= 0; col--) {
				if(mazeArray[x][col] == '#') {
					turnCat();
					mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = '.';
					catLocation.move(x, (col+1));
					mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = catDirection;
					break;
				}
			}

			if(col < 0) 
			{
				col++;
				turnCat();
				mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = '.';
				catLocation.move(x, (col+1));
				mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = catDirection;
			}
		} else {
			System.out.println("[advanceCat]Fatal Error: Invalid Cat Direction!");
			System.exit(1);
		}
	}
		

	//////////////////////////////////////////////////////////////////
	// Function:  moveMouse          				//
	// 								//
	// Synopsis:  private boolean moveMouse()                       //
	// 						                //
	// Description: Turn the mouse if it sees a cat and then move   //
	//              it til it hits a wall or finds the exit.        //
	//				                                //
	// Return Value: true if the mouse found the exit.              //
	//////////////////////////////////////////////////////////////////
	private boolean moveMouse()
	{
		// First, let's search for that darn cat, turn if we find him
		if(findCat()) {
			turnMouse();
			mazeArray[(int)mouseLocation.getX()][(int)mouseLocation.getY()] = mouseDirection;
		}

		return advanceMouse();
	}


	//////////////////////////////////////////////////////////////////
	// Function:  moveCat            				//
	// 								//
	// Synopsis:  private boolean moveCat()                         //
	// 						                //
	// Description: Determine if we caught the mouse, if not either //
	//              move to the spot we last saw it or until we hit //
	//              a wall.                                         //
	//				                                //
	// Return Value: True if the cat ate the mouse.                 //
	//////////////////////////////////////////////////////////////////
	private boolean moveCat()
	{
		// First, let's search for that yummy mouse, eat it, yum!
		if(findMouse()) {
			return true;
		}
		
		if(mouseSpotted) {
			mouseSpotted = false;
			mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = '.';
			catLocation.move((int)mouseSpottedLocation.getX(), (int)mouseSpottedLocation.getY());
			
			if(mouseDirection == 'n') { catDirection = 'E'; }
			else if(mouseDirection == 's') { catDirection = 'W'; }
			else if(mouseDirection == 'e') { catDirection = 'S'; }
			else if(mouseDirection == 'w') { catDirection = 'N'; }

			mazeArray[(int)catLocation.getX()][(int)catLocation.getY()] = catDirection;
		} else {
			advanceCat();
		}

		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  traverseMaze					//
	// 								//
	// Synopsis:  private void traverseMaze()                       //
	// 						                //
	// Description: Initialize the maze, and then have the mouse and//
	//              cat take turns moving, giving up after 100 turns//
	//				                                //
	// Return Value: None                                           //
	//////////////////////////////////////////////////////////////////
	private void traverseMaze()
	{
		int turn;
		mouseSpotted = false;

		// Start off by finding the cat and mouse inital location
		for(int row = 0; row < numRows; row++) {
			for(int col = 0; col < numCols; col++) {
				if(isCatLoc(mazeArray[row][col])) {
					catLocation = new Point(row, col);
					catDirection = mazeArray[row][col];
				} else if(isMouseLoc(mazeArray[row][col])) {
					mouseLocation = new Point(row, col);
					mouseDirection = mazeArray[row][col];
				}
			}
		}

		// Continue through the maze, giving up after 100 turns, we break early 
		// if the mouse is able to find an exit
		for(turn = 1; turn <= 100; turn++) {
			if(moveMouse()) { 
				System.out.println("The mouse escapes in " + turn + " moves.");
				break; 
			}

			if(moveCat()) {
				System.out.println("The mouse is caught in " + turn + " moves.");
				break;
			}
		}

		if(turn > 100) {
			System.out.println("The chase never ends.");
		}
	}


	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the chase class by reading in each maze  //
	//              and traversing it.                              //
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("chase.in")));

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
			// Get the dimensions of the maze     		
			try {
                  		line = in.readLine();
				tokenBuffer = new StringTokenizer(line);
				numCols = Integer.parseInt(tokenBuffer.nextToken());
				numRows = Integer.parseInt(tokenBuffer.nextToken());
                        } catch(IOException ioError) {
				System.out.println(
					"Error occurred while reading in the next line of input.");
                		ioError.printStackTrace();
				System.exit(1);
			}

			// Populate the maze array
			mazeArray = new char[numRows][numCols];
			for(int row = 0; row < numRows; row++) {
				// Get a row of the maze    		
				try {
                  			line = in.readLine();
                        	} catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
				}

				for(int col = 0; col < numCols; col++) {
					mazeArray[row][col] = line.charAt(col);
				}
			}

			// Let the chase begin....
			traverseMaze();	
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the chase class.               //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		chase chaseEngine = new chase();
		chaseEngine.start();
		System.exit(0);
	}
}