import java.util.*;
import java.io.*;

public class Jeremy 
{
    int[][] matrix;
    int row;
    int col;
    
    public Jeremy() throws IOException
    {
        Scanner input = new Scanner(new File("jeremy.dat"));
        int dataSets = input.nextInt();
        while(dataSets-- > 0)
        {
            row = input.nextInt();
            col = input.nextInt();
            
            matrix = new int[row][col];
            
            for(int r=0; r<row; r++)
            {
                for(int c=0; c<col; c++)
                {
                    matrix[r][c] = input.nextInt();
                }
            }
            
            int A = input.nextInt();   // target row
            int B = input.nextInt();   // target col
            int D = input.nextInt();   // flood fill color
            
            int C = matrix[A][B];
            
            floodFill(A, B, C, D);
            
            printMatrix();
            
        }
            
    }
    
    public void floodFill(int a, int b, int c, int d)
    {
        if(inBounds(a, b) && matrix[a][b] == c)
        {
            matrix[a][b] = d;
            
            floodFill(a - 1, b, c, d);
            floodFill(a + 1, b, c, d);
            floodFill(a, b - 1, c, d);
            floodFill(a, b + 1, c, d);
        }   
    }
    
    public void printMatrix()
    {
        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public boolean inBounds(int r, int c)
    {
        return r >= 0 && c >= 0 && r < row && c < col;
    }
    
    public static void main(String[] args) throws IOException
    {
        new Jeremy();
    }
}
