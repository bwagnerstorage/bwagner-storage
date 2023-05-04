package org.bwagner;

import java.io.Serializable; // needed to save to data file as an object

/*
   This class stores each player’s name, classification(9, 10, 11, 12),
   and weight max for each of the four exercises: bench, squat, incline,  
   and power clean.
*/

public class Player implements Serializable
{
    // instance variables
    private String name;
    private int benchMax;
    private int squatMax;
    private int inclineMax;
    private int powerMax;
    private int classification;
    
    // constructors    
    public Player()
    {
        name = "";
        benchMax = 0;
        squatMax = 0;
        inclineMax = 0;
        powerMax = 0;
        classification = 9;
    }
    
    public Player(String n, int b, int s, int i, int p, int c)
    {
        name = n;
        benchMax = b;
        squatMax = s;
        inclineMax = i;
        powerMax = p;
        classification = c;
    }
    
    // accessor methods 
    public String getName()
    {
        return name;
    }
    
    public int getBenchMax()
    {
        return benchMax;
    }
    
    public int getSquatMax()
    {
        return squatMax;
    }
        
    public int getInclineMax()
    {
        return inclineMax;
    }
            
    public int getPowerMax()
    {
        return powerMax;
    }
    
    public int getClassification()
    {
        return classification;
    }
    
    // mutator method
    public void setName(String n)
    {
        name = n;
    }
    
    public void setBenchMax(int b)
    {
        benchMax = b;
    }
    
    public void setSquatMax(int s)
    {
        squatMax = s;
    }
        
    public void setInclineMax(int i)
    {
        inclineMax = i;
    }
    
    public void setPowerMax(int p)
    {
        powerMax = p;
    }
    
    public void setClassification(int c)
    {
        classification = c;
    }
    
    // toString
    @Override
    public String toString()
    {
        return String.format("%-17s%4s%n%-17s%4s%n%-17s%4d%n%-17s%4d%n%-17s%4d%n%-17s%4d",
                      "Name:", name,
                      "Classification:", classification,
                      "Bench Max:", benchMax, 
                      "Squat Max:", squatMax,  
                      "Incline Max:", inclineMax, 
                      "Power Clean Max:", powerMax);
    }
}
