import greenfoot.*;

/**
 * Write a description of class Ball5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball5 extends Actor
{
    private double initialVelocity = -10;   // negative is up
    private double dy = initialVelocity;
    private double gravity = .3;
    private double dx = 7.4;
    
    public void act() 
    {
        setLocation((int)(getX() + dx), (int)(getY() + dy));
        dy = dy + gravity;
    }    
} 
