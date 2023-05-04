import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartUpScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartUpScreen extends World
{
    StartButton button; 
    
    /**
     * Constructor for objects of class StartUpScreen.
     * 
     */
    public StartUpScreen()
    {    
        super(695, 400, 1);
      
        Title title = new Title();
        addObject(title, 348, 100);
        
        button = new StartButton();
        addObject(button, 348, 200);
        
        getBackground().setColor(new Color(84,204,218));  // baby blue
        getBackground().fill();
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(button))
        {
            Greenfoot.setWorld(new FlappyWorld());
        }
    }
}

