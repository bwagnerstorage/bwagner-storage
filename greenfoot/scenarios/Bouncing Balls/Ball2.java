import greenfoot.*;

/**
 * Write a description of class Ball2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball2 extends Actor
{
    private int vx = 3;      // horizontal velocity
    private int vy = 3;
    
    private int ballRadius = getImage().getWidth() / 2;
    
    public void act() 
    {
        setLocation(getX() + vx, getY());
        
        if(getX() <= ballRadius)    // at left edge of world
        {
            vx =  vx * -1;      // flip horizontal velocity (changes direction)
        }
        
        if(getX() >= getWorld().getWidth() - ballRadius)    // at right edge of world
        {
            vx =  vx * -1;     // flip horizontal velocity  (changes direction)
        }
    }    
}
