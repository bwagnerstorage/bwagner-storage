import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Object.*;

public class FullHouse {
	public static void main(String args[]) throws IOException 	{
		Scanner kb = new Scanner(new File("fullhouse.dat"));
		int count = Integer.parseInt(kb.nextLine().trim());
		int times = 0; 
		while(times < count) {
			times++;
			ArrayList<String> names = new ArrayList<String>();  // parallel ArrayLists
			ArrayList<Integer> three = new ArrayList<Integer>();
			ArrayList<Integer> two = new ArrayList<Integer>();
			for(int i = 0; i < 3; i++) {
				ArrayList <Integer> dice = new ArrayList <Integer> ();  // ArrayList to hold the counts
				int [] hand = new int[6];
				String [] t = kb.nextLine().trim().split(" ");
				for(int j=1; j<6; j++)								// count how many of each die
					hand[Integer.parseInt(t[j])-1]++;								
				for(int j=0; j<6; j++)						
					dice.add(hand[j]);	
				if(dice.contains(3) && dice.contains(2)) {
					names.add(t[0]);
					three.add(dice.indexOf(3));
					two.add(dice.indexOf(2));
				}					
			}
			if(names.isEmpty())
			 	out.println("NO WINNER");
			else if (names.size() == 1 )
			 	out.println(names.get(0));
			 
			else if (names.size() == 2 ){
				if(three.get(0) > three.get(1)) {
					out.println(names.get(0));
				}
				else if (three.get(1) > three.get(0)) {
					out.println(names.get(1));
				}
				else {								// 3 of kind are tied
					if(two.get(0) > two.get(1))	{
						out.println(names.get(0));
					}	
					else if (two.get(1) > two.get(0)) {
						out.println(names.get(1));
					}
					else {
						printNames(names);
					}
				}
			}
			else	{						// three with 3 of a kind
				int a = three.get(0);
				int b = three.get(1);
				int c = three.get(2);
				int x = two.get(0);
				int y = two.get(1);
				int z = two.get(2);
				if(a>b &&  a>c) 				// all have 3 of a kind - one winner
					out.println(names.get(0));
				else if (b>a &&  b>c) 
					out.println(names.get(1));
				else if (c>a &&  c>b) 
					out.println(names.get(2));
				else if(a==b && b>c) {			// two tied - check for low 2 of a kind
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
				else if(a==b && b==c ) {	 	// all three tied - check 2 of a kind
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
