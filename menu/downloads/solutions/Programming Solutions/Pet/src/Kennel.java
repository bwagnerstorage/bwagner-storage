import java.util.ArrayList;

public class Kennel
{
    private ArrayList <Pet> petList;

    public Kennel() 
    { 
       petList = new ArrayList<> (); 
    }
    public void add(Pet pet)
    { 
       petList.add(pet);
    }

    // A-2, (c)

    public void allSpeak()
    {

    }

    public static void main(String[] args)
    {
      Kennel kennel = new Kennel();
      kennel.add(new Dog("Maddie"));
      kennel.add(new Cat("Tommy"));
      kennel.add(new LoudDog("Barker"));
      kennel.allSpeak();
    }
}

