//UIL 2018 - Invitational B - Fa
import java.io.*;
import java.lang.*;
import java.util.*;
import static java.lang.System.*;

public class Fa{
	public static void main(String [] args) 
		throws IOException
	{ 
		Scanner f = new Scanner(new File("fa.dat"));
		while(f.hasNext())
		{
			int N = f.nextInt();
			int [] list = new int[N];
			int [] before = new int[N];
			int [] after = new int[N];
			for(int x=0;x<N;x++)
				list[x]=before[x]=after[x]=f.nextInt();
			for(int x=1;x<N;x++)
				before[x]+=before[x-1];
			for(int x=N-2;x>=0;x--)
				after[x]+=after[x+1];
//			out.print("Index: ");
//			for(int x=0;x<N;x++)
//				out.printf("%3d",x);
//			out.println();
//			out.print("List:  ");
//			for(int a:list)
//				out.printf("%3d",a);
//			out.println();
//			out.print("before:");
//			for(int a:before)
//				out.printf("%3d",a);
//			out.println();
//			out.print("after: ");
//			for(int a:after)
//				out.printf("%3d",a);
//			out.println();
//			out.println();
			//process - difference array
			int[]diff=new int[2*N-3];
			for(int x = 1;x<N;x++){
				diff[2*x-2]=Math.abs(before[x-1]-after[x]);
				if(x<N-1)
					diff[2*x-1]=Math.abs(before[x-1]-after[x+1]);
			}
//			for(int x:diff)
//				out.print(x+" ");
//			out.println();
			int pos = 0;
			for(int x = 1;x<diff.length;x++)
				if(diff[x]<diff[pos])
					pos = x;
//			out.println("fulcrum position is "+pos);
			if(pos%2==0)
				out.println(before[pos/2]+" "+(pos/2)+"^"+(pos/2+1)+" "+after[pos/2+1]);
			else
				out.println(before[pos/2]+" ^"+(pos/2+1)+" "+after[pos/2+2]);
		}
		f.close();
	}
}