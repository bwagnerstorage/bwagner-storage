import greenfoot.*;

/**
 * Write a description of class ForceField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForceField extends Actor
{
    double domeTime = 0;  // dome active for 10 seconds
    
    public ForceField()
    {
        double currentTime = System.currentTimeMillis();  // get current time in milliseconds
        domeTime = currentTime + 10000;   // add 10 seconds to current time
    }
    
    /**
     * Act - do whatever the ForceField wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor actor = getOneIntersectingObject(Bomb.class);
        if(actor != null)
        {
            getWorld().removeObject(actor);
        }
        
        // start Timer
        if(System.currentTimeMillis() >= domeTime)  // if current time past domeTime
        {
            getWorld().removeObject(this);
        }
    }    
}
