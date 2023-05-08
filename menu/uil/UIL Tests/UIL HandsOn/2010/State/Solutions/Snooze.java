import java.util.*;
import java.io.*;
import java.awt.*;

public class Snooze {

    static class time {
        public int minutes;
        public int hours;
        String[][] digits;

        public time (String[] clock) {
           int clockDigits[] = new int[4];
           int numDigits=0;
           int currCursor;

           digits = new String[10][3];
           digits[0][0]=" _ ";
           digits[0][1]="| |";
           digits[0][2]="|_|";

           digits[1][0]="   ";
           digits[1][1]="  |";
           digits[1][2]="  |";
 
           digits[2][0]=" _ ";
           digits[2][1]=" _|";
           digits[2][2]="|_ ";

           digits[3][0]=" _ ";
           digits[3][1]=" _|";
           digits[3][2]=" _|";

           digits[4][0]="   ";
           digits[4][1]="|_|";
           digits[4][2]="  |";

           digits[5][0]=" _ ";
           digits[5][1]="|_ ";
           digits[5][2]=" _|";

           digits[6][0]=" _ ";
           digits[6][1]="|_ ";
           digits[6][2]="|_|";

           digits[7][0]=" _ ";
           digits[7][1]="  |";
           digits[7][2]="  |";

           digits[8][0]=" _ ";
           digits[8][1]="|_|";
           digits[8][2]="|_|";

           digits[9][0]=" _ ";
           digits[9][1]="|_|";
           digits[9][2]=" _|";
        

           //Read in the digits in reverse order
           //so we don't worry about whether there
           //are 3 or 4 digits
           currCursor = clock[0].length()-3;

           while(currCursor >= 0) {
              //Find matching digit
              for(int d = 0; d <= 9; d++) {
                 boolean match = true;
                 for(int row = 0; row < 3; row++) {
                    if(clock[row].substring(currCursor,currCursor+3).compareTo(digits[d][row]) != 0) {
                       match = false;
                       break;
                    }
                 }
                 if(match) {
                    clockDigits[numDigits++]=d;
                    break;
                 }
              }

              //Skip asterisks
              if(numDigits == 2)
                 currCursor -= 2;

              //Go to next digit
              currCursor -= 4;
           }

           //Convert digits to hours and minutes              
           minutes = clockDigits[1] * 10 + clockDigits[0];
           if(numDigits == 3)
              hours = clockDigits[2];
           else
              hours = clockDigits[3] * 10 + clockDigits[2];
        }

        public void add(int snoozeMinutes) {
           int totMinutes = ((hours == 12 ? 0 : hours) * 60 + minutes + snoozeMinutes) % (12 * 60);

           hours = totMinutes / 60;
           if(hours == 0)
              hours = 12;

           minutes = totMinutes % 60;
        }

        public void display() {
           for(int row=0;row < 3; row++) {
              char asteriskValue = '*';
              if(row == 0)
                 asteriskValue = ' ';

              //Print tens hours digit only if there is one
              if(hours >= 10)
                 System.out.print(digits[1][row] + " ");

              System.out.println(digits[hours % 10][row] + " " + asteriskValue + " " + digits[minutes / 10][row] + " " + digits[minutes % 10][row]);
           }

           
        }

    }
    static final int SNOOZE_TIME=9;
    static int numSnoozes;

    // Setup constraints from the problem statement
    public static void main(String[] args) throws Exception {

	String[] clock = new String[3];
        time clockTime;

        // Create a new scanner
        Scanner sin = new Scanner(new File("snooze.dat"));

        // Get the number of data sets
        int numSets = sin.nextInt(); 
        sin.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            // Get the initial time
            for(int i = 0; i < 3; i++)
               clock[i] = sin.nextLine();

            clockTime = new time(clock);
            numSnoozes = sin.nextInt();
            sin.nextLine();
            clockTime.add(numSnoozes * SNOOZE_TIME);
            clockTime.display();
        }
        sin.close();
    }
}
