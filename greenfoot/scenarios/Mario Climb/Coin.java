import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends AnimatedActor
{
    public Coin(String imageFile, int numframes, int frameWidth, int frameHeight)
    {
        super(imageFile, numframes, frameWidth, frameHeight);
        setAutoAdvance(true);
        setAdvanceSpeed(5);
        setLooping(true);
        setAutoAdvanceRange(0, 6);
        show();
    }
    
    public void act() 
    {
       super.act();
    }    
}
