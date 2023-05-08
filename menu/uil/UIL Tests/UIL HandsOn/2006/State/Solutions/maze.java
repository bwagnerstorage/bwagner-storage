import java.util.Scanner;
import java.util.regex.*;
import java.io.File;
import java.io.IOException;

public class maze
{
    enum orientation { 
       NORTH, EAST, WEST, SOUTH;
       final orientation opposite()
       {
          if(name().equals("NORTH"))
             return SOUTH;
          else if(name().equals("EAST"))
             return WEST;
          else if(name().equals("WEST"))
             return EAST;
          else if(name().equals("SOUTH"))
             return NORTH;
          return NORTH;
       }
       final orientation turn(way whichWay)
       {
          if(name().equals("NORTH"))
          {
             if(whichWay == way.LEFT)
                return WEST;
             else if(whichWay == way.RIGHT)
                return EAST;
          }
          if(name().equals("EAST"))
          {
             if(whichWay == way.LEFT)
                return NORTH;
             else if(whichWay == way.RIGHT)
                return SOUTH;
          }
          if(name().equals("WEST"))
          {
             if(whichWay == way.LEFT)
                return SOUTH;
             else if(whichWay == way.RIGHT)
                return NORTH;
          }
          if(name().equals("SOUTH"))
          {
             if(whichWay == way.LEFT)
                return EAST;
             else if(whichWay == way.RIGHT)
                return WEST;
          }
          return NORTH;
       }
       final char toSymbol()
       {
          if(name().equals("NORTH"))
             return 'N';
          if(name().equals("EAST"))
             return 'E';
          if(name().equals("WEST"))
             return 'W';
          if(name().equals("SOUTH"))
             return 'S';
          return 'N';
       }
       final static orientation fromSymbol(char c)
       {
           switch (c)
           {
               case 'N': return NORTH;
               case 'E': return EAST;
               case 'W': return WEST;
               case 'S': return SOUTH;
           }
           return NORTH;
       }
    };
    enum direction { FORWARD, BACK };
    enum way { LEFT, RIGHT };
    static final int MAXROWS = 10;
    static final int MAXCOLS = 10;
    static final char WALL = '#';
    static final char EMPTY = '.';
    static orientation robotOrientation;
    static int robotRow, robotCol;
    static char maze[][];
    static int numRows, numCols;

    public static void main(String[] args) throws IOException
    {
        Scanner s = new Scanner(new File("maze.in"));
        int numDataSets, numCommands;
        int distance;
        String command;

        maze = new char[MAXROWS][MAXCOLS];
	numDataSets = s.nextInt();
        
        for(int i = 0; i < numDataSets; i++)
        {
           System.out.println("Data Set #" + (i+1));
           numRows = s.nextInt();
           numCols = s.nextInt();

           //Skip to next line
           s.nextLine();
           
           for(int j = 0; j < numRows; j++)
           {
               maze[j] = (s.nextLine()).toCharArray();
               for(int k = 0; k < numCols; k++)
               {
                   switch(maze[j][k])
                   {
                       case 'N':
                       case 'E':
                       case 'W':
                       case 'S':  robotOrientation = orientation.fromSymbol(maze[j][k]);
                                  robotRow = j;
                                  robotCol = k;
                                  break;
                   }
               }
           }
           numCommands = s.nextInt();
           
           for(int j = 0; j < numCommands; j++)
           {
               command = s.next();
               if(command.equals("FORWARD"))
               {
                   distance = s.nextInt();
                   move(direction.FORWARD, distance);
               }
               else if(command.equals("BACK"))
               {
                   distance = s.nextInt();
                   move(direction.BACK, distance);
               }
               else if(command.equals("TURN"))
               {
                   command = s.next();

                   if(command.equals("LEFT"))
                      robotOrientation = robotOrientation.turn(way.LEFT);
                   else if(command.equals("RIGHT"))
                      robotOrientation = robotOrientation.turn(way.RIGHT);

                   maze[robotRow][robotCol] = robotOrientation.toSymbol();
               }
               else if(command.equals("ZAP"))
               {
                   zap();
               }
           }
           for(int j = 0; j < numRows; j++)
           {
               for(int k = 0; k < numCols; k++)
               {
                   System.out.print(maze[j][k]);
               }
               System.out.println();
           }
        }
    }
    public static void move(direction robotDir, int distance)
    {
        int possRow, possCol;
        orientation heading;
        if(robotDir == direction.FORWARD)
           heading = robotOrientation;
        else
           heading = robotOrientation.opposite();

        possRow = robotRow;
        possCol = robotCol;        
        for(int i = 0; i < distance; i++)
        {
            if(heading == orientation.NORTH)
               possRow--;
            else if(heading == orientation.EAST)
               possCol++;
            else if(heading == orientation.WEST)
               possCol--;
            else if(heading == orientation.SOUTH)
               possRow++;

            if(possRow >= 0 && possRow < numRows &&
               possCol >= 0 && possCol < numCols &&
               maze[possRow][possCol] != WALL)
            {
               maze[possRow][possCol] = maze[robotRow][robotCol];
               maze[robotRow][robotCol] = EMPTY;
               robotRow = possRow;
               robotCol = possCol;
            }
        }
    }
    public static void zap()
    {
        int possRow, possCol;
        possRow = robotRow;
        possCol = robotCol;
        while(true)
        {
            if(robotOrientation == orientation.NORTH)
               possRow--;
            else if(robotOrientation == orientation.EAST)
               possCol++;
            else if(robotOrientation == orientation.WEST)
               possCol--;
            else if(robotOrientation == orientation.SOUTH)
               possRow++;

            if(possRow >= 0 && possRow < numRows &&
               possCol >= 0 && possCol < numCols)
            {
               if(maze[possRow][possCol] == WALL)
               {
                  maze[possRow][possCol] = EMPTY;
                  return;
               }
            }
            else
               return;
        }
    }
}

