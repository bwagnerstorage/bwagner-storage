import greenfoot.*;

/**
 * Write a description of class Ball4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball4 extends Actor
{
    private int initialVelocity = -25;   // negative is up
    private int dy = initialVelocity;
    private int gravity = 1;
    private int dx = 10;
    
    public void act() 
    {
        setLocation(getX() + dx, getY() + dy);
        dy = dy + gravity;
    }    
} 
