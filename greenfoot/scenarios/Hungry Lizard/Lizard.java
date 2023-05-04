import greenfoot.*;

/**
 * Write a description of class Lizard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lizard extends Actor
{
    //constants
    private final int SPEED = 2;
    private final int SPIN_SPEED = 10;
    
    //variables
    private int spinCounter = 0;
    
    public void act() 
    {

        
    }    
    
    public void spinLizard()
    {
        if(spinCounter <= 360 / SPIN_SPEED)  // keep spinning until complete revolution
        {
            setRotation(getRotation() + SPIN_SPEED);   // spin a little bit
            if(getRotation() == 360)
                setRotation(0);
            spinCounter++;    // spinCounter keeps track of far lizard has spinned so far
        }
        else   // after making complete revolution -- eat fly
        {
            removeTouching(Fly.class);    // remove fly you area currently touching
            spinCounter = 0;              // reset spincounter
        }
    }
    
    public void moveLizard()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + SPEED, getY());
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - SPEED, getY());
            setRotation(180);
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - SPEED);
            setRotation(270);
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + SPEED);
            setRotation(90);
        }
    }
         
}
