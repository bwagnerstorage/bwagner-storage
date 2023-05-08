import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Selection {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("selection.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		
			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			int [] nums = new int [s.length];
			for(int i=0; i<nums.length; i++) 
				nums[i] = Integer.parseInt(s[i]);  
			selSort(nums);
			out.println();
		}
	}
	public static void selSort(int n[]) {
		int i, j, k;
		for(i=0; i<n.length-1; i++)  {
   			int min = i;           
   			for(j=i+1; j<n.length; j++) 
     			if(n[j] < n[min] )     // if min greater,
       				min = j;        // we have a new min
   			int temp = n[min]; n[min]=n[i]; n[i]=temp;  // swap them
   			for(k=0; k<n.length; k++)
   				out.print(n[k] + " ");
   			out.println();	
		}
   } 
}
