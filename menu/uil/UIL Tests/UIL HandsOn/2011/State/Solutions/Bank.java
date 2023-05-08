import java.io.*;
import java.util.Scanner;

public class Bank
{
    public static void main(String args[]) throws IOException
    {
        double balance = 0.0;
        long month = 1;
        long year = 1;
        
        // Parse each line in the file
        Scanner kb = new Scanner(new File("bank.dat"));
        
        boolean bFirstLine = true;
        while (kb.hasNextLine())
        {
            String line = kb.nextLine();
            
            // Get the date and amount data from the line
            String[] dateAndAmount = line.split(" ");
            double amount = Double.parseDouble(dateAndAmount[1]);
            String[] dateComponents = dateAndAmount[0].split("-");
            
            if (bFirstLine)
            {
                bFirstLine = false;
                
                // Just store the year, month on first deposit
                year = Long.parseLong(dateComponents[0]);
                month = Long.parseLong(dateComponents[1]);
            }
            else
            {
                // Get what the new year and month are for the entry
                long newYear = Long.parseLong(dateComponents[0]);
                long newMonth = Long.parseLong(dateComponents[1]);

                // If we wrap years or months we need to add interest
                long monthsOfInterest = 0;
                
                // For every year we'll add 12 months. The month check will
                // correct any difference
                monthsOfInterest += 12 * Math.abs(newYear - year);
                
                // If the months are different we add the difference (including
                // negative to counter-act the month assumption above)
                monthsOfInterest += (newMonth - month);
                
                // Add interest
                for (long i = 0; i < monthsOfInterest; ++i)
                {
                    balance += (balance * 0.02);
                }
                
                // Store new year and month
                year = newYear;
                month = newMonth;
            }
            
            // Add the amount to the balance
            balance += amount;
        }
        
        System.out.printf("$%.2f", (long)(balance * 100.0) / 100.0);
    }
}
