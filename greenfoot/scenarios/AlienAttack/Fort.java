import greenfoot.*;

/**
 * Write a description of class Fort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fort extends Actor
{
    int damage = 3;
    GreenfootSound implosionSound = new GreenfootSound("implosion.wav");
    Scoreboard scoreboard;
    
    public Fort(Scoreboard s)
    {
        scoreboard = s;
    }

    public void act() 
    {
        collisionTest();
    }    
    
    public void collisionTest()
    {
        Actor actor = getOneIntersectingObject(Bomb.class);
        if(actor != null && actor.getX() < getWorld().getHeight())
        {
            damage--;
            scoreboard.updateDamage(damage);
            getWorld().removeObject(actor);
            implosionSound.play();
        }
        
        if(damage == 0)
        {
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
            
            Greenfoot.stop();
        }
    }
}
