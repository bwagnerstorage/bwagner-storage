import java.io.File;
import java.io.IOException;
import java.util.*;

public class Max {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("max.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            int[][] board = new int[6][6];
            for(int r = 0; r < 6; r++)
                for(int c = 0; c < 6; c++)
                    board[r][c] = s.nextInt();
            
            /*int boardTotal = 0;
            for(int r = 0; r < 6; r++)
                for(int c = 0; c < 6; c++)
                    boardTotal += board[r][c];
            System.out.println(boardTotal);
            for(int[] row : board)
                System.out.println( Arrays.toString(row));
                */
            boolean[][] covered = new boolean[6][6];
            System.out.println(maxVal(board, covered, 0, 0));
            
        }
        s.close();
    }
    
    private static int[] rowDiffs = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    private static int[] colDiffs = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    
    private static int maxVal(int[][] board, boolean[][] covered, int row, int col){
        // base case: no more possible discs so total up how much current placement is worth
        if(row == 6)
            return boardScore(board, covered);
        
        // recursive case
        // choices for current position: 1. cover if allowed or 2. leave uncovered.
        int nextCol = (col + 1) % 6;
        int nextRow = row + (col + 1) / 6;
        int doNotCoverCurrent = maxVal(board, covered, nextRow, nextCol);
        int coverCurrent = 0;
        if( canCoverCurrent(covered, row, col) ){
            covered[row][col] = true;
            coverCurrent = maxVal(board, covered, nextRow, nextCol);
            covered[row][col] = false;
        }
        return Math.max(doNotCoverCurrent, coverCurrent);
    }
    
    private static boolean canCoverCurrent(boolean[][] covered, int row, int col) {
        // only allowed to cover if all adjacent cells are uncovered
        boolean canCover = true;
        for(int j = 0; j < rowDiffs.length; j++){
            int nextRow = row + rowDiffs[j];
            int nextCol = col + colDiffs[j];
            if(inbounds(nextRow, nextCol) && covered[nextRow][nextCol])
                canCover = false;
        }
        return canCover;
    }

    private static int boardScore(int[][] board, boolean[][] covered) {
        int result = 0;
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[0].length; c++)
                if( covered[r][c])
                    result += board[r][c];
        if(result == 1330){
            for(int r = 0; r < board.length; r++){
                for(int c = 0; c < board[0].length; c++)
                    if( covered[r][c] )
                        System.out.print("X");
                    else
                        System.out.print("-");
                System.out.println();
            }
        }
            
        return result;
    }

    private static boolean inbounds(int r, int c){
        return r >= 0 && r < 6 && c >= 0 && c < 6;
    }
}

