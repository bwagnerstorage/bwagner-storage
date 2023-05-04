import java.util.*;

public class SortPractice
{
    public static void selectionSort(String[] names)
    {
        for(int i = 0; i < names.length - 1; i++)
        {
            int min = i;
            // find smallest
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
        }
    }
    
    public static void insertionSort(Integer[] numbers)
    {
        int i, j, index;
                
        for (i=1; i < numbers.length; i++)
        {
           index = numbers[i];
           j = i;
           // find insertion point
           while ((j > 0) && (numbers[j-1].compareTo(index)) > 0)
           {
               numbers[j] = numbers[j-1];
               j = j - 1;
           }
           
           // insert current value
           numbers[j] = index;
        }
    }
   
    
    public static void main(String[] args) 
    {
        String[] names = {"Garth", "Cher", "Pink", "Madonna", "Rihana", "Prince", "Adele"};
        selectionSort(names);
        
        System.out.println();
        
        Integer [] numbers = {20, 70, 40, 90, 10, 60, 30, 80, 50};
        insertionSort(numbers);      
    }
}