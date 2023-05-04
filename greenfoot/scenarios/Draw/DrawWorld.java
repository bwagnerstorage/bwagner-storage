import greenfoot.*;

/**
 * Write a description of class DrawWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawWorld extends World
{
    private int startX = 0;
    private int startY = 0;
    
    public DrawWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

    }
    
    public void act()
    {
        if(Greenfoot.mousePressed(this) == true)
        {
            greenfoot.MouseInfo info = Greenfoot.getMouseInfo();  // get info about mouse status
            int button = info.getButton();                        // get button press info
            
            if(button == 1)  // 1 = left button
            {
                startX = info.getX();
                startY = info.getY();
            }
        }
        
        if(Greenfoot.mouseDragged(this) == true)
        {
            greenfoot.MouseInfo info = Greenfoot.getMouseInfo();
            int button = info.getButton();
            
            if(button == 1)  // 1 = left button
            {
                int endX = info.getX();
                int endY = info.getY();
                GreenfootImage bk = getBackground();
                bk.setColor(Color.BLACK);
                bk.drawLine(startX, startY, endX, endY);
                startX = endX;
                startY = endY;
            }
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            greenfoot.MouseInfo info = Greenfoot.getMouseInfo();
            int button = info.getButton();
            
            if(button == 3)  // 3 = right button
            {
                GreenfootImage bk = getBackground();
                bk.setColor(Color.WHITE);
                bk.fill();
            }
        }
        
    }
}
