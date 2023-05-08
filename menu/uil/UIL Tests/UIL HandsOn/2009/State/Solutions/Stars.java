
import java.io.*;
import java.util.*;

public class Stars {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("stars.dat"));
        int numSets = s.nextInt();
        int[][] coords = new int[numSets][3];
        String[] names = new String[numSets];
        s.nextLine();

        for(int i = 0; i < numSets; i++){
            String temp = s.nextLine();
            names[i] = temp.substring(0, temp.indexOf(':'));
            temp = temp.substring(temp.indexOf(':') + 1).trim();
            String[] vals = temp.split("\\s+");
            for(int j = 0; j < 3; j++){
                coords[i][j] = Integer.parseInt(vals[j]);
            }
        }

        double max = 0;
        int one = 0, two = 0;
        for(int i = 0; i < coords.length - 1; i++){
            for(int j = i + 1; j < coords.length; j++){
                double xPart, yPart, zPart;
                xPart = coords[i][0] - coords[j][0];
                yPart = coords[i][1] - coords[j][1];
                zPart = coords[i][2] - coords[j][2];
                double distance = Math.sqrt(xPart * xPart + yPart * yPart + zPart * zPart);
                if(distance > max){
                    max = distance;
                    one = i;
                    two = j;
                }
            }
        }
        double disOne = Math.sqrt(coords[one][0] * coords[one][0] +
                coords[one][1] * coords[one][1] +
                coords[one][2] * coords[one][2]);
        double disTwo = Math.sqrt(coords[two][0] * coords[two][0] +
                coords[two][1] * coords[two][1] +
                coords[two][2] * coords[two][2]);
        if(disTwo < disOne){
            int temp = one;
            one = two;
            two = temp;
        }
        System.out.print(names[one] + "," + names[two] + ":");
        System.out.printf("%1.1f", max);
        System.out.println();
        s.close();
    }
}
