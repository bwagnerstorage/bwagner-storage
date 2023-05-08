
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Shortwalk {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("shortwalk.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            String street = s.nextLine();
            long[] addresses = new long[s.nextInt()];
            s.nextLine();
            for(int j = 0; j < addresses.length; j++){
                addresses[j] = s.nextLong();
                s.nextLine();
            }
            Arrays.sort(addresses);
            long minDistance = addresses[1] - addresses[0];
            int numMins = 0;
            final int LIMIT = addresses.length - 1;
            for(int j = 0; j < LIMIT; j++){
                long diff = addresses[j + 1] - addresses[j];
                if(diff < minDistance){
                    numMins = 1;
                    minDistance = diff;
                }
                else if(minDistance == diff){
                    numMins++;
                }
            }
            System.out.println(street);
            System.out.println("min distance: " + minDistance);
            System.out.println("number of pairs: " + numMins);
        }
        s.close();
    }
}
