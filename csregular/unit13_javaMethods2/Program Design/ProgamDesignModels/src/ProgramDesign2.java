// Object-oriented Programming

import java.util.*;

public class ProgramDesign2
{
    // Instane Variables (State)
    Scanner keyboard = new Scanner(System.in);
    double nineWeek1 = 0;
    double nineWeek2 = 0;
    double semesterExam = 0;
    
    // Input
    public void inputGrades() // void method
    {
        System.out.print("Enter 1st 9 Weeks Average -->");
        nineWeek1 = keyboard.nextDouble();
        
        System.out.print("Enter 2nd 9 Weeks Average -->");
        nineWeek2 = keyboard.nextDouble();
        
        System.out.print("Enter Semester Exam -->");
        semesterExam = keyboard.nextDouble();
        
        System.out.println();
    }
    
    // Processing
    public double calculateSemesterAvg() // nonVoid method
    {
       double avgNineWeeks = (nineWeek1 + nineWeek2) / 2;
       return avgNineWeeks * 0.8 + semesterExam * 0.2;
    }
    
    // Output
    public void displayResults()  // void method
    {
        System.out.println();
        System.out.println("1st Nine Weeks Average = " + nineWeek1);
        System.out.println("2nd Nine Weeks Average = " + nineWeek2);
        System.out.println("Semester Exam Grade    = " + semesterExam);
        System.out.println("------------------------------------");
        System.out.println("Semester Average       = " + calculateSemesterAvg());
    }
    
    public static void main(String[] args)
    {
        ProgramDesign2 app = new ProgramDesign2();    /// create object
        app.inputGrades();                            // object calls methods
        app.calculateSemesterAvg();
        app.displayResults();
    }
}