import java.util.*;

// Topic: Array
// Reference: AP A 2002 Question 2

public class GroceryStore
{
	public final int SIZE = 50;
	
	private GroceryItem[] groceryList;  // array of grocery items
	private int numItems;               // number of items added to list
	
	public GroceryStore()
	{
            groceryList = new GroceryItem[SIZE];

            groceryList[0]= new GroceryItem("avocado",1.68, 8, "P");
            groceryList[1]= new GroceryItem("milk",1.78, 64, "D");
            groceryList[2]= new GroceryItem("chicken",4.48, 64, "M");
            groceryList[3]= new GroceryItem("broccoli",1.92, 16, "P");
            groceryList[4]= new GroceryItem("yogurt",0.96, 16, "D");
            groceryList[5]= new GroceryItem("spinach",1.76, 16, "P");
            groceryList[6]= new GroceryItem("cornedbeef",6.72, 48, "M");
            groceryList[7]= new GroceryItem("porkchops",2.02, 32, "M");

            numItems = 8;  // number of items added to list
	}
	
	// returns the price of this item
	public double getPrice(String itemName)
	{
	   for(int i=0; i < numItems; i++)
	   {
                GroceryItem item = groceryList[i];
                if(item.getItemName().equals(itemName))
                    return item.getItemPrice();
	   }
	   return -1;  // not found	
	}
	
	// returns the size (in ounces) of this item
	public int getSize(String itemName)
	{
	   for(int i=0; i < numItems; i++)
	   {
                GroceryItem item = groceryList[i];
                if(item.getItemName().equals(itemName))
                    return item.getItemSize();
	   }
	   return -1;  // not found		
	}
	
	// Part (a)
	// changes the price of item associated with itemName
        public void setPrice(String itemName, double price)
	{
	
	}
	
	// Part (b)
        // postcondition: returns the name of an item whose unit
	//                price is the lowest in the specified category;
	//                if no items in the specified category,
	//                returns "none".
	public String bargainItem(String category)
	{

	}
	
	public String toString()
	{
            String str="";
            for(int i=0; i < numItems; i++)
            {
                    str+= groceryList[i].toString() + "\n";
            }
            return str;
	}
}