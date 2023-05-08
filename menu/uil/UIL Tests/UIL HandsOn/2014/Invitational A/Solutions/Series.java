import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Series {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner (new File ("series.dat"));
		int testcases = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < testcases; i++) {
			System.out.println(getTerm(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
			sc.nextLine();
		}
		
		sc.close();
	}
	
	public static int getTerm (int a, int b, int c, int n) {	
		int term = a;
		if (n == 1) return term;
		term = (int)(b*Math.pow(c, n)*getTerm(a, b, c, n-1));
		return term;
	}
}
