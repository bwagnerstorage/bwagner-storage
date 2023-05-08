////////////////////////////////
//  File:        cipher.java  // 
//  Programmer:  Marc Douet   //
//  Date:        04/09/05     //
////////////////////////////////

import java.util.*;

public class cipher
{       
  final static int MAX_KEY_LINES = 10;

  public static void main(String[] args)
  {	
      UILFileReader  input = new UILFileReader("cipher.in");
      int numLines = input.readInt();
      String[] key = new String[MAX_KEY_LINES];
 
      for(int index = 0; index < numLines; index++) {
          key[index] = input.readLine();
      }

      numLines = input.readInt();
         
      for(int index = 0; index < numLines; index++) {
          String messageLine = input.readLine();
          String[] messageList = messageLine.split(" ");

          for(int i = 0; i < messageList.length; i++) {
              String[] coord = messageList[i].split(",", 2);
              int row = Integer.parseInt(coord[0]);
              int col = Integer.parseInt(coord[1]);

              System.out.print(key[row-1].charAt(col-1));
          }
          
          System.out.println();
      }
  }
}
