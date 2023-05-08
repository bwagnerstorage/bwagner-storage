
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Realtor {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("realtor.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            int rows = s.nextInt();
            int cols = s.nextInt();
            int[][] houses = new int[rows][cols];
            for(int r = 0; r < rows; r++)
                for(int c = 0; c < cols; c++)
                    houses[r][c] = s.nextInt();
            int maxValue = -10 * rows * cols;
            for(int startRow = 0; startRow < rows; startRow++)
                for(int startCol = 0; startCol < cols; startCol++)
                    for(int numRows = 1; numRows <= rows - startRow; numRows++)
                        for(int numCols = 1; numCols <= cols - startCol; numCols++){
                            int value = valueOfRegion(startRow, startCol, numRows, numCols, houses);
                            if( value > maxValue){
                                maxValue = value;
                                //System.out.println(startRow + " " + startCol + " " + numRows + " " + numCols);
                            }
                        }
            System.out.println(maxValue);
        }
        s.close();
    }

    private static int valueOfRegion(int row, int col, int numRows, int numCols, int[][] houses){
        int total = 0;
        for(int r = row; r < row + numRows; r++)
            for(int c = col; c < col + numCols; c++)
                total += houses[r][c];
        return total;
    }
}
