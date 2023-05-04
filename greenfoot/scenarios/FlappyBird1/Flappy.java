import greenfoot.*;

/**
 * Write a description of class Flappy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flappy extends Actor
{
    double dy = 0;                      // vertical velocity
    double g = .4;                      // gravity
    final double BOOST_SPEED = -7;      // vertical lift
    
    public void act() 
    {
        fly();
        
        if(getY() > getWorld().getHeight())   // fallen off bottom
           displayGameOver();     
    }
    
    public void fly()
    {
        setLocation(getX(), (int)(getY() + dy));   // update position
        
        if(Greenfoot.isKeyDown("up") == true)
        {
            dy = BOOST_SPEED;                      // provide lift
        }
        
        dy = dy + g;                               // apply gravity
    }
    
    public void displayGameOver()
    {

    }
}
