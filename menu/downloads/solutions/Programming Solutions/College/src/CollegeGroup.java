import java.util.*;

public class CollegeGroup 
{ 
    private ArrayList <College> myColleges;

    public CollegeGroup()
    {
        myColleges = new ArrayList<>();
    }

    // precondition:  collegeName exists in this CollegeGroup 
    // postcondition: tuition for collegeName is changed to newTuition 
    public void updateTuition(String collegeName, int newTuition) 
    { 


    }

    // precondition:  low <= high 
    // postcondition: returns an ArrayList of colleges in region 
    // where low <= tuition <= high;
    public ArrayList <College> getCollegeList(String region, int low, int high) 
    { 


    }

    public void addCollege(College c)
    {
        myColleges.add(c);
    }

    public ArrayList <College> getColleges()
    {
        return myColleges;
    }

}