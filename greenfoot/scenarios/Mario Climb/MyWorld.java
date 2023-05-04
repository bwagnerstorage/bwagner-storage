import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        super(600, 400, 1, false);
        
        Platform p1 = new Platform();
        Platform p2 = new Platform();
        Platform p3 = new Platform();
        Platform p4 = new Platform();
        Platform p5 = new Platform();
        
        addObject(p1, 181, 260);
        addObject(p2, 304, 260);
        addObject(p3, 427, 260);
        addObject(p4, 243, 172);
        addObject(p5, 366, 172);
        
        Ladder ladder1 = new Ladder();
        Ladder ladder2 = new Ladder();
        Ladder ladder3 = new Ladder();
        Ladder ladder4 = new Ladder();
        Ladder ladder5 = new Ladder();
        
        addObject(ladder1, 126, 294);
        addObject(ladder2, 301, 294);
        addObject(ladder3, 478, 294);
        addObject(ladder4, 225, 207);
        addObject(ladder5, 377, 207);
        
        // add Mario
        Mario mario = new Mario("marioSheet2.png", 16, 40, 48);
        addObject(mario, 40, 314);
        mario.show();
        

    }
   
}
