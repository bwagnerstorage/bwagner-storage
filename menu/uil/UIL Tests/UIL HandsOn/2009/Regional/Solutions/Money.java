
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Money {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("money.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            int goal = s.nextInt();
            s.nextLine();
            int ways = 0;
            for(int j = 0; j <= goal / 77; j++){
                for(int k = 0; k <= goal / 7; k++){
                    for(int m = 0; m <= goal; m++){
                        if( j * 77 + k * 7 + m == goal)
                            ways++;
                    }
                }
            }
            System.out.println(ways);
        }
        s.close();
    }

}
