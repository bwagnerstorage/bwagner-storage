import greenfoot.*;

/**
 * Write a description of class Flappy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flappy extends Actor
{
    double dy = 0;
    double g = .4;
    final double BOOST_SPEED = -7;
    
    public void act() 
    {
        fly();
        
        rotateFlappyBird();
        
        if(getOneIntersectingObject(Pipe.class) != null)
        {
            displayGameOver();
        }
              
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
    
    public void rotateFlappyBird()
    {
        if(dy < -8)
        {
            setRotation(300);
        }
        else if(dy >= -8 && dy < -4)
        {
            setRotation(320);
        }
        else if(dy >= -4 && dy <= 4)
        {
            setRotation(0);
        }
        else if(dy > 4 && dy <= 8)
        {
            setRotation(40);
        }
        else if(dy > 8)
        {
            setRotation(80);
        }
    }
}
