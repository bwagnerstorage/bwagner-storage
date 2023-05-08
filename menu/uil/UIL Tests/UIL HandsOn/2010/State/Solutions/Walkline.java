
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Walkline {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("walkline.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            Point[] points = new Point[4];
            for(int j = 0; j < 4; j++){
                points[j] = new Point();
                points[j].x = s.nextInt();
                points[j].y = s.nextInt();
            }
            s.nextLine();
            Equation[] lines = new Equation[6];
            int lineNum = 0;
            for(int j = 0; j < 3; j++){
                for(int k = j + 1; k < 4; k++){
                    lines[lineNum] = new Equation();
                    if(points[j].x == points[k].x){
                        lines[lineNum].slope = Integer.MAX_VALUE;
                    }
                    else{
                        lines[lineNum].slope = 1.0 *(points[j].y - points[k].y) / (points[j].x - points[k].x);
                    }
                    if( lines[lineNum].slope == Integer.MAX_VALUE){
                        lines[lineNum].intercept = points[j].x;
                    }
                    else{
                        lines[lineNum].intercept = points[j].y - points[j].x * lines[lineNum].slope;
                    }
                    lineNum++;
                }
            }
            boolean[] repeat = new boolean[6];
            for(int j = 0; j < 5; j++){
                if(!repeat[j]){
                    for(int k = j + 1; k < 6; k++){
                        if(lines[j].same(lines[k]))
                            repeat[k] = true;
                    }
                }
            }
            int num = 0;
            for(int j = 0; j < 6; j++)
                if(!repeat[j])
                    num++;
            System.out.println(num);
        }
        s.close();
    }

    private static class Equation{
        double slope;
        double intercept;

        public boolean same(Equation other){
            return slope == other.slope && intercept == other.intercept;
        }

        public String toString(){
            return "y = " + slope + " * x + " + intercept;
        }
    }
}
