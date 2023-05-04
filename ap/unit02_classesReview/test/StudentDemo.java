class Student
{
   private String name;

   public Student(String n)
   {
      name = n;
   }

   public String getName()
   {
   	  return name;
   }

   public void setName(String n)
   {
   	  name = n;
   }

   public String toString()
   {
   	  return "Student name = " + name +"\n";
   }
}



public class StudentDemo
{
	public static void main(String[] args)
	{
		Student s1 = new Student();
		System.out.println(s1);
		Student s2 = new Student("Bob");
		System.out.println(s2);
	}
}

