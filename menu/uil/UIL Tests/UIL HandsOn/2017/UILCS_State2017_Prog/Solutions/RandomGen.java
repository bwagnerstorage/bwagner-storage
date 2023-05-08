/*
*/
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import static java.lang.System.*;
class RandomGen

{
	public static void main(String [] args) throws IOException
	{
		//generates 20 randome values between 1 and 10
//		for(int x=0;x<20;x++)
//			out.println((int)(Math.random()*10)+1);
			
/*		for(int x=0;x<20;x++){
			int c = (int)(Math.random()*4)+2;
			String ss = "";
			for(int y = 0;y<c;y++){
				String a = String.format("%02d",(int)(Math.random()*17)+1);
				String s = "UuLlR";
				int b = (int)(Math.random()*5);
				ss+=""+a+s.charAt(b);
			}
			out.println(ss);
		}	
*/
//		for(int x=0;x<100;x++){
//			int n = (int)(Math.random()*10000+1);
//			int b = (int)(Math.random()*36+1);
//			String s = Integer.toString(n,b).toUpperCase();
//			if(Pattern.matches(".*[A-Z].*",s))
//				out.println(n+" "+b+" "+s);
		String s= "Peter Piper picked a peck of pickled peppers A peck of pickled peppers Peter Piper picked If Peter Piper picked a peck of pickled peppers Wheres the peck of pickled peppers Peter Piper picked";
		out.println(s.toUpperCase());
		
			
	}
}
/*

*/