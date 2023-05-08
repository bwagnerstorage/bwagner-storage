import java.io.*;
import java.util.*;

public class Unlucky {
    private static final int TARGET_SUM = 13;

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("unlucky.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        
        for(int i = 1; i <= numSets; i++){
            String num = s.nextLine();
            int forwardSum = 0;;
            int backwardSum = 0;
            int pos = 0;
            while(pos < num.length() && forwardSum < 13){
                forwardSum += num.charAt(pos) - '0';
                pos++;
            }
            if(forwardSum == TARGET_SUM){
                pos = num.length() - 1;
                while( pos >= 0 && backwardSum < TARGET_SUM){
                    backwardSum += num.charAt(pos) - '0';
                    pos--;
                }
            }
            if( forwardSum == TARGET_SUM && backwardSum == TARGET_SUM)
                System.out.println("UNLUCKY");
            else
                System.out.println("NOT UNLUCKY");
        }
    }
}

