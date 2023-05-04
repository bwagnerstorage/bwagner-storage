import java.util.*;
import java.io.*;

public class SpellChecker
{
    public static final int TABLE_SIZE = 100000;   // 104217 words in list
    private Scanner infile;
    private ListNode[] hashTable;

    public SpellChecker()
    {
        hashTable = new ListNode[TABLE_SIZE];
        try
        {
            infile = new Scanner(new File("spellcheck.txt"));
        }
        catch(IOException e)
        {
            System.out.println("I/O Error");
        }
        populateTable();
        infile.close();
    }

    // The hash function
    // Returns a valid index within the range of arrays indices
    public int hashCode(String key)
    {
        int sum = 0;
        for(int i=0; i < key.length(); i++) 
        {
           sum += (int)key.charAt(i);	
        }
        return sum % TABLE_SIZE;
    }

    // Populates the hash table with words retrieved from a text file
    public void populateTable()
    {
       while(infile.hasNext())
       {
            String word = infile.next();
            add(word);
       }
    }

    // Calculates the hash value for word then adds word to the hash table
    // Uses chaining to resolve collisions
    public void add(String word)
    {


    }

    // Searches the hash table for key
    // If key is found it returns true;
    //    otherwise it returns false
    public boolean search(String key)
    {


    }

    public static void main(String[] args)
    {
        SpellChecker app = new SpellChecker();
    }
}