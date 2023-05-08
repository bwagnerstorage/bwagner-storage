import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class sudoku2
{
    static final int MAXROWS = 4;
    static final int MAXCOLS = 4;
    static final int MAXQUADRANTS = 4;
    static final int MAXNUMBERS = 4;
    static final char BLANKCHAR = '.';
    static final int BLANKNUM = 0;
    static char inputBoard[][];
    static int board[][];
    static int rowAmounts[][];
    static int colAmounts[][];
    static int quadrantAmounts[][];

    public static void main(String[] args) throws IOException
    {
        Scanner s = new Scanner(new File("sudoku2.in"));
        int numDataSets;
        String line;

        inputBoard = new char[MAXROWS][MAXCOLS];
        board = new int[MAXROWS][MAXCOLS];

	numDataSets = s.nextInt();
        s.nextLine();
        
        for(int i = 0; i < numDataSets; i++)
        {
           System.out.println("Data Set #" + (i+1));

           for(int j = 0; j < MAXROWS; j++)
           {
               line = s.nextLine();
               inputBoard[j] = line.toCharArray();
               for(int k = 0; k < MAXCOLS; k++)
               {
                   if(inputBoard[j][k] == BLANKCHAR)
                      board[j][k] = BLANKNUM;
                   else
                      board[j][k] = Integer.parseInt(String.valueOf(inputBoard[j][k]));
               }
           }

           initAmounts();
           fillBlanks();

           for(int j = 0; j < MAXROWS; j++)
           {
               for(int k = 0; k < MAXCOLS; k++)
                   System.out.print(board[j][k]);
               System.out.println();
           }           
        }
    }

    static void fillBlanks()
    {
        for(int j = 0; j < MAXROWS; j++)
        {
            for(int k = 0; k < MAXCOLS; k++)
            {
                if(board[j][k] == BLANKNUM)
                {
                   int possibleNum = -1;
                   for(int m = 0; m < MAXNUMBERS; m++)
                   {
                       //If this number isn't in the row, column, or quadrant, mark it as possible
                       if(rowAmounts[j][m] == 0 && 
                          colAmounts[k][m] == 0 &&
                          quadrantAmounts[getQuadrant(j,k)][m] == 0)
                       {
                          if(possibleNum == -1)
                             possibleNum = m;
                          else
                          {
                             //We have more than one possible number that can go here; exit from loop
                             possibleNum = -1;
                             break;
                          }
                       }
                   }
                   if(possibleNum != -1)
                   {
                      //We only had one possibility; add it to the board
                      board[j][k] = possibleNum + 1; //Adjust for index
                      rowAmounts[j][possibleNum] = 1;
                      colAmounts[k][possibleNum] = 1;
                      quadrantAmounts[getQuadrant(j,k)][possibleNum] = 1;
                      fillBlanks();
                   }           
                }
            }            
        }
    }

    static void initAmounts()
    {
        rowAmounts = new int[MAXROWS][MAXNUMBERS];
        colAmounts = new int[MAXCOLS][MAXNUMBERS];
        quadrantAmounts = new int[MAXROWS][MAXNUMBERS];
        
        for(int j = 0; j < MAXROWS; j++)
        {
            for(int k = 0; k < MAXCOLS; k++)
            {
                if(board[j][k] != BLANKNUM)
                {
                   rowAmounts[j][board[j][k]-1] = 1;
                   colAmounts[k][board[j][k]-1] = 1;
                   quadrantAmounts[getQuadrant(j,k)][board[j][k]-1] = 1;
                }
            }            
        }
    }

    static int getQuadrant(int j, int k)
    {
        if(j == 0 || j == 1)
        {
           if(k == 0 || k == 1)
              return 0;
           return 1;
        }
        if(k == 0 || k == 1)
           return 2;
        return 3;
    }
}

