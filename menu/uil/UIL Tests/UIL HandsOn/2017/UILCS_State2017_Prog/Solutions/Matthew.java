/*
UIL 2017
State - Matthew

Searching for words using wild cards has been a challenge for Matthew in his algorithms class
and he needs your help.  He knows that the * character means to look for any character as many times as possible, even zero times.
He also knows that the ? means look for any single character, once and only once, and that those two
wild card search characters can be embedded in a some kind of search string.  

For example, if he has a list of words like:
BILLS BELLS TILLS DOLLS DOLLIES 2BILLS 5BELLS

The search string "B*" will match any word that starts with the letter "B", including just the letter "B".
This search would result in the words "BILLS", "BELLS", and "B".

Using "D?LLS" will match only match the word "DOLL", since that is the only one in this list
of words that starts with "D", ends in "LLS", and contains a single letter in between.

In addition to using these two wildcard characters, he understands that a range of characters
can be included in a search string, using the "[]" symbols. For example, the search string 
"[2-5]B?LLS" will look for a single instance of a digit for the numbers 2, 3, 4 and 5, followed
by a "B", then a single character, and ending with "LLS".

It is also possible that his search comes up empty, which means no words in the list match the search string.
In those cases, he just indicates with an output of "NONE".

Input: Several data sets, each of which begin with a list of N words (1 < N < 20) consisting of uppercase letters and digits,
all on one line with single space separation. The line following the word list contains a single integer P
(1 <= P <= 20), followed by P search strings containing the search string components described above in various combinations.

Output: For each search string, output the resulting list of words that are matched by the string,
or the word NONE if there are no matches.

Sample input:
BILLS BELLS B TILLS DOLLS DOLLIES 2BILLS 5BELLS
3
B*
D?LLS
[2-5]B?LLS
UIL DISTRICT REGION STATE CONTEST COMPUTER SCIENCE PROGRAMMING CHAMPION
4
C*
*?ON
?[I-M]*
*MM*

Sample output:
BILLS BELLS B
DOLLS
2BILLS 5BELLS
CONTEST COMPUTER CHAMPION
REGION CHAMPION
UIL DISTRICT
PROGRAMMING

*/
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import static java.lang.System.*;
public class Matthew
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("matthew.dat"));
		while(f.hasNext())
		{
			String t = f.nextLine();
			args = t.split(" ");
			int N = f.nextInt();
			while(N-->0){
				String s = f.next();
				s = s.replace("*",".*");
				s = s.replace("?",".");
			boolean print = false;
			
			for(String ss:args)
				if(Pattern.matches(s,ss)){
					out.print(ss + " ");
					print = true;
				}
				if(print)
					out.println();
				else
					out.println("NONE");
			}
			f.nextLine();
		}
	}
}
/*

Test input
BILLS BELLS B TILLS DOLLS DOLLIES 2BILLS 5BELLS
3
B*
D?LLS
[2-5]B?LLS
UIL DISTRICT REGION STATE CONTEST COMPUTER SCIENCE PROGRAMMING CHAMPION
4
C*
*?ON
?[I-M]*
*MM*
POUCH TOUCH OUCH PROU4CH ROUCH PROU2CHIR TOUCHIR ACHI ORCHARD RESEARCH
11
*UCH
*UCH*
?UCH*
*CH?
*U?CH	
*U[2-4]*
?OUCH*
R*CH
*C*
????
?*H

Test output
BILLS BELLS B
DOLLS
2BILLS 5BELLS
CONTEST COMPUTER CHAMPION
REGION CHAMPION
UIL DISTRICT
PROGRAMMING
POUCH TOUCH OUCH ROUCH
POUCH TOUCH OUCH ROUCH TOUCHIR
OUCH
ACHI
PROU4CH
PROU4CH PROU2CHIR
POUCH TOUCH ROUCH TOUCHIR
ROUCH RESEARCH
POUCH TOUCH OUCH PROU4CH ROUCH PROU2CHIR TOUCHIR ACHI ORCHARD RESEARCH
OUCH ACHI
POUCH TOUCH OUCH PROU4CH ROUCH RESEARCH

*/