
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Clock {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("clock.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            String[] startTime = s.nextLine().trim().split(":");
            int[] time = new int[3];
            int timeIndex = 0;
            for(int j = 0; j < startTime.length; j++)
                    time[timeIndex++] = Integer.parseInt(startTime[j]);
            String[] elapsedTime = s.nextLine().trim().split(":");
            int target = s.nextLine().trim().charAt(0) - '0';
            int numSeconds = Integer.parseInt(elapsedTime[2]);
            numSeconds += Integer.parseInt(elapsedTime[1]) * 60;
            numSeconds += Integer.parseInt(elapsedTime[0]) * 3600;
            int totalTimes = countDigits(time, target);
            for(int j = 0; j < numSeconds; j++){
                tick(time);
                totalTimes += countDigits(time, target);
            }
            System.out.println(totalTimes);
        }
        s.close();
    }

    private static void tick(int[] time) {
        time[2] = (time[2] + 1) % 60;
        if( time[2] == 0){
            time[1] = (time[1] + 1) % 60;
            if(time[1] == 0)
                time[0] = (time[0] + 1) % 24;
        }
        //System.out.println(Arrays.toString(time));
    }

    private static int countDigits(int[] time, int target) {
        int result = 0;
        for(int i = 0; i < time.length; i++){
            if(time[i] % 10 == target)
                result++;
            if(target == 0 && time[i] < 10)
                result++;
            else if(target != 0 && time[i] / 10 == target)
                result++;
        }
        return result;
    }
}
