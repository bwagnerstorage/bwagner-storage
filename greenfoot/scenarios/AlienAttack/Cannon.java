import greenfoot.*;

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Actor
{
    int score = 0;
    Scoreboard scoreboard;
    GreenfootSound phaserSound = new GreenfootSound("phaser.wav");
    
    public Cannon(Scoreboard sc)
    {
       setRotation(270);
       scoreboard = sc;
    }
    
    public void act() 
    {
        if(Greenfoot.mouseMoved(getWorld()) == true)   // has mouse moved?
        {
            moveCannon();
        }
        
        if(Greenfoot.mouseClicked(getWorld()) == true)  // has mouse been clicked?
        {
            shootCannon();
        }
    }   
    
    public void moveCannon()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();   // get mouse status
        int x = mouse.getX();     // get mouse x coordinate
        int y = mouse.getY();     // get mouse y coordinate 
        
        if(y < 350)  // cannon can't point below 350
        {
            turnTowards(x, y);  // turn cannon so it faces current mouse position
        }
    }
    
    public void shootCannon()
    {

    }
    
    public void updateScore()
    {
        score++;
        scoreboard.updateScore(score);
    }
    
}
