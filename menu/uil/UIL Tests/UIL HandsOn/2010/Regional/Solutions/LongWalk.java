
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LongWalk {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("longwalk.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            String street = s.nextLine();
            int[] addresses = new int[s.nextInt()];
            s.nextLine();
            for(int j = 0; j < addresses.length; j++){
                addresses[j] = s.nextInt();
                s.nextLine();
            }
            Arrays.sort(addresses);
            System.out.println("The two houses farthest apart on " + street + " are");
            System.out.println(addresses[0] + " " + street + " and " + addresses[addresses.length - 1] + " " + street);
        }
        s.close();
    }
}
