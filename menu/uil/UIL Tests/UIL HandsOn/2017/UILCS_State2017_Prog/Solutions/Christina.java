/*
UIL 2017
State - Christina

In a recent computer science class, Christina has learned about string manipulation, and decided to use
the names of her friends to practice her newly learned techniques.  She decides to list all of her friends in a 
datafile, input them, and then use a special coding system to combine the names in certain situations
to create some unique and interesting name combinations.  

For example, she'll use the letter 'U' to indicate uppercasing the entire name, 'L' to lowercase, and 'R' to keep the name in its regular original format.
Furthermore, she decides to reverse the order of the letters in the name in a similar fashion by using 'u', 'l', and 'r' which still 
performs the uppercase, lowercase, of keep regular casing, but reverses the name.

She puts all of the names into a list, and then indicates which name to use with a 1 indicating the first
name in the list, and 12 (if there are 12 names) to indicate the last name.  In the sample data below, her name
is in position 3 of the list of names, and so a code string of "03U" will produce her name in all upper case letters,
resulting in CHRISTINA. She then tries several codes, like "03u12R05L", which produces this result:

ANITSIRHCZacharyeric

The first portion of the code, "03u", causes her name, "Christina", to be shown in all uppercase letters, in reverse letter order.
The next part, "12R", takes the 12th name in the list, "Zachary", and keeps it in regular initial case form, normal letter order.
Finally, "05L" takes "Eric", and lowercases it, in normal letter order.

Input: An initial value N, followed by N names, all spelled with initial uppercase letters, followed by all lowercased letters.
Following all of the names are several code strings which will produce interesting name combinations according to the rules stipulated above.

Output: The resulting name combination string produced by each of the code strings at the end of the data file.


Sample Input:
12
Arun
Changpu
Christina
Dai
Eric
Guang
Keerthi
Matthew
Rohan
Sasha
Yulia
Zachary
03u12R05L
01u05L06R
12R07U
10l03R09u
08R09u12l03u11l
12L05U

Sample Output:
ANITSIRHCZacharyeric
NURAericGuang
ZacharyKEERTHI
ahsasChristinaNAHOR
MatthewNAHORyrahcazANITSIRHCailuy
zacharyERIC

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class Christina
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("christina.dat"));
		int N = f.nextInt();
		args = new String [N];
		for(int x=0;x<N;x++)
			args[x]=f.next();
		while(f.hasNext())
		{
			String s = f.next();
			String ans = "";
			for(int x=0;x<s.length();x+=3)
			{
				int i = Integer.parseInt(s.substring(x,x+2))-1;
				char a = s.charAt(x+2);
				switch(a)
				{
					case 'U':ans+=args[i].toUpperCase();break;
					case 'L':ans+=args[i].toLowerCase();break;
					case 'u':ans+=new String(new StringBuilder(args[i]).reverse()).toUpperCase();break;
					case 'l':ans+=new String(new StringBuilder(args[i]).reverse()).toLowerCase();break;
					case 'R':ans+=args[i];break;
				}
			}
			out.println(ans);
		}
	}
}
/*
ANITSIRHCZacharyeric
NURAericGuang
ZacharyKEERTHI
ahsasChristinaNAHOR
MatthewNAHORyrahcazANITSIRHCailuy
zacharyERIC
UPGNAHCKeerthiGNAUGAILUY
upgnahcKeerthiGUANGihtreekchangpu
arunCHANGPU
YRAHCAZericchangpueric
arunupgnahcDaiMATTHEWGuang
DAIChristinacire
guangERICgnaugnahorYRAHCAZ
CIREmatthewERICKEERTHI
changpuNAHORKEERTHIgnaugYRAHCAZ
ANITSIRHCsasha
ailuyyrahcazARUNguang
UPGNAHCrohancirechristina
ihtreekahsasguang
GuangahsascireguangYULIA
ROHANYRAHCAZzachary
KeerthiGUANGciredaiyulia
matthewIADnahorSASHAyrahcaz
changpuDAIyrahcazailuyailuy
CHRISTINAWEHTTAMAHSASdavid
shyamalcrystalNAHORdavidyrahcaz
WEHTTAMrohan
CrystalROHANNURA
CrystalEricZachary
NURAMatthewRohan
AILUYArun
Joeldavidihtreek
nhojEric
anitsirhcCIRE
gnaugYULIA
CrystalIADDaiDIVADNAHOR
rohanZacharyahsasMatthewupgnahc
ROHANdavidSASHAlamayhsZACHARY
DIVADGuang
keerthicrystalROHANYULIAARUN
IHTREEKJohn
DAVIDrohanIADWEHTTAMDIVAD
DIVADNAHORArunRohanIAD
ANITSIRHCDIVADzacharyleoj
*/