
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("armstrong.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            int total = 0;
            String num = s.nextLine().trim();
            for(int j = 0; j < num.length(); j++){
                int digit = (int)(num.charAt(j) - '0');
                total += Math.pow(digit, num.length());
            }
            if( total == Integer.parseInt(num))
                System.out.println("ARMSTRONG");
            else
                System.out.println("NOT AN ARMSTRONG");
        }
        s.close();
    }
}