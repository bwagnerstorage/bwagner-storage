import greenfoot.*;

/**
 * Write a description of class Ball3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball3 extends Actor
{
    private double initialVelocity = -25;   // negative is up
    private int dy = (int)initialVelocity;
    private int gravity = 1;
    
    public void act() 
    {
        setLocation(getX(), getY() + dy);
        dy = dy + gravity;
       
    }    
}
