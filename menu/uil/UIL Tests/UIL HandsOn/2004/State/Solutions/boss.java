///////////////////////////////
// File:        boss.java    //
// Programmer:  Marc Douet   //
// Date:        03/20/04     //
///////////////////////////////

import java.util.*;

public class boss
{
 
    public static UILFileReader  input = new UILFileReader("boss.dat");
    public static int            numBosses,
                                 numDataSets;
    public static BossMan[]      bosses;
        
   
    /*
     * Determine whether a person is the boss of another person.  This is
     * done by first checking if the employee is on the boss' list.  If this is
     * the case, then we return true.  If not, we try to find someone who is the
     * boss of the employee and determine if the boss we are looking for is the
     * boss of that person.  This is done by recursively calling ourselves
     * with the employee's boss as the employee and the boss we are searching
     * for as the boss.
     */
    public static boolean determinePeckingOrder(String employee, String boss)
    {
        /* 
         * BASE CASE:
         * If we are direct employees of the boss we are searching for, 
         * we are done so return true.
         */
        for(int bossIndex = 0; bossIndex < numBosses; bossIndex++)
        {
            if(bosses[bossIndex].name.equals(boss))
            {
                if(bosses[bossIndex].isBossOf(employee))
                {
                    return true;
                }
            }
        }
        
        /* 
         * Go through each boss/employee list and try to find someone
         * that is the boss of us.
         */
        for(int bossIndex = 0; bossIndex < numBosses; bossIndex++)
        {
            /* 
             * If this guy is our boss, recursively call ourselves to find out
             * if the boss we are searching for is the boss of this guy.
             * If he is, then the boss we are searching for must be our boss
             * as well, so return true.
             */
            if(bosses[bossIndex].isBossOf(employee))
            {
                if(determinePeckingOrder(bosses[bossIndex].name, boss))
                {
                    return true;
                }
            }
        }
        
        /*
         * If we got this far the boss we are searching for must not
         * be our boss, so return false.
         */
        return false;
    }
        
        
    public static void main(String[] args)
    {    
        while( input.ready())
        {          
            /* 
             * Read in the first line of input.
             */
            numBosses = Integer.parseInt(input.readWord());
            bosses = new BossMan[numBosses];
            
            /* 
             * For each boss/employee list, build a BossMan structure including
             * the boss' name, number of employees under him, and the list of
             * employees under him.
             */
            for(int bossIndex = 0; bossIndex < numBosses; bossIndex++)
            {
                int numEmployees = Integer.parseInt(input.readWord());
                String bossName = new String(input.readWord());
                bosses[bossIndex] = new BossMan(bossName, numEmployees);
            
                for(int employeeIndex = 0; employeeIndex < bosses[bossIndex].numEmployees; employeeIndex++)
                {
                    bosses[bossIndex].addEmployee(employeeIndex, input.readWord());
                }
            } 
            
            /*
             * Read in the number of data sets.
             */
            numDataSets = Integer.parseInt(input.readWord());
 
            /*
             * For every dataset, determine the pecking order of the employee and the boss
             * to see if the employee should listen to the boss or not.
             */
            for(int index = 0; index < numDataSets; index++)
            {
                int     bossIndex;
                String  employee = new String(input.readWord());
                String  boss = new String(input.readWord());
                
                if(determinePeckingOrder(employee, boss))
                {
                    System.out.println(employee + ": Sure " + boss + ", I'll get right on it.");
                } else {
                    System.out.println(employee + ": No " + boss + ", I don't have time to do your work and mine.");
                }
            }
        }
    }
}


/*
 * This class represents each boss and his list of employees.
 */
class BossMan {

    private String[]   employees;
    public String      name;
    public int         numEmployees;
    
    
    /*
     * BossMan consturctor that sets the name and number of
     * employees for this boss.
     */
    public BossMan(String bossName, int employeeCount)
    {
        name = new String(bossName);
        employees = new String[employeeCount];
        numEmployees = employeeCount;
    }
    
    
    /*
     * Adds an employee to this boss' employee list.
     */
    public void addEmployee(int employeeID, String employeeName)
    {
        employees[employeeID] = new String(employeeName);
    }
    
    
    /*
     * Determines whether an employee is on this boss' employee list.
     */
    public boolean isBossOf(String employeeName)
    {
        for(int employeeIndex = 0; employeeIndex < numEmployees; employeeIndex++)
        {
            if(employees[employeeIndex].equals(employeeName))
            {
                return true;
            }
        }
        
        return false;
    }
}