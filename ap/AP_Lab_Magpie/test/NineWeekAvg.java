import java.util.*;

public class NineWeekAvg
{
	// Instance Variables (global scope)
	Scanner keyboard = new Scanner(System.in);
	private int test1;
	private int test2;
	private int test3;
	private int quiz1;
	private int quiz2;
	private int quiz3;
	private int quiz4;
	private double majorGradeAvg;
	private double minorGradeAvg;
	private double nineWeekAvg;

	// User-Defined Methods
	public void inputMajorGrades()
	{
		System.out.println("/************************/");
		System.out.println("/*   inputMajorGrades   */");
		System.out.println("/************************/");
		System.out.println();
		System.out.print("Enter Test 1 -->");
		test1 = keyboard.nextInt();
		System.out.print("Enter Test 2 -->");
		test2 = keyboard.nextInt();
		System.out.print("Enter Test 3 -->");
		test3 = keyboard.nextInt();
		System.out.println();
	}

	public void inputMinorGrades()
	{
		System.out.println("/************************/");
		System.out.println("/*   inputMinorGrades   */");
		System.out.println("/************************/");
		System.out.println();
	}

	public void calculateAvg()
	{
		System.out.println("/************************/");
		System.out.println("/*     calculateAvg     */");
		System.out.println("/************************/");
		System.out.println();
	}

	public void printResults()
	{
		System.out.println("/************************/");
		System.out.println("/*     printResults     */");
		System.out.println("/************************/");
		System.out.println();
	}

	public static void main(String[] args)
	{
		NineWeekAvg app = new NineWeekAvg();

		app.inputMajorGrades();
		app.inputMinorGrades();
		app.calculateAvg();
		app.printResults();
	}
}