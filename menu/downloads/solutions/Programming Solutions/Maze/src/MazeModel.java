import java.util.*;

public class MazeModel
{
    // Constants
    public final String EXIT = "X";
    public final String WALL = "W";
    public final String PATH = "P";
    public final String MOUSE = "M";
    public final String TRACK = "T";
    public final int SEARCHING = 0;
    public final int EXITFOUND = 1;
    public final int NOEXITFOUND = 2;

    // Instance Variables
    private String[][] maze;   // two-dimensional grid
    private Stack<Location> stack;  // used for backtracking
    private Location mouseLoc; // current location of mouse within maze
    private Random rg;

    // Constructor
    public MazeModel()
    {
        maze = new String[20][20];
        rg = new Random();
        createMaze();
    }

    // The createMaze method initializes the stack and
    // sets the positions of the paths, walls, start, and
    // exit within the two-dimensional grid(maze). It also
    // places the mouse at its starting location within the
    // maze.
    public void createMaze()
    {
        stack = new Stack<>();
        // Assign paths
        setPaths();
        // Assign walls
        setWalls();
        // Assign starting position
        setStart();
        // Assign finish line
        setExit();

        // System.out.println(toString());
    }

    // The searchMaze method is responsible for finding a path
    // through the maze. The mouse keeps searching until either an exit is found
    // or it returns to its starting position with no paths left to search.
    // @return one of three values: SEARCHING, EXITFOUND, or NOEXITFOUND
    public int searchMaze()
    {
       
        
    }

    // The setPaths method sets the entire grid cells
    // as paths.
    public void setPaths()
    {
        for(int r = 0; r < 20; r++)
        {
            for(int c = 0; c < 20; c++)
            {
                maze[r][c] = PATH;
            }
        }
    }

    // The setWalls method randomly sets the cells within the
    // grid to walls. There is a 40% chance that a path will
    // be turned into a wall.
    public void setWalls()
    {
        double prob = 0;
        for(int r = 0; r < 20; r++)
        {
            for(int c = 0; c < 20; c++)
            {
                prob = rg.nextDouble();
                if(prob <= .4)          // 40%
                   maze[r][c] = WALL;
            }
        }
    }

    // The setStart method sets the starting position of
    // the mouse within the maze it is located along the
    // right boundary of the maze.
    public void setStart()
    {
        int r = rg.nextInt(18) + 1;
        maze[r][19] = MOUSE;
        maze[r][18] = PATH;
        mouseLoc = new Location(r, 19);
        stack.push(mouseLoc);
    }

    // The setExit method sets the exit for the maze. The
    // exit is located along the left boundary of the
    // maze
    public void setExit()
    {
        int r = rg.nextInt(18) + 1;
        maze[r][0] = EXIT;
        maze[r][1] = PATH;
    }

    // The isExit method returns true if loc is the
    // same location as the exit; false otherwise.
    public boolean isExit(Location loc)
    {
        if(maze[loc.getRow()][loc.getColumn()].equals(EXIT))
           return true;
        else
           return false;
    }

    // The isWall method returns true if loc is a
    // wall; false otherwise.
    public boolean isWall(Location loc)
    {
        if(maze[loc.getRow()][loc.getColumn()].equals(WALL))
           return true;
        else
           return false;
    }

    // The isPath method returns true if loc is a
    // path; false otherwise;
    public boolean isPath(Location loc)
    {
        if(maze[loc.getRow()][loc.getColumn()].equals(PATH))
           return true;
        else
           return false;
    }

    // The isMouse method returns true if loc is the
    // mouse's position; false otherwise.
    public boolean isMouse(Location loc)
    {
        if(maze[loc.getRow()][loc.getColumn()].equals(MOUSE))
           return true;
        else
           return false;
    }

    // The isTrack method returns true if loc is a track.
    // A track is a position within the grid that the mouse
    // has already visited.
    public boolean isTrack(Location loc)
    {
        if(maze[loc.getRow()][loc.getColumn()].equals(TRACK))
           return true;
        else
           return false;
    }

    // The inBounds method returns true is loc is a valid
    // location within the grid; false otherwise.
    public boolean inBounds(Location loc)
    {
        if(loc.getRow() >=0 && loc.getRow() <= 19 &&
           loc.getColumn() >= 0 && loc.getColumn() <= 19)
             return true;
        else
             return false;
    }

    public String toString()
    {
        String str="";

        for(int r=0; r < 20; r++)
        {
            for(int c=0; c < 20; c++)
            {
                str += maze[r][c] + " ";
            }
            str += "\n";
        }
        return str;
    }
}