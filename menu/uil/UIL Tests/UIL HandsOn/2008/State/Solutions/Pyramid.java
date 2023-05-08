import java.io.*;
import java.util.*;

public class Pyramid {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("pyramid.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        
        for(int i = 1; i <= numSets; i++){
            int rows = s.nextInt();
            int cols = s. nextInt();
            int[][] plan = getPlan(rows, cols, s);
            int numRings = getNumRings(rows, cols);
            //System.out.println(numRings);
            boolean build = true;
            int ring = 0;
            int max = getMax(ring, plan);
            int min;
            ring++;
            while( ring < numRings && build){
                min = getMin(ring, plan);
                //System.out.println("min: " + min + ", max: " + max);
                build = max < min;
                max = getMax(ring, plan);
                ring++;
            }
            if( build )
                System.out.println("BUILD IT");
            else
                System.out.println("SCRAP IT");
        }
    }

    private static int getMin(int ring, int[][] plan) {
        int topRow = ring;
        int bottomRow = plan.length - ring - 1;
        int leftCol = ring;
        int rightCol = plan[0].length - ring - 1;
        int min = Integer.MAX_VALUE;
        //System.out.println("Get min topRow, bottomRow, leftCol, rightCol: " + topRow + " " + bottomRow + " " + leftCol + " " + rightCol);
        for(int rowNum = topRow; rowNum <= bottomRow; rowNum++){
            min = Math.min(min, plan[rowNum][leftCol]);
            min = Math.min(min, plan[rowNum][rightCol]);
        }
        for(int colNum = leftCol; colNum <= rightCol; colNum++){
            min = Math.min(min, plan[topRow][colNum]);
            min = Math.min(min, plan[bottomRow][colNum]);
        }
        return min;
    }

    private static int getMax(int ring, int[][] plan) {
        int topRow = ring;
        int bottomRow = plan.length - ring - 1;
        int leftCol = ring;
        int rightCol = plan[0].length - ring - 1;
        //System.out.println("Get max topRow, bottomRow, leftCol, rightCol: " + topRow + " " + bottomRow + " " + leftCol + " " + rightCol);
        
        int max = Integer.MIN_VALUE;
        for(int rowNum = topRow; rowNum <= bottomRow; rowNum++){
            max = Math.max(max, plan[rowNum][leftCol]);
            max = Math.max(max, plan[rowNum][rightCol]);
        }
        for(int colNum = leftCol; colNum <= rightCol; colNum++){
            max = Math.max(max, plan[topRow][colNum]);
            max = Math.max(max, plan[bottomRow][colNum]);
        }
        return max;
    }

    private static int getNumRings(int rows, int cols) {
        int r = 0, c = 0;
        r = rows % 2 == 0 ? rows / 2 : rows / 2 + 1;
        c = cols % 2 == 0 ? cols / 2 : cols / 2 + 1;
        return Math.min(r, c);
    }

    private static int[][] getPlan(int rows, int cols, Scanner s) {
        int[][] result = new int[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++)
                result[r][c] = s.nextInt();
        }
        return result;
    }
}
