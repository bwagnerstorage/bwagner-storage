
public class Friend implements Comparable
{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String birthdate;
    
    //constructor
    public Friend(String firstName, String lastName, String phoneNumber, String birthdate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
    }
    
    // Accessor Methods
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public String getBirthdate()
    {
        return birthdate;
    }
    
    // Mutator Methods
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public void setBirthdate(String birthdate)
    {
        this.birthdate = birthdate;
    }
    
    // toString Method
    public String toString()
    {
        return lastName + ", " + firstName + ", " + phoneNumber + ", " + birthdate;
    }
    
    // The compareTo method first attempts to compare two Friend objects by their
    // last names. If they are equal to each other, then they are compared again using
    // their first names and the result of the comparison is returned. If their last 
    // names are not equal, the result of the first comparison is returned. The last
    // names and first names are compared using the String classes implementation of
    // the compareTo method.
    public int compareTo(Object obj)
    {
        Friend friend = (Friend)obj;      // cast obj to a Friend object
        int result = this.lastName.compareTo(friend.lastName);
        if(result == 0)
        {
            return this.firstName.compareTo(friend.firstName);
        }
        else
            return result;
    }
}
