////////////////////////////////
//  File:        menu.java    // 
//  Programmer:  Marc Douet   //
//  Date:        04/07/05     //
////////////////////////////////

import java.util.*;

public class menu
{       
  final static int MAX_ACTIONS = 20;
  static Customer[] customerList = new Customer[MAX_ACTIONS];
  static int[] trayStack = new int[MAX_ACTIONS*2]; 
  static int customerIndex;
  static int trayIndex;

  public static void addCustomer(String name)
  {
      for(int index = 0; index < customerIndex; index++) {
          if(customerList[index].getName().equals(name)) {
              return;
          }
      }

      customerList[customerIndex++] = new Customer(name);
  }

  public static void infectCustomer(String name)
  {
      for(int index = 0; index < customerIndex; index++) {
          if(customerList[index].getName().equals(name)) {
              customerList[index].infect();
              return;
          }
      }
  }

  public static Customer getCustomer(String name)
  {
      for(int index = 0; index < customerIndex; index++) {
          if(customerList[index].getName().equals(name)) {
              return customerList[index];
          }
      }

      return null;
  }
      
  public static void grabTray(String name)
  {
      // Grab the tray
      getCustomer(name).setTray(trayStack[--trayIndex]);

      // If the tray being grabbed is infected, infect the customer
      if(trayStack[trayIndex] > 0) {
          infectCustomer(name);
      } 
  }

  public static void returnTray(String name)
  {
      // Return the tray to the stack
      trayStack[trayIndex] = getCustomer(name).getTray();

      // If the customer is infected, infect the tray being returned on both sides
      if(getCustomer(name).isInfected()) {
          trayStack[trayIndex] = 3;
      } 

      // If the tray being returned is infected on the bottom, infect the top of the tray beneath it
      if((trayStack[trayIndex] == 1) || (trayStack[trayIndex] == 3)) {
          trayStack[trayIndex-1] = 2;

      // If the top of the tray we are stacking this tray on top of is infected, infect the bottom of this tray
      } else if((trayStack[trayIndex-1] == 2) || (trayStack[trayIndex-1] == 3)) {
          trayStack[trayIndex] = 1;
      }

      // Move the pointer to the next free stack slot
      trayIndex++;
  }
           
  public static void main(String[] args)
  {	
      int numDatasets;
      UILFileReader  input = new UILFileReader("menu.in");
	
      numDatasets = input.readInt();
      for(int dataSet = 0; dataSet < numDatasets; dataSet++) {
          int numTrays = input.readInt();
          char action;
          String customer;

          // The first customer is always infected
          customerIndex = 0;
          customer = input.readWord();
          customer = customer.substring(1, (customer.length()));
          addCustomer(customer);
          infectCustomer(customer);

          // Initialize all trays
          for(int index = 0; index < (numTrays-1)*2; index++) {
              trayStack[index] = 0;
          }

          // Start from the top of the stack
          trayIndex = numTrays;

          // Perform each customer action
          for(int index = 0; index < (numTrays-1); index++) {

              // Add this customer
              customer = input.readWord();
              action = customer.charAt(0);
              customer = customer.substring(1, (customer.length()));
              addCustomer(customer);

              // Process this customer's action
              if(action == 'g') {
                  grabTray(customer);
              } else if(action == 'r') {
                  returnTray(customer);
              }
          }

          // Print the list of infected customers
          String infectedList = new String();
          for(int index = 0; index < customerIndex; index++) {
              if(customerList[index].isInfected()) {
                  infectedList = infectedList + customerList[index].getName() + " ";
              }
          }
          System.out.println(infectedList);
      }
  }
}

class Customer
{
    private String name;
    private boolean infected;
    private int tray;

    public Customer(String customerName)
    {
        name =  customerName;
        infected = false;
        tray = 0;
    }

    public String getName()
    {
        return name;
    }

    public void infect()
    {
        infected = true;
    }

    public boolean isInfected()
    {
        return infected;
    }

    public void setTray(int trayInfection)
    {
        tray = trayInfection;
    }

    public int getTray()
    {
        return tray;
    }
}
