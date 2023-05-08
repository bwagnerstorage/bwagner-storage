
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Target {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("target.dat"));
        int numShooters = s.nextInt();
        int numCenters = s.nextInt();
        s.nextLine();
        Officer[] shooters = new Officer[numShooters];
        for(int i = 0; i < numShooters; i++){
            shooters[i] = new Officer(s.nextLine().trim());
            //System.out.println(shooters[i].name + " " + shooters[i].score);
        }
        for(int i = 0; i < numCenters; i++){
            String[] data = s.nextLine().trim().split("[(),]");
            int x = Integer.parseInt(data[1]);
            int y = Integer.parseInt(data[2]);
            for(int j = 0; j < shooters.length; j++)
                shooters[j].setCenter(x, y);
            Arrays.sort(shooters);
            //System.out.println(Arrays.toString(shooters));
            System.out.println("TARGET " + (i + 1) + " " + shooters[0].name + " " + shooters[0].score);
        }

        /*
        for(Officer sh : shooters)
            System.out.println(sh.score)
        */
        s.close();
    }

    private static class Officer implements Comparable<Officer>{
        String name;
        Point[] shotCoords;
        int score;

        public String toString(){
            return name + " " + score;
        }

        public void setCenter(int x, int y){
            double[] distances = new double[5];
            for(int i = 0; i < 5; i++){
                double xDiff = x - shotCoords[i].x;
                double yDiff = y - shotCoords[i].y;
                distances[i] += Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
            }
            Arrays.sort(distances);
            score = (int)Math.round(distances[0] + distances[1] + distances[2]);
        }

        private Officer(String data){
            //System.out.println(data);
            shotCoords = new Point[5];
            String[] raw = data.split("\\s+");
            name = raw[0];
            for(int i = 1; i <= 5; i++){
                String[] coords = raw[i].trim().split("[(),]");
                assert coords.length == 3;
                int x = Integer.parseInt(coords[1]);
                int y = Integer.parseInt(coords[2]);
                shotCoords[i - 1] = new Point(x, y);
            }
        }

        public int compareTo(Officer other){
            return score - other.score;
        }
    }


}
