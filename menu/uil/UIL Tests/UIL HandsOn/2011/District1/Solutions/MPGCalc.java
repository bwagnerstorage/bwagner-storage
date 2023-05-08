import java.io.*;
import java.util.*;


public class MPGCalc
{
    private class MPGCategory
    {
        // Structs would be awesome
        private class MPGCategoryEntry
        {
            public long miles = 0;
            public double gallons = 0.0f;
        }
        
        
        // Member variables
        private ArrayList<MPGCategoryEntry> mMPGs;
        
        
        // Constructor
        public MPGCategory()
        {
            mMPGs = new ArrayList<MPGCategoryEntry>();
        }
        
        // Adds an entry to the category
        public void addEntry(long miles, double gallons)
        {
            if ((long)0 == miles || 0.0 == gallons)
            {
                return;
            }
            
            MPGCategoryEntry entry = new MPGCategoryEntry();
            entry.miles = miles;
            entry.gallons = gallons;
            mMPGs.add(entry);
        }
        
        // Returns the MPG for the category
        public double getMPG()
        {
            double mpg = 0.0;
            if (mMPGs.size() > 0)
            {
                Long count = (long) 0;
                double gallonsTotal = 0.0;
                
                for (int i = 0; i < mMPGs.size(); ++i)
                {
                    Long miles = mMPGs.get(i).miles;
                    count += miles;
                    gallonsTotal += mMPGs.get(i).gallons;
                }
                
                mpg = count.doubleValue() / gallonsTotal;
            }
            
            return mpg;
        }
    }
    
    
    // Member variables
    private HashMap<String, MPGCategory> mEntries = new HashMap<String, MPGCategory>();
    private long mLongestCategory = 0;
    
    
    // Parses the data file and stores the data
    public void parseFile() throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("mpgcalc.dat"));
        
        long lastMileage = 0;
        boolean bFirstLine = true;
        while (kb.hasNextLine())
        {
            // Create a category if one doens't exist
            String[] strItems = kb.nextLine().split(" ");
            
            // The only data we can get from the first line is a category name
            // and starting mileage
            if (bFirstLine)
            {
                bFirstLine = false;
                lastMileage = Long.parseLong(strItems[0]);
            }
            else
            {
                if (!mEntries.containsKey(strItems[2]))
                {
                    MPGCategory category = new MPGCalc.MPGCategory();
                    mEntries.put(strItems[2], category);
                    
                    mLongestCategory = java.lang.Math.max(mLongestCategory, strItems[2].length());
                }
                
                // Add the data to the proper category
                MPGCategory category = mEntries.get(strItems[2]);
                
                // The miles traveled is the difference between the last and current
                long currentMileage = Long.parseLong(strItems[0]);
                category.addEntry(currentMileage - lastMileage, Double.parseDouble(strItems[1]));
                
                // Last is now current
                lastMileage = currentMileage;
            }
        }
    }
    
    // Prints the information to the console
    public void printData()
    {
        // Get the list of category names and alphabetize them
        Set<String> namesSet = mEntries.keySet();
        Object[] names = namesSet.toArray();
        Arrays.sort(names);

        for (int s = 0; s < names.length; ++s)
        {
            String name = (String) names[s];
            System.out.print(name);
            
            // Guarantee vertical alignment regardless of the length of category
            // names
            for (int i = 0; i < mLongestCategory - name.length() + 4; ++i)
            {
                System.out.print(" ");
            }
            
            MPGCategory category = mEntries.get(name);
            System.out.format("%.1f", category.getMPG());
            System.out.println();
        }
    }
    
    
    public static void main(String args[]) throws IOException
    {
        // The class does all the work so just call into it
        MPGCalc calc = new MPGCalc();
        calc.parseFile();
        calc.printData();
    }

}
