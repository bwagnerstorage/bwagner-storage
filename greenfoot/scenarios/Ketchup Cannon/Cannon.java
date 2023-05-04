import greenfoot.*;

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Actor
{
    private GreenfootSound pop = new GreenfootSound("pop.wav");   // cannon fire sound
    
    public void act() 
    {
        // code executes when mouse moves
        if(Greenfoot.mouseMoved(getWorld()) == true)   // has mouse moved?
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();   // get mouse status
            int x = mouse.getX();     // get mouse x coordinate
            int y = mouse.getY();     // get mouse y coordinate 
            
            turnTowards(x, y);  // turn cannon so it faces current mouse position
        }
        
        // Code executes when Cannon is fired
        if(Greenfoot.mouseClicked(getWorld()) == true)  // has mouse been clicked?
        {
            KetchupBall ball = new KetchupBall();  // create KetchupBall
            ball.setRotation(getRotation());       // point KetchBall same direction as Cannon
            getWorld().addObject(ball, getX(), getY());   // add KetchBall to World at Cannon's
                                                          // position
            ball.move(65);    // move ball to cannon's edge
            pop.play();       // play pop sound when cannon is fired
        }
    }    
}
