import greenfoot.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Explosion explosion;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        explosion = new Explosion("explosion_sheet.png", 13, 196, 190);   // create Explosion object
        addObject(explosion, getWidth()/2, getHeight()/2);    // add object to world
        
        explosion.setAutoAdvance(true);
        explosion.setAdvanceSpeed(10);
        explosion.setLooping(true);
    }
}
