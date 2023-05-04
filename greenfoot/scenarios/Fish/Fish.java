import greenfoot.*;

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    private int speed = 1;
   
    public void act() 
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + speed, getY());
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed, getY());
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            getImage().mirrorHorizontally();
        }
    }    
}
