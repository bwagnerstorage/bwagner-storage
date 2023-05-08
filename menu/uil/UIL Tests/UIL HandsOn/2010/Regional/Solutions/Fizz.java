
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Fizz {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("fizz.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            System.out.println("Data Set " + i);
            int start = s.nextInt();
            int end = s.nextInt();
            s.nextLine();
            for(int j = start; j <= end; j++){
                if( j % 3 == 0 && j % 5 == 0 )
                    System.out.println("FizzBang");
                else if(j % 3 == 0)
                    System.out.println("Fizz");
                else if(j % 5 == 0)
                    System.out.println("Bang");
                else
                    System.out.println(j);
            }
        }
        s.close();
    }
}
