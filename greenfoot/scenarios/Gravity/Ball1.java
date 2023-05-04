import greenfoot.*;

/**
 * Write a description of class Ball1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball1 extends Actor
{
    private int dy = 2;     // vertical velocity
    
    public void act() 
    {
        setLocation(getX(), getY() + dy);   // linear motion
    }    
}
