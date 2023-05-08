//package _2008;

import java.io.*;
import java.util.*;

public class Burn {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("burn.dat"));
        int numSets = Integer.parseInt(s.nextLine());
        
        for(int i = 1; i <= numSets; i++){
            String samp = s.nextLine();
            int cap = Integer.parseInt(samp);  
            int[] lengths = new int[Integer.parseInt(s.nextLine())];
            String[] nums = s.nextLine().split("\\s+");
            for(int j = 0; j < lengths.length; j++)
                lengths[j] = Integer.parseInt(nums[j]);
            
            ArrayList<Integer> best = new ArrayList<Integer>();
            best.add(cap);
            best = findItems(lengths, 0, best);
            int minWaste = best.remove(0);
            Collections.sort(best);
            System.out.print("CD " + i + ": " + minWaste);
            if( best.size() > 0){
                System.out.print(" ");
                for(int j = 0; j < best.size() - 1; j++)
                    System.out.print(best.get(j) + " ");
                System.out.print(best.get( best.size() - 1));
            }
            System.out.println();
        }
    }

    
    public static ArrayList<Integer> findItems(int[] items, int currentPos,
ArrayList<Integer> currentList)
    {   if(currentPos >= items.length)
            return currentList;

        ArrayList<Integer> withoutItem = new ArrayList<Integer>(currentList);
        ArrayList<Integer> withItem = new ArrayList<Integer>(currentList);

        withoutItem = findItems(items, currentPos + 1, withoutItem);

        int spaceLeft = currentList.get(0);
        
        if( (spaceLeft < items[currentPos]) )
            return withoutItem; 

        spaceLeft -= items[currentPos];
        withItem.set(0, spaceLeft );
        withItem.add(items[currentPos]);
        withItem = findItems(items, currentPos + 1, withItem);

        int spaceLeftWith = withItem.get(0);
        int spaceLeftWithout = withoutItem.get(0);

        if( spaceLeftWith < spaceLeftWithout)
            return withItem;
        else
            return withoutItem;
    }

    
 
}

