//UIL 2018 - Invitational B - Baldo
import static java.lang.System.out;
public class Baldo {

	public static void main(String[] args) {
		for(int ch=65;ch<91;ch++)
			out.println((char)ch+" "+ch+" "+(char)(ch+32)+" "+(ch+32));
	}
}
