import java.io.*;
import java.util.*;

public class Block {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("block.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        
        for(int i = 1; i <= numSets; i++){
            char[][] board = new char[s.nextInt()][s.nextInt()];
            s.nextLine();
            for(int r = 0; r < board.length; r++){
                String line = s.nextLine();
                for(int c = 0; c < line.length(); c++)
                    board[r][c] = line.charAt(c);
            }
            runGame(board, s);
        }
    }
    
    public static void runGame(char[][] board, Scanner s){
        int numMoves = s.nextInt();
        s.nextLine();
        int score = 0;
        for(int move = 0; move < numMoves; move++){
            int row = s.nextInt() - 1;
            int col = s.nextInt() - 1;
            if( board[row][col] != '.')
                score += processMove(board, row, col);
        }
        System.out.println(score);
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++)
                System.out.print(board[r][c]);
            System.out.println();
        }
    }

    private static int processMove(char[][] board, int r, int c) {
        int result = blobSize(board, r, c, 
                new boolean[board.length][board[0].length], board[r][c]);
        if( result <= 2 )
            result = -1;
        else{
            result = result * result;
            removeBlocks(board, r, c, board[r][c]);
        }
        return result;
    }

    private static void removeBlocks(char[][] board, 
            int r, int c, char tgt){
        removeBlob(board, r, c, tgt);
        moveDown(board);
        
    }

    private static void moveDown(char[][] board) {
        for(int col = 0; col < board[0].length; col++){
            int numPeriods = 0;
            for(int row = board.length - 1; row >= 0; row--){
                if(board[row][col] == '.')
                    numPeriods++;
                else if(numPeriods > 0){
                    board[row + numPeriods][col] = board[row][col];
                    board[row][col] = '.';
                }
            }
        }
            
        
    }

    private static void removeBlob(char[][] board, int r, int c, char tgt) {
        if( board[r][c] != tgt)
            return;
        board[r][c] = '.';
        int rowUp = r == 0 ? board.length - 1 : r - 1;
        int rowDown = (r + 1) % board.length;
        int colRight = (c + 1) % board[0].length;
        int colLeft = c == 0 ? board[0].length - 1 : c - 1;
        removeBlob(board, rowUp, c, tgt);
        removeBlob(board, rowDown, c, tgt);
        removeBlob(board, r, colRight, tgt);
        removeBlob(board, r, colLeft, tgt);
    }

    private static int blobSize(char[][] board, int r, int c,  
            boolean[][] beenHere, char tgt) {
        if(beenHere[r][c] || board[r][c] != tgt)
            return 0;
        int result = 1;
        beenHere[r][c] = true;
        int rowUp = r == 0 ? board.length - 1 : r - 1;
        int rowDown = (r + 1) % board.length;
        int colRight = (c + 1) % board[0].length;
        int colLeft = c == 0 ? board[0].length - 1 : c - 1;
        result += blobSize(board, rowUp, c, beenHere, tgt);
        result += blobSize(board, rowDown, c, beenHere, tgt);
        result += blobSize(board, r, colLeft, beenHere, tgt);
        result += blobSize(board, r, colRight, beenHere, tgt);
        return result;
    }
}

