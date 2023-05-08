/////////////////////////////////
//  File:        wordwrap.java // 
//  Programmer:  Marc Douet    //
//  Date:        04/09/05      //
/////////////////////////////////

import java.util.*;

public class wrap
{       
  public static void main(String[] args)
  {	
      int numDatasets = 0;
      UILFileReader  input = new UILFileReader("wrap.in");
	
      numDatasets = input.readInt();
      for(int dataSet = 0; dataSet < numDatasets; dataSet++) {
          int numCols = input.readInt();
          int remainingCols = numCols;
          String text = input.readLine();
          String[] words = text.split(" ");
   
          for(int index = 0; index < words.length; index++) {
              if(words[index].length() <= remainingCols) {
                  System.out.print(words[index] + " ");
                  remainingCols -= (words[index].length()+1);
              } else {
                  remainingCols = numCols;
                  System.out.println();
                  System.out.print(words[index] + " ");
                  remainingCols -= (words[index].length()+1);
              }
          }
          System.out.println();
      }
  }
}
