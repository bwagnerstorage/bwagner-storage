import greenfoot.*;

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phaser extends Actor
{
    final int SPEED = 5;
    boolean hit = false;
    GreenfootSound explosionSound = new GreenfootSound("explosion.wav");
    
    Cannon cannon;
    
    public Phaser(Cannon c)
    {
        cannon = c;
    }
    
    public void act() 
    {
        move(SPEED);
        
        collisionTest();
    }    
    
    public void collisionTest()
    {
        // test for Alien hit
        Actor actor = getOneIntersectingObject(Alien.class);
        
        if(actor != null)
        {
            getWorld().removeObject(actor);   // remove the alien
            hit = true;
        }
        
        // test for Bomb hit
        Actor actor2 = getOneIntersectingObject(Bomb.class);
        
        if(actor2 != null)
        {
            getWorld().removeObject(actor2);   // remove the bomb
            hit = true;
        }
        
        
        if(hit == true)
        {
            getWorld().removeObject(this);    // remove this laser
            explosionSound.play();
            cannon.updateScore();
        }
    }
}
