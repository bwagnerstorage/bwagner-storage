import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Wally {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("wally.dat"));
		boolean flag = false;
		Set<String> keywords=new HashSet<String>();
		Set<String> validIdentifiers=new TreeSet<String>();
		while(f.hasNext()){
			String s = f.nextLine();
			if(s.equals("999"))
			{
				flag = true;
				continue;
			}
			if(!flag)
				keywords.add(s);
			else
			{
				if(keywords.contains(s))
					continue;
				if(s.matches("[a-zA-Z_$]{1}[a-zA-Z0-9_$]*"))
				validIdentifiers.add(s);
			}
		}
		f.close();
		for(String s:validIdentifiers)
			out.println(s);
	}

}
