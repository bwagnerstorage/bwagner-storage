import greenfoot.*;

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    private int speed = 0;
    private double bombDelay = 0;
    private double currentTime = 0;
    
    public Alien(int s)
    {
        speed = s;
    }
    
    public void act() 
    {
        setLocation(getX() + speed, getY());
        
        // drop bomb ever 3 seconds
        if(System.currentTimeMillis() >= bombDelay)  // if current time past delay
        {
            dropBomb();   // drop bomb
            currentTime = System.currentTimeMillis();  // get current time in milliseconds
            bombDelay = currentTime + 3000;   // 3 second delay
        }
        
        // remove alien after it moves across screen 
        if(speed < 0 && getX() + getImage().getWidth()/2 < 0)  // left moving aiien
        {
            getWorld().removeObject(this);   // remove this alien from world
        }
        
        if(speed > 0 && getX() - getImage().getWidth()/2 > getWorld().getWidth())  // right moving
        {
            getWorld().removeObject(this);   // remove this alien from world
        }
        
        
    } 
    
    public void dropBomb()
    {
            Bomb bomb = new Bomb(speed);
            getWorld().addObject(bomb, getX(), getY());
            bomb.setRotation(90);   // set bomb direction south
            bomb.move(20);          // move bomb to bottom edge of alien
    }
}
