import greenfoot.*;

/**
 * Write a description of class ExamWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExamWorld extends World
{

    /**
     * Constructor for objects of class ExamWorld.
     * 
     */
    public ExamWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Pig pig = new Pig();
        addObject(pig, 50, 30);
        
        Wombat wombat = new Wombat();
        addObject(wombat, 50, 100);
        
        TeddyBear teddy = new TeddyBear();
        addObject(teddy, 300, 175);
        
        Car car = new Car();
        addObject(car, 300, 320);
        
        Penguin penguin = new Penguin();
        addObject(penguin, 500, 120);
        
        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        addObject(wall1, 150, 320);
        addObject(wall2, 540, 320);
    }
}
