package Problem1;

import java.util.*;

public class Students
{
   // Instance Variables
   private StudentInfo[] studentArray;    // an array of Student information
   private int numStudents;	              // number of Students enterded into array
   
   // Constructor
   public Students()
   {
   	  studentArray = new StudentInfo[50];  // array size = 50
   	  numStudents = 0;                     // number of students in array = 0
   }
   
   //------------------------//
   //    GetInfo Method      //
   //------------------------//
   public void GetInfo()
   {
   	  Scanner keyboard = new Scanner(System.in);

   	  System.out.println("===================");
   	  System.out.println("      GetInfo      ");
   	  System.out.println("===================");
   	  System.out.println();
   	  
   	  
   	  
   	  
   	  
   	  	     
   }
   
   //------------------------//
   //    PrintInfo Method    //
   //------------------------//
   public void PrintInfo()
   {
   	  System.out.println();
   	  System.out.println("===================");
   	  System.out.println("     PrintInfo     ");
   	  System.out.println("===================");
   	  System.out.println();

   	  
   	  
   	  
   	  
   	  
   }
   
   	public static void main(String[] args)
	{
	   Students students = new Students();
	   students.GetInfo();
	   students.PrintInfo();	
	}
}