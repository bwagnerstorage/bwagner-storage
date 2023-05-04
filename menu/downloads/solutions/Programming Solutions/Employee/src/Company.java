import java.util.*;

public class Company 
{ 
   private ArrayList <Employee> empList;    // all employees in this company
   private int retireAge;        // minimum age to retire
   private int retireYears;      // minimum years on job to retire
   private int retireSalary;     // minimum salary to retire
   private double salaryBudget;
   
   public Company(int age, int years, int salary)
   {
        empList = new ArrayList<>();
        retireAge = age;
        retireYears = years;
        retireSalary = salary;
   }
   
   // postcondition: returns true if emp is eligible to retire;
   // otherwise, returns false
   private boolean employeeIsEligible(Employee emp) 
   { 
      
      
   }

   // postcondition: all retirement-eligible employees have been 
   // removed from empList;
   // empList remains sorted by employee ID;
   // salaryBudget has been updated to reflect remaining
   // employees
   public void processRetirements() 
   { 

   
   }

   public void addEmployee(Employee emp)
   {
        empList.add(emp);
        salaryBudget += emp.getSalary();
   }
   
   public void printList()
   {
        for(Employee e : empList)
        {
            System.out.printf("%-5d",e.getID());
            System.out.printf("%-5d",e.getAge());
            System.out.printf("%-5d",e.getYearsOnJob());
            System.out.printf("%9.2f",e.getSalary());
            System.out.println();
        }
        System.out.println();
        System.out.println("Salary Budget = " + salaryBudget);
        System.out.println();
   }
}