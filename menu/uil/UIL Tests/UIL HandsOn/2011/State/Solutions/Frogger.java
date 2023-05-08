import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Frogger
{
    public static void PrintBoolMaze(boolean[][] maze)
    {
        int w = maze.length;
        int h = maze[0].length;
        for (int x = 0; x < w; ++x)
        {
            for (int y = 0; y < h; ++y)
            {
                System.out.printf("%c ", maze[x][y] ? 'x' : '.');
            }
            
            System.out.println();
        }
    }
    
    public static boolean[][] MazeVisitedCopy(boolean[][] mazeVisited)
    {
        int w = mazeVisited.length;
        int h = mazeVisited[0].length;
        boolean[][] mazeVisitedCopy = new boolean[w][h];
        for (int x = 0; x < w; ++x)
        {
            for (int y = 0; y < h; ++y)
            {
                mazeVisitedCopy[x][y] = mazeVisited[x][y];
            }
        }
        
        return mazeVisitedCopy;
    }
    
    public static boolean CanJumpTo(char[][] maze, int x, int y)
    {
        int maxX = maze.length;
        int maxY = maze[0].length;
        
        if (0 > x || x >= maxX)
            return false;
        
        if (0 > y || y >= maxY)
            return false;
        
        return '*' != maze[x][y];
    }
    
    public static int FindPath(char[][] maze, boolean[][] mazeVisited, int x, int y, int level)
    {
        if (x >= maze.length)
            return maze.length * maze[0].length;
        
        if (y >= maze[0].length)
            return maze.length * maze[0].length;
        
        if (0 > x || 0 > y)
            return maze.length * maze[0].length;
        
        if (mazeVisited[x][y])
            return maze.length * maze[0].length;
        
        mazeVisited[x][y] = true;
        
        /*
        for (int l = 0; l < level; ++l)
            System.out.printf("\t");
        
        System.out.printf("%d %d\n", x, y);
        */
        
        char c = maze[x][y];
        if ('$' == c)
            return maze.length * maze[0].length;
        
        if ('*' == c)
            return maze.length * maze[0].length;
        
        if ('@' == c)
            return 1;
        
        int add = 0;
        if ('.' == c)
            add = 1;
        else
            add = c - '0' + 1;
                
        //PrintBoolMaze(mazeVisited);
        //System.out.println();
        
        boolean bCanJumpOut = 1 != add;
        if (bCanJumpOut)
        {
            bCanJumpOut =    CanJumpTo(maze, x - add, y)
                          || CanJumpTo(maze, x + add, y)
                          || CanJumpTo(maze, x, y - add)
                          || CanJumpTo(maze, x, y + add);
        }
                
        int up = maze.length * maze[0].length;
        int down = maze.length * maze[0].length;
        int left = maze.length * maze[0].length;
        int right = maze.length * maze[0].length;
        
        if (bCanJumpOut)
        {
            up = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), x - add, y, level + 1);
            down = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), x + add, y, level + 1);
            left = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), x, y - add, level + 1);
            right = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), x, y + add, level + 1);
        }
        else
        {
            up = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), x - 1, y, level + 1);
            down = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), x + 1, y, level + 1);
            left = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), x, y - 1, level + 1);
            right = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), x, y + 1, level + 1);
        }
        
        int min = up;
        if (down < min)
            min = down;
        if (left < min)
            min = left;
        if (right < min)
            min = right;

                
        return min;
    }
    
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("frogger.dat"));
        
        String line = kb.nextLine();
        int mazes = Integer.parseInt(line);
        for (int i = 0; i < mazes; ++i)
        {
            line = kb.nextLine();
            String[] arr = line.split(" ");
            int h = Integer.parseInt(arr[0]);
            int w = Integer.parseInt(arr[1]);
            char[][] maze = new char[h][w];
            boolean[][] mazeVisited = new boolean[h][w];
            
            int sX = 0;
            int sY = 0;
            
            for (int x = 0; x < h; ++x)
            {
                line = kb.nextLine();
                for (int y = 0; y < w; ++y)
                {
                    maze[x][y] = line.charAt(y);
                    mazeVisited[x][y] = false;
                    
                    if ('$' == maze[x][y])
                    {
                        sX = x;
                        sY = y;
                        mazeVisited[x][y] = true;
                    }
                }
            }
            
            int up = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), sX - 1, sY, 1);
            int down = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), sX + 1, sY, 1);
            int left = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), sX, sY - 1, 1);
            int right = 1 + FindPath(maze, MazeVisitedCopy(mazeVisited), sX, sY + 1, 1);
            
            int min = up;
            if (down < min)
                min = down;
            if (left < min)
                min = left;
            if (right < min)
                min = right;
            
            System.out.println(min);
        }
    }
}
