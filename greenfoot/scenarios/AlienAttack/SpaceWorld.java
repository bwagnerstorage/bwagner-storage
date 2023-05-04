import greenfoot.*;

/**
 * Write a description of class SpaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceWorld extends World
{
    int forceFieldCount = 3;
    Scoreboard scoreboard;
    
    /**
     * Constructor for objects of class SpaceWorld.
     * 
     */
    public SpaceWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1 ,false);
        
        GreenfootImage bk = getBackground();
        bk.setColor(Color.BLACK);
        bk.fill();
        
        scoreboard = new Scoreboard();
        addObject(scoreboard, getWidth()/2, -15);
        
        Fort fort = new Fort(scoreboard);
        addObject(fort, getWidth()/2, getHeight());
        
        Cannon cannon = new Cannon(scoreboard);
        addObject(cannon, getWidth()/2, getHeight());
        
        setPaintOrder(Fort.class, Cannon.class, ForceField.class);
        
    }
    
    public void act()
    {
        int random = Greenfoot.getRandomNumber(200) + 1;
        if(random == 1)
        {
             addAlien();
        }
        
        forceFieldTest();
    }
    
    public void forceFieldTest()
    {
        String key = Greenfoot.getKey();
        if("space".equals(key))
        { 
            if(forceFieldCount > 0)
            {
               ForceField dome = new ForceField();
               addObject(dome, getWidth() / 2, getHeight() - 25);
               
               forceFieldCount--;
               scoreboard.updateForceField(forceFieldCount);
            }
        }
    }
    
     public void addAlien()
    {
        int direction = Greenfoot.getRandomNumber(2);
        
        if(direction == 0)  // alien moves from west to east
        {
            int speed = Greenfoot.getRandomNumber(2) + 1;
            int y = Greenfoot.getRandomNumber(getHeight() - 200) + 50 ;
            Alien alien = new Alien(speed);
            addObject(alien, -50, y);
        }
        else  // alien moves from east to west
        {
            
            int speed = Greenfoot.getRandomNumber(3) + 1;
            int y = Greenfoot.getRandomNumber(getHeight() - 200) + 25 ;
            Alien alien = new Alien(-speed);
            addObject(alien, getWidth()+50, y);
        }
    }
}
