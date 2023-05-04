// Object-oriented Programming (Final Goal)

import java.util.*;

public class ProgramDesign5     // Managing/Driver class
{
    // Variables
    private Student student;   // declare Student object
    
    // Input
    public void inputGrades() // void method
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter 1st 9 Weeks Average -->");
        double nineWeek1 = keyboard.nextDouble();
        
        System.out.print("Enter 2nd 9 Weeks Average -->");
        double nineWeek2 = keyboard.nextDouble();
        
        System.out.print("Enter Semester Exam -->");
        double semesterExam = keyboard.nextDouble();
        
        System.out.println();
        
        // create Student object, give initial state
        student = new Student(nineWeek1, nineWeek2, semesterExam); 
    }
    
    // Output
    public void displayResults()  // void method
    {
        System.out.println();
        System.out.println("1st Nine Weeks Average = " + student.getNineWeek1());
        System.out.println("2nd Nine Weeks Average = " + student.getNineWeek1());
        System.out.println("Semester Exam Grade    = " + student.getSemesterExam());
        System.out.println("------------------------------------");
        System.out.println("Semester Average       = " + student.calculateSemesterAvg());
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        ProgramDesign5 app = new ProgramDesign5();    /// create object
        app.inputGrades();                            // call methods
        app.displayResults();
    }
}