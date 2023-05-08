import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class BlobTop
{
    public static class Point
    {
        public int r;
        public int c;
        
        public Point(int x, int y)
        {
            r = x;
            c = y;
        }
    }
    
    static Point ReturnToppestPoint(Point p1, Point p2)
    {
        if (p1.r < p2.r)
            return p1;
        else if (p2.r < p1.r)
            return p2;
        else
        {
            if (p1.c < p2.c)
                return p1;
            else
                return p2;
        }
    }
    
    static Point RecurseBlob(char[][] set, int r, int c)
    {
        Point p = new Point(set.length, set[0].length);
        
        if (0 <= r && set.length > r && 0 <= c && set[0].length > c)
        {
            if ('*' == set[r][c])
            {
                p.r = r;
                p.c = c;
                
                set[r][c] = '#';
                
                Point tmpP = null;
                
                tmpP = RecurseBlob(set, r + 1, c + 0);
                p = ReturnToppestPoint(p, tmpP);
                
                tmpP = RecurseBlob(set, r - 1, c + 0);
                p = ReturnToppestPoint(p, tmpP);
                
                tmpP = RecurseBlob(set, r + 0, c + 1);
                p = ReturnToppestPoint(p, tmpP);
                
                tmpP = RecurseBlob(set, r + 0, c - 1);
                p = ReturnToppestPoint(p, tmpP);
            }
        }        
        
        return p;
    }
    
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("blobtop.dat"));
        
        int numSets = Integer.parseInt(kb.nextLine());
       
        for (int i = 0; i < numSets; ++i)
        {
            String line = kb.nextLine();
            String[] nums = line.split(" ");
            
            int r = Integer.parseInt(nums[0]);
            int c = Integer.parseInt(nums[1]);
            int s = Integer.parseInt(nums[2]);
            
            char[][] set = new char[r][c];
            for (int x = 0; x < r; ++x)
            {
                line = kb.nextLine();
                
                for (int y = 0; y < c; ++y)
                {
                    set[x][y] = line.charAt(y);
                }
            }
            
            for (int j = 0; j < s; ++j)
            {
                line = kb.nextLine();
                String[] strPos = line.split(" ");
                int x = Integer.parseInt(strPos[0]) - 1;
                int y = Integer.parseInt(strPos[1]) - 1;
                
                if ('.' == set[x][y])
                {
                    System.out.println("NOT A BLOB");
                }
                else
                {
                    char[][] setCopy = new char[r][c];
                    for (int row = 0; row < r; ++row)
                    {
                        for (int col = 0; col < c; ++col)
                        {
                            setCopy[row][col] = set[row][col];
                        }
                    }
                    
                    Point p = RecurseBlob(setCopy, x, y);
                    System.out.printf("%d %d\n", p.r + 1, p.c + 1);
                }
            }
        }
    }
}
                
               