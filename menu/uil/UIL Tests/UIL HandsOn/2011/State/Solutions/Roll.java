import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Roll {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("roll.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine();
			int len = t.length();
			int s = (int)(Math.sqrt(len));
			char [][] a = new char[s][s];
			int index = 0;	
			for(int i=0; i<s; i++)  {            //read string into matrix
				for(int j=0; j<s; j++) {
					a[i][j] = t.charAt(index++);    
				}	
			}
			
			for(int i=0; i<s/2; i++) {
				ArrayList <Character> al = new ArrayList <Character> ();
				
				for(int j=i; j<s-i; j++)     	//across top
					al.add(a[i][j]);
				for(int j=i+1; j<s-i-1; j++)   	//down right side
					al.add(a[j][s-i-1]);
				for(int j=s-i-1; j>=i; j--)   	//back across bottom
					al.add(a[s-i-1][j]);
				for(int j=s-i-2; j>i; j--)	 	//up left side
					al.add(a[j][i]);
						  
				if(i%2==0) {					//rotate clockwise
					al.add(al.get(0));				
					al.remove(0);
				}
				else  {							//rotate counter-clockwise
					al.add(0,al.get(al.size()-1));
					al.remove(al.size()-1);					
				}
					
				index = 0;						//put back in matriz
				for(int j=i; j<s-i; j++)     	//across top
					a[i][j] = al.get(index++);
				for(int j=i+1; j<s-i-1; j++)   	//down right side
					a[j][s-i-1] = al.get(index++);
				for(int j=s-i-1; j>=i; j--)   	//back across bottom
					a[s-i-1][j] = al.get(index++);
				for(int j=s-i-2; j>i; j--)	 	//up left side
					a[j][i] = al.get(index++);	
			}
			int i=0; 
			int j=0;
			boolean star =  true;
			for(i=0; i<s && star; i++) {
				for(j=0; j<s; j++) {
					if(a[i][j] == '*')  {
						star = false;
						break;
					}
					out.print(a[i][j]);
				}
			}
			out.println();
		}
	}	
}
