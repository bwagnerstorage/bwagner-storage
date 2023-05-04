import java.util.*;

public class SortPractice
{ 
    public static void selectionSort(String[] names)
    {   
        int c = 1;
        for(int i = 0; i < names.length - 1; i++)
        {
            int min = i;
            // find smallest
            
            System.out.print("Pass - " + c + " : ") ;
            for(int j = i+1; j < names.length; j++)
            {
               if(names[j].compareTo(names[min]) < 0)
               {
                   min = j;
               }
            }
            
            // swap values
            String temp = names[i];
            names[i] = names[min];
            names[min] = temp;
            c++;
            
            for(String n : names)
            {
                System.out.print(n + " ") ;
            }
            System.out.println("");
        }
    }
    
    public static void bubbleSort(Integer[] nums)
    {
        int i;
        int c = 1;
        int temp;
        boolean done;
        do
        {
           done = true;
           
           System.out.print("Pass - " + c + " : ") ;
           for(i = 0; i < nums.length-1; i++)
           {
               if (nums[i].compareTo(nums[i + 1]) > 0)
               {            
                   // swap
                   temp = nums[i];
                   nums[i] = nums[i+1];
                   nums[i+1] = temp;
                   done = false;             // made a swap
               }            
           }   
            c++;
            for(int n : nums)
            {
                System.out.print(n + " ") ;
            }
            System.out.println("");
        } 
        while (!done);
    }

    public static void main(String[] args) 
    {
        String[] names = {"Garth", "Cher", "Pink", "Madonna", "Rihana", "Prince", "Adele"};
        System.out.println("Selection Sort");
        System.out.println("==============");
        System.out.print("Original : ");
        for(String name : names)
        {
            System.out.print(name + " ") ;
        }
        System.out.println();
        selectionSort(names);
        
        System.out.println();
        
        Integer [] numbers = {20, 70, 40, 90, 10, 60, 30, 80, 50};
        System.out.println("Bubble Sort");
        System.out.println("==============");
        System.out.print("Original : ");
        for(int number : numbers)
        {
            System.out.print(number + " ") ;
        }
        System.out.println();
        bubbleSort(numbers);     
        System.out.println();
    }
}