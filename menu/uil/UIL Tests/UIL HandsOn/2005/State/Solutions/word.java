////////////////////////////////
//  File:        word.java    // 
//  Programmer:  Marc Douet   //
//  Date:        04/02/05     //
////////////////////////////////

import java.util.*;

public class word
{
  public static String getMatrixColumn(char[][] matrix, int colIndex)
  {
    char[] matrixColumn = new char[10];

    for(int rowIndex = 0; rowIndex < 10; rowIndex++) {
        matrixColumn[rowIndex] = matrix[rowIndex][colIndex];
    }

    return (new String(matrixColumn));
  }

  public static String getMatrixDiagonal(char[][] matrix, int rowIndex, int colIndex, int rowDirection, int colDirection)
  {
    char[] matrixColumn = new char[10];
    int index = 0;

    while((rowIndex >= 0 && rowIndex < 10) && (colIndex >= 0 && colIndex < 10)) {
        matrixColumn[index] = matrix[rowIndex][colIndex];
        if(index++ >= 10) {
            break;
        }
        rowIndex = rowIndex + rowDirection;
        colIndex = colIndex + colDirection;
    }

    return (new String(matrixColumn));
  }
    
  public static String reverseString(String word)
  {
    char[] tempWord = word.toCharArray();
    char[] reverseWord = new char[word.length()];
    
    for(int index = 0; index < word.length(); index++) {
        reverseWord[index] = tempWord[(word.length()-1)-index];
    }

    String reverseString = new String(reverseWord);
    return reverseString;
  }
        
  public static void main(String[] args)
  {	
      int numDatasets = 0;
      char[][] wordMatrix = new char[10][10];
      String word;

      UILFileReader  input = new UILFileReader("word.in");
	
      numDatasets = input.readInt();
      for(int index = 0; index < numDatasets; index++)
      {	
          // Populate the word matrix
          for(int row = 0; row < 10; row++) {
              String line = input.readLine();
              for(int col = 0; col < 10; col++) {
                  wordMatrix[row][col] = line.charAt(col);
              }
          }
          
          // Fetch each word on the list and search for it
          for(int i = 0; i < 10; i++) {
              boolean foundWord = false;

              // Grab the next word to search for
              word = input.readLine();

              // Search the matrix horizontally
              for(int j = 0; j < 10; j++) {
                  
                  String substring = new String(wordMatrix[j]);
                  String reverseSubstring = reverseString(substring);

                  if((substring.indexOf(word) != -1) || (reverseSubstring.indexOf(word) != -1)) {
                      System.out.println(word + " was found");
                      foundWord = true;
                      break;
                  }
              }

              if(foundWord) {
                  continue;
              }

              // Search the matrix vertically
              for(int j = 0; j < 10; j++) {
                  
                  String substring = getMatrixColumn(wordMatrix, j);
                  String reverseSubstring = reverseString(substring);

                  if((substring.indexOf(word) != -1) || (reverseSubstring.indexOf(word) != -1)) {
                      System.out.println(word + " was found");
                      foundWord = true;
                      break;
                  }
              }

              if(foundWord) {
                  continue;
              }

              // Search the matrix diagonaly from the left side
              for(int j = 0; j < 10; j++) {
                  // Search the upper diagonal
                  String diagString = getMatrixDiagonal(wordMatrix, j, 0, -1, 1);
                  String reverseSubstring = reverseString(diagString);

                  if((diagString.indexOf(word) != -1) || (reverseSubstring.indexOf(word) != -1)) {
                      System.out.println(word + " was found");
                      foundWord = true;
                      break;
                  }

                  // Search the lower diagonal
                  diagString = getMatrixDiagonal(wordMatrix, j, 0, 1, 1);
                  reverseSubstring = reverseString(diagString);

                  if((diagString.indexOf(word) != -1) || (reverseSubstring.indexOf(word) != -1)) {
                      System.out.println(word + " was found");
                      foundWord = true;
                      break;
                  }
              }

              if(foundWord) {
                  continue;
              }

              // Search the matrix diagonaly from the right side
              for(int j = 0; j < 10; j++) {
                  // Search the upper diagonal
                  String diagString = getMatrixDiagonal(wordMatrix, j, 9, -1, -1);
                  String reverseSubstring = reverseString(diagString);

                  if((diagString.indexOf(word) != -1) || (reverseSubstring.indexOf(word) != -1)) {
                      System.out.println(word + " was found");
                      foundWord = true;
                      break;
                  }

                  // Search the lower diagonal
                  diagString = getMatrixDiagonal(wordMatrix, j, 9, 1, -1);
                  reverseSubstring = reverseString(diagString);

                  if((diagString.indexOf(word) != -1) || (reverseSubstring.indexOf(word) != -1)) {
                      System.out.println(word + " was found");
                      foundWord = true;
                      break;
                  }
              }

              // If the word wasn't found, inform the user
              if(!foundWord) {
                  System.out.println(word + " was not found");
              }
          }                       
      }
  }
}
