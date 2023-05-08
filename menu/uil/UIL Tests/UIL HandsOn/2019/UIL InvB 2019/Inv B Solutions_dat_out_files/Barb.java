//2019 UIL B Packet - Solution
//Barb
import java.io.File;
import java.util.Scanner;

public class Barb {
    
    public static void main(String[] args) throws Exception{
        Scanner file = new Scanner(new File("Barb.dat"));
        int stop = file.nextInt();
        System.out.println("A   A*A   3*A   A/2");
        for (int i = 1; i <= stop; i++) {
            System.out.println(i + "     " + i*i + "     " + 3*i + "     " + (i/2));
        }
    }
}
