import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DryRun {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("dryrun.dat"));
        int num = s.nextInt();
        for(int i = 0; i < num; i++)
            System.out.println("I like " + s.next() + ".");

        s.close();
    }
}
