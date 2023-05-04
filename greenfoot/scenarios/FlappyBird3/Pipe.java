import greenfoot.*;

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends Actor
{
    final int PIPE_SPEED = -4;

    public void act() 
    {
        setLocation(getX() + PIPE_SPEED, getY());
    }     
}
