import java.util.*;
import java.io.*;
import java.awt.*;

public class Room {

    static class space {
        public char mapValue;
        public int row;
        public int col;

        public space (char inChar, int inRow, int inCol) {
           mapValue = inChar;
           row = inRow;
           col = inCol;
        }
        public boolean isStart() {
           return (mapValue == '@');
        }
        public boolean isWall() {
           return (mapValue == '#');
        }
        public boolean isEmpty() {
           return (mapValue == '.');
        }
    }

    static final int MAX_ROWS=50;
    static final int MAX_COLS=50;

    static int cost;
    static int numRows;
    static int numCols;

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

	space[][] map = new space[MAX_ROWS][MAX_COLS];
        space currSpace;
        Queue floodQ = new LinkedList();

        // Create a new scanner
        Scanner sin = new Scanner(new File("room.dat"));

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

            //Start cost at 1 since we start on an empty space
            cost=1;

            //Flood fill map
            while(floodQ.peek() != null) {
               currSpace=(space)floodQ.remove();

               //Flood north if possible and we haven't been there
               if(currSpace.row > 0 && !map[currSpace.row-1][currSpace.col].isWall()
                  && map[currSpace.row-1][currSpace.col].isEmpty()) {
                      //Mark space as checked
                      cost++;
                      map[currSpace.row-1][currSpace.col].mapValue = '@';
                      floodQ.add(map[currSpace.row-1][currSpace.col]);
               }
               //Flood east if possible and we haven't been there
               if(currSpace.col < numCols-1 && !map[currSpace.row][currSpace.col+1].isWall() && map[currSpace.row][currSpace.col+1].isEmpty()) {
                      //Mark space as checked
                      cost++;
                      map[currSpace.row][currSpace.col+1].mapValue = '@';
                      floodQ.add(map[currSpace.row][currSpace.col+1]);
               }
               //Flood south if possible and we haven't been there
               if(currSpace.row < numRows-1 && !map[currSpace.row+1][currSpace.col].isWall() && map[currSpace.row+1][currSpace.col].isEmpty()) {
                      //Mark space as checked
                      cost++;
                      map[currSpace.row+1][currSpace.col].mapValue = '@';
                      floodQ.add(map[currSpace.row+1][currSpace.col]);
               }
               //Flood west if possible and we haven't been there
               if(currSpace.col > 0 && !map[currSpace.row][currSpace.col-1].isWall()
                  && map[currSpace.row][currSpace.col-1].isEmpty()) {
                      //Mark space as checked
                      cost++;
                      map[currSpace.row][currSpace.col-1].mapValue = '@';
                      floodQ.add(map[currSpace.row][currSpace.col-1]);
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

            System.out.println("$" + cost);

        }
        sin.close();
    }
}
