import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class BlobSize
{
    static int RecurseBlob(char[][] set, int r, int c)
    {
        int count = 0;
        
        if (0 <= r && set.length > r && 0 <= c && set[0].length > c)
        {
            if ('*' == set[r][c])
            {
                ++count;
                
                set[r][c] = '#';
                
                count += RecurseBlob(set, r + 1, c - 1);
                count += RecurseBlob(set, r + 1, c + 0);
                count += RecurseBlob(set, r + 1, c + 1);
                
                count += RecurseBlob(set, r + 0, c - 1);
                count += RecurseBlob(set, r + 0, c + 1);
                
                count += RecurseBlob(set, r - 1, c - 1);
                count += RecurseBlob(set, r - 1, c + 0);
                count += RecurseBlob(set, r - 1, c + 1);
            }
        }        
        
        return count;
    }
    
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("blobsize.dat"));
        
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
                    System.out.println("NO BLOB");
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
                    
                    System.out.println(RecurseBlob(setCopy, x, y));
                }
            }
        }
    }
}
