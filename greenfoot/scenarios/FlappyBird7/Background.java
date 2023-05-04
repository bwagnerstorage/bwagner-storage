import greenfoot.*;

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    final int SCROLL_SPEED = -1;

    public void act() 
    {
         setLocation(getX() + SCROLL_SPEED, getY());
    }    
}
