////////////////////////////////
//  File:        mouse.java   // 
//  Programmer:  Marc Douet   //
//  Date:        04/08/05     //
////////////////////////////////

import java.util.*;

public class mouse
{       
  final static int MAX_DIM = 10;

  public static int getDist(int x1, int y1, int x2, int y2)
  {
      return (Math.abs(x1-x2) + Math.abs(y1-y2));
  }

  public static void main(String[] args)
  {	
      int numDatasets = 0;
      UILFileReader  input = new UILFileReader("mouse.in");
	
      numDatasets = input.readInt();
      for(int dataSet = 0; dataSet < numDatasets; dataSet++) {
          char[][] maze = new char[MAX_DIM][MAX_DIM];
          int mazeDim = input.readInt();
          int mouseRow = 0, mouseCol = 0, cheeseRow = 0, cheeseCol = 0;
          
          for(int row = 0; row < mazeDim; row++) {
              String mazeRow = input.readLine();

              for(int col = 0; col < mazeDim; col++) {
                  maze[row][col] = mazeRow.charAt(col);
              }
          }
          
          // Find the mouse
          for(int row = 0; row < mazeDim; row++) {
              for(int col = 0; col < mazeDim; col++) {
                  if(maze[row][col] == 'm') {
                      mouseRow = row;
                      mouseCol = col;
                      cheeseRow = row;
                      cheeseCol = col;
                      break;
                  }
              }
          }

          while(true) {
              int prevCheeseRow = cheeseRow, prevCheeseCol = cheeseCol;
              int mouseConfused = 0;
              int foundCheese = 0;

          // Look for cheese in the upward direction
          for(int index = mouseRow-1; index >= 0; index--) {
              if(maze[index][mouseCol] == 'C') {
                  int closestCheeseDist = getDist(mouseRow, mouseCol, cheeseRow, cheeseCol);
                  int thisCheeseDist = getDist(mouseRow, mouseCol, index, mouseCol);

                  foundCheese++;
                  if((closestCheeseDist == 0) || (thisCheeseDist < closestCheeseDist)) {
                      cheeseRow = index;
                      cheeseCol = mouseCol;
                      break;
                  } else if(((cheeseRow != index) && (cheeseCol != mouseCol)) && (thisCheeseDist == closestCheeseDist)) {
                      mouseConfused++;
                      break;
                  }
              } else if(maze[index][mouseCol] == '#') {
                  break;
              }
          }

          // Look for cheese in the rightward direction
          for(int index = mouseCol+1; index < mazeDim; index++) {
              if(maze[mouseRow][index] == 'C') {
                  int closestCheeseDist = getDist(mouseRow, mouseCol, cheeseRow, cheeseCol);
                  int thisCheeseDist = getDist(mouseRow, mouseCol, mouseRow, index);
                  foundCheese++;

                  if((closestCheeseDist == 0) || (thisCheeseDist < closestCheeseDist)) {
                      cheeseRow = mouseRow;
                      cheeseCol = index;
                      break;
                  } else if(((cheeseRow != mouseRow) && (cheeseCol != index)) && (thisCheeseDist == closestCheeseDist)) {
                      mouseConfused++;
                      break;
                  }
              } else if(maze[mouseRow][index] == '#') {
                  break;
              }
          }  

          // Look for cheese in the downward direction
          for(int index = mouseRow+1; index < mazeDim; index++) {
              if(maze[index][mouseCol] == 'C') {
                  int closestCheeseDist = getDist(mouseRow, mouseCol, cheeseRow, cheeseCol);
                  int thisCheeseDist = getDist(mouseRow, mouseCol, index, mouseCol);
                  foundCheese++;

                  if((closestCheeseDist == 0) || (thisCheeseDist < closestCheeseDist)) {
                      cheeseRow = index;
                      cheeseCol = mouseCol;
                      break;
                  } else if(((cheeseRow != index) && (cheeseCol != mouseCol)) && (thisCheeseDist == closestCheeseDist)) {
                      mouseConfused++;
                      break;
                  }
              } else if(maze[index][mouseCol] == '#') {
                  break;
              }
          }    

          // Look for cheese in the leftward direction
          for(int index = mouseCol-1; index >= 0; index--) {
              if(maze[mouseRow][index] == 'C') {
                  int closestCheeseDist = getDist(mouseRow, mouseCol, cheeseRow, cheeseCol);
                  int thisCheeseDist = getDist(mouseRow, mouseCol, mouseRow, index);
                  foundCheese++;

                  if((closestCheeseDist == 0) || (thisCheeseDist < closestCheeseDist)) {
                      cheeseRow = mouseRow;
                      cheeseCol = index;
                      break;
                  } else if(((cheeseRow != mouseRow) && (cheeseCol != index)) && (thisCheeseDist == closestCheeseDist)) {
                      mouseConfused++;
                      break;
                  }
              } else if(maze[mouseRow][index] == '#') {
                  break;
              }
          }  

          // If no cheese was found, or the mouse is confused, break out of the sim
          if((foundCheese == 0) || ((foundCheese > 1) && (mouseConfused == (foundCheese-1)))) {
              break;
          }

          // Move the mouse towards the closest piece of cheese
          if(cheeseRow > mouseRow) {
              maze[mouseRow][mouseCol] = '.';
              mouseRow++;
          } else if(cheeseRow < mouseRow) {
              maze[mouseRow][mouseCol] = '.';
              mouseRow--;
          }else if(cheeseCol > mouseCol) {
              maze[mouseRow][mouseCol] = '.';
              mouseCol++;
          }else if(cheeseCol < mouseCol) {
              maze[mouseRow][mouseCol] = '.';
              mouseCol--;
          }
          maze[mouseRow][mouseCol] = 'm';    
          
          }

          // Print the resultant maze
          for(int row = 0; row < mazeDim; row++) {
              for(int col = 0; col < mazeDim; col++) {
                  System.out.print(maze[row][col]);
              }
              System.out.println();
          }
      }
  }
}
