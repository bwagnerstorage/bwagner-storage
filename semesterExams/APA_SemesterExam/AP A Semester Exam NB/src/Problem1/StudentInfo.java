package Problem1;

public class StudentInfo
{
	// Instance Variables
	private String lastName;
	private String firstName;
	private String id;
	private String address;
	private String phone;
	
	// Default Constructor
	public StudentInfo()
	{
	   this("","","","","");
    }
    
    // Second Constructor
    public StudentInfo(String l, String f, String i, String a, String p)
    {
    	lastName = l;
    	firstName = f;
    	id = i;
    	address = a;
    	phone = p;
    }
    
    //-------------------------//
    //    Accessor methods     //
    //-------------------------//
    public String getLastName()
    {
    	return lastName;
    }
    public String getFirstName()
    {
    	return firstName;
    }
    public String getId()
    {
    	return id;
    }
    public String getAddress()
    {
    	return address;
    }
    public String getPhone()
    {
    	return phone;
    }
    
    //-----------------------//
    //     Mutator methods   //
    //-----------------------//
    public void setLastName(String l)
    {
    	lastName = l;
    }
    public void setFirstName(String f)
    {
    	firstName = f;
    }
    public void setId(String i)
    {
    	id = i;
    }
    public void setAddress(String a)
    {
    	address = a;
    }
    public void setPhone(String p)
    {
    	phone = p;
    }
    
    //-------------------------//
    //    toString Method      //
    //-------------------------//
    public String toString()
    {
    	String str;
    	str = "Last Name  : " + lastName + "\n" +
    	      "First Name : " + firstName + "\n" +
    	      "ID #       : " + id + "\n" +
    	      "Address    : " + address + "\n" +
    	      "Phone      : " + phone;
    	return str;
    }
}