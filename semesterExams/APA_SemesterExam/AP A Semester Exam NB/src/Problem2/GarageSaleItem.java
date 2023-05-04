package Problem2;

public class GarageSaleItem
{
	// Instance Variables
	private String itemName;
	private double priceSold;
	private boolean sold;
	
	// Constructors
	public GarageSaleItem()
	{
		itemName = "";
		priceSold = 0;
		sold = false;
	}
	
	public GarageSaleItem(String i)
	{
		itemName = i;
		priceSold = 0;
	}
	
	public GarageSaleItem(String i, double p)
	{
		itemName = i;
		priceSold = p;
	}
	
	// Accessor Methods
	public String getName()
	{
		return itemName;
	}
	
	public double getPriceSold()
	{
		return priceSold;
	}
	
	// Mutator Methods
	public void setItemName(String i)
	{
		itemName = i;
	}	
	
	public void setPriceSold(double p)
	{
		priceSold = p;
		sold = true;
	}
	
	public boolean isItemSold()
	{
		return sold;
	}
	
	// toString Method
	public String toString()
	{
		String str;
		str = itemName + "     " + priceSold;
		return str;
	}
}