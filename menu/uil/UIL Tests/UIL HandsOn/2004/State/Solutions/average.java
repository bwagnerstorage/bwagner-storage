
/**
 * Write a description of class average here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class average
{

    public static void main(String[] args)
    {
        UILFileReader input = new UILFileReader("average.dat");
        int numStudents, totalStudents;
        int i, j;
        boolean found, swap;

        String name;
        int score;
        Student temp;
        Student students[] = new Student[100];

        input.readInt();
        
        while( input.ready() )
        {
            totalStudents = 0;
            numStudents = input.readInt();
            for (i = 0; i < numStudents; i++)
            {
                name = input.readWord();
                score = input.readInt();
                
                for (j = 0, found = false; j < totalStudents && !found; j++)
                {
                    if (students[j].equals(name))
                    {
                       found = true;
                       students[j].addScore(score);
                    }
                }
                
                if (!found)
                {
                   students[totalStudents++] = new Student(name, score);
                }
            }
            
            do
            {
                swap = false;
                for (i = 0; i < totalStudents - 1; i++)
                {
                    if (students[i].name.compareTo(students[i+1].name) > 0)
                    {
                        swap = true;
                        temp = students[i];
                        students[i] = students[i+1];
                        students[i+1] = temp;
                    }
                }
            }
            while (swap);
            
            System.out.println(totalStudents + " students");
            for (i = 0; i < totalStudents; i++)
               System.out.println(students[i].name + " " + students[i].letterGrade());
        }
    }
}

class Student
{
     String name;
     int totalScore;
     int numScores;
 
     public Student(String theName, int theScore)
     {
         name = theName;
         totalScore = theScore;
         numScores = 1;
     }
     
     public char letterGrade()
     {
         int average;
         
         average = totalScore / numScores;
         
         if (average < 60)
            return 'F';
         if (average < 73)
            return 'D';
         if (average < 83)
            return 'C';
         if (average < 93)
            return 'B';
         return 'A';
     }
     
     boolean equals(String theName)
     {
         if (name.equals(theName))
            return true;
         return false;
     }
     
     void addScore(int score)
     {
         totalScore += score;
         numScores++;
     }
}

