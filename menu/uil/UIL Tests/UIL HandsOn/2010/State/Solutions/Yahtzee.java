import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Object.*;

public class Yahtzee {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("yahtzee.dat"));
		int count = Integer.parseInt(kb.nextLine().trim());
		int times = 0; 
		while(times < count) {
			times++;
			String names[] = new String[3];
			Arrays.fill(names, " ");
			int num [] = new int[3];
			int ct = 0;
			for(int i = 0; i < 3; i++) {
				String [] t = kb.nextLine().trim().split(" ");
				int die = Integer.parseInt(t[1]);
				boolean same = false;
				int j = 2;
				for(j=2; j<6; j++) {					// check if all are same
					if(Integer.parseInt(t[j]) != die) 
						break;	
				}
				if(j == 6) 	{							// if Yahtzee, put in TreeMap
					names[ct] = t[0];
					num[ct] = die;
					ct++;
				}
			}
			if(ct==0)
				out.println("NO WINNER");
			else if(ct == 1)
				out.println(names[0]);
			else if(ct==2) {
				if(num[0] > num[1])
					out.println(names[0]);
				else if(num[1] > num[0])
					out.println(names[1]);
				else {
					Arrays.sort(names);
					out.println("TIE "+names[1]+" "+names[2]);
				}
			}
			else {
				if(num[0] == num[1]  && num[1] == num[2]) {
					Arrays.sort(names);
					out.print("TIE");
					for(String s : names)
						out.print(" " + s);
					out.println();
				}
				else {
					int a = num[0];
					int b = num[1];
					int c = num[2];
					if(a == b  && b == c) {  // all tied
						Arrays.sort(names);
						out.print("TIE");
						for(String s : names)
							out.print(" " + s);
						out.println();
					}
					else if(a==b && b>c){  // a and b tied and bigger than c
						names[2] = " ";
						Arrays.sort(names);
						out.println("TIE "+ names[1] +" "+ names[2]);
					}
					else if(b==c && c>a){	// b and c tied and bigger than a
						names[0] = " ";
						Arrays.sort(names);
						out.println("TIE "+ names[1] +" "+ names[2]);
					}
					else if(a==c && c>b){  // a and c tied and bigger than b
						names[1] = " ";
						Arrays.sort(names);
						out.println("TIE "+ names[1] +" "+ names[2]);
					}
					else if(a>b && a>c){
						out.println(names[0]);
					}
					else if(b>c && b>a){
						out.println(names[1]);
					}
					else if(c>a && c>b){
						out.println(names[2]);
					}
					else
					
						out.println("xx");
				}
			}				
		}
	}
}
