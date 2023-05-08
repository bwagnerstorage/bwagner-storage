////////////////////////////////
//  File:        shampoo.java // 
//  Programmer:  Marc Douet   //
//  Date:        04/07/05     //
////////////////////////////////

import java.util.*;

public class shampoo
{       
  final static double SMALL_DOG_QUANTITY = .5;
  final static int    MED_DOG_QUANTITY = 1;
  final static int    LARGE_DOG_QUANTITY = 2;
  final static int    XLARGE_DOG_QUANTITY = 4;
  final static int    SMALL_SHAMPOO_QUANTITY = 8;
  final static int    SMALL_SHAMPOO_COST = 5;
  final static int    MED_SHAMPOO_QUANTITY = 16;
  final static int    MED_SHAMPOO_COST = 9;
  final static int    LARGE_SHAMPOO_QUANTITY = 24;
  final static int    LARGE_SHAMPOO_COST = 12;

  public static int getCost(double quantity) 
  {
      if (quantity == 0) {
          return 0;
      } else if(quantity <= SMALL_SHAMPOO_QUANTITY) {
          return SMALL_SHAMPOO_COST;
      } else if(quantity <= MED_SHAMPOO_QUANTITY) {
          return MED_SHAMPOO_COST;
      } else if(quantity <= LARGE_SHAMPOO_QUANTITY) {
          return LARGE_SHAMPOO_COST;
      } else {
          return LARGE_SHAMPOO_COST + getCost(quantity-LARGE_SHAMPOO_QUANTITY);
      }
  }

  public static void main(String[] args)
  {	
      int numDatasets = 0;
      UILFileReader  input = new UILFileReader("shampoo.in");
	
      numDatasets = input.readInt();
      for(int index = 0; index < numDatasets; index++) {
          double quantity = 0;
          int cost = 0;
          int numSmall = input.readInt();
          int numMed = input.readInt();
          int numLarge = input.readInt();
          int numXLarge = input.readInt();

          quantity = (double)(numSmall*SMALL_DOG_QUANTITY) + 
                             (numMed*MED_DOG_QUANTITY)     + 
                             (numLarge*LARGE_DOG_QUANTITY) + 
                             (numXLarge*XLARGE_DOG_QUANTITY);
          cost = getCost(quantity);  
          System.out.println("$" + cost);
      }
  }
}
