import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Linus {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("linus.dat"));
		int n=f.nextInt();
		for(int x=1;x<=n;x++) {
			int num=f.nextInt();
			int den=f.nextInt();
			if(num==0)
				out.println(0);
			else if(num<den) {
				int div=gcd(num,den);
				out.println(num/div+"/"+den/div);
			}
			else if(num%den==0)
				out.println(num/den);
			else {
				int wholepart=num/den;
				num=num%den;
				int div=gcd(num,den);
				out.println(wholepart+" "+num/div+"/"+den/div);
			}			
		}
	}
	
	public static int gcd(int x,int y) {
		int gcd=1;
		int smaller=Math.min(x, y);
		for(int div=smaller;div>1;div--)
			if(x%div==0&&y%div==0) {
				gcd=div;
				break;
			}
		return gcd;
	}
}
