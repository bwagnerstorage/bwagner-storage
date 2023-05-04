import greenfoot.*;

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private int speed;
    
    // default constructor
    public Bomb()
    {
        speed = 0;
    }
    
    // another constructor
    public Bomb(int s)
    {
        speed = s;
    }
    
    public void act() 
    {
        setLocation(getX() + speed, getY() + 2);
        
        // remove alien after it moves across screen 
        if(getY() - getImage().getHeight() > getWorld().getHeight())
        {
            getWorld().removeObject(this);   // remove this alien from world
        }
    }    
}
