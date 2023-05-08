////////////////////////////////
//  File:        monkey.java  // 
//  Programmer:  Marc Douet   //
//  Date:        04/10/05     //
////////////////////////////////

import java.util.*;

public class monkey
{       
 
  public static int normalize(int randomNumber)
  {
      return ((Math.abs(randomNumber) % 26) + 97);
  }

  public static void main(String[] args)
  {	
      int numDatasets = 0;
      UILFileReader  input = new UILFileReader("monkey.in");
	
      numDatasets = input.readInt();
      for(int dataSet = 0; dataSet < numDatasets; dataSet++) {
          Random randomCharacter = new Random(input.readInt());

          for(int index = 0; index < 10; index++) {
              System.out.print((char)normalize(randomCharacter.nextInt()));
          }

          System.out.println();
          
      }
  }
}
