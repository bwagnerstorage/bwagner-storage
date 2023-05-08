import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Stairs {

	public static void main(String args[]) throws IOException
	{
		int n=14;
		for(int i=0; i<10; i++) {
			for(int j=0; j<n; j++)
				out.print("*");
			out.println();
			for(int j=0; j<n; j++)
				out.print("*");
			out.println();
			n += 4;
		}
	}
}
