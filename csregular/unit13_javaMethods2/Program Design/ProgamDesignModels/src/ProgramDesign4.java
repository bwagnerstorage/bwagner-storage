// Functional Programming
// No state variables

import java.util.*;

public class ProgramDesign4
{
    // Input
    public static double[] inputNineWeekAvgs() // void method
    {
        Scanner keyboard = new Scanner(System.in);
        double[] nineWeekAvgs = new double[2];
        
        System.out.print("Enter 1st 9 Weeks Average -->");
        nineWeekAvgs[0] = keyboard.nextDouble();
        
        System.out.print("Enter 2nd 9 Weeks Average -->");
        nineWeekAvgs[1] = keyboard.nextDouble();
        
        System.out.println();
        
        return nineWeekAvgs;
    }
    
    public static double inputSemesterExam()
    {
        Scanner keyboard = new Scanner(System.in);
        double semesterExam = 0;
        
        System.out.print("Enter Semester Exam Grade -->");
        semesterExam = keyboard.nextDouble();
        
        System.out.println();
        
        return semesterExam;
    }
    
    // Processing
    public static double calculateSemesterAvg(double[] avgs, double semesterExam) // nonVoid method
    {
       double avgNineWeeks = (avgs[0] + avgs[1]) / 2;
       return avgNineWeeks * 0.8 + semesterExam * 0.2;
    }
    
    // Output
    public static void displayResults(double[] avgs, double semesterExam)  // void method
    {
        System.out.println();
        System.out.println("1st Nine Weeks Average = " + avgs[0]);
        System.out.println("2nd Nine Weeks Average = " + avgs[1]);
        System.out.println("Semester Exam Grade    = " + semesterExam);
        System.out.println("------------------------------------");
        System.out.println("Semester Average       = " + calculateSemesterAvg(avgs, semesterExam));
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        displayResults(inputNineWeekAvgs(), inputSemesterExam());
    }
}