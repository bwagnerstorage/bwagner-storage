// UIL 2006 - Regional Programming Contest
//
// maze.java
//
// The purpose of this problem is to test contestant
// ability to use two-dimensional arrays and perform
// optimal path finding.
//

import java.io.*;
import java.util.*;

class cell {

   public cell () {
      type = '.';
      distance = 1000;
      closestcell = null;
   }

   char type;
   int distance;
   cell closestcell;
}

public class maze {

   private static final int UP    = 0;
   private static final int DOWN  = 1;
   private static final int LEFT  = 2;
   private static final int RIGHT = 3;
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("maze.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {
         boolean foundatty = false;
         cell startcell = null;
         cell endcell   = null;
         int width  = infile.nextInt();
         int height = infile.nextInt();
         infile.nextLine();

         // create an empty maze
         cell[][]  Maze = new cell[height][width];

         // populate it from the intput file
         for (int h=0; h<height; h++) {
            // read next line of the maze
            String line = infile.nextLine();
            for (int w=0; w<width; w++) {
               Maze[h][w] = new cell();
               Maze[h][w].type = line.charAt(w);
               if (line.charAt(w) == '@') {
                  if (!foundatty) {
                     foundatty = true;
                     startcell = Maze[h][w];
                     startcell.distance = 0;
                  }
                  else {
                     endcell = Maze[h][w];
                     endcell.type = '.';
                  }
               }
            }
         }

         // iterate over the maze until there are no more changes
         // note that this could be done recursively, but I find that
         // the algorithm is no simpler in that case, which defeats the
         // purpose.
         boolean changed = true; // indicates if we made a change on last pass
         while (changed) {
            changed = false;
            for (int h=0; h<height; h++) {
               for (int w=0; w<width; w++) {
                  cell thiscell = Maze[h][w];

                  cell adjacent[] = { null, null, null, null } ;
                  if (h > 0)        { adjacent[UP]    = Maze[h-1][w]; }
                  if (h < height-1) { adjacent[DOWN]  = Maze[h+1][w]; }
                  if (w > 0)        { adjacent[LEFT]  = Maze[h][w-1]; }
                  if (w < width-1)  { adjacent[RIGHT] = Maze[h][w+1]; }

                  // the only thing we process is blank floor
                  if (thiscell.type == '.') {
                     // look for adjacent cells with distance at least 2 less
                     for (int a=0; a<4; a++) {
                        if (adjacent[a] != null  && 
                            adjacent[a].distance < (thiscell.distance - 1) ) {
                           // we found a new shortest path to here
                           thiscell.distance    = adjacent[a].distance + 1;
                           thiscell.closestcell = adjacent[a];
                           changed = true;
                        }
                     }
                  }
               }
            }
         }

         // fill the shortest path with '@' 
         cell mycell = endcell;
         while (mycell != startcell) { // yep, we do this backward
            mycell.type = '@';
            mycell = mycell.closestcell;
         }

         // display results
         for (int h=0; h<height; h++) {
            for (int w=0; w<width; w++) {
               System.out.printf("%c", Maze[h][w].type);
            }
            System.out.println("");
         }
      }
   }
}
