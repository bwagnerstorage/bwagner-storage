public class Student
{
    // instance variables
    private double nineWeeks1;
    private double nineWeeks2;
    private double semesterExam;
    
    // constructor
    public Student(double nineWeeks1, double nineWeeks2, double semesterExam)
    {
        this.nineWeeks1 = nineWeeks1;
        this.nineWeeks2 = nineWeeks2;
        this.semesterExam = semesterExam;
    }
    
    // calculation
    public double calculateSemesterAvg()
    {
        double nineWeekAvg = (nineWeeks1 + nineWeeks2);
        return nineWeekAvg * 0.8 + semesterExam * 0.2;
    }
    
    // accessor methods
    public double getNineWeek1()
    {
        return nineWeeks1;
    }
    
    public double getNineWeeks2()
    {
        return nineWeeks2;
    }
    
    public double getSemesterExam()
    {
        return semesterExam;
    }
    
    // mutator methods
    public void setNineWeek1(double avg)
    {
        nineWeeks1 = avg;
    }
    
    public void setNineWeek2(double avg)
    {
        nineWeeks2 = avg;
    }
    
    public void setSemesterExam(double exam)
    {
        semesterExam = exam;
    }
}