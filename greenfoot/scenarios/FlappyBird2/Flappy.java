import greenfoot.*;

/**
 * Write a description of class Flappy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flappy extends Actor
{
    double dy = 0;                      // vertical velocity
    double g = .4;                      // gravity
    final double BOOST_SPEED = -7;      // vertical lift
    
    public void act() 
    {
        fly();
        
        rotateFlappyBird();
        
        if(getY() > getWorld().getHeight())   // fallen off bottom
           displayGameOver();
    }
    
    public void fly()
    {
        setLocation(getX(), (int)(getY() + dy));   // update position
        
        if(Greenfoot.isKeyDown("up") == true)
        {
            dy = BOOST_SPEED;                      // provide lift
        }
        
        dy = dy + g;                               // apply gravity
    }
    
    public void displayGameOver()
    {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
    }
    
    /**
     * This method rotates the flappy bird so that when it is falling its nose is facing 
     *   downward and when it is climbing its nose is facing upward.
     */
    public void rotateFlappyBird()
    {

        
    }
}
