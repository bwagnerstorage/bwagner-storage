import greenfoot.*;

/**
 * Write a description of class Ball2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball2 extends Actor
{
    private int dy = 0;
    private int gravity = 1;
    
    public void act() 
    {
        setLocation(getX(), getY() + dy);
        dy = dy + gravity;
    }    
}
