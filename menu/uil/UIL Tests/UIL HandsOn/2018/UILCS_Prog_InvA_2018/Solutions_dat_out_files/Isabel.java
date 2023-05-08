/*2018 UIL Invitational A - Isabel
*/
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Isabel
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("isabel.dat"));
		GregorianCalendar c = new GregorianCalendar(2018,0,1);
		TreeMap<String,String> map = new TreeMap<String,String>();
		while(f.hasNext()){
			String name = f.next();
			int year = f.nextInt();
			int month = f.nextInt()-1;
			int day = f.nextInt();
			c = new GregorianCalendar(year,month,day);
			String entry = String.format("%-10s : %tA, %tB %te, %tY",name,c,c,c,c);
			String dayName = String.format("%tA",c);
			map.put(entry,dayName);
		}
		for(String t:map.keySet())
			if(map.get(t).equals("Sunday"))
				out.println(t);
		for(String t:map.keySet())
			if(map.get(t).equals("Monday"))
				out.println(t);
		for(String t:map.keySet())
			if(map.get(t).equals("Tuesday"))
				out.println(t);
		for(String t:map.keySet())
			if(map.get(t).equals("Wednesday"))
				out.println(t);
		for(String t:map.keySet())
			if(map.get(t).equals("Thursday"))
				out.println(t);
		for(String t:map.keySet())
			if(map.get(t).equals("Friday"))
				out.println(t);
		for(String t:map.keySet())
			if(map.get(t).equals("Saturday"))
				out.println(t);
	}
}

/*Judges data
Isabel 2003 9 18
Rocio 2004 12 25
Wally 2003 10 31
Klara 2002 11 1
Chaoxiang 2001 2 16
Stelios 2002 6 6
Linus 2001 4 21
Deshi 2002 3 7
Logan 2003 8 17
Polina 2002 5 15
Vicente 2001 7 9
Aaron 2000 1 23


Judges output:
Aaron      : Sunday, January 23, 2000
Logan      : Sunday, August 17, 2003
Vicente    : Monday, July 9, 2001
Polina     : Wednesday, May 15, 2002
Deshi      : Thursday, March 7, 2002
Isabel     : Thursday, September 18, 2003
Stelios    : Thursday, June 6, 2002
Chaoxiang  : Friday, February 16, 2001
Klara      : Friday, November 1, 2002
Wally      : Friday, October 31, 2003
Linus      : Saturday, April 21, 2001
Rocio      : Saturday, December 25, 2004

*/
