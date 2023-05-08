import java.util.*;
import java.io.*;
import java.awt.*;

public class Door {

    static class space {
        public char mapValue;
        public int floodValue;
        public int row;
        public int col;

        public space (char inChar, int inRow, int inCol) {
           mapValue = inChar;
           row = inRow;
           col = inCol;
           if(mapValue == 'S')
              floodValue = 0;
           else
              floodValue=MAX_ROWS*MAX_COLS;
        }
        public boolean isDoor() {
           return (mapValue == 'd');
        }
        public boolean isStart() {
           return (mapValue == 'S');
        }
        public boolean isWall() {
           return (mapValue == '#');
        }
    }

    static final int MAX_ROWS=50;
    static final int MAX_COLS=50;

    static int maxDoorsOpened;
    static int numRows;
    static int numCols;
    static int doorValue;

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

	space[][] map = new space[MAX_ROWS][MAX_COLS];
        space currSpace;
        Queue floodQ = new LinkedList();

        // Create a new scanner
        Scanner sin = new Scanner(new File("door.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            // Get the number of rows
            numRows = sin.nextInt(); 
            // Get the number of columns
            numCols = sin.nextInt(); 
            sin.nextLine();

            // Read in the map
            for (int row=0; row < numRows; row++) {
               String currRow = sin.next();
               for (int col=0; col < numCols; col++) {
                  map[row][col] = new space(currRow.charAt(col),row,col);

                  //Add starting location to list of spaces to check                  
                  if(map[row][col].isStart()) {
                     floodQ.add(map[row][col]);
                  }
               }
               sin.nextLine();
            }

            //Flood fill map
            while(floodQ.peek() != null) {
               currSpace=(space)floodQ.remove();

               //Flood north if possible
               if(currSpace.row > 0 && !map[currSpace.row-1][currSpace.col].isWall()) {
                   //If the space is a door, it will cost us 1 to go there
                   doorValue = map[currSpace.row-1][currSpace.col].isDoor() ? 1 : 0;
                   if(map[currSpace.row-1][currSpace.col].floodValue > currSpace.floodValue+doorValue) {
                      //This is a better route, take it
                      map[currSpace.row-1][currSpace.col].floodValue = currSpace.floodValue+doorValue;
                      floodQ.add(map[currSpace.row-1][currSpace.col]);
                   }
               }
               //Flood east if possible
               if(currSpace.col < numCols-1 && !map[currSpace.row][currSpace.col+1].isWall()) {
                   //If the space is a door, it will cost us 1 to go there
                   doorValue = map[currSpace.row][currSpace.col+1].isDoor() ? 1 : 0;
                   if(map[currSpace.row][currSpace.col+1].floodValue > currSpace.floodValue+doorValue) {
                      //This is a better route, take it
                      map[currSpace.row][currSpace.col+1].floodValue = currSpace.floodValue+doorValue;
                      floodQ.add(map[currSpace.row][currSpace.col+1]);
                   }
               }
               //Flood south if possible
               if(currSpace.row < numRows-1 && !map[currSpace.row+1][currSpace.col].isWall()) {
                   //If the space is a door, it will cost us 1 to go there
                   doorValue = map[currSpace.row+1][currSpace.col].isDoor() ? 1 : 0;
                   if(map[currSpace.row+1][currSpace.col].floodValue > currSpace.floodValue+doorValue) {
                      //This is a better route, take it
                      map[currSpace.row+1][currSpace.col].floodValue = currSpace.floodValue+doorValue;
                      floodQ.add(map[currSpace.row+1][currSpace.col]);
                   }
               }
               //Flood west if possible
               if(currSpace.col > 0 && !map[currSpace.row][currSpace.col-1].isWall()) {
                   //If the space is a door, it will cost us 1 to go there
                   doorValue = map[currSpace.row][currSpace.col-1].isDoor() ? 1 : 0;
                   if(map[currSpace.row][currSpace.col-1].floodValue > currSpace.floodValue+doorValue) {
                      //This is a better route, take it
                      map[currSpace.row][currSpace.col-1].floodValue = currSpace.floodValue+doorValue;
                      floodQ.add(map[currSpace.row][currSpace.col-1]);
                   }
               }              
            }
//Debug output
//for(int row=0;row<numRows;row++) {
//   for(int col=0;col<numCols;col++)
//      if(map[row][col].floodValue == MAX_ROWS*MAX_COLS)
//         System.out.print("#");
//      else
//         System.out.print(map[row][col].floodValue);
//   System.out.println();
//}
      
            //Check outside squares for lowest number of doors needed to reach there
            maxDoorsOpened = MAX_ROWS * MAX_COLS;
            for(int row=0; row < numRows; row++)
               for(int col=0; col < numCols; col++)
                  if((row == 0 ||
                      row == numRows-1 ||
                      col == 0 ||
                      col == numCols-1) && 
                      map[row][col].floodValue < maxDoorsOpened) {
                     maxDoorsOpened=map[row][col].floodValue;
                  }


            System.out.println(maxDoorsOpened + " door(s)");

        }
        sin.close();
    }
}
