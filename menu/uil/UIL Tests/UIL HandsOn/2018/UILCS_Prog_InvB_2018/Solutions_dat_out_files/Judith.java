//2018 UIL Invitational B - Judith
import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;

public class Judith{
	public static void main(String [] args) 
		throws IOException
	{ 
		Scanner f = new Scanner(new File("judith.dat"));
		ArrayList<BigDecimal> list = new ArrayList<BigDecimal>();
		while(f.hasNext())
		{
			String s = f.next();
			list.add(new BigDecimal(s));
		}
		Collections.sort(list);
		for(BigDecimal b:list)
			out.println(b);
	}
}