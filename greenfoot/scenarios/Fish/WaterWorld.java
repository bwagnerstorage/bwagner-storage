import greenfoot.*;

/**
 * Write a description of class WaterWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterWorld extends World
{

    /**
     * Constructor for objects of class WaterWorld.
     * 
     */
    public WaterWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Fish fish = new Fish();
        addObject(fish, getWidth()/2, getHeight()/2);
    }
}
