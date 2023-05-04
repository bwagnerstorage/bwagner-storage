import greenfoot.*;
import java.awt.*;  

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
    // constants
    final int SPACE_BETWEEN_PIPES = 275;
    
    // instance variables
    
    
    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        Flappy flappy = new Flappy();
        //addObject(flappy, 200, getHeight()/2);

    }
    
    public void started()
    {
        Greenfoot.delay(100);
    }
    
    public void act()
    {
       
        
    }
    
    public void createPipes()
    {
        BottomPipe bottomPipe = new BottomPipe();
        GreenfootImage image = bottomPipe.getImage();
        int height = Greenfoot.getRandomNumber(150) + 20;
        addObject(bottomPipe, getWidth(), getHeight()/2 + image.getHeight() - height);
        
        TopPipe topPipe = new TopPipe();
        image = topPipe.getImage();
        addObject(topPipe, getWidth(), getHeight()/2 + image.getHeight()/2 - height - SPACE_BETWEEN_PIPES);
            
    }
}
