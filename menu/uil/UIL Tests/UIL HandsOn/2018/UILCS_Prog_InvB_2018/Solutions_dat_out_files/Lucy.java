//2018 UIL Invitational B - Lucy
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Lucy {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("lucy.dat"));
		int d=Integer.parseInt(f.nextLine());
		for(int x=1;x<=d;x++) {
			int n=Integer.parseInt(f.nextLine());
		for(int y=1;y<=n;y++) {
			String line=f.nextLine();
			String coded="";
			int count=0;
			for(int i=0;i<line.length()-1;i++) {
				if(line.substring(i, i+1).equals(line.substring(i+1,i+2))) 
					count++;
				else { 
					count++;
					coded+=line.substring(i, i+1)+count;
					count=0;
					}				
				}
			if(line.substring(line.length()-2, line.length()-1).equals(line.substring(line.length()-1))) {
				count++;
				coded+=line.substring(line.length()-1)+count;
			}
			else 
				coded+=line.substring(line.length()-1)+1;
			out.println(coded);
			}
		out.println("=====");
		}
	}
}


