import java.util.*;
import java.io.*;

public class Kinga 
{
    int col;
    
    public Kinga() throws IOException
    {
        Scanner input = new Scanner(new File("kinga.dat"));
        
        while(input.hasNextInt())
        {
            col = input.nextInt();
            displayHeading(col);
            for(int i = 0; i < Math.pow(2, col); i++)
            {
                System.out.print((i+1) + " ");
                String binary =  Integer.toBinaryString(i);
                while(binary.length() < col)
                {
                    binary = "0" + binary;
                }
                
                    for(int j = 0; j < binary.length(); j++)
                    {
                        if(j < binary.length() - 1)
                            System.out.print(binary.substring(j, j+1) + "|"); 
                        else
                            System.out.println(binary.substring(j, j+1));
                    }
                
            }
            System.out.println("=====");
        }
    }
    
    public void displayHeading(int num)
    {
        System.out.print("  ");
        for(int i = 65; i < 65+num; i++)
        {
            if(i < 65+num-1)
                System.out.print((char)i + "|");
            else
                System.out.println((char)i);
        }
        
    }
    
    public static void main(String[] args) throws IOException
    {
        new Kinga();
    }
}
