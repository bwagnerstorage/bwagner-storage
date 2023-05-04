import java.util.*;

public class RadixSort
{
	public  RadixSort()
	{
	   ArrayList<Integer> list = new ArrayList<Integer>();
	   list.add(20); list.add(47); list.add(13); list.add(88);
	   list.add(52); list.add(71); list.add(97); list.add(5);
	   list.add(35); list.add(64);
	   
	   printList(list);
	   ArrayList<Integer> sortedList = radixSort(list, 3);
	   System.out.println();
	   printList(sortedList);
	}
	
	// precondition: number = 0; k = 0 
    // postcondition: returns kth digit of number
	public int getDigit(int number, int k)
	{
	   int remainder = 0;
	   Integer n = new Integer(number);
	   String s = n.toString();
	   if(s.length() < k)
	     return 0;
	   for(int i=0; i < k; i++)
	   {
	   	  remainder = number % 10;
	   	  number = number / 10;
	   }	
	   return remainder;
	}
	
	// precondition: all values in L are positive;
    //     k >= 0
    // postcondition: Step 1 of the Radix sort algorithm for the digit
    //     at position k has been completed
	public ArrayList<Queue<Integer>> itemsToQueues(ArrayList<Integer> L, int k)
	{
		ArrayList<Queue<Integer>> QA = new ArrayList<Queue<Integer>>();
		
		// Make QA Arraylist QA.size() == 10
		for(int i=0; i < 10; i++)
		{
			QA.add(new LinkedList<Integer>());
		}
		
		for(int i=0; i < L.size(); i++)
		{
			int num = L.get(i);
			int digit = getDigit(num, k);
			Queue<Integer> queue = QA.get(digit);
			queue.add(num);
		}
		
		return QA;
	} 
	
	// precondition: QA.size() == 10; numVals is the total number of
    //    integers in all the queues in QA
    // postcondition: returns an ArrayList of length numVals that contains
    //    the integers from QA[0] through QA[9] in the order
    //    in which they were stored in the queues;
    //    the queues in QA are empty
	public ArrayList<Integer> queuesToArray(ArrayList<Queue<Integer>> QA, int numVals)
	{
	   ArrayList<Integer> list = new ArrayList<Integer>();
	   
	   for(int i=0; i < 10; i++)
	   {
	   	  Queue<Integer> queue = QA.get(i);
	   	  while(!queue.isEmpty())
	   	  {
	   	  	list.add(queue.remove());
	   	  }
	   }
	   
	   return list;	
	}
	
	// precondition: L.size() > 0; all values in L are positive; 
    //    the largest value in L has numDigits digits;
    // postcondition: returns an Arraylist of values, sorted in 
    //    increasing order
	public ArrayList<Integer> radixSort(ArrayList<Integer> L, int numDigits)
	{
		ArrayList<Queue<Integer>> QA;
		ArrayList<Integer> list = L;
		
		for(int i=0; i < numDigits; i++)
		{
			QA = itemsToQueues(list, i);
			list = queuesToArray(QA, L.size());
		}
		
		return list;
	}
	
	public void printList(ArrayList<Integer> list)
	{
	   for(int i =0; i < list.size(); i++)
	   {
	   	  System.out.print(list.get(i) + " ");
	   }	
	   System.out.println();
	}
	
	public static void main(String[] args)
	{
		RadixSort app = new RadixSort();
	}
}