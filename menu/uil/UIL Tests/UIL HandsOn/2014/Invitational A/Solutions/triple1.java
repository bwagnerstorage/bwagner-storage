import java.io.*;
import java.util.*;
import static java.lang.System.*;


public class triple1 {
	
	//receives ArrayList of integers and returns true if the list
	//contains three and only three unique integers
	public static boolean isTriple(ArrayList<Integer> l)
	{
		if(l.size()!=3)
			return false;
		int x=l.get(0);
		int y=l.get(1);
		int z=l.get(2);
		if(x==y || x==z || y==z)
			return false;
		return true;
	}
	public static void main(String [] args) throws FileNotFoundException { 
		Scanner f = new Scanner(new File("triple.dat"));
		int []primes={2,3,5,7,11,13,17,23,29};
		//read initial N value
		int N = f.nextInt(); 
		f.nextLine();
		//loop through N data items
		while(N-- > 0) 
		{
				//input test value
				int num=f.nextInt();
				//duplicate test value
				int n=num;
				//list to gather factors
				ArrayList<Integer> a = new ArrayList<Integer>();
				//loop through primes and divide down the test value by primes
				//until it reaches 1, adding each prime factor to the list
				for(int x=0;x<primes.length;   )
				{
					if(num%primes[x]==0)
					{
						a.add(primes[x]);
						num/=primes[x];
					}
					else
						x++;
					if(num==1)
						break;
				}
				//send list of factors to isTriple method
				out.println(n+" "+a+(isTriple(a)?" YES":" NO"));
		}
	}
}
