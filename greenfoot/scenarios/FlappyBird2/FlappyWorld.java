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

    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        Flappy flappy = new Flappy();
        addObject(flappy, 200, getHeight()/2); 

    }
    
    /**
     * This method is a World method that is called automatically when the world is first created.
     * Any code placed in this method will be executed before the act method is called.
     * It is used here to delay the start of the game for a couple of seconds.
     */
    public void started()
    {
        Greenfoot.delay(100);
    }
    
}
