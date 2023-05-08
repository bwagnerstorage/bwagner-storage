//2018 UIL Invitational B - Micaela
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;
class Micaela
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("micaela.dat"));
		while(f.hasNext()){
			String A = f.next();
			String B = f.next();
			int m = A.length();
			int n = B.length();
			int[][]g = new int[m+1][n+1];

			for(int r=0;r<=m;r++){
				for(int c=0;c<=n;c++)
				{
					if(r==0||c==0)
						g[r][c]=0;
					else
					if(A.charAt(r-1)==B.charAt(c-1))
						g[r][c]=g[r-1][c-1]+1;
					else
						g[r][c]=max(g[r][c-1],g[r-1][c]);
				}
			}
//			for(int r=0;r<=m;r++){
//				for(int c=0;c<=n;c++)
//					out.print(g[r][c]+" ");
//				out.println();					
//			}
			//build longest common subsequence string
			String s = "";
//			int num = g[m][n];//last value in lcs table
			int r=m,c=n;
			while(r>0&&c>0){
				if(A.charAt(r-1)==B.charAt(c-1))//letters match
				{
					s=""+A.charAt(r-1)+s;
					r--;c--;//move up and left, diagonally
				}
				else
				if(g[r-1][c]>g[r][c-1])//upper cell value greater
					r--;//move up a row
				else
					c--;//move left a column
			}
			out.println(s.length()>0?s:"NONE");
//			out.println(A+" "+B+" "+(s.length()>0?s:"NONE"));
		}
			
		
	}
}
/*
Test input:
DEBQGLBFUE BMANOPLRSTUEVE
URPWOEGJSDLFJA RARKQENMED
QGWFEDRGQWFD ULIKJOULIKJYUKLIJ
QESSJYUBNGVLHXSLDCBWXBOMUOWWHJZNUUEUAF HSKCRTYJJL
TIMSMXWBEYZJQFWUWPGRQIEIXQ CNUPMBJADQQCVBJOHIFMTX
LKATSZHXQATSRTJFLKHUAQLXD LIKKUINCMG
RVLOXRHSBFNOZESJTKAFY TWTPMFNUDQREEOIHBQDUGPHIUTCAOIZSDDCHUMBV
NOPQRSTUVWXYZRSTUVWX ABCDEFGHIJKLMLKJABCEFDILM
GMALAKZQYAJPYAOXXQFPUOEOFLVXOACZMZBRSKCT BQAIFIKPMHSZTQMHVKNZDQKHXKKZCTKZUHWNCQVRGGAVPMY
EJTZWCBMVBJIINHYVFDSUSVWUCWXBVJJDXWZRHLFUWISBFVK FQXBIETRCPJMPATYHQRBIIPAYCEB
CFJTPWGJCQXZNVBMTKXKDYVUZNONSTONYNSUFDT AKAJVIPLVPFUTVZHWC
KINHFWITRNQMHQCIPHIBSTKLEWRWMPC TSYGSZQJEHTBDXOKBXOGCWUPBEMBFXUX
MVIJZTQXTCUNQIIJSAGDGZRPGICCMFVQPIGKJ GSRRAJNXUKYHPKFOBFNNPBKFLFBEPKJXBKVYJLOZNNUYVONNU 
ECQSBMZPAYBLPJOOHVDSKOIVTATE NVNIBNJOEPNHRKGQHZZWWJ

Test output:
BLUE
RED
NONE
HSCJ
MBJQQIX
LKKU
ROHBOZS
NONE
QAFPZMZKCT
ETCMBIIYCB
JPVTVZ
TQHCPBEM
JXUNPFPKJ
BJOHK

*/