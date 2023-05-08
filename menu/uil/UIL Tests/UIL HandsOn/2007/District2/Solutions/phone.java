// UIL 2007 - District B Hands-On Programming Contest
// phone.java
//

import java.io.*;
import java.util.*;

public class phone {
   
   public static void main (String args[]) throws IOException {
      Scanner infile = new Scanner( new File("phone.in") );
      String line;
      char[] keys;
      char[][] keyTable = { {'0'}, {'1'}, {'a','b','c','2'},
                            {'d','e','f','3'}, {'g','h','i','4'},
                            {'j','k','l','5'}, {'m','n','o','6'},
                            {'p','q','r','s','7'}, {'t','u','v','8'},
                            {'w','x','y','z','9'}
                          };
      int numDataSets = infile.nextInt(); infile.nextLine();

      // process the data sets
      for (int d = 0; d < numDataSets; d++) {
         keys = infile.next().toCharArray();
         for (int i = 0; i < keys.length; i++) {
             if (keys[i] == 'P')
                 continue;
             int numPress = 0;
             while(++i < keys.length && keys[i] == keys[i-1])
                numPress++;
             System.out.print(keyTable[keys[--i] - '0'][numPress]);
         }
         System.out.println();
         infile.nextLine();
      }
   }
}
