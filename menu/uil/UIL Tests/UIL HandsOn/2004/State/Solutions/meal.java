import java.lang.*;
import java.io.*;

/**
 * @author James Goodwin
 * @version 1.0
 */
public class meal
{
    public static void main(String args[])
    {
        int datasets;
        
        UILFileReader input = new UILFileReader("meal.dat");
        
        datasets = input.readInt();

        // Process all the data sets
        for (int i = 0; i < datasets; i++)
        {
            int nfoods;
            int fat, salt, sugar, caffiene;
            
            // Read the number of lines
            nfoods = input.readInt();
            
            // Initialize the food groups
            fat = salt = sugar = caffiene = 0;
            
            // Process the foods
            for (int j = 0; j < nfoods; j++)
            {
                String fname;
                
                // Read the food name
                fname = input.readLine();
                
                // Mark the appropriate food group
                if (fname.toLowerCase().matches("[a-z\\s]*soda[a-z\\s]*") ||
                    fname.toLowerCase().matches("[a-z\\s]*coffee[a-z\\s]*"))
                    caffiene++;
                if (fname.toLowerCase().matches("[a-z\\s]*cake[a-z\\s]*") ||
                    fname.toLowerCase().matches("[a-z\\s]*candy[a-z\\s]*"))
                    sugar++;
                if (fname.toLowerCase().matches("[a-z\\s]*chips[a-z\\s]*") ||
                    fname.toLowerCase().matches("[a-z\\s]*popcorn[a-z\\s]*"))
                    salt++;
                if (fname.toLowerCase().matches("[a-z\\s]*burger[a-z\\s]*") ||
                    fname.toLowerCase().matches("[a-z\\s]*pizza[a-z\\s]*"))
                    fat++;
            }
            
            // Print the results
            if (caffiene * sugar * salt * fat > 0 &&
                caffiene < 3 && sugar < 3 && salt < 3 && fat < 3)
            {
                System.out.println("Programmer Fuel");
            }
            else
            {
                System.out.println("What would your mom say?");
            }
        }
    }
}
