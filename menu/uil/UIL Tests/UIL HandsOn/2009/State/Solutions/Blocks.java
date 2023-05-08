
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Blocks {

    private static final int BOARD_SIZE = 6;

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("blocks.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
            // read in board
            for(int r = 0; r < BOARD_SIZE; r++){
                String line = s.nextLine().trim();
                for(int c = 0; c < BOARD_SIZE; c++){
                    board[r][c] = line.charAt(c);
                }
            }
            // read in blocks
            int[] blocks = new int[4];
            while(s.hasNextInt()){
                // convert to spaces covered
                blocks[(s.nextInt() / 3) - 1]++;
            }
            s.nextLine();
            if( canCover(board, blocks, 0, 0) )
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        s.close();
    }

    /*
    private static int callCount = 0;
    private static Scanner key = new Scanner(System.in);
    */

    private static boolean canCover(char[][] board, int[] blocks,
            int currentRow, int currentCol) {
        // check if done
        if( allCovered(board) ){
            // debugging code to print out arrangement if found
            /*
            System.out.println();
            System.out.println(Arrays.toString(blocks));
            for(int r = 0; r < BOARD_SIZE; r++){
                for(int c = 0; c < BOARD_SIZE; c++){
                    System.out.print(board[r][c]);
                }
                System.out.println();
            }
            */
            return true;
        }

        int nextCol = (currentCol + 1) % BOARD_SIZE;
        int nextRow = currentRow + (currentCol + 1) / BOARD_SIZE;

        // is this a space that is already covered by Mom or other block?
        // If so skip it and go to next space.
        if( board[currentRow][currentCol] != '.' )
            return canCover(board, blocks, nextRow, nextCol);

        // recursive case. Go through block sizes and try to fit
        // to current space. Try bigger blocks first
        for(int i = 3; i >= 0; i--){
            // any blocks of this size to use?
            if(blocks[i] > 0){
                if(fitsHorizontal(board, currentRow, currentCol, i + 1)){
                    // one less block of this kind to use
                    blocks[i]--;
                    placeHorizontal(board, currentRow, currentCol, i + 1);
                    if(canCover(board, blocks, nextRow, nextCol)){
                        return true;
                    }
                    blocks[i]++;
                    pickUpHorizontal(board, currentRow, currentCol, i+1);
                }
                if(fitsVertical(board, currentRow, currentCol, i + 1)){
                    // one less block of this kind to use
                    blocks[i]--;
                    placeVertical(board, currentRow, currentCol, i + 1);
                    if(canCover(board, blocks, nextRow, nextCol)){
                        return true;
                    }
                    blocks[i]++;
                    pickUpVertical(board, currentRow, currentCol, i+1);
                }
            }
        }
        return false;
    }

    private static void pickUpVertical(char[][] board, int r, int c,
            int size) {
        for(int i = 0; i < size; i++)
            board[r + i][c] = '.';
    }

    private static void placeVertical(char[][] board, int r, int c,
            int size) {
        for(int i = 0; i < size; i++)
            board[r + i][c] = (char)('0' + size);
    }

    private static boolean fitsVertical(char[][] board, int r, int c,
            int size) {
        for(int i = 0; i < size; i++){
            if( (r + i) >= BOARD_SIZE || board[r + i][c] != '.')
                return false;
        }
        return true;
    }

    private static void pickUpHorizontal(char[][] board, int r, int c,
            int size) {
        for(int i = 0; i < size; i++)
            board[r][c + i] = '.';
    }

    private static void placeHorizontal(char[][] board, int r, int c,
            int size) {
        for(int i = 0; i < size; i++)
            board[r][c + i] = (char)('0' + size);
    }

    private static boolean fitsHorizontal(char[][] board, int r, int c,
            int size) {
        for(int i = 0; i < size; i++){
            if( (c + i) >= BOARD_SIZE || board[r][c + i] != '.')
                return false;
        }
        return true;
    }

    private static boolean allCovered(char[][] board) {
        for(char[] row : board)
            for(char c : row)
                if( c == '.' )
                    return false;
        return true;
    }
}

