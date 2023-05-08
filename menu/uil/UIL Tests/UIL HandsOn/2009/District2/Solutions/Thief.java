
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Thief {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("thief.dat"));
        int numSets = s.nextInt();
        
        for(int i = 1; i <= numSets; i++){
            int weightLimit = s.nextInt();
            ArrayList<Item> items = new ArrayList<Item>();
            int numItems = s.nextInt();
            s.nextLine();
            String[] rawData = s.nextLine().trim().split("\\s+");
            // System.out.println(Arrays.toString(rawData));
            for(int j = 0; j < numItems; j++){
                items.add(new Item(rawData[j]));
            }
            System.out.println("DATA SET " + i + " " + getMaxValue(items, weightLimit));
        }
        s.close();
    }
    
    public static int getMaxValue(ArrayList<Item> things, int capacity){
        if(things.size() == 0 || capacity <= 0)
            return 0;
        else{
            Item temp = things.remove(things.size() - 1);

            // try without this item in the bag
            int result = getMaxValue(things, capacity);

            if( temp.weight <= capacity ){
                // try with this item in the bag
                int with = temp.value + getMaxValue(things, capacity - temp.weight);
                result = Math.max(result, with);
            }

            things.add(temp); // put it back for later combinations
            return result;
        }
    }
    
    private static class Item{
        final int value;
        final int weight;
        
        public Item(String data){
            String[] nums = data.split("[\\[\\],]");
            value = Integer.parseInt(nums[2]);
            weight = Integer.parseInt(nums[1]);
        }
        
        public String toString(){
            return weight + " " + value;
        }
    }
    

}
