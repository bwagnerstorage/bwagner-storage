import java.util.*;

public class SpellCheckerTest
{
    private SpellChecker checker;

    public SpellCheckerTest()
    {
        Scanner keyboard = new Scanner(System.in);
        checker = new SpellChecker();

        while(true)
        {
            System.out.println("Spelling Checker");
            System.out.println("----------------");
            System.out.print("Enter word-->");
            String word = keyboard.nextLine();
            if(checker.search(word))
            {
                    System.out.println(word + " is spelled correctly!");
            }
            else
            {
                    System.out.println(word + " is spelled incorrectly!");
            }	
            System.out.println();	
        }
    }
    public static void main(String[] args)
    {
        SpellCheckerTest app = new SpellCheckerTest();
    }
}