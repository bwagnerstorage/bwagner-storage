import greenfoot.*;

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    GreenfootImage image1 = null;
    GreenfootImage image2 = null;
    public final int GROUND_SPEED = -3;
    
    public Ground()
    {
        image1 = new GreenfootImage("ground.png");
        image2 = new GreenfootImage(image1.getWidth() * 2, image1.getHeight());
        image2.drawImage(image1, 0, 0);
        image2.drawImage(image1, image1.getWidth(), 0);
        setImage(image2);
    }
    
    public void act() 
    {
        if(((FlappyWorld)getWorld()).isPaused() == false)
        {
            int half = getImage().getWidth()/2;  // half the width = 616
            
            
            if(getX() > 200)
            {
                setLocation(getX() + GROUND_SPEED, getY());
            }
            else
                setLocation(getWorld().getWidth()/2, getY());
        }
   }    
}
