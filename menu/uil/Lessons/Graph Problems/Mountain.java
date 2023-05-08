import java.io.File;
import java.io.IOException;
import java.util.*;

public class Mountain 
{
    
    public Mountain() throws IOException
    {
        Scanner input = new Scanner(new File("mountain.dat"));
        int dataSets = input.nextInt();
        while(dataSets-- > 0)
        {
            
            int size = input.nextInt(); input.nextLine();
            int[][] matrix = new int[size][size];   
            
            int highestPeak = 0;
            for(int i=0; i < size; i++)
            {
                String line = input.nextLine();
                String[] array = line.split(" ");
                for(int j = 0; j < array.length; j++)
                {
                    matrix[i][j] = Integer.parseInt(array[j]);
                    if(matrix[i][j] > highestPeak)
                    {
                        highestPeak = matrix[i][j];
                    }
                }
            }
            
            // Print Solution
            boolean solution = bfs(matrix, highestPeak);
            if(solution == true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    
    public boolean bfs(int[][] matrix, int highestPeak)
    {
        Queue<Vertex> queue = new LinkedList<>();   // needed for bfs search
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];  // don't visit vertex more than once
        Vertex cur = new Vertex(0,0,matrix[0][0]);
        visited[0][0] = true;
        
        if(cur.value == highestPeak)  // highest peak at location (0,0) return true
            return true;
        queue.add(cur);
        
        while(!queue.isEmpty())
        {
            cur = queue.remove();

            for(int i = 0; i < 4; i++)
            {
                int r = 0; int c = 0;
                if(i == 0) {
                    r = cur.row; c = cur.col + 1;   // right
                }
                else if (i == 1) {
                    r = cur.row + 1; c = cur.col;   // down
                }
                else if ( i == 2) {
                    r = cur.row; c = cur.col - 1;   // left
                }
                else {
                    r = cur.row - 1; c = cur.col;   // up
                }

                if(inBounds(matrix,r,c))
                {
                    Vertex next = new Vertex(r,c,matrix[r][c]);
                    if(!visited[r][c] && next.value > cur.value && next.value < cur.value + 2)
                    {
                        if(next.value == highestPeak)
                            return true;
                        visited[r][c] = true;
                        queue.add(next);
                    }
                    else if(!visited[r][c] && next.value == cur.value)
                    {
                         if(matrix[r][c] == highestPeak)
                            return true;
                        visited[r][c] = true;
                        queue.add(next);
                    }
                    else if(!visited[r][c] && next.value < cur.value && next.value >= cur.value - 2)
                    {
                        visited[r][c] = true;
                        queue.add(next);
                    }
                }
            } 
        }
        return false;
    }
    

    
    public boolean inBounds(int[][] matrix, int r, int c)
    {
        return (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length);
    }
    
    public static void main(String[] args) throws IOException
    {
        Mountain app = new Mountain();
    }
}

class Vertex
{
    int row;
    int col;
    int value;
    
    public Vertex(int r, int c, int value)
    {
        this.row = r;
        this.col = c;
        this.value = value;
    }
    
}

