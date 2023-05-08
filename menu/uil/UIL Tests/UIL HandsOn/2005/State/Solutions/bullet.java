////////////////////////////////
//  File:        bullet.java  // 
//  Programmer:  Marc Douet   //
//  Date:        04/07/05     //
////////////////////////////////

import java.util.*;

public class bullet
{       
  public static void main(String[] args)
  {	
      int numDatasets = 0;
      UILFileReader  input = new UILFileReader("bullet.in");
	
      numDatasets = input.readInt();
      for(int index = 0; index < numDatasets; index++) {
          String coordinate;
          String[] coordinateBuffer;
          int start_x, start_y, start_z, next_x, next_y, next_z;

          // Get the starting coordinates
          coordinate = input.readWord();
          coordinate = coordinate.substring(1, (coordinate.length()-1));
          coordinateBuffer = coordinate.split(",", 3);
          start_x = Integer.parseInt(coordinateBuffer[0]);
          start_y = Integer.parseInt(coordinateBuffer[1]);
          start_z = Integer.parseInt(coordinateBuffer[2]);

          // Get the next coordinates
          coordinate = input.readWord();
          coordinate = coordinate.substring(1, (coordinate.length()-1));
          coordinateBuffer = coordinate.split(",", 3);
          next_x = Integer.parseInt(coordinateBuffer[0]);
          next_y = Integer.parseInt(coordinateBuffer[1]);
          next_z = Integer.parseInt(coordinateBuffer[2]);

          // Calculate the coordinates after 5 seconds
          next_x = start_x + ((next_x - start_x)*5);
          next_y = start_y + ((next_y - start_y)*5);
          next_z = start_z + ((next_z - start_z)*5);
          System.out.println("(" + next_x + "," + next_y + "," + next_z + ")");
      }
  }
}
