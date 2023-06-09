import java.util.*;

public class Warehouse
{
    private ArrayList <InventoryItem> items;
    
    public Warehouse()
    {
        items = new ArrayList<>();
    }
    
    public void addItem(InventoryItem item)
    {
        items.add(item);
    }
    
    // Part (b)
    // returns an ArrayList of all items whose price is between
    // loPrice and hiPrice inclusive
    public ArrayList <InventoryItem> getItems(double loPrice, double hiPrice)
    {
         
        
    }
    
    public void printInventory()
    {
        for(InventoryItem item : items)
        {
           System.out.printf(" %-6d",item.getID());
           System.out.printf("%8.2f",item.getBasePrice());
           System.out.printf("%8.2f\n",item.getPrice());
        }
    }
}