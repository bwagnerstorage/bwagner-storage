import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Object.*;

public class FourKind {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("fourkind.dat"));
		int count = Integer.parseInt(kb.nextLine().trim());
		
		int times = 0; 
		while(times < count) {
			times++;
			ArrayList<String> names = new ArrayList<String>();  // parallel ArrayLists
			ArrayList<Integer> four = new ArrayList<Integer>();
			ArrayList<Integer> fifth = new ArrayList<Integer>();
			for(int i = 0; i < 3; i++) {
				ArrayList <Integer> dice = new ArrayList <Integer> ();  // ArrayList to hold the counts
				int [] hand = new int[6];
				String [] t = kb.nextLine().trim().split(" ");
				for(int j=1; j<6; j++)								// count how many of each die
					hand[Integer.parseInt(t[j])-1]++;								
				for(int j=0; j<6; j++)						
					dice.add(hand[j]);	
				if (dice.contains(4) ) {
					names.add(t[0]);
					four.add(dice.indexOf(4));
					fifth.add(dice.indexOf(1));

				}	
			}
			if(names.isEmpty())
			 	out.println("NO WINNER");
			else if (names.size() == 1 )
			 	out.println(names.get(0));
			 
			else if (names.size() == 2 ){
				if(four.get(0) > four.get(1)) {
					out.println(names.get(0));
				}
				else if (four.get(1) > four.get(0)) {
					out.println(names.get(1));
				}
				else {								// 4 of kind are tied
					if(fifth.get(0) > fifth.get(1))	{
						out.println(names.get(0));
					}	
					else if (fifth.get(1) > fifth.get(0)) {
						out.println(names.get(1));
					}
					else {
						printNames(names);
					}
				}
			}
			else	{						// three with 4 of a kind
				int a = four.get(0);
				int b = four.get(1);
				int c = four.get(2);
				int x = fifth.get(0);
				int y = fifth.get(1);
				int z = fifth.get(2);
				if(a>b &&  a>c) 				// all have 4 of a kind - one winner
					out.println(names.get(0));
				else if (b>a &&  b>c) 
					out.println(names.get(1));
				else if (c>a &&  c>b) 
					out.println(names.get(2));
				else if(a==b && b>c) {			// two tied - check for low four of a kind
					if(x>y) 
						out.println(names.get(0));
					else if(y>x)
						out.println(names.get(1));
					else {
						names.remove(2);
						printNames(names);
					}
				}
				else if(a==c && c>b) {
					if(x>z) 
						out.println(names.get(0));
					else if(z>x)
						out.println(names.get(2));
					else {
						names.remove(1);
						printNames(names);
					}
				}
				else if(b==c && b>a) {
					if(y>z) 
						out.println(names.get(1));
					else if(z>y)
						out.println(names.get(2));
					else {
						names.remove(0);
						printNames(names);
					}
				}
				else if(a==b && b==c) {	 	// all three tied - check 5th die
				 	if(x==y && y==z)    	
						printNames(names);
					else if(x>y && x>z)		
						out.println(names.get(0));
					else if(y>x && y>z)
						out.println(names.get(1));
					else if(z>x && z>y)
						out.println(names.get(2));
					else if(x==y && y>z) {	
						names.remove(2);
						printNames(names);
					}
					else if(x==z && z>y) {
						names.remove(1);
						printNames(names);
					}
					else if(y==z && z>x) {
						names.remove(0);
						printNames(names);
					}
					else
						out.println("xx");
				}
			}			
		}
	}
	public static void printNames(ArrayList<String> names) {
		Collections.sort(names);
		out.print("TIE");
		for(String s : names)
			out.print(" " + s);
		out.println();
	}
}
