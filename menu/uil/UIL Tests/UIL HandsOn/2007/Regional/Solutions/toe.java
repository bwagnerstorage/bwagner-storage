// UIL 2007 - Hands-On Programming Contest

//



import java.io.*;

import java.util.*;


import java.math.*;


public class toe {

      static char[][]board;
   
   public static void main (String args[]) throws IOException {


      Scanner infile = new Scanner( new File("toe.in") );


      int numDataSets = infile.nextInt(); infile.nextLine();


      // process the data sets

      for (int d = 0; d < numDataSets; d++) {
	 board = new char[3][4];
         int square;
         for (int i = 0; i < 3; i++) {
            board[i] = infile.next().toCharArray();
            infile.nextLine();
         }
         //Since we can't have ties, no need to check one-move wins
         if((square = oneAway('O')) == -1 && (square = oneAway('X')) == -1 &&
            (square = twoWins())    == -1 && (square = middleFree()) == -1) {
            square = 3; //Top right square
	 }
         switch (square) {
            case 1: board[0][0] = 'O'; break;
            case 2: board[0][1] = 'O'; break;
            case 3: board[0][2] = 'O'; break;
            case 4: board[1][0] = 'O'; break;
            case 5: board[1][1] = 'O'; break;
            case 6: board[1][2] = 'O'; break;
            case 7: board[2][0] = 'O'; break;
            case 8: board[2][1] = 'O'; break;
            case 9: board[2][2] = 'O'; break;  
         }
         System.out.println("Board #" + (d+1));
         for (int i = 0; i < 3; i++)
            System.out.println(String.valueOf(board[i]));
      }
   }
   public static int oneAway (char playersMark) {
      //Check rows && cols
      for(int i = 0; i < 3; i++) {
         if(board[i][0] == playersMark && board[i][1] == playersMark && board[i][2] == '.')
            return (i+1)*3;
         if(board[i][0] == playersMark && board[i][1] == '.' && board[i][2] == playersMark)
            return (i+1)*3-1;
         if(board[i][0] == '.' && board[i][1] == playersMark && board[i][2] == playersMark)
            return (i+1)*3-2;
         if(board[0][i] == playersMark && board[1][i] == playersMark && board[2][i] == '.')
            return i+7;
         if(board[0][i] == playersMark && board[1][i] == '.' && board[2][i] == playersMark)
            return i+4;
         if(board[0][i] == '.' && board[1][i] == playersMark && board[2][i] == playersMark)
            return i+1;
      }
      //Check diags
      if(board[0][0] == playersMark && board[1][1] == playersMark && board[2][2] == '.')
         return 9;
      if(board[0][0] == '.' && board[1][1] == playersMark && board[2][2] == playersMark)
         return 1;
      if(board[0][2] == playersMark && board[1][1] == playersMark && board[2][0] == '.')
         return 7;
      if(board[0][2] == '.' && board[1][1] == playersMark && board[2][0] == playersMark)
         return 3;
      if(board[0][0] == playersMark && board[1][1] == '.' && board[2][2] == playersMark ||
         board[2][0] == playersMark && board[1][1] == '.' && board[0][2] == playersMark)
         return 5;
      
      return -1;
   }
   public static int twoWins() {
      //The only two-win moves that don't meet a higher priority criteria are:
      //.X. .O. .O. .X.
      //OXX XXO OXX XXO
      //.O. .X. .X. .O.
      if(board[1][1] != 'X')
         return -1;
      if(board[0][1] == 'X' && board[2][1] == 'O') {
         if(board[1][0] == 'O' && board[1][2] == 'X')
            return 7;
         if(board[1][0] == 'X' && board[1][2] == 'O')
            return 9;
         return -1;
      }
      if(board[0][1] == 'O' && board[2][1] == 'X') {
         if(board[1][0] == 'X' && board[1][2] == 'O')
            return 3;
         if(board[1][0] == 'O' && board[1][2] == 'X')
            return 1;
      }
      return -1;
   }

   public static int middleFree() {
      if(board[1][1] == '.')
         return 5;
      return -1;
   }
}
