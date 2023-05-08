import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Insertion {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("insertion.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			
			int [] nums = new int [s.length];
			for(int i=0; i<nums.length; i++) 
				if(s[i].equals("T"))
					nums[i] = 10;
				else if (s[i].equals("J"))
					nums[i] = 11;
				else if (s[i].equals("Q"))
					nums[i] = 12;
				else if (s[i].equals("K"))
					nums[i] = 13;
				else if (s[i].equals("A"))
					nums[i] = 14;
				else		
					nums[i] = Integer.parseInt(s[i]);  
			insertionSort(nums);
			out.println();
		}
	}
	
   public static void insertionSort(int[] a)  {
        for(int i = 1; i < a.length; i++)  {
            int temp = a[i];
  			int j=i;
	        for( ; j>0 && temp < a[j-1]; j--) {
	            a[j] = a[j-1];
	        }    
	        	a[j] = temp;
	        
	        for(int k=0; k<a.length; k++) {
				switch(a[k]){
					case 10: out.print("T "); break;
					case 11: out.print("J "); break;
					case 12: out.print("Q "); break;
					case 13: out.print("K "); break;
					case 14: out.print("A "); break;
					default: out.print(a[k]+ " "); 	        	
				}
	        }
	   		out.println();
   		}	
    } 
}
