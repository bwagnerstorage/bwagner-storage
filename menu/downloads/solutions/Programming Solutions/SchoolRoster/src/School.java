import java.util.*;

// Topic: ArrayList
// Reference: AP A 1999 Question 1
// Difficulty: Easy

public class School
{
	public static void main(String[] args)
	{
		SchoolRoster roster = new SchoolRoster();
		
		System.out.println(roster);
		System.out.println();
		
		roster.computeGPA();
		
	    System.out.println(roster);
		System.out.println();
		
		ArrayList list = roster.fillSeniorList();
		
		System.out.println(list);
		System.out.println();
	}
}