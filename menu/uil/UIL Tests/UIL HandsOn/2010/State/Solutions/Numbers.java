import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Object.*;

public class Numbers {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("numbers.dat"));
		int count = Integer.parseInt(kb.nextLine().trim());		
		int times = 0; 
		String[] nums = new String[100001];
		for (int i=1;i<=100000; i++)     //store 100000 numbers as Strings
			nums[i]= String.valueOf(i);
				
		while(times < count) {
			String[] digits = new String[10];//store 10 digits as Strings
			Arrays.fill(digits,"x");					//fill with x's
			times++;
			String [] t = kb.nextLine().trim().split(" ");
			int nth = Integer.parseInt(t[t.length-1]);		// term number we are looking for	
			for (int i=0; i<t.length-1; i++) {
				int temp = Integer.parseInt(t[i]);		
				digits[temp]= t[i];	
			}	
			
			int index = 1;
			ArrayList<String> found = new ArrayList<String>();  // ArrayList to store found numbers
			while(found.size() < nth) {
				boolean boo = true;
				for(int j=0;  j<t.length-1; j++) {
					if(!nums[index].contains(t[j]))
						boo=false;
				}
				if(boo)
					for(int i=0; i<digits.length; i++) {
						if(digits[i]=="x" && nums[index].contains(String.valueOf(i)))
							boo = false;
				}
				if(boo) {
					found.add(nums[index]);				//out.println(found);
						
				}
				boo = true;
				index++;							
			}
			out.println(found.get(found.size()-1));
		}
	}
}
