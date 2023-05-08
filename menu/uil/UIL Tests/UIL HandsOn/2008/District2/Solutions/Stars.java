import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Stars {

	public static void main(String args[]) throws IOException
	{
		for(int i=0; i<20; i++) {
			for(int j=0; j<=i; j++)
				out.print("*");
			out.println();
		}			
	}	
}
