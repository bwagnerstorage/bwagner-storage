import java.util.*;

// Topic: ArrayList
// Reference: AP A 2003 Free Response Question 2

public class Company
{
	// constants
	public static final int RETIRE_AGE = 65;          // minimum age to retire
	public static final int RETIRE_YEARS = 20;        // minimum years on job to retire
	public static final double RETIRE_SALARY = 50000; // minimum salary to retire

	// instance variables
	private ArrayList<Employee> empList;
	// empList.size() is the number of employees in this company
	private double salaryBudget; // total salary of all employees

	public Company()
	{
		empList = new ArrayList <Employee>();
		empList.add(new Employee(40, 18, 48000, 1));
		empList.add(new Employee(65, 15, 52000, 2));
		empList.add(new Employee(27, 04, 30000, 3));
		empList.add(new Employee(65, 22, 60000, 4));
		empList.add(new Employee(67, 20, 70000, 5));
		empList.add(new Employee(45, 21, 50000, 6));
		empList.add(new Employee(33, 10, 40000, 7));
		empList.add(new Employee(66, 23, 51000, 8));

		// update salaryBudget
		for(Employee emp : empList)
		{
			salaryBudget += emp.getSalary();
		}
	}

	// postcondition: returns true if emp is eligible to retire;
	//                otherwise, returns false
	//                An employee is eligible for retirement if (s)he
	//                meets at least two of the requirements.
	private boolean employeeIsEligible(Employee emp)
	{


	}

	// postcondition: all retirement-eligible employees have been
	//                removed from empList; empList has been resized
	//                to reflect retirements; empList remains sorted
	//                by employee ID; salaryBudget has been updated
	//                to reflect remaining employees
	public void processRetirements()
	{


	}

	public String toString()
	{
		String str="";
		for(int i=0; i < empList.size(); i++)
		{
		   str += empList.get(i).toString() + "\n";
		}
		str += "\nSalary Budget = " + salaryBudget;
		return str;
	}
}