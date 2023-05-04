import greenfoot.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Lizard lizard = new Lizard();
        addObject(lizard, 300, 200);
        
        addObject(new Fly(), 50, 50);
        addObject(new Fly(), 400, 100);
        addObject(new Fly(), 100, 300);
        addObject(new Fly(), 350, 280);
        addObject(new Fly(), 250, 350);
        addObject(new Fly(), 550, 380);
        addObject(new Fly(), 500, 300);
        addObject(new Fly(), 500, 50);
        addObject(new Fly(), 100, 200);
        addObject(new Fly(), 275, 80);
       
    }
}
