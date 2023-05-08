////////////////////////////////
//  File:        horse.java   // 
//  Programmer:  Marc Douet   //
//  Date:        04/08/05     //
////////////////////////////////

import java.util.*;

public class horse
{       
  public static void main(String[] args)
  {	
      int numDatasets = 0;
      UILFileReader  input = new UILFileReader("horse.in");
	
      numDatasets = input.readInt();
      for(int index = 0; index < numDatasets; index++) {
          double weight = input.readInt();
          double distance = input.readInt();
          double duration = input.readInt();
          double speed = (distance/duration);
          System.out.println(Math.round((Math.pow(Math.E, (3.20+(.0065*speed)))*weight*duration)));
      }
  }
}
