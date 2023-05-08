import java.io.*;
import java.util.*;


public class Maze
{
    public enum CellType
    {
        kCellType_Begin,
        kCellType_End,
        kCellType_Wall,
        kCellType_Path
    }
 
    // As close to a struct as I'm going to get in Java
    class MazeCell
    {
        CellType cellType = CellType.kCellType_Wall;
        MazeCell north = null;
        MazeCell east = null;
        MazeCell south = null;
        MazeCell west = null;
        boolean visited = false;
    }
    
    
    // Member variables
    private static int MAZE_SIZE = 20;
    private MazeCell[][] mMaze;
    private MazeCell mBegin;
    
    
    // Constructor
    public Maze()
    {
        mMaze = new MazeCell[MAZE_SIZE][MAZE_SIZE];
        for (int x = 0; x < MAZE_SIZE; ++x)
        {
            for (int y = 0; y < MAZE_SIZE; ++y)
            {
                mMaze[x][y] = new MazeCell();
            }
        }
        
        mBegin = null;
    }
    
    // Recursion function to search for the solution
    private boolean recurseCell(MazeCell toCell)
    {
        if (null == toCell || toCell.visited)
        {
            return false;
        }
        
        toCell.visited = true;
        
        if (CellType.kCellType_End == toCell.cellType)
        {
            return true;
        }
        else if (CellType.kCellType_Wall != toCell.cellType)
        {
            return    recurseCell(toCell.north)
                   || recurseCell(toCell.east)
                   || recurseCell(toCell.south)
                   || recurseCell(toCell.west);
        }
        else
        {
            return false;
        }
    }
    
    // Parses the data file and stores the data
    public void parseMaze(Scanner kb) throws IOException
    {
        for (int l = 0; l < MAZE_SIZE; ++l)
        {
            String strLine = kb.nextLine();
            for (int s = 0; s < strLine.length(); ++s)
            {
                MazeCell cell = mMaze[l][s];
                char c = strLine.charAt(s);
                if ('#' == c)
                {
                    cell.cellType = CellType.kCellType_Wall;
                }
                else if ('.' == c)
                {
                    cell.cellType = CellType.kCellType_Path;
                }
                else if ('S' == c)
                {
                    cell.cellType = CellType.kCellType_Begin;
                    mBegin = cell;
                }
                else if ('E' == c)
                {
                    cell.cellType = CellType.kCellType_End;
                }
                
                cell.north = (l == 0) ? null : mMaze[l - 1][s];
                cell.south = (l >= MAZE_SIZE - 1) ? null : mMaze[l + 1][s];
                
                cell.east = (s >= MAZE_SIZE - 1) ? null : mMaze[l][s + 1];
                cell.west = (s == 0) ? null : mMaze[l][s - 1];
            }
        }
    }
    
    // Returns true if the maze is solvable, false otherwise
    public boolean trySolve()
    {
        return recurseCell(mBegin);
    }
    
    
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("maze.dat"));
        long mazeCount = 0;
        
        mazeCount = Long.parseLong(kb.nextLine());
        
        for (long m = 0; m < mazeCount; ++m)
        {
            // The class does all the work so just call into it
            Maze maze = new Maze();
            maze.parseMaze(kb);
            
            System.out.print("Maze #" + (m + 1) + ": ");
            
            if (maze.trySolve())
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
            
            // Get the empty line between mazes
            if (kb.hasNextLine())
            {
                kb.nextLine();
            }
        }
    }
}
