
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Attend {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("attend.dat"));
        int numPlans= s.nextInt();
        s.nextLine();
        int[][] plans = new int[numPlans][3];
        for(int i = 0; i < numPlans; i++){
            for(int j = 0; j < 3; j++)
                plans[i][j] = s.nextInt();
            s.nextLine();
        }
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            System.out.println("Data Set " + i);
            String[] data = new String[s.nextInt()];
            s.nextLine();
            for(int j = 0; j < data.length; j++)
                data[j] = s.nextLine();
            for(int j = 0; j < numPlans; j++){
                int awards = 0;
                for(int k = 0; k < data.length; k++){
                    int as = 0;
                    int ls = 0;
                    for(int m = 0; m < data[k].length(); m++)
                        if( data[k].charAt(m) == 'A')
                            as++;
                        else if( data[k].charAt(m) == 'L')
                            ls++;
                    if(as <= plans[j][0] && ls <= plans[j][2]){
                        int len = data[k].length();
                        boolean found = false;
                        String conAs = "";
                        for(int m = 0; m < len; m++)
                            conAs += "A";
                        while(len > 0 && !found){
                            found = data[k].indexOf(conAs) != -1;
                            if(!found)
                                conAs = conAs.substring(1);
                        }
                        if(conAs.length() <= plans[j][1])
                            awards++;
                    }
                }
                System.out.println("Plan " + (j + 1) + " " + awards);
            }
        }
        s.close();
    }
}
