import java.util.*;

// Topic: ArrayList
// Reference: AP A 1999 Question 1
// Difficulty: Easy

public class SchoolRoster
{
	private ArrayList <StudentInfo> roster;
	// a list of students on the school's roster

	public SchoolRoster()
	{
		roster = new ArrayList <StudentInfo>();
		roster.add(new StudentInfo("King", 45, 171));
		roster.add(new StudentInfo("Norton", 128, 448));
		roster.add(new StudentInfo("Solo", 125, 350));
		roster.add(new StudentInfo("Kramden", 150, 150));
	}

	// precondition:  The name, creditHours and gradePoints
	//                data members have been initialized for each record in
	//                in roster.
	// postcondition: the GPA data member of each record in roster has
	//                been calculated.
	public void computeGPA()
	{


	}

	// postcondition: returns true if this student's credit
	//                hours >= 125 and GPA >= 2.0; otherwise,
	//                returns false.
	public boolean isSenior(StudentInfo student)
	{


	}
    // postcondition: determines which students in the roster are
	//                seniors and returns an ArrayList containing
	//                those records.
	public ArrayList <StudentInfo> fillSeniorList()
	{


	}

	public String toString()
	{
		String str="";
		for(int i=0; i < roster.size(); i++)
		{
			str += roster.get(i) + "\n";
		}

		return str;
	}
}