package Problem2;

import java.util.*;

public class Manager
{
	// Instance Variables
	private GarageSale garageSale;
	private Scanner keyboard;
	
	// Constructor
	public Manager()
	{
		garageSale = new GarageSale();
		keyboard = new Scanner(System.in);
		MainMenu();
	}
	
	public void MainMenu()
	{
		int sel;
		
		do
		{
			System.out.println("--------------------");
			System.out.println("     Garage Sale ");
			System.out.println("--------------------");
			System.out.println("1. Add Sale Item");
			System.out.println("2. Mark Item Sold");
			System.out.println("3. View Sale Items");
			System.out.println("4. Exit");
			System.out.println();
			System.out.print("Select-->");
			sel = keyboard.nextInt();
			
			if(sel == 1)
			{
				AddSaleItem();
			}
			else if (sel == 2)
			{
				MarkItemSold();
			}
			else if (sel == 3)
			{
				ViewSummaryReport();
			}
		}	
		while(sel != 4);
	}
	
	public void AddSaleItem()
	{
		System.out.println("--------------------");
		System.out.println("    Add Sale Item ");
		System.out.println("--------------------");
		System.out.println();
		System.out.print("Enter item name-->");
		String dummy = keyboard.nextLine();
		String name = keyboard.nextLine();
		System.out.println();
		
		GarageSaleItem item = new GarageSaleItem(name);
		garageSale.addItem(item);
		
	}
	
	public void MarkItemSold()
	{
		System.out.println("--------------------");
		System.out.println("   Mark Item Sold ");
		System.out.println("--------------------");
		System.out.println();

        int i = 0;
        int j = 1;
		while( i < garageSale.getTotalItemsCollected())
		{
			GarageSaleItem item = garageSale.getItem(i);
	
			System.out.print((i+1) + ". " + item.getName());
			if(item.isItemSold())
			  System.out.println(" (sold)");
			else
			  System.out.println();
			i++;	  
		}
		System.out.println();
		
		System.out.print("Select item --> ");
		int sel = keyboard.nextInt();
		System.out.print("Enter sale price -->$ ");
		double price = keyboard.nextDouble();
		
		GarageSaleItem item = garageSale.getItem(sel-1);
		item.setPriceSold(price);
		   
		System.out.println();
			
	}
	
	public void ViewSummaryReport()
	{
		System.out.println("--------------------");
		System.out.println("   Summary Report ");
		System.out.println("--------------------");
		System.out.println();
		System.out.println("Item Name         Price Sold");
		System.out.println("----------------------------");
				

		for(int i=0; i < garageSale.getTotalItemsCollected(); i++)
		{
			GarageSaleItem item = garageSale.getItem(i);
			System.out.printf("%-20s", item.getName());
			System.out.printf("%8.2f%n", item.getPriceSold());
		}
		
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("Total Items Collected = "  + garageSale.getTotalItemsCollected());
		System.out.println("Total Items Sold      = "  + garageSale.getTotalItemsSold());
		System.out.printf ("Total Sales           = $%.2f%n", garageSale.getTotalSales());
		System.out.println();
		System.out.println();
		
	}
	
	public static void main(String[] args)
	{
		Manager m = new Manager();
	}
}