// UIL 2006 - State Programming Contest
//
// vending.java
//
// PURPOSE: Teams that understand 1-dimensional arrays of classes
// will have an advantage solving this problem.
//

import java.io.*;
import java.util.*;

class item {

   public String name;
   public int cost;

   public item ( String name1, int cost1 ) {
      name = new String(name1);
      cost = cost1;
   }
}

public class vending {
  
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("vending.in") );

      item itemList[] = new item[] { new item("Gum", 25),
                                     new item("Chips", 75),
                                     new item("Coke", 65),
                                     new item("Candy", 55),
                                     new item("Pretzels", 60),
                                     new item("Donuts", 95) };
   
      int numLines = infile.nextInt();
      infile.nextLine();

      // process each item in the list
      for (int l=0; l<numLines; l++) {

         int item_index;
         int cost;

         // read in the data
         int yourmoney = infile.nextInt();
         String name = infile.next();
         infile.nextLine();

         // lookup the cost of the item in our list
         for (item_index = 0; ; item_index++) {
            if (itemList[item_index].name.equals(name)) {
               break;
            }
         }
         cost = itemList[item_index].cost;

         // see if we have enough to buy it and print the result
         if (yourmoney >= cost) {
            System.out.println("You have " + (yourmoney-cost) + " cents left.");
         }
         else {
            System.out.println("You need " + (cost-yourmoney) + " cents more.");
         }

      }
   }
}
