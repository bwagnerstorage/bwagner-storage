import greenfoot.*;

/**
 * Write a description of class KetchupBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KetchupBall extends Actor
{
    private int distance = 0;    // how far ball has traveled
    private int speed = 4;       // speed of ball
    private GreenfootSound bloop = new GreenfootSound("bloop.wav");
    
    public void act() 
    {
        move(speed);
        // code goes below this line
        
        
        distance = distance + speed;
    }    
}
