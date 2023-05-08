import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Ampersands {

	public static void main(String args[]) throws IOException
	{
		for(int i=0; i<20; i++) {
			for(int j=20; j>i; j--)
				out.print("&");
			out.println();
		}			
	}	
}
