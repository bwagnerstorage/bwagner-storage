//2019 UIL B Packet - Solution
//Sara
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Sara {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("sara.dat"));
		int n=Integer.parseInt(f.nextLine());
		for(int wedding=1;wedding<=n;wedding++) {
			Set<String> bride=new TreeSet<String>();
			Set<String> groom=new TreeSet<String>();
			Scanner line=new Scanner(f.nextLine());
			while(line.hasNext())
				bride.add(line.next());
			line=new Scanner(f.nextLine());
			while(line.hasNext())
				groom.add(line.next());
			Set<String> all=new TreeSet<String>(bride);
			all.addAll(groom);
			out.print("Guests: ");
			printset(all);
			Set<String> friends=new TreeSet<String>(bride);
			friends.retainAll(groom);
			out.print("Guests of Both: ");
			printset(friends);
			Set<String> brideonly=new TreeSet<String>(bride);
			brideonly.removeAll(groom);
			out.print("Bride's Guests: ");
			printset(brideonly);
			Set<String> groomonly=new TreeSet<String>(groom);
			groomonly.removeAll(bride);
			out.print("Groom's Guests: ");
			printset(groomonly);
			out.println("--------------------");
		}
		

	}
	public static void printset(Set<String> s) {
		if(s.size()>0){
			String ans = "";
			for(String name:s) 
				ans+=name+" ";
			out.print(ans.trim());
		}
		else
			out.print("none");
		out.println();
	}

}
