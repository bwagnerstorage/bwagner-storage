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
    final int GROUND_SPEED = -3;
    
    public Ground()
    {
        // Since the original ground image does not quite cover the entire world
        // horizontally this code duplicates the image so that is twice its original size
        // and makes this new image the image for the class. (1232 x 50)
        image1 = new GreenfootImage("ground.png");
        image2 = new GreenfootImage(image1.getWidth() * 2, image1.getHeight());
        image2.drawImage(image1, 0, 0);
        image2.drawImage(image1, image1.getWidth(), 0);
        setImage(image2);
    }
    
    public void act() 
    {       
        // scrolling effect
        if(getX() > 200)
        {
            setLocation(getX() + GROUND_SPEED, getY());     // move image to the left
        }
        else
        {
            setLocation(getWorld().getWidth()/2, getY());  // move it back and start over
        }
        
   }    
}
