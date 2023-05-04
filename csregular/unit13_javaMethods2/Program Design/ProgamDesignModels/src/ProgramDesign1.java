// Functional Programming

import java.util.*;

public class ProgramDesign1
{   
    public static void main(String[] args)
    {
        // Variables
        Scanner keyboard = new Scanner(System.in);
        double nineWeek1 = 0;
        double nineWeek2 = 0;
        double semesterExam = 0;
        double avgNineWeeks = 0;
        double semesterAvg = 0;
        
        // Input
        System.out.print("Enter 1st 9 Weeks Average -->");
        nineWeek1 = keyboard.nextDouble();
        
        System.out.print("Enter 2nd 9 Weeks Average -->");
        nineWeek2 = keyboard.nextDouble();
        
        System.out.print("Enter Semester Exam -->");
        semesterExam = keyboard.nextDouble();
       
        System.out.println();
        
        // Processing
        avgNineWeeks = (nineWeek1 + nineWeek2) / 2;
        semesterAvg = avgNineWeeks * 0.8 + semesterExam * 0.2;
        
        // Output
        System.out.println();
        System.out.println("1st Nine Weeks Average = " + nineWeek1);
        System.out.println("2nd Nine Weeks Average = " + nineWeek2);
        System.out.println("Semester Exam Grade    = " + semesterExam);
        System.out.println("------------------------------------");
        System.out.println("Semester Average       = " + semesterAvg);
        System.out.println();
    }
}