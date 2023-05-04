public class Item 
{ 
   private Comparable data; 
   private int count;
    
   public Item(Comparable d) 
   { 
      data = d; 
      count = 1;
   } 
   
   public void incrementCount() 
   { 
      count++;
   } 
   
   // precondition: the count of this item is greater than 0. 
   public void decrementCount() 
   { 
     count--; 
   }
    
   public int getCount() 
   { 
      return count; 
   } 

   public Comparable getData() 
   { 
      return data; 
   } 
   
   public String toString()
   {
      return data + " " + count;
   }
} 