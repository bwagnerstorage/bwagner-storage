
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Benford {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("benford.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            int[] leadDigitCount = new int[9];
            int numValues = Integer.parseInt(s.nextLine());
            for(int j = 0; j < numValues; j++){
                leadDigitCount[(s.nextInt() + "").charAt(0) - '1' ]++;
            }
            s.nextLine();
            boolean descending = true;
            int index = 1;
            while(descending && index < 9)
                descending = leadDigitCount[index - 1] >= leadDigitCount[index++];
            if(descending)
                System.out.println("CONFIRMS");
            else
                System.out.println("DOES NOT CONFIRM");
        }
        s.close();
    }
}
